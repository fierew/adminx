package com.fierew.adminx.controller;

import com.fierew.adminx.annotation.PassAuth;
import com.fierew.adminx.dto.ResultDTO;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.service.AdminUserService;
import com.fierew.adminx.utils.RedisUtils;
import com.fierew.adminx.vo.AdminUserTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author xuyang
 */
@RestController
@RequestMapping("admin/user")
public class AdminUserController {
    private RedisUtils redisUtils;
    private AdminUserService adminUserService;

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Autowired
    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @PostMapping("/getList")
    ResultDTO getList(@RequestBody AdminUserTableVO adminUserTableVO) throws ExecutionException, InterruptedException {
        // List<AdminUserDTO> userList = adminUserService.getList(1, 10);
        redisUtils.set("'test'", "测试");
        ResultDTO result = new ResultDTO();
        result.setCode(200);
        result.setData(adminUserTableVO);
        result.setMsg("success");
        return result;
    }
}
