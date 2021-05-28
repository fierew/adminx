package com.fierew.adminx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fierew.adminx.dao.UserDAO;
import com.fierew.adminx.domain.DeptDO;
import com.fierew.adminx.domain.RoleDO;
import com.fierew.adminx.domain.UserDO;
import com.fierew.adminx.dto.UserDTO;
import com.fierew.adminx.service.AsyncDeptService;
import com.fierew.adminx.service.AsyncRoleService;
import com.fierew.adminx.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author xuyang
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private AsyncRoleService asyncRoleService;
    private AsyncDeptService asyncDeptService;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setAsyncRoleService(AsyncRoleService asyncRoleService) {
        this.asyncRoleService = asyncRoleService;
    }

    @Autowired
    public void setAsyncDeptService(AsyncDeptService asyncDeptService) {
        this.asyncDeptService = asyncDeptService;
    }

    @Override
    public List<UserDTO> getList(Integer page, Integer pageSize) throws ExecutionException, InterruptedException {
        // 条件构造器
        QueryWrapper<UserDO> userQueryWrapper = new QueryWrapper<>();
        // 模糊查询Like
        //userQueryWrapper.like("real_name", userDO.getRealName());
        // 分页插件
        IPage<UserDO> userPage = new Page<>(page, pageSize);
        userPage = userDAO.selectPage(userPage, userQueryWrapper);
        List<UserDO> list = userPage.getRecords();

        List<Integer> roleIdList = list.stream().map(UserDO::getRoleId).collect(Collectors.toList());
        List<Integer> deptIdList = list.stream().map(UserDO::getRoleId).collect(Collectors.toList());

        // 异步获取角色信息
        CompletableFuture<List<RoleDO>> asyncRoleList = asyncRoleService.getRoleListByIds(roleIdList);
        // 异步获取部门信息
        CompletableFuture<List<DeptDO>> asyncDeptList = asyncDeptService.getDeptListByIds(deptIdList);
        // 等待所有任务都执行完
        CompletableFuture.allOf(asyncRoleList, asyncDeptList).join();
        // 获取每个任务的返回结果
        List<RoleDO> roleList = asyncRoleList.get();
        List<DeptDO> deptList = asyncDeptList.get();

        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserDO userDO : list) {
            Integer roleId = userDO.getRoleId();
            Integer deptId = userDO.getDeptId();

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userDO, userDTO);
            for (RoleDO role: roleList) {
                if(roleId.equals(role.getId())){
                    userDTO.setRoleName(role.getName());
                }
            }

            for (DeptDO dept: deptList) {
                if(deptId.equals(dept.getId())){
                    userDTO.setDeptName(dept.getName());
                }
            }

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }
}
