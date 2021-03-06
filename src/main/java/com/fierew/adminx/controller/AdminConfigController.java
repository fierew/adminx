package com.fierew.adminx.controller;

import com.fierew.adminx.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminConfigController {

    @GetMapping("/config")
    ResultVO getList() {
        return ResultVO.success();
    }

    @PostMapping("/config")
    ResultVO add() {
        return ResultVO.success();
    }

    @PutMapping("/config/{id}")
    ResultVO modify(@PathVariable Integer id) {
        return ResultVO.success();
    }

    @DeleteMapping("/config/{id}")
    ResultVO delete(@PathVariable Integer id) {
        return ResultVO.success();
    }
}
