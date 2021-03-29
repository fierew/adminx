package com.fierew.adminxservice.service.impl;

import com.fierew.adminxservice.service.IndexService;
import com.fierew.adminxutils.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author xuyang
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    PasswordUtils passwordUtils;

    @Override
    public void index(String aa) {
        System.out.println(passwordUtils.encode(aa));
    }
}
