
package library.android.service.model.flightSearch.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightItinerary {

    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("Options")
    @Expose
    private List<Option> options = null;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}
