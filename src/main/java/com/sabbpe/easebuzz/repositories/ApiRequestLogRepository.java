package com.sabbpe.easebuzz.repositories;

import com.sabbpe.easebuzz.models.ApiRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRequestLogRepository extends JpaRepository<ApiRequestLog, Long> {
}
