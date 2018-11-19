
package library.android.service.model.flightSearch.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("Agency")
    @Expose
    private Agency agency;
    @SerializedName("ArrivalDateTime")
    @Expose
    private String arrivalDateTime;
    @SerializedName("Available")
    @Expose
    private Integer available;
    @SerializedName("DepartureDateTime")
    @Expose
    private String departureDateTime;
    @SerializedName("DurationStop")
    @Expose
    private String durationStop;
    @SerializedName("FlightSegments")
    @Expose
    private List<FlightSegment> flightSegments = null;
    @SerializedName("JourneyDuration")
    @Expose
    private String journeyDuration;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("Policy")
    @Expose
    private List<Policy> policy = null;
    @SerializedName("RPH")
    @Expose
    private Object rPH;
    @SerializedName("Reference")
    @Expose
    private String reference;
    @SerializedName("StopQuantity")
    @Expose
    private Object stopQuantity;

    @Expose
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getDurationStop() {
        return durationStop;
    }

    public void setDurationStop(String durationStop) {
        this.durationStop = durationStop;
    }

    public List<FlightSegment> getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(List<FlightSegment> flightSegments) {
        this.flightSegments = flightSegments;
    }

    public String getJourneyDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(String journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<Policy> getPolicy() {
        return policy;
    }

    public void setPolicy(List<Policy> policy) {
        this.policy = policy;
    }

    public Object getRPH() {
        return rPH;
    }

    public void setRPH(Object rPH) {
        this.rPH = rPH;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Object getStopQuantity() {
        return stopQuantity;
    }

    public void setStopQuantity(Object stopQuantity) {
        this.stopQuantity = stopQuantity;
    }

}
