package ru.cft.template.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String id;
    private String walletId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private long phone;
    private String password;
    private LocalDate registrationDate;
    private LocalDate lastUpdateDate;
    private int age;
}
