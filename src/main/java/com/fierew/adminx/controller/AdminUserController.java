package com.fierew.adminx.controller;

import com.fierew.adminx.annotation.PassAuth;
import com.fierew.adminx.dto.ResultDTO;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author xuyang
 */
@RestController
@RequestMapping("admin/user")
public class AdminUserController {
    private AdminUserService adminUserService;

    @Autowired
    public void setAdminUserService(AdminUserService adminUserService){
        this.adminUserService = adminUserService;
    }

    @GetMapping("/getList")
    ResultDTO getList() throws ExecutionException, InterruptedException {
        List<AdminUserDTO> userList = adminUserService.getList(1, 10);
        ResultDTO result = new ResultDTO();
        result.setCode(200);
        result.setData(userList);
        result.setMsg("success");
        return result;
    }
}
