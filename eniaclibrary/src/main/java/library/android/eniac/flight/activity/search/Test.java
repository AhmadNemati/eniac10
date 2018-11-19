package library.android.eniac.flight.activity.search;

import android.support.v4.widget.NestedScrollView;
import android.util.Log;

import java.util.logging.Handler;

import library.android.calendar.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import library.android.eniac.flight.adapter.FlightResultAdapter;
import library.android.service.model.flightSearch.response.FlightOffer;

/**
 * Created by RezaNejati on 10/24/2018.
 */
public class Test implements DatePickerDialog.OnDateSetListener, FlightResultAdapter.BuyFlight {
    NestedScrollView nestedScrollView;

    public Test() {

        FlightOffer offer;


    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int endYear, int endMonth, int endDay) {

    }

    @Override
    public void onData(FlightOffer flightOffer, int position) {
        String offerId = flightOffer.getOfferId();
        String referenceGo;
        String referenceBack;


        for (int i = 0; i < flightOffer.getFlightItinerary().get(0).getOptions().size(); i++) {

            if (flightOffer.getFlightItinerary().get(0).getOptions().get(i).isSelect()) {
                referenceGo = flightOffer.getFlightItinerary().get(0).getOptions().get(i).getReference();
            }
        }

            for (int j = 0; j < flightOffer.getFlightItinerary().get(1).getOptions().size(); j++) {
                if (flightOffer.getFlightItinerary().get(1).getOptions().get(j).isSelect()) {
                    referenceBack = flightOffer.getFlightItinerary().get(1).getOptions().get(j).getReference();




            }


        }
    }
}
