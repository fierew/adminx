package com.fierew.adminx.controller;

import com.fierew.adminx.vo.PageVO;
import com.fierew.adminx.vo.ResultVO;
import com.fierew.adminx.vo.AdminUserVO;
import com.fierew.adminx.service.AdminUserService;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResultVO getList(@Validated TableDTO tableDTO, @Validated AdminUserDTO adminUserDTO) {
        PageVO<AdminUserVO> userList = adminUserService.getList(tableDTO, adminUserDTO);
        return ResultVO.success(userList);
    }

    @PostMapping("/user")
    ResultVO add(@Validated @RequestBody AdminUserDTO adminUserDTO) {
        Integer result = adminUserService.add(adminUserDTO);
        if (result != 0) {
            return ResultVO.error(500, "新增用户失败");
        }
        return ResultVO.success();
    }

    @PutMapping("/user/{id}")
    ResultVO modify(@PathVariable Integer id, @Validated @RequestBody AdminUserDTO adminUserDTO) {
        Integer result = adminUserService.modify(id, adminUserDTO);
        if (result != 0) {
            return ResultVO.error(500, "修改用户失败");
        }
        return ResultVO.success();
    }

    @DeleteMapping("/user/{id}")
    ResultVO del(@PathVariable Integer id) {
        Integer result = adminUserService.del(id);
        if (result != 0) {
            return ResultVO.error(400, "删除用户失败");
        }
        return ResultVO.success();
    }
}
