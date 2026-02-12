/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.sabbpe.easebuzz.dto;

import lombok.Generated;

public class TransactionV2Request {
    private String key;
    private String salt;
    private String txnid;

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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TransactionV2Request)) {
            return false;
        }
        TransactionV2Request other = (TransactionV2Request)o;
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
        return !(this$txnid == null ? other$txnid != null : !this$txnid.equals(other$txnid));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TransactionV2Request;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $key = this.getKey();
        result = result * 59 + ($key == null ? 43 : $key.hashCode());
        String $salt = this.getSalt();
        result = result * 59 + ($salt == null ? 43 : $salt.hashCode());
        String $txnid = this.getTxnid();
        result = result * 59 + ($txnid == null ? 43 : $txnid.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TransactionV2Request(key=" + this.getKey() + ", salt=" + this.getSalt() + ", txnid=" + this.getTxnid() + ")";
    }

    @Generated
    public TransactionV2Request() {
    }

    @Generated
    public TransactionV2Request(String key, String salt, String txnid) {
        this.key = key;
        this.salt = salt;
        this.txnid = txnid;
    }
}
