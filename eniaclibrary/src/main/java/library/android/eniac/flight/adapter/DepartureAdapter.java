package library.android.eniac.flight.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.List;

import library.android.eniac.R;
import library.android.eniac.singleton.SingletonContext;
import library.android.service.model.flightSearch.response.FlightOffer;
import library.android.service.model.flightSearch.response.FlightSegment;
import library.android.service.model.flightSearch.response.Option;

/**
 * Created by RezaNejati on 10/24/2018.
 */
public class DepartureAdapter extends RecyclerView.Adapter<DepartureAdapter.ViewHolder> {

    private final List<Option> data;
    private Context context;
    private OnChangeData changeData;
    private int type;
    private Activity activity;
    private RadioButton lastCheckedRB = null;
    private RadioGroup lastCheckedRadioGroup = null;



    public DepartureAdapter(final List<Option> data, int type, OnChangeData changeData,Activity activity) {
        this.data = data;
        this.type = type;
        this.changeData = changeData;
        this.activity = activity;

    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.departure_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Option item = data.get(position);
        holder.setIsRecyclable(false);

       holder.rvSegment.setAdapter(new SegmentAdapter(item.getFlightSegments(), type));

        int id = (position);
        for(FlightSegment option : item.getFlightSegments()){
            RadioButton rb = new RadioButton(DepartureAdapter.this.context);
            rb.setId(id++);
            rb.setTag(item);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                ColorStateList colorStateList = new ColorStateList(
                        new int[][]{

                                new int[]{-android.R.attr.state_enabled}, //disabled
                                new int[]{android.R.attr.state_enabled} //enabled
                        },
                        new int[] {

                                Color.parseColor("#f2e190") //disabled
                                , Color.parseColor("#f2e190")//enabled

                        }
                );


                rb.setButtonTintList(colorStateList);//set the color tint list
                rb.invalidate(); //could not be necessary
            }


            holder.priceRadioGroup.addView(rb);
        }


       holder.priceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (lastCheckedRadioGroup != null
                        && lastCheckedRadioGroup.getCheckedRadioButtonId()
                        != radioGroup.getCheckedRadioButtonId()
                        && lastCheckedRadioGroup.getCheckedRadioButtonId() != -1) {
                    lastCheckedRadioGroup.clearCheck();
             /*       Toast.makeText(SingletonContext.Companion.getInstance().getContext(),
                            "Radio button clicked " + radioGroup.getCheckedRadioButtonId(),
                            Toast.LENGTH_SHORT).show();*/
                    data.get(radioGroup.getCheckedRadioButtonId()).setSelect(true);


                        for (int ii = 0; ii < data.size(); ii++) {
                            if (ii != radioGroup.getCheckedRadioButtonId()) {
                                data.get(ii).setSelect(false);


                        }
                    }

                }else{
                    data.get(radioGroup.getCheckedRadioButtonId()).setSelect(true);

                }

                lastCheckedRadioGroup = radioGroup;

            }
        });

       /* holder.rbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              //  changeData.change(b,position);


                if (b) {
                    item.setSelect(true);
                    holder.rbSelect.setSelected(true);

                    for (int i = 0; i < data.size(); i++) {
                        if (i != position) {
                            data.get(i).setSelect(false);
                        }

                    }
               notifyItemChanged(position);


                }


            }
        });
*/

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView rvSegment;
        private RadioButton rbSelect;
        private RadioGroup priceRadioGroup;


        public ViewHolder(View v) {
            super(v);
            rvSegment = v.findViewById(R.id.rvSegment);
          //  rbSelect = v.findViewById(R.id.rbSelect);
            priceRadioGroup = v.findViewById(R.id.priceRadioGroup);


        }
    }

    public interface OnChangeData {
        void change(boolean b, int position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
