package com.rlti.autoescola.security.auth.api;

import com.rlti.autoescola.security.user.domain.Role;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstName;
  private String lastName;
  @Email
  private String email;
  private String password;
  private Role role;
}
