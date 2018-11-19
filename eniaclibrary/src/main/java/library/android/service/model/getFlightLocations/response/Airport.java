
package library.android.service.model.getFlightLocations.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airport {

    @SerializedName("Iatacode")
    @Expose
    private String iatacode;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Lat")
    @Expose
    private Object lat;
    @SerializedName("Lon")
    @Expose
    private Object lon;
    @SerializedName("Name")
    @Expose
    private String name;

    public String getIatacode() {
        return iatacode;
    }

    public void setIatacode(String iatacode) {
        this.iatacode = iatacode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLon() {
        return lon;
    }

    public void setLon(Object lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
