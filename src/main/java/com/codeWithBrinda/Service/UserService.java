package com.codeWithBrinda.Service;

import com.codeWithBrinda.entities.User;

import java.util.Optional;

public interface UserService  {

    void saveUsers(User user);
    Optional<User> getUserById(int id);
    User getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);

    User upateUser(User user);

    void deleteUser(int id);

    boolean isUserExistsBYEmail(String emailId);

    boolean isUserExists(int id);

    Optional<User> getAllUser ();





}
