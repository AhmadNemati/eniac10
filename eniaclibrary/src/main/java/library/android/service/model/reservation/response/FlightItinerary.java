
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightItinerary {

    @SerializedName("FlightOption")
    @Expose
    private FlightOption flightOption;

    public FlightOption getFlightOption() {
        return flightOption;
    }

    public void setFlightOption(FlightOption flightOption) {
        this.flightOption = flightOption;
    }

}
