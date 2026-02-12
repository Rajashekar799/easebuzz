package com.sabbpe.easebuzz.repositories;

import com.sabbpe.easebuzz.models.EasebuzzRequestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EasebuzzLogRepository
        extends JpaRepository<EasebuzzRequestResponse, Long> {

    Optional<EasebuzzRequestResponse> findByTxnId(String txnId);

    boolean existsByTxnId(String txnId);
}
