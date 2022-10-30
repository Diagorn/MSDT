package com.diagorn.lab6.dto.request;

/**
 * A request for adding a user
 *
 * @author Diagorn
 */
public class AddUserRequest {
    /**
     * User's name
     */
    private String name;
    /**
     * User's email
     */
    private String email;
    /**
     * User's gender
     */
    private String gender;
    /**
     * User's status
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
