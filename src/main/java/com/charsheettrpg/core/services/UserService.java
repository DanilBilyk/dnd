package com.charsheettrpg.core.services;

import com.charsheettrpg.core.models.User;

import java.rmi.ServerException;
import java.util.List;

public interface UserService {
    User createNewUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
