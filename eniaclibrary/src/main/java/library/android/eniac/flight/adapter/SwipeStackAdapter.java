package library.android.eniac.flight.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import library.android.eniac.R;
import library.android.eniac.model.PassengerModel;

/**
 * Created by RezaNejati on 11/18/2018.
 */
public class SwipeStackAdapter extends BaseAdapter {

    private List<PassengerModel> data;
    private Activity activity;

    public SwipeStackAdapter(List<PassengerModel> data, Activity activity) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public PassengerModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = activity.getLayoutInflater().inflate(R.layout.passenger_item, parent, false);
     /*   TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
        textViewCard.setText(mData.get(position));
*/
        return convertView;
    }
}