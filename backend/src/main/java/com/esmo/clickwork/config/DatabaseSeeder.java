package com.esmo.clickwork.config;

import com.esmo.clickwork.entities.Role;
import com.esmo.clickwork.enums.RolesEnum;
import com.esmo.clickwork.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder {

    private final RoleRepository roleRepository;

    @Bean
    public void roleSeeder() {
        Role user = Role.builder().name(RolesEnum.USER).build();
        Role admin = Role.builder().name(RolesEnum.ADMIN).build();

        if (roleRepository.findByName(RolesEnum.USER).isEmpty()) {
            roleRepository.save(user);
        }

        if (roleRepository.findByName(RolesEnum.ADMIN).isEmpty()) {
            roleRepository.save(admin);
        }
    }
}
