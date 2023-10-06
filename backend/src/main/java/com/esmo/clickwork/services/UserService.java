package com.esmo.clickwork.services;

import com.esmo.clickwork.entities.User;
import com.esmo.clickwork.enums.RolesEnum;
import com.esmo.clickwork.exceptions.ResourceAlreadyExistException;
import com.esmo.clickwork.exceptions.ResourceNotFoundException;
import com.esmo.clickwork.repositories.RoleRepository;
import com.esmo.clickwork.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }

    public User save(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ResourceAlreadyExistException("User", "email", user.getEmail());
        }

        user.setRole(roleRepository.findByName(RolesEnum.USER).orElseThrow(() -> new ResourceNotFoundException("Role", "role", RolesEnum.USER.toString())));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
