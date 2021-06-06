package com.fierew.adminx.websocket;

import lombok.Data;

import java.security.Principal;

/**
 * @author xuyang
 */
public class MyPrincipal implements Principal {
    private String name;
    public MyPrincipal(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

}
