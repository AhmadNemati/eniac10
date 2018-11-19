
package library.android.service.model.reservation.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketingCombination {

    @SerializedName("PaymentformOption")
    @Expose
    private PaymentformOption paymentformOption;
    @SerializedName("TicketplaceOption")
    @Expose
    private TicketplaceOption ticketplaceOption;

    public PaymentformOption getPaymentformOption() {
        return paymentformOption;
    }

    public void setPaymentformOption(PaymentformOption paymentformOption) {
        this.paymentformOption = paymentformOption;
    }

    public TicketplaceOption getTicketplaceOption() {
        return ticketplaceOption;
    }

    public void setTicketplaceOption(TicketplaceOption ticketplaceOption) {
        this.ticketplaceOption = ticketplaceOption;
    }

}
