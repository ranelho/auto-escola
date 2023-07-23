package com.rlti.autoescola.security.user.domain;

import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.security.auth.api.RegisterRequest;
import com.rlti.autoescola.security.token.domain.Token;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;


    public User(ClienteRequest clienteRequest) {
        String[] nameParts = extractFirstAndLastName(clienteRequest.fullName());
        this.firstName = nameParts[0];
        this.lastName = nameParts[1];
        this.email = clienteRequest.email();
        this.password = new  BCryptPasswordEncoder().encode(lastName.toLowerCase());
        this.role = Role.USER;
    }

    public User(RegisterRequest request, PasswordEncoder passwordEncoder) {
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.email = request.getEmail();
        this.password = passwordEncoder.encode(request.getPassword());
        this.role = request.getRole();
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
