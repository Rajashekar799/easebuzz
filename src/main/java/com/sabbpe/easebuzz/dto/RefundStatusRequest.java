/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.sabbpe.easebuzz.dto;

import lombok.Generated;

public class RefundStatusRequest {
    private String key;
    private String salt;
    private String easebuzz_id;
    private String merchant_refund_id = "";

    @Generated
    public String getKey() {
        return this.key;
    }

    @Generated
    public String getSalt() {
        return this.salt;
    }

    @Generated
    public String getEasebuzz_id() {
        return this.easebuzz_id;
    }

    @Generated
    public String getMerchant_refund_id() {
        return this.merchant_refund_id;
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
    public void setEasebuzz_id(String easebuzz_id) {
        this.easebuzz_id = easebuzz_id;
    }

    @Generated
    public void setMerchant_refund_id(String merchant_refund_id) {
        this.merchant_refund_id = merchant_refund_id;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RefundStatusRequest)) {
            return false;
        }
        RefundStatusRequest other = (RefundStatusRequest)o;
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
        String this$easebuzz_id = this.getEasebuzz_id();
        String other$easebuzz_id = other.getEasebuzz_id();
        if (this$easebuzz_id == null ? other$easebuzz_id != null : !this$easebuzz_id.equals(other$easebuzz_id)) {
            return false;
        }
        String this$merchant_refund_id = this.getMerchant_refund_id();
        String other$merchant_refund_id = other.getMerchant_refund_id();
        return !(this$merchant_refund_id == null ? other$merchant_refund_id != null : !this$merchant_refund_id.equals(other$merchant_refund_id));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RefundStatusRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $key = this.getKey();
        result = result * 59 + ($key == null ? 43 : $key.hashCode());
        String $salt = this.getSalt();
        result = result * 59 + ($salt == null ? 43 : $salt.hashCode());
        String $easebuzz_id = this.getEasebuzz_id();
        result = result * 59 + ($easebuzz_id == null ? 43 : $easebuzz_id.hashCode());
        String $merchant_refund_id = this.getMerchant_refund_id();
        result = result * 59 + ($merchant_refund_id == null ? 43 : $merchant_refund_id.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "RefundStatusRequest(key=" + this.getKey() + ", salt=" + this.getSalt() + ", easebuzz_id=" + this.getEasebuzz_id() + ", merchant_refund_id=" + this.getMerchant_refund_id() + ")";
    }

    @Generated
    public RefundStatusRequest(String key, String salt, String easebuzz_id, String merchant_refund_id) {
        this.key = key;
        this.salt = salt;
        this.easebuzz_id = easebuzz_id;
        this.merchant_refund_id = merchant_refund_id;
    }

    @Generated
    public RefundStatusRequest() {
    }
}
