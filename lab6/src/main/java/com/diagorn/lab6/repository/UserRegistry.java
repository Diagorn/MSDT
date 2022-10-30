package com.diagorn.lab6.repository;

import com.diagorn.lab6.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class UserRegistry {

    private final int MIN_ID = 1;
    private final int MAX_ID = 100000;

    private final Set<User> users = new HashSet<>();

    public void add(User user) {
        this.users.add(user);
    }

    public void add(User user, int id) {
        user.setId(id);
        add(user);
    }

    public void add(Collection<User> users) {
        this.users.addAll(users);
    }

    public void delete(User user) {
        this.users.remove(user);
    }

    public User getById(int id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst().orElse(null);
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    public User deleteById(int id) {
        User user = this.getById(id);
        if (user != null) {
            this.delete(user);
        }
        return user;
    }

    public int generateNewId() {
        if (CollectionUtils.isEmpty(users)) {
            return 1;
        }

        return ThreadLocalRandom.current().nextInt(MIN_ID, MAX_ID);
    }
}
