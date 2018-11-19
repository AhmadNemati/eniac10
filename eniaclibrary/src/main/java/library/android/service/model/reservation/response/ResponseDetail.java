
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDetail {

    @SerializedName("ReservationResponceBook")
    @Expose
    private ReservationResponceBook reservationResponceBook;

    public ReservationResponceBook getReservationResponceBook() {
        return reservationResponceBook;
    }

    public void setReservationResponceBook(ReservationResponceBook reservationResponceBook) {
        this.reservationResponceBook = reservationResponceBook;
    }

}
