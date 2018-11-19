package library.android.eniac.flight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import library.android.eniac.R;
import library.android.eniac.model.NumberPickerModel;
import library.android.eniac.utility.GlideApp;
import library.android.service.model.flightSearch.response.FlightSegment;

/**
 * Created by RezaNejati on 10/28/2018.
 */
public class NumberPickerAdapter extends RecyclerView.Adapter<NumberPickerAdapter.ViewHolder> {

    private List<NumberPickerModel> data = new ArrayList<>();
    private Context context;
    private int type;

    public NumberPickerAdapter(int type) {


        for (int i = 0; i < 10; i++) {
            NumberPickerModel pickerModel = new NumberPickerModel();
            pickerModel.setNumber(i+1);

            if (type == 1 && i == 0)
                pickerModel.setSelected(true);
            else
                pickerModel.setSelected(false);


            data.add(pickerModel);


        }

    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.number_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final NumberPickerModel item = data.get(position);
        holder.setIsRecyclable(false);

        holder.tvNumber.setText(item.getNumber()+"");
        if (item.isSelected()) {
            holder.tvNumber.setTextColor(context.getResources().getColor(R.color.textColor3));
            holder.tvNumber.setTextSize(16);


        } else {
            holder.tvNumber.setTextColor(context.getResources().getColor(R.color.textColor));
            holder.tvNumber.setTextSize(12);


        }
        holder.tvNumber.setOnClickListener(view -> {
            item.setSelected(true);
            for (int i = 0; i <data.size() ; i++) {
                if (i!=position)
                    data.get(i).setSelected(false);

            }
            notifyDataSetChanged();



        });


    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNumber;


        public ViewHolder(View v) {
            super(v);
            tvNumber = v.findViewById(R.id.tvNumber);


        }
    }


}
