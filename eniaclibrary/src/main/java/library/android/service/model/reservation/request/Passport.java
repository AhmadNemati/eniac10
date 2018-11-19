
package library.android.service.model.reservation.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Passport {

    @SerializedName("Citizenship")
    @Expose
    private String citizenship;
    @SerializedName("Issued")
    @Expose
    private String issued;
    @SerializedName("Number")
    @Expose
    private String number;
    @SerializedName("ValidityDate")
    @Expose
    private String validityDate;

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

}
