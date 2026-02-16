/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.sabbpe.easebuzz.dto;

import lombok.Generated;

public class TransactionV1ByDate {
    private String merchant_key;
    private String salt;
    private String transaction_date;
    private String merchant_email;
    private String submerchant_id;

    @Generated
    public String getMerchant_key() {
        return this.merchant_key;
    }

    @Generated
    public String getSalt() {
        return this.salt;
    }

    @Generated
    public String getTransaction_date() {
        return this.transaction_date;
    }

    @Generated
    public String getMerchant_email() {
        return this.merchant_email;
    }

    @Generated
    public String getSubmerchant_id() {
        return this.submerchant_id;
    }

    @Generated
    public void setMerchant_key(String merchant_key) {
        this.merchant_key = merchant_key;
    }

    @Generated
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Generated
    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    @Generated
    public void setMerchant_email(String merchant_email) {
        this.merchant_email = merchant_email;
    }

    @Generated
    public void setSubmerchant_id(String submerchant_id) {
        this.submerchant_id = submerchant_id;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TransactionV1ByDate)) {
            return false;
        }
        TransactionV1ByDate other = (TransactionV1ByDate)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$merchant_key = this.getMerchant_key();
        String other$merchant_key = other.getMerchant_key();
        if (this$merchant_key == null ? other$merchant_key != null : !this$merchant_key.equals(other$merchant_key)) {
            return false;
        }
        String this$salt = this.getSalt();
        String other$salt = other.getSalt();
        if (this$salt == null ? other$salt != null : !this$salt.equals(other$salt)) {
            return false;
        }
        String this$transaction_date = this.getTransaction_date();
        String other$transaction_date = other.getTransaction_date();
        if (this$transaction_date == null ? other$transaction_date != null : !this$transaction_date.equals(other$transaction_date)) {
            return false;
        }
        String this$merchant_email = this.getMerchant_email();
        String other$merchant_email = other.getMerchant_email();
        if (this$merchant_email == null ? other$merchant_email != null : !this$merchant_email.equals(other$merchant_email)) {
            return false;
        }
        String this$submerchant_id = this.getSubmerchant_id();
        String other$submerchant_id = other.getSubmerchant_id();
        return !(this$submerchant_id == null ? other$submerchant_id != null : !this$submerchant_id.equals(other$submerchant_id));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TransactionV1ByDate;
    }

    @Generated
    public int hashCode() {
        // ...existing code...
        int result = 1;
        String $merchant_key = this.getMerchant_key();
        result = result * 59 + ($merchant_key == null ? 43 : $merchant_key.hashCode());
        String $salt = this.getSalt();
        result = result * 59 + ($salt == null ? 43 : $salt.hashCode());
        String $transaction_date = this.getTransaction_date();
        result = result * 59 + ($transaction_date == null ? 43 : $transaction_date.hashCode());
        String $merchant_email = this.getMerchant_email();
        result = result * 59 + ($merchant_email == null ? 43 : $merchant_email.hashCode());
        String $submerchant_id = this.getSubmerchant_id();
        result = result * 59 + ($submerchant_id == null ? 43 : $submerchant_id.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TransactionV1ByDate(merchant_key=" + this.getMerchant_key() + ", salt=" + this.getSalt() + ", transaction_date=" + this.getTransaction_date() + ", merchant_email=" + this.getMerchant_email() + ", submerchant_id=" + this.getSubmerchant_id() + ")";
    }

    @Generated
    public TransactionV1ByDate(String merchant_key, String salt, String transaction_date, String merchant_email, String submerchant_id) {
        this.merchant_key = merchant_key;
        this.salt = salt;
        this.transaction_date = transaction_date;
        this.merchant_email = merchant_email;
        this.submerchant_id = submerchant_id;
    }

    @Generated
    public TransactionV1ByDate() {
    }
}
