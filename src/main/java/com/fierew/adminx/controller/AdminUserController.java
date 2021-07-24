package com.fierew.adminx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fierew.adminx.domain.AdminUserDO;
import com.fierew.adminx.utils.RedisUtils;
import com.fierew.adminx.vo.PageVO;
import com.fierew.adminx.vo.ResultVO;
import com.fierew.adminx.vo.AdminUserVO;
import com.fierew.adminx.service.AdminUserService;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author xuyang
 */
@RestController
@RequestMapping("admin")
public class AdminUserController {
    private AdminUserService adminUserService;

    @Autowired
    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    //    @Cacheable(cacheNames = "user")
    @GetMapping("/user")
    public ResultVO getList(@Validated TableDTO tableDTO, @Validated AdminUserDTO adminUserDTO) throws ExecutionException, InterruptedException {
        PageVO<AdminUserVO> userList = adminUserService.getList(tableDTO, adminUserDTO);
        return ResultVO.success(userList);
    }

    @PostMapping("/user")
    ResultVO addUser(@Validated @RequestBody AdminUserDTO adminUserDTO) {
        Integer affectRows = adminUserService.add(adminUserDTO);
        if (affectRows > 0) {
            return ResultVO.success();
        }
        return ResultVO.error(400, "添加用户失败");
    }

    @DeleteMapping("/user/{id}")
    ResultVO delUser(@PathVariable Integer id) {
        Integer affectRows = adminUserService.del(id);
        if (affectRows > 0) {
            return ResultVO.success();
        }
        return ResultVO.error(400, "删除用户失败");
    }


}
