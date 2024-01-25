package com.workintech.ecommerce.service.user;

import com.workintech.ecommerce.entity.user.Role;
import com.workintech.ecommerce.repository.user.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
