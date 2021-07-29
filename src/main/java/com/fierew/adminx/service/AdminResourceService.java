package com.fierew.adminx.service;

import com.fierew.adminx.dto.AdminResourceDTO;
import com.fierew.adminx.vo.AdminResourceVO;

import java.util.List;

public interface AdminResourceService {
    List<AdminResourceVO> getTreeResource(AdminResourceDTO adminResourceDTO);

    Integer add(AdminResourceDTO adminResourceDTO);

    Integer modify(Integer id, AdminResourceDTO adminResourceDTO);

    Integer del(Integer id);
}
