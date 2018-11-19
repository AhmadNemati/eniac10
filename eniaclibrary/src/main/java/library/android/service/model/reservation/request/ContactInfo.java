
package library.android.service.model.reservation.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactInfo {

    @SerializedName("ContactName")
    @Expose
    private String contactName;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Telephone")
    @Expose
    private Telephone telephone;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

}
