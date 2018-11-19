
package library.android.service.model.reservation.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightPassengerPrice {

    @SerializedName("BasePricePerPassenger")
    @Expose
    private Integer basePricePerPassenger;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("FullPricePerPassenger")
    @Expose
    private Integer fullPricePerPassenger;
    @SerializedName("OperatorFeePerPassenger")
    @Expose
    private Integer operatorFeePerPassenger;

    public Integer getBasePricePerPassenger() {
        return basePricePerPassenger;
    }

    public void setBasePricePerPassenger(Integer basePricePerPassenger) {
        this.basePricePerPassenger = basePricePerPassenger;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFullPricePerPassenger() {
        return fullPricePerPassenger;
    }

    public void setFullPricePerPassenger(Integer fullPricePerPassenger) {
        this.fullPricePerPassenger = fullPricePerPassenger;
    }

    public Integer getOperatorFeePerPassenger() {
        return operatorFeePerPassenger;
    }

    public void setOperatorFeePerPassenger(Integer operatorFeePerPassenger) {
        this.operatorFeePerPassenger = operatorFeePerPassenger;
    }

}
