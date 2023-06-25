package com.rlti.autoescola.security.user.domain;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class AccessLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private TipoAcesso accessType;

    private LocalDateTime accessTime;

    private String ipAddress;

    public AccessLog(User user, HttpServletRequest httpServletRequest) {
        this.user = user;
        this.accessType = TipoAcesso.LOGIN;
        this.accessTime = LocalDateTime.now();
        this.ipAddress = httpServletRequest.getRemoteAddr();
    }
}

