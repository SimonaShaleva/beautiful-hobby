package com.example.krasivohobi.service.impl;

import java.util.List;

import com.example.krasivohobi.model.entity.UserEntity;
import com.example.krasivohobi.model.entity.UserRoleEntity;
import com.example.krasivohobi.model.entity.enums.UserRoleEnum;
import com.example.krasivohobi.repository.UserRepository;
import com.example.krasivohobi.repository.UserRoleRepository;
import com.example.krasivohobi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void seedUsers() {

        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);
            UserRoleEntity userPublisherRole = new UserRoleEntity().setRole(UserRoleEnum.USER_PUBLISHER);

            userRoleRepository.saveAll(List.of(adminRole, userRole, userPublisherRole));

            UserEntity admin = new UserEntity().setUsername("admin").setPassword(passwordEncoder.encode("topsecret"));
            UserEntity user = new UserEntity().setUsername("user").setPassword(passwordEncoder.encode("topsecret"));
            UserEntity publisher = new UserEntity().setUsername("publisher").setPassword(passwordEncoder.encode("topsecret"));
            admin.setRoles(List.of(adminRole, userRole));
            user.setRoles(List.of(userRole));
            publisher.setRoles(List.of(userRole, userPublisherRole));

            userRepository.saveAll(List.of(admin, user, publisher));
        }
    }
}
