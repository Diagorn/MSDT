package com.diagorn.lab6.rest;

import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.dto.UserFormDto;
import com.diagorn.lab6.dto.request.AddUserRequest;
import com.diagorn.lab6.dto.response.AddUserResponse;
import com.diagorn.lab6.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Main controller handling users
 *
 * @author Diagorn
 */
@RestController
@RequestMapping("api/v1/users/")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users
     * @return all users
     */
    @GetMapping
    @ResponseBody
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    /**
     * Retrieves a user by his id
     * @param id - user's id
     * @return user with given id
     */
    @GetMapping("/{id}")
    @ResponseBody
    public UserDto getById(@PathVariable int id) {
        return userService.getById(id);
    }

    /**
     * Add a new user
     * @param request - new user data
     * @return new user id
     */
    @PostMapping("/add")
    @ResponseBody
    public AddUserResponse addUser(@RequestBody AddUserRequest request) {
        return userService.addNewUser(request);
    }

    /**
     * Get editable user information
     * @param id - user id
     * @return user's editable information
     */
    @GetMapping("/{id}/edit")
    @ResponseBody
    public UserFormDto getUserForEditForm(@PathVariable int id) {
        return userService.getUserForEdit(id);
    }

    /**
     * Edit user
     * @param userDto - updated user info
     * @param id - user id
     * @return updated user
     */
    @PutMapping("/{id}")
    @ResponseBody
    public UserFormDto editUser(@RequestBody UserFormDto userDto, @PathVariable int id) {
        return userService.editUser(userDto, id);
    }

    /**
     * Delete user by id
     * @param id - user id
     * @return deleted user
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public UserDto deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }
}
