package com.fierew.adminx.controller;

import com.fierew.adminx.dto.AdminRoleDTO;
import com.fierew.adminx.dto.TableDTO;
import com.fierew.adminx.service.AdminRoleService;
import com.fierew.adminx.vo.AdminRoleVO;
import com.fierew.adminx.vo.PageVO;
import com.fierew.adminx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminRoleController {
    AdminRoleService adminRoleService;

    @Autowired
    public void setService(AdminRoleService adminRoleService) {
        this.adminRoleService = adminRoleService;
    }

    @GetMapping("/role")
    ResultVO getList(@Validated TableDTO tableDTO, @Validated AdminRoleDTO adminRoleDTO) {
        PageVO<AdminRoleVO> list = adminRoleService.getList(tableDTO, adminRoleDTO);
        return ResultVO.success(list);
    }

    @PostMapping("/role")
    ResultVO add(@Validated @RequestBody AdminRoleDTO adminRoleDTO) {
        Integer result = adminRoleService.add(adminRoleDTO);
        if (result != 1) {
            return ResultVO.error(500, "新增角色失败");
        }
        return ResultVO.success();
    }

    @PutMapping("/role/{id}")
    ResultVO modify(@PathVariable Integer id, @Validated @RequestBody AdminRoleDTO adminRoleDTO) {
        Integer result = adminRoleService.modify(id, adminRoleDTO);
        if (result != 1) {
            return ResultVO.error(500, "修改角色失败");
        }
        return ResultVO.success();
    }

    @DeleteMapping("/role/{id}")
    ResultVO delete(@PathVariable Integer id) {
        Integer result = adminRoleService.del(id);
        if (result != 1) {
            return ResultVO.error(500, "删除角色失败");
        }
        return ResultVO.success();
    }
}
