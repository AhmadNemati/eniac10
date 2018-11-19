package library.android.eniac.flight.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import library.android.eniac.R;
import library.android.eniac.model.PassengerModel;
import library.android.eniac.ui.GenderDialog;
import library.android.eniac.ui.IdTypeDialog;
import library.android.eniac.utility.ClearableEditText;
import library.android.eniac.utility.Utility;
import library.android.service.model.getFlightLocations.response.GetFlightLocationsResponse;

/**
 * Created by RezaNejati on 11/17/2018.
 */
public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.ViewHolder> {

    private List<PassengerModel> data;
    private Activity activity;
    private AdapterHelper adapterHelper;
    ArrayList<ViewHolder> myViewHolders = new ArrayList<>();



    public PassengerAdapter(final List<PassengerModel> data, Activity activity, AdapterHelper adapterHelper) {
        this.data = data;
        this.activity = activity;
        this.adapterHelper = adapterHelper;
    }


    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.passenger_item, parent, false), data, activity, adapterHelper);
    }

    public ArrayList<ViewHolder> getMyViewHolders() {
        return myViewHolders;
    }

    public void setMyViewHolders(ArrayList<ViewHolder> myViewHolders) {
        this.myViewHolders = myViewHolders;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final PassengerModel item = data.get(position);
        myViewHolders.add(position,holder);


        String type = "";
        if (item.isAdult())
            type = " بزرگسال";
        if (item.isChild())
            type = " کودک";
        if (item.isInfant())
            type = " نوزاد";

        holder.tvCount.setText("اطلاعات مسافر " + (position + 1) + type);


        holder.etBirthDay.setText(item.getTraveler()!=null&&item.getTraveler().getBirthDate()!=null?item.getTraveler().getBirthDate():"");


        //holder.etExpireDate.setText(item.getTraveler()!=null&&item.getTraveler().getPassport().getValidityDate()!=null?item.getTraveler().getPassport().getValidityDate():"");


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


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnFocusChangeListener, View.OnClickListener {
        List<PassengerModel> data;
        PassengerModel item;
        Activity activity;
        AdapterHelper adapterHelper;
        public TextView tvCount;
        public TextInputLayout tilGender;
        public ClearableEditText etGender, etLastName, etFirstName, etLastNameEn, etFirstNameEn, etIdType, etExpireDate, etNationality, etNationalCode, etBirthDay;


        public ViewHolder(View v, List<PassengerModel> data, Activity activity, AdapterHelper adapterHelper) {
            super(v);
            this.data = data;
            this.activity = activity;
            this.adapterHelper = adapterHelper;
            tvCount = v.findViewById(R.id.tvCount);
            tilGender = v.findViewById(R.id.tilGender);
            etGender = v.findViewById(R.id.etGender);
            etLastName = v.findViewById(R.id.etLastName);
            etFirstName = v.findViewById(R.id.etFirstName);
            etLastNameEn = v.findViewById(R.id.etLastNameEn);
            etFirstNameEn = v.findViewById(R.id.etFirstNameEn);
            etIdType = v.findViewById(R.id.etIdType);
            etExpireDate = v.findViewById(R.id.etExpireDate);
            etNationality = v.findViewById(R.id.etNationality);
            etNationalCode = v.findViewById(R.id.etNationalCode);
            etBirthDay = v.findViewById(R.id.etBirthDay);

            etBirthDay.setInputType(InputType.TYPE_NULL);
            etExpireDate.setInputType(InputType.TYPE_NULL);
            etIdType.setInputType(InputType.TYPE_NULL);
            etGender.setInputType(InputType.TYPE_NULL);

            etExpireDate.setOnFocusChangeListener(this);
            etBirthDay.setOnFocusChangeListener(this);
            etIdType.setOnFocusChangeListener(this);
            etGender.setOnFocusChangeListener(this);

            etExpireDate.setOnClickListener(this);
            etBirthDay.setOnClickListener(this);
            etIdType.setOnClickListener(this);
            etGender.setOnClickListener(this);


        }

        @Override
        public void onFocusChange(View view, boolean b) {
            int i = view.getId();
            item = data.get(getLayoutPosition());



            if (i == R.id.etExpireDate && b) {
                hideKeyboard(view,activity);

                if (!data.get(getLayoutPosition()).isFocus()) {
                    data.get(getLayoutPosition()).setFocus(true);
                    adapterHelper.openCalendar(getLayoutPosition(), etExpireDate);

                } else {
                    data.get(getLayoutPosition()).setFocus(false);


                }
            }


            if (i == R.id.etIdType && b) {
                hideKeyboard(view,activity);
                IdTypeDialog idTypeDialog = new IdTypeDialog(activity, name -> etIdType.setText(name));
                idTypeDialog.show(activity.getFragmentManager(), "genderDialog");


            }

            if (i == R.id.etBirthDay && b) {
                hideKeyboard(view,activity);

                if (!item.isFocus()) {
                    item.setFocus(true);
                    adapterHelper.openCalendar(getLayoutPosition(), etBirthDay);

                } else {
                    item.setFocus(false);

                }


            }


            if (i == R.id.etGender && b) {
                hideKeyboard(view,activity);
                GenderDialog genderDialog = new GenderDialog(activity, name -> etGender.setText(name));
                genderDialog.show(activity.getFragmentManager(), "genderDialog");

            }
        }


        @Override
        public void onClick(View view) {
            int i = view.getId();
            if (i == R.id.etExpireDate) {
                hideKeyboard(view,activity);
                if (!item.isFocus()) {
                    item.setFocus(true);
                    adapterHelper.openCalendar(getLayoutPosition(), etExpireDate);

                } else {
                    item.setFocus(false);

                }
            }


            if (i == R.id.etIdType) {
                hideKeyboard(view,activity);
                IdTypeDialog idTypeDialog = new IdTypeDialog(activity, name -> etIdType.setText(name));
                idTypeDialog.show(activity.getFragmentManager(), "genderDialog");
            }
            if (i == R.id.etBirthDay) {
                hideKeyboard(view,activity);

                if (!item.isFocus()) {
                    item.setFocus(true);
                    adapterHelper.openCalendar(getLayoutPosition(), etBirthDay);

                } else {
                    item.setFocus(false);

                }
            }


            if (i == R.id.etGender) {
                hideKeyboard(view,activity);

                GenderDialog genderDialog = new GenderDialog(activity, name -> etGender.setText(name));
                genderDialog.show(activity.getFragmentManager(), "genderDialog");

            }


        }
        public void hideKeyboard(View view,Activity activity){

            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public interface AdapterHelper {
        void openCalendar(int position, EditText editText);
    }


}
