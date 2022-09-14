package com.diagorn.lab6.service;

import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.dto.request.AddUserRequest;
import com.diagorn.lab6.dto.response.AddUserResponse;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(int id);

    AddUserResponse addNewUser(AddUserRequest request);

    UserDto editUser(UserDto userDto);

    UserDto deleteById(int id);
}
