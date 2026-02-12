package com.sabbpe.easebuzz.repositories;

import com.sabbpe.easebuzz.models.EasebuzzPaymentCallback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EasebuzzPaymentCallbackRepository
        extends JpaRepository<EasebuzzPaymentCallback, Long> {

    Optional<EasebuzzPaymentCallback> findByTxnId(String txnId);

    boolean existsByTxnId(String txnId);
}
