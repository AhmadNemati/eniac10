
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookedReservations {

    @SerializedName("BookedReservation")
    @Expose
    private BookedReservation bookedReservation;

    public BookedReservation getBookedReservation() {
        return bookedReservation;
    }

    public void setBookedReservation(BookedReservation bookedReservation) {
        this.bookedReservation = bookedReservation;
    }

}
