package com.fierew.adminx.controller;

import com.fierew.adminx.dto.ResultDTO;
import com.fierew.adminx.dto.UserDTO;
import com.fierew.adminx.service.UserService;
import com.fierew.adminx.vo.UserTableVO;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author xuyang
 */
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    ResultDTO getList() throws ExecutionException, InterruptedException {
        List<UserDTO> userList = userService.getList(1, 10);
        ResultDTO result = new ResultDTO();
        result.setCode(200);
        result.setData(userList);
        result.setMsg("success");
        return result;
    }
}
