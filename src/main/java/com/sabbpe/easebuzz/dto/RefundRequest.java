/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.sabbpe.easebuzz.dto;

import lombok.Generated;

public class RefundRequest {
    private String key;
    private String salt;
    private String txnid;
    private String refund_amount;
    private String phone;
    private String email;
    private String amount;
    private String udf1 = "";
    private String udf2 = "";
    private String udf3 = "";
    private String udf4 = "";
    private String udf5 = "";
    private String udf6 = "";
    private String udf7 = "";

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
    public String getRefund_amount() {
        return this.refund_amount;
    }

    @Generated
    public String getPhone() {
        return this.phone;
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public String getAmount() {
        return this.amount;
    }

    @Generated
    public String getUdf1() {
        return this.udf1;
    }

    @Generated
    public String getUdf2() {
        return this.udf2;
    }

    @Generated
    public String getUdf3() {
        return this.udf3;
    }

    @Generated
    public String getUdf4() {
        return this.udf4;
    }

    @Generated
    public String getUdf5() {
        return this.udf5;
    }

    @Generated
    public String getUdf6() {
        return this.udf6;
    }

    @Generated
    public String getUdf7() {
        return this.udf7;
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
    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }

    @Generated
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Generated
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Generated
    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    @Generated
    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    @Generated
    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    @Generated
    public void setUdf4(String udf4) {
        this.udf4 = udf4;
    }

    @Generated
    public void setUdf5(String udf5) {
        this.udf5 = udf5;
    }

    @Generated
    public void setUdf6(String udf6) {
        this.udf6 = udf6;
    }

    @Generated
    public void setUdf7(String udf7) {
        this.udf7 = udf7;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RefundRequest)) {
            return false;
        }
        RefundRequest other = (RefundRequest)o;
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
        String this$refund_amount = this.getRefund_amount();
        String other$refund_amount = other.getRefund_amount();
        if (this$refund_amount == null ? other$refund_amount != null : !this$refund_amount.equals(other$refund_amount)) {
            return false;
        }
        String this$phone = this.getPhone();
        String other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) {
            return false;
        }
        String this$email = this.getEmail();
        String other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        String this$amount = this.getAmount();
        String other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) {
            return false;
        }
        String this$udf1 = this.getUdf1();
        String other$udf1 = other.getUdf1();
        if (this$udf1 == null ? other$udf1 != null : !this$udf1.equals(other$udf1)) {
            return false;
        }
        String this$udf2 = this.getUdf2();
        String other$udf2 = other.getUdf2();
        if (this$udf2 == null ? other$udf2 != null : !this$udf2.equals(other$udf2)) {
            return false;
        }
        String this$udf3 = this.getUdf3();
        String other$udf3 = other.getUdf3();
        if (this$udf3 == null ? other$udf3 != null : !this$udf3.equals(other$udf3)) {
            return false;
        }
        String this$udf4 = this.getUdf4();
        String other$udf4 = other.getUdf4();
        if (this$udf4 == null ? other$udf4 != null : !this$udf4.equals(other$udf4)) {
            return false;
        }
        String this$udf5 = this.getUdf5();
        String other$udf5 = other.getUdf5();
        if (this$udf5 == null ? other$udf5 != null : !this$udf5.equals(other$udf5)) {
            return false;
        }
        String this$udf6 = this.getUdf6();
        String other$udf6 = other.getUdf6();
        if (this$udf6 == null ? other$udf6 != null : !this$udf6.equals(other$udf6)) {
            return false;
        }
        String this$udf7 = this.getUdf7();
        String other$udf7 = other.getUdf7();
        return !(this$udf7 == null ? other$udf7 != null : !this$udf7.equals(other$udf7));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RefundRequest;
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
        String $refund_amount = this.getRefund_amount();
        result = result * 59 + ($refund_amount == null ? 43 : $refund_amount.hashCode());
        String $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        String $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
        String $udf1 = this.getUdf1();
        result = result * 59 + ($udf1 == null ? 43 : $udf1.hashCode());
        String $udf2 = this.getUdf2();
        result = result * 59 + ($udf2 == null ? 43 : $udf2.hashCode());
        String $udf3 = this.getUdf3();
        result = result * 59 + ($udf3 == null ? 43 : $udf3.hashCode());
        String $udf4 = this.getUdf4();
        result = result * 59 + ($udf4 == null ? 43 : $udf4.hashCode());
        String $udf5 = this.getUdf5();
        result = result * 59 + ($udf5 == null ? 43 : $udf5.hashCode());
        String $udf6 = this.getUdf6();
        result = result * 59 + ($udf6 == null ? 43 : $udf6.hashCode());
        String $udf7 = this.getUdf7();
        result = result * 59 + ($udf7 == null ? 43 : $udf7.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "RefundRequest(key=" + this.getKey() + ", salt=" + this.getSalt() + ", txnid=" + this.getTxnid() + ", refund_amount=" + this.getRefund_amount() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", amount=" + this.getAmount() + ", udf1=" + this.getUdf1() + ", udf2=" + this.getUdf2() + ", udf3=" + this.getUdf3() + ", udf4=" + this.getUdf4() + ", udf5=" + this.getUdf5() + ", udf6=" + this.getUdf6() + ", udf7=" + this.getUdf7() + ")";
    }

    @Generated
    public RefundRequest(String key, String salt, String txnid, String refund_amount, String phone, String email, String amount, String udf1, String udf2, String udf3, String udf4, String udf5, String udf6, String udf7) {
        this.key = key;
        this.salt = salt;
        this.txnid = txnid;
        this.refund_amount = refund_amount;
        this.phone = phone;
        this.email = email;
        this.amount = amount;
        this.udf1 = udf1;
        this.udf2 = udf2;
        this.udf3 = udf3;
        this.udf4 = udf4;
        this.udf5 = udf5;
        this.udf6 = udf6;
        this.udf7 = udf7;
    }

    @Generated
    public RefundRequest() {
    }
}
