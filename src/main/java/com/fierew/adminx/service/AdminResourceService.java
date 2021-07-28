package com.fierew.adminx.service;

import com.fierew.adminx.dto.AdminResourceDTO;
import com.fierew.adminx.vo.AdminResourceVO;

import java.util.List;

public interface AdminResourceService {
    List<AdminResourceVO> getTreeResource(AdminResourceDTO adminResourceDTO);
}
