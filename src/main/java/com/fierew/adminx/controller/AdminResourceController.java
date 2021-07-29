package com.fierew.adminx.controller;

import com.fierew.adminx.dto.AdminResourceDTO;
import com.fierew.adminx.service.AdminResourceService;
import com.fierew.adminx.vo.AdminResourceVO;
import com.fierew.adminx.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminResourceController {
    AdminResourceService adminResourceService;

    @Autowired
    public void setService(AdminResourceService adminResourceService) {
        this.adminResourceService = adminResourceService;
    }

    @GetMapping("/resource")
    ResultVO getList(@Validated AdminResourceDTO adminResourceDTO) {
        List<AdminResourceVO> result = adminResourceService.getTreeResource(adminResourceDTO);
        return ResultVO.success(result);
    }

    @PostMapping("/resource")
    ResultVO add(@Validated @RequestBody AdminResourceDTO adminResourceDTO) {
        Integer result = adminResourceService.add(adminResourceDTO);
        if (result != 1) {
            return ResultVO.error(500, "新增资源失败");
        }
        return ResultVO.success();
    }

    @PutMapping("/resource/{id}")
    ResultVO modify(@PathVariable Integer id, @Validated @RequestBody AdminResourceDTO adminResourceDTO) {
        Integer result = adminResourceService.modify(id, adminResourceDTO);
        if (result != 1) {
            return ResultVO.error(500, "修改资源失败");
        }
        return ResultVO.success();
    }

    @DeleteMapping("/resource/{id}")
    ResultVO delete(@PathVariable Integer id) {
        Integer result = adminResourceService.del(id);
        if (result != 1) {
            return ResultVO.error(500, "删除资源失败");
        }
        return ResultVO.success();
    }
}
