package library.android.service.part;

import library.android.service.generator.ServiceGenerator;
import library.android.service.listener.OnServiceStatus;
import library.android.service.model.authenticateLogin.request.AuthenticateLoginRequest;
import library.android.service.model.authenticateLogin.response.AuthenticateLoginResponse;
import library.android.service.model.flightSearch.request.FlightSearchRequest;
import library.android.service.model.flightSearch.response.FlightSearchResponse;

/**
 * Created by RezaNejati on 10/23/2018.
 */
public class FlightSearchService extends BasePart {
    public FlightSearchService(ServiceGenerator serviceGenerator) {
        super(serviceGenerator);
    }

    @Override
    protected BasePart getPart() {
        return this;
    }
    public void setFlightSearchService(OnServiceStatus<FlightSearchResponse> listener, FlightSearchRequest request){
        start(getServiceGenerator().createService().flightSearch(request),listener);

    }
}
