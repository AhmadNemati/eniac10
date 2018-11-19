
package library.android.service.model.reservation.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Traveler {

    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("Gender")
    @Expose
    private Integer gender;
    @SerializedName("GivenName")
    @Expose
    private String givenName;
    @SerializedName("PersianGivenName")
    @Expose
    private String persianGivenName;
    @SerializedName("PersianSurname")
    @Expose
    private String persianSurname;
    @SerializedName("LoyaltyProgram")
    @Expose
    private Object loyaltyProgram;
    @SerializedName("NamePrefix")
    @Expose
    private Integer namePrefix;
    @SerializedName("PassengerType")
    @Expose
    private Integer passengerType;
    @SerializedName("DocNo")
    @Expose
    private String docNo;
    @SerializedName("DocType")
    @Expose
    private Integer docType;
    @SerializedName("Passport")
    @Expose
    private Passport passport;
    @SerializedName("Surname")
    @Expose
    private String surname;
    @SerializedName("Mobile")
    @Expose
    private String mobile;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPersianGivenName() {
        return persianGivenName;
    }

    public void setPersianGivenName(String persianGivenName) {
        this.persianGivenName = persianGivenName;
    }

    public String getPersianSurname() {
        return persianSurname;
    }

    public void setPersianSurname(String persianSurname) {
        this.persianSurname = persianSurname;
    }

    public Object getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(Object loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public Integer getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(Integer namePrefix) {
        this.namePrefix = namePrefix;
    }

    public Integer getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
