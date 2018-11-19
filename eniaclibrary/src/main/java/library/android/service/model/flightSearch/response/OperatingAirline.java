
package library.android.service.model.flightSearch.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OperatingAirline {

    @SerializedName("Code")
    @Expose
    private Object code;
    @SerializedName("Logo")
    @Expose
    private List<String> logo = null;
    @SerializedName("Name")
    @Expose
    private String name;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public List<String> getLogo() {
        return logo;
    }

    public void setLogo(List<String> logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
