package com.diagorn.lab6.service;

import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.dto.UserFormDto;
import com.diagorn.lab6.dto.request.AddUserRequest;
import com.diagorn.lab6.dto.response.AddUserResponse;

import java.util.List;

/**
 * Service to work with users
 *
 * @author Diagorn
 */
public interface UserService {
    /**
     * Get all the users
     */
    List<UserDto> getAll();

    /**
     * Get a user by id
     */
    UserDto getById(int id);

    /**
     * Get editable user information
     */
    UserFormDto getUserForEdit(int id);

    /**
     * Add a new user
     */
    AddUserResponse addNewUser(AddUserRequest request);

    /**
     * Edit existing user
     */
    UserFormDto editUser(UserFormDto userDto, int id);

    /**
     * Delete user by id
     */
    UserDto deleteById(int id);
}
