package library.android.service.api;


import java.util.List;

import library.android.service.helper.Const;


import io.reactivex.Observable;
import library.android.service.model.authenticateLogin.request.AuthenticateLoginRequest;
import library.android.service.model.authenticateLogin.response.AuthenticateLoginResponse;
import library.android.service.model.flightSearch.request.FlightSearchRequest;
import library.android.service.model.flightSearch.response.FlightSearchResponse;
import library.android.service.model.getFlightLocations.request.GetFlightLocationsRequest;
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse;
import library.android.service.model.reservation.request.ReservationRequest;
import library.android.service.model.reservation.response.ReservationResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by Ahmad.nemati on 3/26/2018.
 */

public interface RetroClient {

    @POST(Const.AuthenticateLogin)
    Observable<Response<AuthenticateLoginResponse>> authenticateLogin(
            @Body AuthenticateLoginRequest request);
    @POST(Const.FlightSearch)
    Observable<Response<FlightSearchResponse>> flightSearch(
            @Body FlightSearchRequest request);


    @POST(Const.GetFlightLocations)
    Observable<Response<List<GetFlightLocationsResponse>>> getFlightLocations(
            @Body GetFlightLocationsRequest Type);

    @POST(Const.Reservation)
    Observable<Response<ReservationResponse>> getReservation(
            @Body ReservationRequest request);

}
