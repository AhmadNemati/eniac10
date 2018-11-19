
package library.android.service.model.reservation.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PricedReference {

    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("References")
    @Expose
    private List<String> references = null;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

}
