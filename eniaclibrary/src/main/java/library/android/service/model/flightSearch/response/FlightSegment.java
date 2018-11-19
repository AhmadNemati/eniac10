
package library.android.service.model.flightSearch.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightSegment {

    @SerializedName("ArrivalDateTime")
    @Expose
    private String arrivalDateTime;
    @SerializedName("AvailableBookingClasses")
    @Expose
    private Object availableBookingClasses;
    @SerializedName("BaggageLimit")
    @Expose
    private BaggageLimit baggageLimit;
    @SerializedName("BookingClassName")
    @Expose
    private String bookingClassName;
    @SerializedName("DepartureDateTime")
    @Expose
    private String departureDateTime;
    @SerializedName("DestinationAirport")
    @Expose
    private DestinationAirport destinationAirport;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("FlightType")
    @Expose
    private String flightType;
    @SerializedName("JourneyDuration")
    @Expose
    private String journeyDuration;
    @SerializedName("MarketingAirline")
    @Expose
    private String marketingAirline;
    @SerializedName("OperatingAirline")
    @Expose
    private OperatingAirline operatingAirline;
    @SerializedName("OriginAirport")
    @Expose
    private OriginAirport originAirport;
    @SerializedName("PlaneType")
    @Expose
    private PlaneType planeType;
    @SerializedName("TerminalDestination")
    @Expose
    private Object terminalDestination;
    @SerializedName("TerminalOrigin")
    @Expose
    private Object terminalOrigin;
    @SerializedName("Ticket")
    @Expose
    private Object ticket;

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

    public BaggageLimit getBaggageLimit() {
        return baggageLimit;
    }

    public void setBaggageLimit(BaggageLimit baggageLimit) {
        this.baggageLimit = baggageLimit;
    }

    public String getBookingClassName() {
        return bookingClassName;
    }

    public void setBookingClassName(String bookingClassName) {
        this.bookingClassName = bookingClassName;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public DestinationAirport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(DestinationAirport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getJourneyDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(String journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public String getMarketingAirline() {
        return marketingAirline;
    }

    public void setMarketingAirline(String marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    public OperatingAirline getOperatingAirline() {
        return operatingAirline;
    }

    public void setOperatingAirline(OperatingAirline operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public OriginAirport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(OriginAirport originAirport) {
        this.originAirport = originAirport;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public Object getTerminalDestination() {
        return terminalDestination;
    }

    public void setTerminalDestination(Object terminalDestination) {
        this.terminalDestination = terminalDestination;
    }

    public Object getTerminalOrigin() {
        return terminalOrigin;
    }

    public void setTerminalOrigin(Object terminalOrigin) {
        this.terminalOrigin = terminalOrigin;
    }

    public Object getTicket() {
        return ticket;
    }

    public void setTicket(Object ticket) {
        this.ticket = ticket;
    }

}
