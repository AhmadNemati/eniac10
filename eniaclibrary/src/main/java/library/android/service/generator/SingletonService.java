package library.android.service.generator;

import library.android.eniac.base.EniacApplication;
import library.android.service.di.component.NetComponent;
import library.android.service.part.AuthenticateLoginService;


import javax.inject.Inject;

import library.android.service.part.FlightSearchService;
import library.android.service.part.GetFlightLocationsService;
import library.android.service.part.ReservationService;
import okhttp3.OkHttpClient;

/**
 * Created by Ahmad.nemati on 3/26/2018.
 */
public class SingletonService {
    private NetComponent netComponent;
    @Inject
    ServiceGenerator serviceGenerator;
    @Inject
    OkHttpClient okHttpClient;
    private EniacApplication serviceApplication;
    private static final SingletonService ourInstance = new SingletonService();

    public static SingletonService getInstance() {
        return ourInstance;
    }

    public SingletonService setNetComponent(NetComponent netComponent) {
        this.netComponent = netComponent;
        return this;
    }

    public void inject() {
        ComponentService componentService = DaggerComponentService.builder().netComponent(netComponent).build();
        componentService.inject(this);
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private SingletonService() {
    }

    public EniacApplication getContext() {
        return serviceApplication;
    }

    public void setContext(EniacApplication context) {
        this.serviceApplication = context;
    }

    public AuthenticateLoginService authenticateLoginService() {
        return new AuthenticateLoginService(serviceGenerator);
    }

    public FlightSearchService flightSearchService() {
        return new FlightSearchService(serviceGenerator);
    }

    public GetFlightLocationsService getFlightLocationsService() {
        return new GetFlightLocationsService(serviceGenerator);
    }
    public ReservationService getReservationService() {
        return new ReservationService(serviceGenerator);
    }
}
