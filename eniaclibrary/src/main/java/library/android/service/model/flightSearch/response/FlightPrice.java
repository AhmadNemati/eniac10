
package library.android.service.model.flightSearch.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightPrice {

    @SerializedName("BasePrice")
    @Expose
    private Integer basePrice;
    @SerializedName("CurrencyName")
    @Expose
    private Object currencyName;
    @SerializedName("FullPrice")
    @Expose
    private Integer fullPrice;
    @SerializedName("OperatorFee")
    @Expose
    private Integer operatorFee;
    @SerializedName("SalePrice")
    @Expose
    private Integer salePrice;

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Object getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(Object currencyName) {
        this.currencyName = currencyName;
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

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

}
