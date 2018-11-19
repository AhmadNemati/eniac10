
package library.android.service.model.reservation.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookedReservation {

    @SerializedName("Agency")
    @Expose
    private Agency agency;
    @SerializedName("Customer")
    @Expose
    private Object customer;
    @SerializedName("Documents")
    @Expose
    private Documents documents;
    @SerializedName("ExternalReservationId")
    @Expose
    private Integer externalReservationId;
    @SerializedName("FlightItinerary")
    @Expose
    private List<FlightItinerary> flightItinerary = null;
    @SerializedName("FlightPassengerPrices")
    @Expose
    private List<FlightPassengerPrice> flightPassengerPrices = null;
    @SerializedName("FlightPrice")
    @Expose
    private FlightPrice flightPrice;
    @SerializedName("Mode")
    @Expose
    private Object mode;
    @SerializedName("PaymentConditions")
    @Expose
    private Object paymentConditions;
    @SerializedName("ReservationId")
    @Expose
    private String reservationId;
    @SerializedName("ReservationParts")
    @Expose
    private Object reservationParts;
    @SerializedName("TokenId")
    @Expose
    private Object tokenId;
    @SerializedName("Travelers")
    @Expose
    private List<Traveler> travelers = null;

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer = customer;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public Integer getExternalReservationId() {
        return externalReservationId;
    }

    public void setExternalReservationId(Integer externalReservationId) {
        this.externalReservationId = externalReservationId;
    }

    public List<FlightItinerary> getFlightItinerary() {
        return flightItinerary;
    }

    public void setFlightItinerary(List<FlightItinerary> flightItinerary) {
        this.flightItinerary = flightItinerary;
    }

    public List<FlightPassengerPrice> getFlightPassengerPrices() {
        return flightPassengerPrices;
    }

    public void setFlightPassengerPrices(List<FlightPassengerPrice> flightPassengerPrices) {
        this.flightPassengerPrices = flightPassengerPrices;
    }

    public FlightPrice getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(FlightPrice flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Object getMode() {
        return mode;
    }

    public void setMode(Object mode) {
        this.mode = mode;
    }

    public Object getPaymentConditions() {
        return paymentConditions;
    }

    public void setPaymentConditions(Object paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Object getReservationParts() {
        return reservationParts;
    }

    public void setReservationParts(Object reservationParts) {
        this.reservationParts = reservationParts;
    }

    public Object getTokenId() {
        return tokenId;
    }

    public void setTokenId(Object tokenId) {
        this.tokenId = tokenId;
    }

    public List<Traveler> getTravelers() {
        return travelers;
    }

    public void setTravelers(List<Traveler> travelers) {
        this.travelers = travelers;
    }

}
