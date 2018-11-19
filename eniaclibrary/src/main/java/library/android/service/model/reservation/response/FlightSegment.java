
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightSegment {

    @SerializedName("ArrivalDateTime")
    @Expose
    private String arrivalDateTime;
    @SerializedName("AvailableBookingClasses")
    @Expose
    private Object availableBookingClasses;
    @SerializedName("DepartureDateTime")
    @Expose
    private String departureDateTime;
    @SerializedName("DestinationAirport")
    @Expose
    private String destinationAirport;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("JourneyDuration")
    @Expose
    private Object journeyDuration;
    @SerializedName("MarketingAirline")
    @Expose
    private Object marketingAirline;
    @SerializedName("OperatingAirline")
    @Expose
    private String operatingAirline;
    @SerializedName("OriginAirport")
    @Expose
    private String originAirport;
    @SerializedName("PlaneType")
    @Expose
    private Object planeType;
    @SerializedName("Ticket")
    @Expose
    private String ticket;

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Object getAvailableBookingClasses() {
        return availableBookingClasses;
    }

    public void setAvailableBookingClasses(Object availableBookingClasses) {
        this.availableBookingClasses = availableBookingClasses;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Object getJourneyDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(Object journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public Object getMarketingAirline() {
        return marketingAirline;
    }

    public void setMarketingAirline(Object marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    public String getOperatingAirline() {
        return operatingAirline;
    }

    public void setOperatingAirline(String operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public Object getPlaneType() {
        return planeType;
    }

    public void setPlaneType(Object planeType) {
        this.planeType = planeType;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
