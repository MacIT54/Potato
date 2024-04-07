package ru.cft.template.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SessionDto {
    private String id;
    private String userId;
    private String token;
    private LocalDate expirationTime;
    private boolean active;
    private long phone;
    private String password;
}
