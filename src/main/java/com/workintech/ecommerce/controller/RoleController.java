package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.user.RoleResponse;
import com.workintech.ecommerce.service.user.RoleService;
import com.workintech.ecommerce.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleResponse> getRoles() {
        return Converter.roleListConverter(roleService.getRoles());
    }
}
