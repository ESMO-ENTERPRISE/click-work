package com.esmo.clickwork.services;

import com.esmo.clickwork.entities.Role;
import com.esmo.clickwork.enums.RolesEnum;
import com.esmo.clickwork.exceptions.ResourceNotFoundException;
import com.esmo.clickwork.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByRole(RolesEnum name) {
        return roleRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Role", "role", name));
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
