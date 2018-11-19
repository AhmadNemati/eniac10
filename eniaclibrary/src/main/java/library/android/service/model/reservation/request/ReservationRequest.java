
package library.android.service.model.reservation.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservationRequest {

    @SerializedName("TokenValue")
    @Expose
    private String tokenValue;
    @SerializedName("SessionId")
    @Expose
    private String sessionId;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("HappyUsername")
    @Expose
    private String happyUsername;

    @SerializedName("HappyPassword")
    @Expose
    private String happyPassword;

    @SerializedName("BookReservations")
    @Expose
    private List<BookReservation> bookReservations = null;
    @SerializedName("TicketingCombinations")
    @Expose
    private List<TicketingCombination> ticketingCombinations = null;

    public String getHappyUsername() {
        return happyUsername;
    }

    public void setHappyUsername(String happyUsername) {
        this.happyUsername = happyUsername;
    }

    public String getHappyPassword() {
        return happyPassword;
    }

    public void setHappyPassword(String happyPassword) {
        this.happyPassword = happyPassword;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<BookReservation> getBookReservations() {
        return bookReservations;
    }

    public void setBookReservations(List<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
    }

    public List<TicketingCombination> getTicketingCombinations() {
        return ticketingCombinations;
    }

    public void setTicketingCombinations(List<TicketingCombination> ticketingCombinations) {
        this.ticketingCombinations = ticketingCombinations;
    }

}
