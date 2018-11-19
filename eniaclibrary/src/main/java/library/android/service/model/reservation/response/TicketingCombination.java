
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketingCombination {

    @SerializedName("PaymentformOption")
    @Expose
    private Object paymentformOption;
    @SerializedName("TicketplaceOption")
    @Expose
    private Object ticketplaceOption;

    public Object getPaymentformOption() {
        return paymentformOption;
    }

    public void setPaymentformOption(Object paymentformOption) {
        this.paymentformOption = paymentformOption;
    }

    public Object getTicketplaceOption() {
        return ticketplaceOption;
    }

    public void setTicketplaceOption(Object ticketplaceOption) {
        this.ticketplaceOption = ticketplaceOption;
    }

}
