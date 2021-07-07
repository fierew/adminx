package com.fierew.adminx.controller;

import com.fierew.adminx.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminDeptController {

    @GetMapping("/dept")
    ResultVO getList() {
        return ResultVO.success();
    }

    @PostMapping("/dept")
    ResultVO add() {
        return ResultVO.success();
    }

    @PutMapping("/dept")
    ResultVO modify() {
        return ResultVO.success();
    }

    @DeleteMapping("/dept")
    ResultVO delete() {
        return ResultVO.success();
    }
}
