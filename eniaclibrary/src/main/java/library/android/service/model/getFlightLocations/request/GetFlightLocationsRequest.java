
package library.android.service.model.getFlightLocations.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFlightLocationsRequest {

    @SerializedName("Name")
    @Expose
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
