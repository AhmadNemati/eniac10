package library.android.eniac.flight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import library.android.eniac.R;
import library.android.eniac.utility.GlideApp;
import library.android.service.model.flightSearch.response.FlightSegment;

/**
 * Created by RezaNejati on 10/27/2018.
 */
public class SegmentAdapter extends RecyclerView.Adapter<SegmentAdapter.ViewHolder> {

    private final List<FlightSegment> data;
    private Context context;
    private int type;

    public SegmentAdapter(final List<FlightSegment> data, int type) {
        this.data = data;
        this.type = type;

    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.segment_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final FlightSegment item = data.get(position);
        holder.setIsRecyclable(false);

        String [] date=item.getDepartureDateTime().split(" ");
        holder.tvTime.setText(date[1]);
        holder.tvAirport.setText(item.getDestinationAirport().getName());


        String [] date2=item.getArrivalDateTime().split(" ");
        holder.tvTime2.setText(date2[1]);
        holder.tvAirport2.setText(item.getOriginAirport().getName());
        GlideApp.with(context).load(item.getOperatingAirline().getLogo().get(0)).into(holder.ivLogo);


    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView ivLogo;
        public TextView tvTime,tvAirport,tvTime2,tvAirport2;


        public ViewHolder(View v) {
            super(v);
            ivLogo=v.findViewById(R.id.ivLogo);
            tvTime=v.findViewById(R.id.tvTime);
            tvAirport=v.findViewById(R.id.tvAirport);
            tvTime2=v.findViewById(R.id.tvTime2);
            tvAirport2=v.findViewById(R.id.tvAirport2);

        }
    }


}
