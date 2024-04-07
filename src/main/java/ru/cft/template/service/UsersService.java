package ru.cft.template.service;

import ru.cft.template.dto.UserDto;
import ru.cft.template.exception.UsernameNotFoundException;

import java.util.Optional;

public interface UsersService {

  void create(UserDto user);

  Optional<UserDto> findById(String id) throws UsernameNotFoundException;

  void updateUser(UserDto user);
}
