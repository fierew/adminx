package com.fierew.adminx.controller;

import com.fierew.adminx.utils.RedisUtils;
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

    @Cacheable(cacheNames = "user")
    @PostMapping("/user")
    public ResultVO getList(@Validated @RequestBody TableDTO tableDTO, @Validated AdminUserDTO adminUserDTO) throws ExecutionException, InterruptedException {
        // List<AdminUserVO> userList = adminUserService.getList(tableDTO, adminUserDTO);
        return ResultVO.success(tableDTO);
    }
}
