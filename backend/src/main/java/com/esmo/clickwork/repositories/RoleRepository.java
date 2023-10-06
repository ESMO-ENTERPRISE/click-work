package com.esmo.clickwork.repositories;

import com.esmo.clickwork.entities.Role;
import com.esmo.clickwork.enums.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByName(RolesEnum name);
}
