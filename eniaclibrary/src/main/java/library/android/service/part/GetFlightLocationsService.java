package library.android.service.part;

import java.util.List;

import library.android.service.generator.ServiceGenerator;
import library.android.service.listener.OnServiceStatus;
import library.android.service.model.getFlightLocations.request.GetFlightLocationsRequest;
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse;

/**
 * Created by RezaNejati on 11/14/2018.
 */
public class GetFlightLocationsService extends BasePart {
    public GetFlightLocationsService(ServiceGenerator serviceGenerator) {
        super(serviceGenerator);
    }

    @Override
    protected BasePart getPart() {
        return this;
    }
    public void GetFlightLocationsService(OnServiceStatus<List<GetFlightLocationsResponse>> listener, GetFlightLocationsRequest type){
        start(getServiceGenerator().createService().getFlightLocations(type),listener);

    }
}
