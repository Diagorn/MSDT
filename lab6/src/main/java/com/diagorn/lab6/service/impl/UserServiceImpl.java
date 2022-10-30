package com.diagorn.lab6.service.impl;

import com.diagorn.lab6.domain.User;
import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.dto.UserFormDto;
import com.diagorn.lab6.dto.request.AddUserRequest;
import com.diagorn.lab6.dto.response.AddUserResponse;
import com.diagorn.lab6.repository.UserRegistry;
import com.diagorn.lab6.service.UserService;
import com.diagorn.lab6.utils.Converters;
import com.diagorn.lab6.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRegistry userRegistry;
    private final Converters converters;

    public UserServiceImpl(UserRegistry userRegistry, Converters converters) {
        this.userRegistry = userRegistry;
        this.converters = converters;
    }

    @Override
    public List<UserDto> getAll() {
        return userRegistry.getAll().stream()
                .map(converters::convertToUserDto)
                .peek(userDto -> {
                    userDto.setStatus(StringUtils.capitalizeFirstLetter(userDto.getStatus()));
                    userDto.setGender(StringUtils.capitalizeFirstLetter(userDto.getGender()));
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(int id) {
        User user = userRegistry.getById(id);

        if (user == null) {
            return new UserDto();
        }

        UserDto userDto = converters.convertToUserDto(user);
        userDto.setStatus(StringUtils.capitalizeFirstLetter(userDto.getStatus()));
        userDto.setGender(StringUtils.capitalizeFirstLetter(userDto.getGender()));
        return userDto;
    }

    @Override
    public UserFormDto getUserForEdit(int id) {
        User user = userRegistry.getById(id);

        if (user == null) {
            return new UserFormDto();
        }

        return converters.convertToUserFormDto(user);
    }

    @Override
    public AddUserResponse addNewUser(AddUserRequest request) {
        User user = converters.convert(request);
        user.setId(userRegistry.generateNewId());

        userRegistry.add(user);

        return converters.convertToAddUserResponse(user);
    }

    @Override
    public UserFormDto editUser(UserFormDto userDto, int id) {
        User user = converters.convert(userDto);
        userRegistry.deleteById(id);
        userRegistry.add(user, id);
        return userDto;
    }

    @Override
    public UserDto deleteById(int id) {
        User user = userRegistry.getById(id);
        userRegistry.delete(user);
        return converters.convertToUserDto(user);
    }
}
