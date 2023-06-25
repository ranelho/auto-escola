package com.rlti.autoescola.security.user.infra;

import com.rlti.autoescola.security.user.domain.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLogRepository  extends JpaRepository<AccessLog, Long> {
}
