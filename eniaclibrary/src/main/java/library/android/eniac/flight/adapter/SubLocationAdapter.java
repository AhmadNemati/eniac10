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
import library.android.service.model.getFlightLocations.response.Airport;
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse;

/**
 * Created by RezaNejati on 11/17/2018.
 */
public class SubLocationAdapter  extends RecyclerView.Adapter<SubLocationAdapter.ViewHolder> {

    private List<Airport> data;
    private Context context;
    private SelectSubAirport subAirport;



    public SubLocationAdapter(final List<Airport> data,SelectSubAirport subAirport) {
        this.data = data;
        this.subAirport = subAirport;


    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.location_sub_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Airport item = data.get(position);
        holder.tvName.setText(item.getName());
        holder.tvIataCode.setText(item.getIatacode());
        holder.llName.setOnClickListener(view -> subAirport.onSelectSubAirport(item.getName(),item.getId(),item.getIatacode()));


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
        public LinearLayout llName;


        public ViewHolder(View v) {
            super(v);
            tvName=v.findViewById(R.id.tvName);
            tvIataCode=v.findViewById(R.id.tvIataCode);
            llName=v.findViewById(R.id.llName);

        }
    }

    public interface SelectSubAirport{
        void onSelectSubAirport(String name,Integer id,String iataCode);

    }




}
