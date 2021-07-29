package com.fierew.adminx.controller;

import com.fierew.adminx.dto.AdminDeptDTO;
import com.fierew.adminx.service.AdminDeptService;
import com.fierew.adminx.vo.AdminDeptVO;
import com.fierew.adminx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminDeptController {
    AdminDeptService adminDeptService;

    @Autowired
    public void setService(AdminDeptService adminDeptService) {
        this.adminDeptService = adminDeptService;
    }

    @GetMapping("/dept")
    ResultVO getList(@Validated AdminDeptDTO adminDeptDTO) {
        List<AdminDeptVO> result = adminDeptService.getTreeDept(adminDeptDTO);
        return ResultVO.success(result);
    }

    @PostMapping("/dept")
    ResultVO add(@Validated @RequestBody AdminDeptDTO adminDeptDTO) {
        Integer result = adminDeptService.add(adminDeptDTO);
        if (result != 1) {
            return ResultVO.error(500, "添加部门失败");
        }
        return ResultVO.success();
    }

    @PutMapping("/dept/{id}")
    ResultVO modify(@PathVariable Integer id, @Validated @RequestBody AdminDeptDTO adminDeptDTO) {
        Integer result = adminDeptService.modify(id, adminDeptDTO);
        if (result != 1) {
            return ResultVO.error(500, "修改部门失败");
        }
        return ResultVO.success();
    }

    @DeleteMapping("/dept/{id}")
    ResultVO delete(@PathVariable Integer id) {
        Integer result = adminDeptService.del(id);
        if (result != 1) {
            return ResultVO.error(500, "删除部门失败");
        }
        return ResultVO.success();
    }
}
