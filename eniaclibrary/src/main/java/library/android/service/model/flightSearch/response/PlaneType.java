
package library.android.service.model.flightSearch.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaneType {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Type")
    @Expose
    private Object type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

}
