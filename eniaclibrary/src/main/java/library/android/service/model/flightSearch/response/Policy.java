
package library.android.service.model.flightSearch.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Policy {

    @SerializedName("TermsEn")
    @Expose
    private Object termsEn;
    @SerializedName("TermsFa")
    @Expose
    private String termsFa;

    public Object getTermsEn() {
        return termsEn;
    }

    public void setTermsEn(Object termsEn) {
        this.termsEn = termsEn;
    }

    public String getTermsFa() {
        return termsFa;
    }

    public void setTermsFa(String termsFa) {
        this.termsFa = termsFa;
    }

}
