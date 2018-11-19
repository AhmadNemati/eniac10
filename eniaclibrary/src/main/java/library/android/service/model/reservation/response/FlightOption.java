
package library.android.service.model.reservation.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightOption {

    @SerializedName("ArrivalDateTime")
    @Expose
    private String arrivalDateTime;
    @SerializedName("DepartureDateTime")
    @Expose
    private String departureDateTime;
    @SerializedName("FlightSegments")
    @Expose
    private List<FlightSegment> flightSegments = null;
    @SerializedName("JourneyDuration")
    @Expose
    private Object journeyDuration;
    @SerializedName("Reference")
    @Expose
    private String reference;

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public List<FlightSegment> getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(List<FlightSegment> flightSegments) {
        this.flightSegments = flightSegments;
    }

    public Object getJourneyDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(Object journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
