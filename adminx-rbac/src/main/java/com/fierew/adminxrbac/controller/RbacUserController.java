package com.fierew.adminxrbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyang
 */
@RestController
public class RbacUserController {
    @GetMapping("/login")
    String login() {
        return "RBAC";
    }
}
