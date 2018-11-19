
package library.android.service.model.flightSearch.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastRate {

    @SerializedName("BatchNumber")
    @Expose
    private Integer batchNumber;
    @SerializedName("CorrencyCode")
    @Expose
    private String correncyCode;
    @SerializedName("CurrencyID")
    @Expose
    private Integer currencyID;
    @SerializedName("LastUpdateTime")
    @Expose
    private String lastUpdateTime;
    @SerializedName("Rate")
    @Expose
    private Integer rate;

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getCorrencyCode() {
        return correncyCode;
    }

    public void setCorrencyCode(String correncyCode) {
        this.correncyCode = correncyCode;
    }

    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

}
