package ru.cft.template.repository.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.cft.template.dto.UserDto;
import ru.cft.template.repository.UsersRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UsersRepository {
    private final Map<String, UserDto> usersMap = new HashMap<>();
    private static int counter = 0;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void addUser(UserDto user) {
        counter += 1;
        String userId = String.valueOf(counter);

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setId(userId);
        usersMap.put(userId, user);
    }

    @Override
    public void updateUser(UserDto user) {
        String userId = user.getId();

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        usersMap.put(userId, user);
    }

    @Override
    public Optional<UserDto> findUserById(String id) {
        return Optional.ofNullable(usersMap.get(id));
    }

}

