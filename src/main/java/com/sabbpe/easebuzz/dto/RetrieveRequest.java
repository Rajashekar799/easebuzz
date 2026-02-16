/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.sabbpe.easebuzz.dto;

import lombok.Generated;

public class RetrieveRequest {
    private String key;
    private String salt;
    private String txnid;
    private String amount;
    private String email;
    private String phone;

    @Generated
    public String getKey() {
        return this.key;
    }

    @Generated
    public String getSalt() {
        return this.salt;
    }

    @Generated
    public String getTxnid() {
        return this.txnid;
    }

    @Generated
    public String getAmount() {
        return this.amount;
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public String getPhone() {
        return this.phone;
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
    public void setTxnid(String txnid) {
        this.txnid = txnid;
    }

    @Generated
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Generated
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RetrieveRequest)) {
            return false;
        }
        RetrieveRequest other = (RetrieveRequest)o;
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
        String this$txnid = this.getTxnid();
        String other$txnid = other.getTxnid();
        if (this$txnid == null ? other$txnid != null : !this$txnid.equals(other$txnid)) {
            return false;
        }
        String this$amount = this.getAmount();
        String other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) {
            return false;
        }
        String this$email = this.getEmail();
        String other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        String this$phone = this.getPhone();
        String other$phone = other.getPhone();
        return !(this$phone == null ? other$phone != null : !this$phone.equals(other$phone));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RetrieveRequest;
    }

    @Generated
    public int hashCode() {
        // ...existing code...
        int result = 1;
        String $key = this.getKey();
        result = result * 59 + ($key == null ? 43 : $key.hashCode());
        String $salt = this.getSalt();
        result = result * 59 + ($salt == null ? 43 : $salt.hashCode());
        String $txnid = this.getTxnid();
        result = result * 59 + ($txnid == null ? 43 : $txnid.hashCode());
        String $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        String $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        return result;
    }

    @Generated
    public RetrieveRequest(String key, String salt, String txnid, String amount, String email, String phone) {
        this.key = key;
        this.salt = salt;
        this.txnid = txnid;
        this.amount = amount;
        this.email = email;
        this.phone = phone;
    }

    @Generated
    public RetrieveRequest() {
    }

    @Generated
    public String toString() {
        return "RetrieveRequest(key=" + this.getKey() + ", salt=" + this.getSalt() + ", txnid=" + this.getTxnid() + ", amount=" + this.getAmount() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ")";
    }
}
