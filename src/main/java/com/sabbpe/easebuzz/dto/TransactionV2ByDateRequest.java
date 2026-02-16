/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.sabbpe.easebuzz.dto;

import lombok.Generated;

public class TransactionV2ByDateRequest {
    private String key;
    private String salt;
    private String merchant_email = "";
    private DateRange date_range;
    private String submerchant_id = "";
    private String page;
    private String token = "";

    @Generated
    public String getKey() {
        return this.key;
    }

    @Generated
    public String getSalt() {
        return this.salt;
    }

    @Generated
    public String getMerchant_email() {
        return this.merchant_email;
    }

    @Generated
    public DateRange getDate_range() {
        return this.date_range;
    }

    @Generated
    public String getSubmerchant_id() {
        return this.submerchant_id;
    }

    @Generated
    public String getPage() {
        return this.page;
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public void setKey(String key) {
        this.key = key;
    }

    @Generated
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Generated
    public void setMerchant_email(String merchant_email) {
        this.merchant_email = merchant_email;
    }

    @Generated
    public void setDate_range(DateRange date_range) {
        this.date_range = date_range;
    }

    @Generated
    public void setSubmerchant_id(String submerchant_id) {
        this.submerchant_id = submerchant_id;
    }

    @Generated
    public void setPage(String page) {
        this.page = page;
    }

    @Generated
    public void setToken(String token) {
        this.token = token;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TransactionV2ByDateRequest)) {
            return false;
        }
        TransactionV2ByDateRequest other = (TransactionV2ByDateRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$key = this.getKey();
        String other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        String this$salt = this.getSalt();
        String other$salt = other.getSalt();
        if (this$salt == null ? other$salt != null : !this$salt.equals(other$salt)) {
            return false;
        }
        String this$merchant_email = this.getMerchant_email();
        String other$merchant_email = other.getMerchant_email();
        if (this$merchant_email == null ? other$merchant_email != null : !this$merchant_email.equals(other$merchant_email)) {
            return false;
        }
        DateRange this$date_range = this.getDate_range();
        DateRange other$date_range = other.getDate_range();
        if (this$date_range == null ? other$date_range != null : !((Object)this$date_range).equals(other$date_range)) {
            return false;
        }
        String this$submerchant_id = this.getSubmerchant_id();
        String other$submerchant_id = other.getSubmerchant_id();
        if (this$submerchant_id == null ? other$submerchant_id != null : !this$submerchant_id.equals(other$submerchant_id)) {
            return false;
        }
        String this$page = this.getPage();
        String other$page = other.getPage();
        if (this$page == null ? other$page != null : !this$page.equals(other$page)) {
            return false;
        }
        String this$token = this.getToken();
        String other$token = other.getToken();
        return !(this$token == null ? other$token != null : !this$token.equals(other$token));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TransactionV2ByDateRequest;
    }

    @Generated
    public int hashCode() {
        // ...existing code...
        int result = 1;
        String $key = this.getKey();
        result = result * 59 + ($key == null ? 43 : $key.hashCode());
        String $salt = this.getSalt();
        result = result * 59 + ($salt == null ? 43 : $salt.hashCode());
        String $merchant_email = this.getMerchant_email();
        result = result * 59 + ($merchant_email == null ? 43 : $merchant_email.hashCode());
        DateRange $date_range = this.getDate_range();
        result = result * 59 + ($date_range == null ? 43 : ((Object)$date_range).hashCode());
        String $submerchant_id = this.getSubmerchant_id();
        result = result * 59 + ($submerchant_id == null ? 43 : $submerchant_id.hashCode());
        String $page = this.getPage();
        result = result * 59 + ($page == null ? 43 : $page.hashCode());
        String $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TransactionV2ByDateRequest(key=" + this.getKey() + ", salt=" + this.getSalt() + ", merchant_email=" + this.getMerchant_email() + ", date_range=" + String.valueOf(this.getDate_range()) + ", submerchant_id=" + this.getSubmerchant_id() + ", page=" + this.getPage() + ", token=" + this.getToken() + ")";
    }

    @Generated
    public TransactionV2ByDateRequest(String key, String salt, String merchant_email, DateRange date_range, String submerchant_id, String page, String token) {
        this.key = key;
        this.salt = salt;
        this.merchant_email = merchant_email;
        this.date_range = date_range;
        this.submerchant_id = submerchant_id;
        this.page = page;
        this.token = token;
    }

    @Generated
    public TransactionV2ByDateRequest() {
    }

    public static class DateRange {
        private String start_date;
        private String end_date;

        @Generated
        public String getStart_date() {
            return this.start_date;
        }

        @Generated
        public String getEnd_date() {
            return this.end_date;
        }

        @Generated
        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        @Generated
        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DateRange)) {
                return false;
            }
            DateRange other = (DateRange)o;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$start_date = this.getStart_date();
            String other$start_date = other.getStart_date();
            if (this$start_date == null ? other$start_date != null : !this$start_date.equals(other$start_date)) {
                return false;
            }
            String this$end_date = this.getEnd_date();
            String other$end_date = other.getEnd_date();
            return !(this$end_date == null ? other$end_date != null : !this$end_date.equals(other$end_date));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof DateRange;
        }

        @Generated
        public int hashCode() {
            // ...existing code...
            int result = 1;
            String $start_date = this.getStart_date();
            result = result * 59 + ($start_date == null ? 43 : $start_date.hashCode());
            String $end_date = this.getEnd_date();
            result = result * 59 + ($end_date == null ? 43 : $end_date.hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "TransactionV2ByDateRequest.DateRange(start_date=" + this.getStart_date() + ", end_date=" + this.getEnd_date() + ")";
        }

        @Generated
        public DateRange(String start_date, String end_date) {
            this.start_date = start_date;
            this.end_date = end_date;
        }

        @Generated
        public DateRange() {
        }
    }
}
