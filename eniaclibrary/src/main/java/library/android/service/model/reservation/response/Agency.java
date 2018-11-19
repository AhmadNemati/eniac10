
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agency {

    @SerializedName("BillingInfo")
    @Expose
    private Object billingInfo;
    @SerializedName("ContactInfo")
    @Expose
    private Object contactInfo;

    public Object getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(Object billingInfo) {
        this.billingInfo = billingInfo;
    }

    public Object getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Object contactInfo) {
        this.contactInfo = contactInfo;
    }

}
