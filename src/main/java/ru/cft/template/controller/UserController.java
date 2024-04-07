package ru.cft.template.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cft.template.dto.UserDto;
import ru.cft.template.service.UsersService;

import java.util.Optional;

@Validated
@RestController
//@CrossOrigin(origins = "*")
@RequestMapping(value = "users")
@Tag(name = "api.user.tag.name", description = "api.user.tag.description")
public class UserController {
  private final UsersService usersService;

  @Autowired
  public UserController(UsersService usersService) {
    this.usersService = usersService;
  }

  @GetMapping(value = "{id}")
  public ResponseEntity<Optional<UserDto>> findUserById(@PathVariable String id) {
      return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<String> createUser(@RequestBody @Valid UserDto user) {
      usersService.create(user);
      return new ResponseEntity<>(HttpStatus.OK);
  }

  @PatchMapping(value = "{id}")
  public ResponseEntity<Void> updateUser(@RequestBody @Valid UserDto user) {
      usersService.updateUser(user);
      return new ResponseEntity<>(HttpStatus.OK);
  }


}
