package com.diagorn.lab6.dto;

/**
 * Main DTO containing all the information about the user
 *
 * @author Diagorn
 */
public class UserDto {
    /**
     * User id
     */
    private int id;
    /**
     * User name
     */
    private String name;
    /**
     * User email
     */
    private String email;
    /**
     * User gender
     */
    private String gender;
    /**
     * User status
     */
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
