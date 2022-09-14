package com.diagorn.lab6.service;

import com.diagorn.lab6.domain.User;
import com.diagorn.lab6.dto.UserDto;
import com.diagorn.lab6.repository.UserRegistry;
import com.diagorn.lab6.utils.Converters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoadDataOnStartupService {

    private final RestTemplate restTemplate;
    private final UserRegistry userRegistry;

    @Value("${users.api.host:https://gorest.co.in}")
    private String usersApiUrl;

    public LoadDataOnStartupService(RestTemplate restTemplate, UserRegistry userRegistry) {
        this.restTemplate = restTemplate;
        this.userRegistry = userRegistry;
    }

    @PostConstruct
    public void initUsersRepository() {
        UserDto[] queryResults;
        try {
            ResponseEntity<UserDto[]> responseEntity = restTemplate.getForEntity(
                    usersApiUrl + "/public/v2/users",
                    UserDto[].class
            );
            queryResults = responseEntity.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get users data via API", e);
        }

        if (queryResults == null || queryResults.length == 0) {
            throw new IllegalStateException("Somehow API returned nothing");
        }

        List<User> users = transformDto(queryResults);
        userRegistry.add(users);
    }

    private List<User> transformDto(UserDto[] queryResults) {
        List<User> users = new ArrayList<>();

        for (UserDto userDto: queryResults) {
            User user = Converters.convert(userDto);
            users.add(user);
        }

        return users;
    }
}
