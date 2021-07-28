package com.fierew.adminx.service;

import com.fierew.adminx.dto.AdminDeptDTO;
import com.fierew.adminx.vo.AdminDeptVO;

import java.util.List;

/**
 * @author xuyang
 */
public interface AdminDeptService {
    List<AdminDeptVO> getTreeDept(AdminDeptDTO adminDeptDTO);
}
