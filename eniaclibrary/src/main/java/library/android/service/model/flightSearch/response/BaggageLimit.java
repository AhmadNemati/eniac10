
package library.android.service.model.flightSearch.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaggageLimit {

    @SerializedName("PerPassenger")
    @Expose
    private List<PerPassenger> perPassenger = null;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Weight")
    @Expose
    private Integer weight;

    public List<PerPassenger> getPerPassenger() {
        return perPassenger;
    }

    public void setPerPassenger(List<PerPassenger> perPassenger) {
        this.perPassenger = perPassenger;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
