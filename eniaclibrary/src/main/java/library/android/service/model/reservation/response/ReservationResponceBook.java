
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservationResponceBook {

    @SerializedName("BookedReservations")
    @Expose
    private BookedReservations bookedReservations;
    @SerializedName("TicketingCombination")
    @Expose
    private TicketingCombination ticketingCombination;
    @SerializedName("ProviderRefernceCode")
    @Expose
    private ProviderRefernceCode providerRefernceCode;

    public BookedReservations getBookedReservations() {
        return bookedReservations;
    }

    public void setBookedReservations(BookedReservations bookedReservations) {
        this.bookedReservations = bookedReservations;
    }

    public TicketingCombination getTicketingCombination() {
        return ticketingCombination;
    }

    public void setTicketingCombination(TicketingCombination ticketingCombination) {
        this.ticketingCombination = ticketingCombination;
    }

    public ProviderRefernceCode getProviderRefernceCode() {
        return providerRefernceCode;
    }

    public void setProviderRefernceCode(ProviderRefernceCode providerRefernceCode) {
        this.providerRefernceCode = providerRefernceCode;
    }

}
