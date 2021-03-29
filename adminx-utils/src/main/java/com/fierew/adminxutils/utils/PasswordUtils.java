package com.fierew.adminxutils.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author xuyang
 */
@Component
public class PasswordUtils {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordUtils(){
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String encode(String rawPassword){
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    public Boolean matches(String rawPassword, String encodedPassword){
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
