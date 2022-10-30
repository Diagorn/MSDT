package com.diagorn.lab6.dto;

/**
 * DTO to handle the user add/edit form
 *
 * @author Diagorn
 */
public class UserFormDto {
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
