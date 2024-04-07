package ru.cft.template.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", nullable = false)
  private String id;

  @Column(name = "wallet_id", nullable = false)
  private String walletId;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone", nullable = false)
  private long phone;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "registration_date", nullable = false)
  private LocalDate registrationDate;

  @Column(name = "last_update_date", nullable = false)
  private LocalDate lastUpdateDate;

  @Column(name = "age", nullable = false)
  private int age;
}
