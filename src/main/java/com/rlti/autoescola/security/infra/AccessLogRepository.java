package com.rlti.autoescola.security.infra;

import com.rlti.autoescola.security.user.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLogRepository  extends JpaRepository<AccessLog, Long> {
}
