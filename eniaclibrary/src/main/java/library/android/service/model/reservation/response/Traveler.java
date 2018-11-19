
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Traveler {

    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("GivenName")
    @Expose
    private String givenName;
    @SerializedName("NamePrefix")
    @Expose
    private String namePrefix;
    @SerializedName("PassengerType")
    @Expose
    private String passengerType;
    @SerializedName("Surname")
    @Expose
    private String surname;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
