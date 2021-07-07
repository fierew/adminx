package com.fierew.adminx.controller;

import com.fierew.adminx.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminResourceController {

    @GetMapping("/resource")
    ResultVO getList() {
        return ResultVO.success();
    }

    @PostMapping("/resource")
    ResultVO add() {
        return ResultVO.success();
    }

    @PutMapping("/resource")
    ResultVO modify() {
        return ResultVO.success();
    }

    @DeleteMapping("/resource")
    ResultVO delete() {
        return ResultVO.success();
    }
}
