
package library.android.service.model.reservation.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketplaceOption {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Price")
    @Expose
    private Integer price;
    @SerializedName("Rate")
    @Expose
    private String rate;
    @SerializedName("RatedFor")
    @Expose
    private String ratedFor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRatedFor() {
        return ratedFor;
    }

    public void setRatedFor(String ratedFor) {
        this.ratedFor = ratedFor;
    }

}
