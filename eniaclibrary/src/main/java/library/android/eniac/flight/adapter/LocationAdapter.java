package library.android.eniac.flight.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import library.android.eniac.R;
import library.android.eniac.model.LocationDBModel;
import library.android.eniac.utility.Utility;
import library.android.service.model.flightSearch.response.FlightOffer;
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse;

/**
 * Created by RezaNejati on 11/14/2018.
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private List<GetFlightLocationsResponse> data;
    private Context context;
    private SelectLocation location;
    private Activity activity;



    public LocationAdapter(final List<GetFlightLocationsResponse> data,SelectLocation location,Activity activity) {
        this.data = data;
        this.location = location;
        this.activity = activity;


    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.location_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final GetFlightLocationsResponse item = data.get(position);
        holder.tvName.setText(item.getPersianName());
        holder.tvIataCode.setText(item.getIatacode());

        holder.rvSubLocation.setLayoutManager(new LinearLayoutManager(activity));
        holder.rvSubLocation.setAdapter(new SubLocationAdapter(item.getAirports(), new SubLocationAdapter.SelectSubAirport() {
            @Override
            public void onSelectSubAirport(String name, Integer id,String iataCode) {
                location.onSelect(name,id,iataCode);

            }
        }));



        holder.llName.setOnClickListener(view -> {
            location.onSelect(item.getPersianName(),item.getId(),item.getIatacode());
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
        public TextView tvName,tvIataCode;
        private RecyclerView rvSubLocation;
        private LinearLayout llName;


        public ViewHolder(View v) {
            super(v);
            tvName=v.findViewById(R.id.tvName);
            rvSubLocation=v.findViewById(R.id.rvSubLocation);
            llName=v.findViewById(R.id.llName);
            tvIataCode=v.findViewById(R.id.tvIataCode);


        }
    }

    public interface SelectLocation{
        void onSelect(String name,Integer id,String iataCode);

    }




}
