
package library.android.service.model.reservation.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookReservation {

    @SerializedName("OfferId")
    @Expose
    private String offerId;
    @SerializedName("SystemId")
    @Expose
    private String systemId;
    @SerializedName("Comment")
    @Expose
    private Object comment;
    @SerializedName("Customer")
    @Expose
    private Customer customer;
    @SerializedName("ExternalReservationId")
    @Expose
    private String externalReservationId;
    @SerializedName("PricedReference")
    @Expose
    private PricedReference pricedReference;
    @SerializedName("Travelers")
    @Expose
    private List<Traveler> travelers = null;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getExternalReservationId() {
        return externalReservationId;
    }

    public void setExternalReservationId(String externalReservationId) {
        this.externalReservationId = externalReservationId;
    }

    public PricedReference getPricedReference() {
        return pricedReference;
    }

    public void setPricedReference(PricedReference pricedReference) {
        this.pricedReference = pricedReference;
    }

    public List<Traveler> getTravelers() {
        return travelers;
    }

    public void setTravelers(List<Traveler> travelers) {
        this.travelers = travelers;
    }

}
