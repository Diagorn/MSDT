package com.diagorn.lab6.utils;

import com.diagorn.lab6.domain.GenderEnum;
import com.diagorn.lab6.domain.StatusEnum;
import com.diagorn.lab6.domain.User;
import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.dto.UserFormDto;
import com.diagorn.lab6.dto.request.AddUserRequest;
import com.diagorn.lab6.dto.response.AddUserResponse;
import org.springframework.stereotype.Component;

@Component
public class Converters {

    public User convert(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setGender(GenderEnum.ofString(userDto.getGender()));
        user.setStatus(StatusEnum.ofString(userDto.getStatus()));

        return user;
    }

    public UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setGender(user.getGender().getName());
        userDto.setStatus(user.getStatus().getName());

        return userDto;
    }

    public User convert(UserFormDto userFormDto) {
        User user = new User();

        user.setName(userFormDto.getName());
        user.setEmail(userFormDto.getEmail());
        user.setStatus(StatusEnum.ofString(userFormDto.getStatus()));
        user.setGender(GenderEnum.ofString(userFormDto.getGender()));

        return user;
    }

    public User convert(AddUserRequest request) {
        User user = new User();

        user.setStatus(StatusEnum.ofString(request.getStatus()));
        user.setGender(GenderEnum.ofString(request.getGender()));
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return user;
    }

    public AddUserResponse convertToAddUserResponse(User user) {
        AddUserResponse response = new AddUserResponse();

        response.setId(user.getId());

        return response;
    }

    public UserFormDto convertToUserFormDto(User user) {
        UserFormDto ufd = new UserFormDto();

        ufd.setEmail(user.getEmail());
        ufd.setName(user.getName());
        ufd.setStatus(StringUtils.capitalizeFirstLetter(user.getStatus().getName()));
        ufd.setGender(StringUtils.capitalizeFirstLetter(user.getGender().getName()));

        return ufd;
    }
}
