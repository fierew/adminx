package com.fierew.adminx.controller;

import com.fierew.adminx.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminRoleController {

    @GetMapping("/role")
    ResultVO getList() {
        return ResultVO.success();
    }

    @PostMapping("/role")
    ResultVO add() {
        return ResultVO.success();
    }

    @PutMapping("/role")
    ResultVO modify() {
        return ResultVO.success();
    }

    @DeleteMapping("/role")
    ResultVO delete() {
        return ResultVO.success();
    }
}
