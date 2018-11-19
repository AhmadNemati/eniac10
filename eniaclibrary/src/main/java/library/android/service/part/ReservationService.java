package library.android.service.part;

import java.util.List;

import library.android.service.generator.ServiceGenerator;
import library.android.service.listener.OnServiceStatus;
import library.android.service.model.getFlightLocations.request.GetFlightLocationsRequest;
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse;
import library.android.service.model.reservation.request.ReservationRequest;
import library.android.service.model.reservation.response.ReservationResponse;

/**
 * Created by RezaNejati on 11/18/2018.
 */
public class ReservationService extends BasePart {
    public ReservationService(ServiceGenerator serviceGenerator) {
        super(serviceGenerator);
    }

    @Override
    protected BasePart getPart() {
        return this;
    }
    public void ReservationService(OnServiceStatus<ReservationResponse> listener, ReservationRequest request){
        start(getServiceGenerator().createService().getReservation(request),listener);

    }
}
