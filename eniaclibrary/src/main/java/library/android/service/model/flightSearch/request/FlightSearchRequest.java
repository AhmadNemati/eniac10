
package library.android.service.model.flightSearch.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightSearchRequest {

    @SerializedName("TokenValue")
    @Expose
    private String tokenValue;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("SessionId")
    @Expose
    private String sessionId;
    @SerializedName("ClientUniqueCode")
    @Expose
    private String clientUniqueCode;
    @SerializedName("FlightPreferences")
    @Expose
    private FlightPreferences flightPreferences;
    @SerializedName("FlightSteps")
    @Expose
    private List<FlightStep> flightSteps = null;
    @SerializedName("SearchedPassenger")
    @Expose
    private SearchedPassenger searchedPassenger;

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getClientUniqueCode() {
        return clientUniqueCode;
    }

    public void setClientUniqueCode(String clientUniqueCode) {
        this.clientUniqueCode = clientUniqueCode;
    }

    public FlightPreferences getFlightPreferences() {
        return flightPreferences;
    }

    public void setFlightPreferences(FlightPreferences flightPreferences) {
        this.flightPreferences = flightPreferences;
    }

    public List<FlightStep> getFlightSteps() {
        return flightSteps;
    }

    public void setFlightSteps(List<FlightStep> flightSteps) {
        this.flightSteps = flightSteps;
    }

    public SearchedPassenger getSearchedPassenger() {
        return searchedPassenger;
    }

    public void setSearchedPassenger(SearchedPassenger searchedPassenger) {
        this.searchedPassenger = searchedPassenger;
    }

}
