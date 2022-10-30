package com.diagorn.lab6.service;

import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.dto.UserFormDto;
import com.diagorn.lab6.dto.request.AddUserRequest;
import com.diagorn.lab6.dto.response.AddUserResponse;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(int id);

    UserFormDto getUserForEdit(int id);

    AddUserResponse addNewUser(AddUserRequest request);

    UserFormDto editUser(UserFormDto userDto, int id);

    UserDto deleteById(int id);
}
