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

/**
 * A service that loads 10 domain objects via given API
 *
 * @author Diagorn
 */
@Service
public class LoadDataOnStartupService {

    private final RestTemplate restTemplate;
    private final UserRegistry userRegistry;

    /**
     * API server url
     */
    @Value("${users.api.host:https://gorest.co.in}")
    private String usersApiUrl;

    public LoadDataOnStartupService(RestTemplate restTemplate, UserRegistry userRegistry) {
        this.restTemplate = restTemplate;
        this.userRegistry = userRegistry;
    }

    /**
     * Loads 10 new users and saves them to registry
     *
     * @throws RuntimeException when API is unavailable
     * @throws IllegalStateException when API returned an empty response
     */
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

    /**
     * Transforms query results to stopeable data
     * @param queryResults - results of API query
     * @return list of users to be saved
     */
    private List<User> transformDto(UserDto[] queryResults) {
        List<User> users = new ArrayList<>();
        Converters convertersUtils = new Converters();

        for (UserDto userDto: queryResults) {
            User user = convertersUtils.convert(userDto);
            users.add(user);
        }

        return users;
    }
}
