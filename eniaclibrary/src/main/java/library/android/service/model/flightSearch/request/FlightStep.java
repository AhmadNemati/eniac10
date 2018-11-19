
package library.android.service.model.flightSearch.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightStep {

    @SerializedName("DepartureDate")
    @Expose
    private String departureDate;
    @SerializedName("Origin")
    @Expose
    private List<String> origin = null;
    @SerializedName("Destination")
    @Expose
    private List<String> destination = null;

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public List<String> getOrigin() {
        return origin;
    }

    public void setOrigin(List<String> origin) {
        this.origin = origin;
    }

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }

}
