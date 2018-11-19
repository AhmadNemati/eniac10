
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightPrice {

    @SerializedName("BasePrice")
    @Expose
    private Integer basePrice;
    @SerializedName("FullPrice")
    @Expose
    private Integer fullPrice;
    @SerializedName("OperatorFee")
    @Expose
    private Integer operatorFee;

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Integer fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Integer getOperatorFee() {
        return operatorFee;
    }

    public void setOperatorFee(Integer operatorFee) {
        this.operatorFee = operatorFee;
    }

}
