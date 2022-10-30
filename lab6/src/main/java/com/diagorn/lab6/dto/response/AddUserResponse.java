package com.diagorn.lab6.dto.response;

/**
 * A response to a new user creation
 *
 * @author Diagorn
 */
public class AddUserResponse {
    /**
     * New user id
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
