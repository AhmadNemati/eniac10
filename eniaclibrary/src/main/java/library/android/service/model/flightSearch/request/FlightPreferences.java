
package library.android.service.model.flightSearch.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightPreferences {

    @SerializedName("DirectFlight")
    @Expose
    private Boolean directFlight;
    @SerializedName("FlightClass")
    @Expose
    private Integer flightClass;
    @SerializedName("PreferredCompany")
    @Expose
    private Object preferredCompany;
    @SerializedName("PriceLimit")
    @Expose
    private Object priceLimit;

    public Boolean getDirectFlight() {
        return directFlight;
    }

    public void setDirectFlight(Boolean directFlight) {
        this.directFlight = directFlight;
    }

    public Integer getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(Integer flightClass) {
        this.flightClass = flightClass;
    }

    public Object getPreferredCompany() {
        return preferredCompany;
    }

    public void setPreferredCompany(Object preferredCompany) {
        this.preferredCompany = preferredCompany;
    }

    public Object getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(Object priceLimit) {
        this.priceLimit = priceLimit;
    }

}
