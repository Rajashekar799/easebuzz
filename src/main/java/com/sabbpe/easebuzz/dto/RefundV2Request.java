/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  lombok.Generated
 */
package com.sabbpe.easebuzz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.Generated;

public class RefundV2Request {
    private String key;
    private String salt;
    private String merchant_refund_id;
    private String easebuzz_id;
    private String refund_amount;
    private String udf1 = "";
    private String udf2 = "";
    private String udf3 = "";
    private String udf4 = "";
    private String udf5 = "";
    private String udf6 = "";
    private String udf7 = "";
    @JsonInclude(value=JsonInclude.Include.NON_NULL)
    private Map<String, Object> split_labels;

    @Generated
    public String getKey() {
        return this.key;
    }

    @Generated
    public String getSalt() {
        return this.salt;
    }

    @Generated
    public String getMerchant_refund_id() {
        return this.merchant_refund_id;
    }

    @Generated
    public String getEasebuzz_id() {
        return this.easebuzz_id;
    }

    @Generated
    public String getRefund_amount() {
        return this.refund_amount;
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
    public Map<String, Object> getSplit_labels() {
        return this.split_labels;
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
    public void setMerchant_refund_id(String merchant_refund_id) {
        this.merchant_refund_id = merchant_refund_id;
    }

    @Generated
    public void setEasebuzz_id(String easebuzz_id) {
        this.easebuzz_id = easebuzz_id;
    }

    @Generated
    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
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
    public void setSplit_labels(Map<String, Object> split_labels) {
        this.split_labels = split_labels;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RefundV2Request)) {
            return false;
        }
        RefundV2Request other = (RefundV2Request)o;
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
        String this$merchant_refund_id = this.getMerchant_refund_id();
        String other$merchant_refund_id = other.getMerchant_refund_id();
        if (this$merchant_refund_id == null ? other$merchant_refund_id != null : !this$merchant_refund_id.equals(other$merchant_refund_id)) {
            return false;
        }
        String this$easebuzz_id = this.getEasebuzz_id();
        String other$easebuzz_id = other.getEasebuzz_id();
        if (this$easebuzz_id == null ? other$easebuzz_id != null : !this$easebuzz_id.equals(other$easebuzz_id)) {
            return false;
        }
        String this$refund_amount = this.getRefund_amount();
        String other$refund_amount = other.getRefund_amount();
        if (this$refund_amount == null ? other$refund_amount != null : !this$refund_amount.equals(other$refund_amount)) {
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
        if (this$udf7 == null ? other$udf7 != null : !this$udf7.equals(other$udf7)) {
            return false;
        }
        Map<String, Object> this$split_labels = this.getSplit_labels();
        Map<String, Object> other$split_labels = other.getSplit_labels();
        return !(this$split_labels == null ? other$split_labels != null : !((Object)this$split_labels).equals(other$split_labels));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RefundV2Request;
    }

    @Generated
    public int hashCode() {
        // ...existing code...
        int result = 1;
        String $key = this.getKey();
        result = result * 59 + ($key == null ? 43 : $key.hashCode());
        String $salt = this.getSalt();
        result = result * 59 + ($salt == null ? 43 : $salt.hashCode());
        String $merchant_refund_id = this.getMerchant_refund_id();
        result = result * 59 + ($merchant_refund_id == null ? 43 : $merchant_refund_id.hashCode());
        String $easebuzz_id = this.getEasebuzz_id();
        result = result * 59 + ($easebuzz_id == null ? 43 : $easebuzz_id.hashCode());
        String $refund_amount = this.getRefund_amount();
        result = result * 59 + ($refund_amount == null ? 43 : $refund_amount.hashCode());
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
        Map<String, Object> $split_labels = this.getSplit_labels();
        result = result * 59 + ($split_labels == null ? 43 : ((Object)$split_labels).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "RefundV2Request(key=" + this.getKey() + ", salt=" + this.getSalt() + ", merchant_refund_id=" + this.getMerchant_refund_id() + ", easebuzz_id=" + this.getEasebuzz_id() + ", refund_amount=" + this.getRefund_amount() + ", udf1=" + this.getUdf1() + ", udf2=" + this.getUdf2() + ", udf3=" + this.getUdf3() + ", udf4=" + this.getUdf4() + ", udf5=" + this.getUdf5() + ", udf6=" + this.getUdf6() + ", udf7=" + this.getUdf7() + ", split_labels=" + String.valueOf(this.getSplit_labels()) + ")";
    }

    @Generated
    public RefundV2Request(String key, String salt, String merchant_refund_id, String easebuzz_id, String refund_amount, String udf1, String udf2, String udf3, String udf4, String udf5, String udf6, String udf7, Map<String, Object> split_labels) {
        this.key = key;
        this.salt = salt;
        this.merchant_refund_id = merchant_refund_id;
        this.easebuzz_id = easebuzz_id;
        this.refund_amount = refund_amount;
        this.udf1 = udf1;
        this.udf2 = udf2;
        this.udf3 = udf3;
        this.udf4 = udf4;
        this.udf5 = udf5;
        this.udf6 = udf6;
        this.udf7 = udf7;
        this.split_labels = split_labels;
    }

    @Generated
    public RefundV2Request() {
    }
}
