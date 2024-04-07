package ru.cft.template.repository;

import org.springframework.stereotype.Repository;
import ru.cft.template.dto.UserDto;

import java.util.Optional;

@Repository
public interface UsersRepository {
    void addUser(UserDto user);

    void updateUser(UserDto user);

    Optional<UserDto> findUserById(String id);
}
