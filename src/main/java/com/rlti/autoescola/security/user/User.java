package com.rlti.autoescola.security.user;

import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.security.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID idUser;
  private String firstname;
  private String lastname;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Token> tokens;


  public User(ClienteRequest clienteRequest) {
    String[] nameParts = extractFirstAndLastName(clienteRequest.getFullName());
      this.firstname = nameParts[0];
      this.lastname = nameParts[1];
      this.email = clienteRequest.getEmail();
      this.password = new  BCryptPasswordEncoder().encode(lastname.toLowerCase());
      this.role = Role.USER;
  }

  private static String[] extractFirstAndLastName(String fullName) {
    String[] parts = fullName.split(" ");
    String firstName = parts[0];
    String lastName = parts[parts.length - 1];
    return new String[]{firstName, lastName};
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
