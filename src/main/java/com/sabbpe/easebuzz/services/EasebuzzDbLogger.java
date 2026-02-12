package com.sabbpe.easebuzz.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabbpe.easebuzz.models.ApiRequestLog;
import com.sabbpe.easebuzz.repositories.ApiRequestLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EasebuzzDbLogger {

    private final ApiRequestLogRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public void saveLog(String clientKey,
                        String clientSalt,
                        Object clientPayload,
                        String hash,
                        Object requestPayload,
                        String url,
                        Object responsePayload) {

        try {
                            ApiRequestLog requestLog = ApiRequestLog.builder()
                    .clientKey(clientKey)
                    .clientSalt(clientSalt)
                    .originalPlainRequestJson(mapper.writeValueAsString(clientPayload))
                    .hash(hash)
                    .requestEasebuzzUrl(url)
                    .requestFullPayload(mapper.writeValueAsString(requestPayload))
                    .responseEasebuzzPayload(mapper.writeValueAsString(responsePayload))
                    .build();

                            repo.save(requestLog);
                            log.info("API request log saved for key={}", clientKey);
        } catch (Exception e) {
            log.error("Failed to save API request log", e);
        }
    }
}
