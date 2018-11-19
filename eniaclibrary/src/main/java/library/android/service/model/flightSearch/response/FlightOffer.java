
package library.android.service.model.flightSearch.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightOffer {

    @SerializedName("FlightItinerary")
    @Expose
    private List<FlightItinerary> flightItinerary = null;
    @SerializedName("FlightPassengerPrices")
    @Expose
    private List<FlightPassengerPrice> flightPassengerPrices = null;
    @SerializedName("FlightPrice")
    @Expose
    private FlightPrice flightPrice;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("MessageDebug")
    @Expose
    private Object messageDebug;
    @SerializedName("OfferId")
    @Expose
    private String offerId;
    @SerializedName("Process")
    @Expose
    private Object process;
    @SerializedName("SystemId")
    @Expose
    private String systemId;

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

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getMessageDebug() {
        return messageDebug;
    }

    public void setMessageDebug(Object messageDebug) {
        this.messageDebug = messageDebug;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public Object getProcess() {
        return process;
    }

    public void setProcess(Object process) {
        this.process = process;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

}
