/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package com.sabbpe.easebuzz.utils;

import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasebuzzLogger {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(EasebuzzLogger.class);

    public static void log(String title, Object clientPayload, String hash, Object easebuzzRequest, String url, Object response) {
        log.info("========== {} ==========", (Object)title);
        if (clientPayload != null) {
            log.info("Client Request Payload: {}", clientPayload);
        }
        if (hash != null && !hash.isEmpty()) {
            log.info("Generated Hash: {}", (Object)hash);
        }
        if (url != null) {
            log.info("Easebuzz Request URL: {}", (Object)url);
        }
        if (easebuzzRequest != null) {
            log.info("Easebuzz Request Payload: {}", easebuzzRequest);
        }
        if (response != null) {
            log.info("Easebuzz Response: {}", response);
        }
        log.info("=======================================");
    }
}
