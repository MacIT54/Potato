package ru.cft.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.template.dto.UserDto;
import ru.cft.template.repository.UsersRepository;
import ru.cft.template.service.UsersService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UsersService {
  private final UsersRepository repository;

  @Autowired
  public UserServiceImpl(UsersRepository repository) {
    this.repository = repository;
  }

  @Override
  public void create(UserDto user) {
    repository.addUser(user);
  }

  @Override
  public Optional<UserDto> findById(String id)  {
    return repository.findUserById(id);
  }

  @Override
  public void updateUser(UserDto user) {
    repository.updateUser(user);
  }

}
