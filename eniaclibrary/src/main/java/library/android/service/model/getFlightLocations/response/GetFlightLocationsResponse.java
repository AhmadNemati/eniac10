
package library.android.service.model.getFlightLocations.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFlightLocationsResponse {

    @SerializedName("Airports")
    @Expose
    private List<Airport> airports = null;
    @SerializedName("Iatacode")
    @Expose
    private String iatacode;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Lat")
    @Expose
    private Double lat;
    @SerializedName("Lon")
    @Expose
    private Double lon;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Order")
    @Expose
    private Integer order;
    @SerializedName("Parent")
    @Expose
    private Integer parent;
    @SerializedName("ParentName")
    @Expose
    private String parentName;
    @SerializedName("PersianName")
    @Expose
    private String persianName;
    @SerializedName("Type")
    @Expose
    private Integer type;

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
