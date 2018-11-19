
package library.android.service.model.reservation.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Telephone {

    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
