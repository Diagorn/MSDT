package com.diagorn.lab6.domain;

import java.util.Objects;

/**
 * User entity
 *
 * @author Diagorn
 */
public class User {
    /**
     * Identifier
     */
    private int id;
    /**
     * Full name
     */
    private String name;
    /**
     * Contact email
     */
    private String email;
    /**
     * Gender
     */
    private GenderEnum gender;
    /**
     * Availability
     */
    private StatusEnum status;

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
