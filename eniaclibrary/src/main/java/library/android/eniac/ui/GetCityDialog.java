package library.android.eniac.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import library.android.eniac.R;
import library.android.eniac.base.BaseDialog;
import library.android.eniac.flight.adapter.LocationAdapter;
import library.android.eniac.model.LocationDBModel;
import library.android.service.generator.SingletonService;
import library.android.service.listener.OnServiceStatus;
import library.android.service.model.getFlightLocations.request.GetFlightLocationsRequest;
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse;


/**
 * Created by RezaNejati on 10/28/2018.
 */
@SuppressLint("ValidFragment")
public class GetCityDialog extends BaseDialog implements View.OnClickListener, TextWatcher ,LocationAdapter.SelectLocation{
    private Activity activity;
    private Dialog dialog;
    private CircularProgressButton btnConfirm;
    private RecyclerView rvLocations;
    private LocationAdapter locationAdapter;
    private List<GetFlightLocationsResponse> locationsResponses = new ArrayList<>();
    private EditText etSearch;
    private LocationDialog locationDialog;
    private boolean isDestination;
    private Timer myTimer;
    private boolean hasStarted = false;


    public GetCityDialog(Activity activity,LocationDialog locationDialog) {
        this.activity = activity;
        this.locationDialog = locationDialog;

    }



    public void setDestination(boolean destination) {
        isDestination = destination;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new Dialog(activity, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.alert_dialog_city);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
       // myTimer = new Timer();

        rvLocations = dialog.findViewById(R.id.rvLocations);
        etSearch = dialog.findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(this);

        rvLocations.setLayoutManager(new LinearLayoutManager(activity));
        locationAdapter = new LocationAdapter(locationsResponses,this,activity);
        rvLocations.setAdapter(locationAdapter);
        locationsResponses.clear();


        return dialog;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (charSequence.length()>2){
        /*    if (myTimer.purge())
            myTimer.cancel();*/

            getLocation(charSequence.toString());


         /*   hasStarted=true;

            myTimer.schedule(new TimerTask() {

                @Override
                public void run() {
                    getLocation(charSequence.toString());
                    myTimer.cancel();
                }

            }, 2000, 1);

            if (hasStarted){
                myTimer.cancel();
                hasStarted=false;


            }*/

        }


    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(etSearch.getText().toString())) {
            rvLocations.removeAllViews();

            locationsResponses.clear();
          //  locationAdapter.notifyDataSetChanged();


        }




 /*       if (etSearch.getText().toString().length() > 2)
            filterTransaction(etSearch.getText().toString());
*/
    }


/*    public void filterTransaction(String text) {

        Observable
                .fromIterable(dbModels)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .filter(x -> {
                            boolean addToList = false;

                            if (x.getPersianName() != null && x.getPersianName().contains(text)) {
                                addToList = true;


                            }

                            if (x.getFullTextSearch() != null && x.getFullTextSearch().contains(text)) {
                                addToList = true;


                            }
                            if (x.getName() != null && x.getName().contains(text)) {
                                addToList = true;


                            }
                            if (x.getIataCode() != null && String.valueOf(x.getIataCode()).equals(text)) {

                                addToList = true;

                            }


                            return addToList;
                        }

                )
                .toList()
                .subscribe(new SingleObserver<List<LocationDBModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<LocationDBModel> userModels) {
                        Log.e("userModels", " after filtering: " + userModels.size());
                        rvLocations.removeAllViews();

                        dbFilterModels.clear();
                        dbFilterModels.addAll(userModels);
                        locationAdapter.notifyDataSetChanged();
                        if (userModels.size() == 0) {
                            rvLocations.removeAllViews();

                            dbFilterModels.clear();
                            locationAdapter.notifyDataSetChanged();


                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }*/


  /*  @Override
    public void onSelect(LocationDBModel locationDBModel) {
        locationDialog.onSelectCity(locationDBModel,isDestination);
        dismiss();
    }
*/
    @Override
    public void onSelect(String name,Integer id,String iataCode) {
        locationDialog.onSelectCity(name,id,isDestination,iataCode);
        dismiss();
    }


    public interface LocationDialog{
        void onSelectCity(String name,Integer id,boolean isDestination,String iataCode);
    }



    public void getLocation(String text){
        GetFlightLocationsRequest request = new GetFlightLocationsRequest();
        request.setName(text);
        SingletonService.getInstance().getFlightLocationsService().GetFlightLocationsService(new OnServiceStatus<List<GetFlightLocationsResponse>>() {
            @Override
            public void onReady(List<GetFlightLocationsResponse> getFlightLocationsResponses) {

             //   Log.e("test", getFlightLocationsResponses.get(0).getIatacode());
                rvLocations.removeAllViews();

                locationsResponses.clear();
                locationsResponses.addAll(getFlightLocationsResponses);
                locationAdapter.notifyDataSetChanged();



            }

            @Override
            public void onError(String message) {

            }
        },request);


    }
}

