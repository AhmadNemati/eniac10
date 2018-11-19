
package library.android.service.model.flightSearch.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchedPassenger {

    @SerializedName("ADT")
    @Expose
    private Integer aDT;
    @SerializedName("CHD")
    @Expose
    private Integer cHD;
    @SerializedName("INF")
    @Expose
    private Integer iNF;
    @SerializedName("YCD")
    @Expose
    private Integer yCD;
    @SerializedName("YTH")
    @Expose
    private Integer yTH;

    public Integer getADT() {
        return aDT;
    }

    public void setADT(Integer aDT) {
        this.aDT = aDT;
    }

    public Integer getCHD() {
        return cHD;
    }

    public void setCHD(Integer cHD) {
        this.cHD = cHD;
    }

    public Integer getINF() {
        return iNF;
    }

    public void setINF(Integer iNF) {
        this.iNF = iNF;
    }

    public Integer getYCD() {
        return yCD;
    }

    public void setYCD(Integer yCD) {
        this.yCD = yCD;
    }

    public Integer getYTH() {
        return yTH;
    }

    public void setYTH(Integer yTH) {
        this.yTH = yTH;
    }

}
