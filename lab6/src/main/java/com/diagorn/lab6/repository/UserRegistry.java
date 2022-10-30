package com.diagorn.lab6.repository;

import com.diagorn.lab6.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Registry containing all the domain objects
 *
 * @author Diagorn
 */
@Repository
public class UserRegistry {

    private final int MIN_ID = 1;
    private final int MAX_ID = 100000;

    private final Set<User> users = new HashSet<>();

    /**
     * Add a new User with a random id
     * @param user - new user
     */
    public void add(User user) {
        user.setId(generateNewId());
        this.users.add(user);
    }

    /**
     * Add a new User with a certain id
     * @param user - new user
     * @param id - user's id
     */
    public void add(User user, int id) {
        user.setId(id);
        add(user);
    }

    /**
     * Add a bunch of users
     * @param users - new users
     */
    public void add(Collection<User> users) {
        this.users.addAll(users);
    }

    /**
     * Delete a certain user
     * @param user - user to delete
     */
    public void delete(User user) {
        this.users.remove(user);
    }

    /**
     * Get user by his id
     * @param id - user id
     * @return found user
     */
    public User getById(int id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst().orElse(null);
    }

    /**
     * Retrieve all the users
     * @return all users
     */
    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    /**
     * Delete a user by his id
     * @param id - user's id
     * @return deleted user
     */
    public User deleteById(int id) {
        User user = this.getById(id);
        if (user != null) {
            this.delete(user);
        }
        return user;
    }

    /**
     * This generates a new id for a user.
     * If there are no users returns 1
     * If not, returns a random id between bounds
     *
     * FIXME check for unique id
     *
     * @return random id
     */
    public int generateNewId() {
        if (CollectionUtils.isEmpty(users)) {
            return 1;
        }

        return ThreadLocalRandom.current().nextInt(MIN_ID, MAX_ID);
    }
}
