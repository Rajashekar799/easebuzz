/*
 * Decompiled with CFR 0.152.
 */
package com.sabbpe.easebuzz.utils;

public class ValueUtil {
    public static String pick(String userValue, String defaultValue) {
        return userValue != null && !userValue.trim().isEmpty() ? userValue.trim() : defaultValue;
    }
}
