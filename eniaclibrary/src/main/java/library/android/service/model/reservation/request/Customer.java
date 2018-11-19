
package library.android.service.model.reservation.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("BillingInfo")
    @Expose
    private Object billingInfo;
    @SerializedName("ContactInfo")
    @Expose
    private ContactInfo contactInfo;
    @SerializedName("ShippingInfo")
    @Expose
    private Object shippingInfo;

    public Object getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(Object billingInfo) {
        this.billingInfo = billingInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Object getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(Object shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

}
