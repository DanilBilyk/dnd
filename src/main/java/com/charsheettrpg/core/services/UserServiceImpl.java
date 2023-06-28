package com.charsheettrpg.core.services;

import com.charsheettrpg.core.models.User;
import com.charsheettrpg.core.models.enums.Role;
import com.charsheettrpg.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createNewUser(User user) {
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        userRepository.saveNewUser(user);
        log.info("Saving new userCreationForm: {}", user.getUsername());
        return user;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
