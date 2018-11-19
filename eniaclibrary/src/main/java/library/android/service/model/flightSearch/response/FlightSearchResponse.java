
package library.android.service.model.flightSearch.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightSearchResponse {

    @SerializedName("Code")
    @Expose
    private List<Integer> code = null;
    @SerializedName("GeneralCode")
    @Expose
    private Integer generalCode;
    @SerializedName("Message")
    @Expose
    private List<String> message = null;
    @SerializedName("MessageUser")
    @Expose
    private Object messageUser;
    @SerializedName("Token")
    @Expose
    private Object token;
    @SerializedName("CodeBook")
    @Expose
    private CodeBook codeBook;
    @SerializedName("Currency")
    @Expose
    private Object currency;
    @SerializedName("FlightOffers")
    @Expose
    private List<FlightOffer> flightOffers = null;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("LastRates")
    @Expose
    private List<LastRate> lastRates = null;
    @SerializedName("SessionId")
    @Expose
    private String sessionId;

    public List<Integer> getCode() {
        return code;
    }

    public void setCode(List<Integer> code) {
        this.code = code;
    }

    public Integer getGeneralCode() {
        return generalCode;
    }

    public void setGeneralCode(Integer generalCode) {
        this.generalCode = generalCode;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Object getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(Object messageUser) {
        this.messageUser = messageUser;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public CodeBook getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(CodeBook codeBook) {
        this.codeBook = codeBook;
    }

    public Object getCurrency() {
        return currency;
    }

    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    public List<FlightOffer> getFlightOffers() {
        return flightOffers;
    }

    public void setFlightOffers(List<FlightOffer> flightOffers) {
        this.flightOffers = flightOffers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LastRate> getLastRates() {
        return lastRates;
    }

    public void setLastRates(List<LastRate> lastRates) {
        this.lastRates = lastRates;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
