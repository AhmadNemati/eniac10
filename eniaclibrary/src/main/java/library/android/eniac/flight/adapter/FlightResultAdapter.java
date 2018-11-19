package library.android.eniac.flight.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import library.android.eniac.R;
import library.android.eniac.utility.Utility;
import library.android.service.model.flightSearch.response.FlightOffer;
import library.android.service.model.flightSearch.response.Option;

/**
 * Created by RezaNejati on 10/24/2018.
 */
public class FlightResultAdapter extends RecyclerView.Adapter<FlightResultAdapter.ViewHolder> {

    private  List<FlightOffer> data;
    private Context context;
    Activity activity;
    OnChangeData onChangeData;
    BuyFlight buyFlight;

    public FlightResultAdapter(final List<FlightOffer> data,Activity activity,  OnChangeData onChangeData,BuyFlight buyFlight) {
        this.data = data;
        this.activity = activity;
        this.onChangeData = onChangeData;
        this.buyFlight = buyFlight;

    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.flight_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final FlightOffer item = data.get(position);
        holder.setIsRecyclable(false);

        holder.rvDeparture.setAdapter(new DepartureAdapter(item.getFlightItinerary().get(0).getOptions(), 0, (b, position_) -> {},activity));






        if (item.getFlightItinerary().get(1).getOptions()!=null)
        holder.rvArrival.setAdapter(new DepartureAdapter(item.getFlightItinerary().get(1).getOptions(), 1, new DepartureAdapter.OnChangeData() {
            @Override
            public void change(boolean b, int position) {

            }
        },activity));


        holder.tvPrice.setText("قیمت: "+ Utility.priceFormat(item.getFlightPrice().getFullPrice()+"")+" تومان");




        holder.btnBuy.setOnClickListener(view -> {
            boolean selectGo=false;
            boolean selectBack=false;
            for (int i = 0; i < item.getFlightItinerary().get(0).getOptions().size(); i++) {

                if (item.getFlightItinerary().get(0).getOptions().get(i).isSelect()) {
                    selectGo=true;
                }
            }

            for (int j = 0; j < item.getFlightItinerary().get(1).getOptions().size(); j++) {
                if (item.getFlightItinerary().get(1).getOptions().get(j).isSelect()) {
                    selectBack=true;

                }
            }

            if (!selectGo){
                Toast.makeText(context, "لطفا پرواز رفت را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                return;
            }

            if (!selectBack){
                Toast.makeText(context, "لطفا پرواز برگشت را انتخاب کنید.", Toast.LENGTH_SHORT).show();

                return;
            }


                buyFlight.onData(item,position);
        });


    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rvDeparture,rvArrival;
        public TextView tvPrice;
        public CircularProgressButton btnBuy;


        public ViewHolder(View v) {
            super(v);
            rvDeparture=v.findViewById(R.id.rvDeparture);
            rvArrival=v.findViewById(R.id.rvArrival);
            tvPrice=v.findViewById(R.id.tvPrice);
            btnBuy=v.findViewById(R.id.btnBuy);

        }
    }



    public interface OnChangeData {
        void change(boolean b, int position);
    }
    public interface BuyFlight{
        void onData(FlightOffer flightOffer, int position);
    }
}
