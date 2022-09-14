package com.diagorn.lab6.rest;

import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.dto.request.AddUserRequest;
import com.diagorn.lab6.dto.response.AddUserResponse;
import com.diagorn.lab6.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserDto getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public AddUserResponse addUser(@RequestBody AddUserRequest request) {
        return userService.addNewUser(request);
    }

    @GetMapping("/{id}/edit")
    @ResponseBody
    public UserDto getUserForEditForm(@PathVariable int id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public UserDto editUser(@RequestBody UserDto userDto, @PathVariable int id) {
        return userService.editUser(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public UserDto deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }
}
