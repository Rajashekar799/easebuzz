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

public class InitiateRequest {
    private String key;
    private String salt;
    private String txnid;
    private String amount;
    private String productinfo;
    private String firstname;
    private String phone;
    private String email;
    private String surl;
    private String furl;
    private String udf1 = "";
    private String udf2 = "";
    private String udf3 = "";
    private String udf4 = "";
    private String udf5 = "";
    private String udf6 = "";
    private String udf7 = "";
    private String address1 = "";
    private String address2 = "";
    private String city = "";
    private String state = "";
    private String country = "";
    private String zipcode = "";
    private String show_payment_mode = "";
    @JsonInclude(value=JsonInclude.Include.NON_NULL)
    private Map<String, Object> split_payments;
    private String request_flow = "";
    private String sub_merchant_id = "";
    private String payment_category = "";
    private String account_no = "";
    private String ifsc = "";
    private String unique_id = "";

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
    public String getProductinfo() {
        return this.productinfo;
    }

    @Generated
    public String getFirstname() {
        return this.firstname;
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
    public String getSurl() {
        return this.surl;
    }

    @Generated
    public String getFurl() {
        return this.furl;
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
    public String getAddress1() {
        return this.address1;
    }

    @Generated
    public String getAddress2() {
        return this.address2;
    }

    @Generated
    public String getCity() {
        return this.city;
    }

    @Generated
    public String getState() {
        return this.state;
    }

    @Generated
    public String getCountry() {
        return this.country;
    }

    @Generated
    public String getZipcode() {
        return this.zipcode;
    }

    @Generated
    public String getShow_payment_mode() {
        return this.show_payment_mode;
    }

    @Generated
    public Map<String, Object> getSplit_payments() {
        return this.split_payments;
    }

    @Generated
    public String getRequest_flow() {
        return this.request_flow;
    }

    @Generated
    public String getSub_merchant_id() {
        return this.sub_merchant_id;
    }

    @Generated
    public String getPayment_category() {
        return this.payment_category;
    }

    @Generated
    public String getAccount_no() {
        return this.account_no;
    }

    @Generated
    public String getIfsc() {
        return this.ifsc;
    }

    @Generated
    public String getUnique_id() {
        return this.unique_id;
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
    public void setProductinfo(String productinfo) {
        this.productinfo = productinfo;
    }

    @Generated
    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
    public void setSurl(String surl) {
        this.surl = surl;
    }

    @Generated
    public void setFurl(String furl) {
        this.furl = furl;
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
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Generated
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Generated
    public void setCity(String city) {
        this.city = city;
    }

    @Generated
    public void setState(String state) {
        this.state = state;
    }

    @Generated
    public void setCountry(String country) {
        this.country = country;
    }

    @Generated
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Generated
    public void setShow_payment_mode(String show_payment_mode) {
        this.show_payment_mode = show_payment_mode;
    }

    @Generated
    public void setSplit_payments(Map<String, Object> split_payments) {
        this.split_payments = split_payments;
    }

    @Generated
    public void setRequest_flow(String request_flow) {
        this.request_flow = request_flow;
    }

    @Generated
    public void setSub_merchant_id(String sub_merchant_id) {
        this.sub_merchant_id = sub_merchant_id;
    }

    @Generated
    public void setPayment_category(String payment_category) {
        this.payment_category = payment_category;
    }

    @Generated
    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    @Generated
    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    @Generated
    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InitiateRequest)) {
            return false;
        }
        InitiateRequest other = (InitiateRequest)o;
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
        String this$productinfo = this.getProductinfo();
        String other$productinfo = other.getProductinfo();
        if (this$productinfo == null ? other$productinfo != null : !this$productinfo.equals(other$productinfo)) {
            return false;
        }
        String this$firstname = this.getFirstname();
        String other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) {
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
        String this$surl = this.getSurl();
        String other$surl = other.getSurl();
        if (this$surl == null ? other$surl != null : !this$surl.equals(other$surl)) {
            return false;
        }
        String this$furl = this.getFurl();
        String other$furl = other.getFurl();
        if (this$furl == null ? other$furl != null : !this$furl.equals(other$furl)) {
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
        String this$address1 = this.getAddress1();
        String other$address1 = other.getAddress1();
        if (this$address1 == null ? other$address1 != null : !this$address1.equals(other$address1)) {
            return false;
        }
        String this$address2 = this.getAddress2();
        String other$address2 = other.getAddress2();
        if (this$address2 == null ? other$address2 != null : !this$address2.equals(other$address2)) {
            return false;
        }
        String this$city = this.getCity();
        String other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) {
            return false;
        }
        String this$state = this.getState();
        String other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        String this$country = this.getCountry();
        String other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) {
            return false;
        }
        String this$zipcode = this.getZipcode();
        String other$zipcode = other.getZipcode();
        if (this$zipcode == null ? other$zipcode != null : !this$zipcode.equals(other$zipcode)) {
            return false;
        }
        String this$show_payment_mode = this.getShow_payment_mode();
        String other$show_payment_mode = other.getShow_payment_mode();
        if (this$show_payment_mode == null ? other$show_payment_mode != null : !this$show_payment_mode.equals(other$show_payment_mode)) {
            return false;
        }
        Map<String, Object> this$split_payments = this.getSplit_payments();
        Map<String, Object> other$split_payments = other.getSplit_payments();
        if (this$split_payments == null ? other$split_payments != null : !((Object)this$split_payments).equals(other$split_payments)) {
            return false;
        }
        String this$request_flow = this.getRequest_flow();
        String other$request_flow = other.getRequest_flow();
        if (this$request_flow == null ? other$request_flow != null : !this$request_flow.equals(other$request_flow)) {
            return false;
        }
        String this$sub_merchant_id = this.getSub_merchant_id();
        String other$sub_merchant_id = other.getSub_merchant_id();
        if (this$sub_merchant_id == null ? other$sub_merchant_id != null : !this$sub_merchant_id.equals(other$sub_merchant_id)) {
            return false;
        }
        String this$payment_category = this.getPayment_category();
        String other$payment_category = other.getPayment_category();
        if (this$payment_category == null ? other$payment_category != null : !this$payment_category.equals(other$payment_category)) {
            return false;
        }
        String this$account_no = this.getAccount_no();
        String other$account_no = other.getAccount_no();
        if (this$account_no == null ? other$account_no != null : !this$account_no.equals(other$account_no)) {
            return false;
        }
        String this$ifsc = this.getIfsc();
        String other$ifsc = other.getIfsc();
        if (this$ifsc == null ? other$ifsc != null : !this$ifsc.equals(other$ifsc)) {
            return false;
        }
        String this$unique_id = this.getUnique_id();
        String other$unique_id = other.getUnique_id();
        return !(this$unique_id == null ? other$unique_id != null : !this$unique_id.equals(other$unique_id));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof InitiateRequest;
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
        String $productinfo = this.getProductinfo();
        result = result * 59 + ($productinfo == null ? 43 : $productinfo.hashCode());
        String $firstname = this.getFirstname();
        result = result * 59 + ($firstname == null ? 43 : $firstname.hashCode());
        String $phone = this.getPhone();
        result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        String $surl = this.getSurl();
        result = result * 59 + ($surl == null ? 43 : $surl.hashCode());
        String $furl = this.getFurl();
        result = result * 59 + ($furl == null ? 43 : $furl.hashCode());
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
        String $address1 = this.getAddress1();
        result = result * 59 + ($address1 == null ? 43 : $address1.hashCode());
        String $address2 = this.getAddress2();
        result = result * 59 + ($address2 == null ? 43 : $address2.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        String $state = this.getState();
        result = result * 59 + ($state == null ? 43 : $state.hashCode());
        String $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        String $zipcode = this.getZipcode();
        result = result * 59 + ($zipcode == null ? 43 : $zipcode.hashCode());
        String $show_payment_mode = this.getShow_payment_mode();
        result = result * 59 + ($show_payment_mode == null ? 43 : $show_payment_mode.hashCode());
        Map<String, Object> $split_payments = this.getSplit_payments();
        result = result * 59 + ($split_payments == null ? 43 : ((Object)$split_payments).hashCode());
        String $request_flow = this.getRequest_flow();
        result = result * 59 + ($request_flow == null ? 43 : $request_flow.hashCode());
        String $sub_merchant_id = this.getSub_merchant_id();
        result = result * 59 + ($sub_merchant_id == null ? 43 : $sub_merchant_id.hashCode());
        String $payment_category = this.getPayment_category();
        result = result * 59 + ($payment_category == null ? 43 : $payment_category.hashCode());
        String $account_no = this.getAccount_no();
        result = result * 59 + ($account_no == null ? 43 : $account_no.hashCode());
        String $ifsc = this.getIfsc();
        result = result * 59 + ($ifsc == null ? 43 : $ifsc.hashCode());
        String $unique_id = this.getUnique_id();
        result = result * 59 + ($unique_id == null ? 43 : $unique_id.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "InitiateRequest(key=" + this.getKey() + ", salt=" + this.getSalt() + ", txnid=" + this.getTxnid() + ", amount=" + this.getAmount() + ", productinfo=" + this.getProductinfo() + ", firstname=" + this.getFirstname() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", surl=" + this.getSurl() + ", furl=" + this.getFurl() + ", udf1=" + this.getUdf1() + ", udf2=" + this.getUdf2() + ", udf3=" + this.getUdf3() + ", udf4=" + this.getUdf4() + ", udf5=" + this.getUdf5() + ", udf6=" + this.getUdf6() + ", udf7=" + this.getUdf7() + ", address1=" + this.getAddress1() + ", address2=" + this.getAddress2() + ", city=" + this.getCity() + ", state=" + this.getState() + ", country=" + this.getCountry() + ", zipcode=" + this.getZipcode() + ", show_payment_mode=" + this.getShow_payment_mode() + ", split_payments=" + String.valueOf(this.getSplit_payments()) + ", request_flow=" + this.getRequest_flow() + ", sub_merchant_id=" + this.getSub_merchant_id() + ", payment_category=" + this.getPayment_category() + ", account_no=" + this.getAccount_no() + ", ifsc=" + this.getIfsc() + ", unique_id=" + this.getUnique_id() + ")";
    }

    @Generated
    public InitiateRequest(String key, String salt, String txnid, String amount, String productinfo, String firstname, String phone, String email, String surl, String furl, String udf1, String udf2, String udf3, String udf4, String udf5, String udf6, String udf7, String address1, String address2, String city, String state, String country, String zipcode, String show_payment_mode, Map<String, Object> split_payments, String request_flow, String sub_merchant_id, String payment_category, String account_no, String ifsc, String unique_id) {
        this.key = key;
        this.salt = salt;
        this.txnid = txnid;
        this.amount = amount;
        this.productinfo = productinfo;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
        this.surl = surl;
        this.furl = furl;
        this.udf1 = udf1;
        this.udf2 = udf2;
        this.udf3 = udf3;
        this.udf4 = udf4;
        this.udf5 = udf5;
        this.udf6 = udf6;
        this.udf7 = udf7;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.show_payment_mode = show_payment_mode;
        this.split_payments = split_payments;
        this.request_flow = request_flow;
        this.sub_merchant_id = sub_merchant_id;
        this.payment_category = payment_category;
        this.account_no = account_no;
        this.ifsc = ifsc;
        this.unique_id = unique_id;
    }

    @Generated
    public InitiateRequest() {
    }
}
