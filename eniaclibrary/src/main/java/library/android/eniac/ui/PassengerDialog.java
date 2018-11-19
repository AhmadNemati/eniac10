package library.android.eniac.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import library.android.eniac.R;
import library.android.eniac.base.BaseDialog;

/**
 * Created by RezaNejati on 10/29/2018.
 */
@SuppressLint("ValidFragment")
public class PassengerDialog extends BaseDialog implements View.OnClickListener {
    private Activity activity;
    private Dialog dialog;
    private CircularProgressButton btnConfirm;
    private TextView tvMAdault, tvCAdault, tvPAdault, tvMChild, tvCChild, tvPChild, tvMInfant, tvCInfant, tvPInfant;
    int adult, child , infant;
    PassengerListener passengerListener;


    public PassengerDialog(Activity activity,PassengerListener passengerListener,int adult,int child,int infant) {
        this.activity = activity;
        this.passengerListener = passengerListener;
        this.adult = adult;
        this.child = child;
        this.infant = infant;

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new Dialog(activity, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.alert_dialog_passenger);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        btnConfirm = dialog.findViewById(R.id.btnConfirm);
        tvMAdault = dialog.findViewById(R.id.tvMAdault);
        tvCAdault = dialog.findViewById(R.id.tvCAdault);
        tvPAdault = dialog.findViewById(R.id.tvPAdault);
        tvMChild = dialog.findViewById(R.id.tvMChild);
        tvCChild = dialog.findViewById(R.id.tvCChild);
        tvPChild = dialog.findViewById(R.id.tvPChild);
        tvMInfant = dialog.findViewById(R.id.tvMInfant);
        tvCInfant = dialog.findViewById(R.id.tvCInfant);
        tvPInfant = dialog.findViewById(R.id.tvPInfant);


        tvCAdault.setText(adult+"");
        tvCChild.setText(child+"");
        tvCInfant.setText(infant+"");

        tvPAdault.setOnClickListener(this);
        tvPChild.setOnClickListener(this);
        tvPInfant.setOnClickListener(this);
        tvMAdault.setOnClickListener(this);
        tvMChild.setOnClickListener(this);
        tvMInfant.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

        btnConfirm.setText("تائید");


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
        int i = v.getId();

        if (i == R.id.btnConfirm) {

            if (adult==0){
                Toast.makeText(activity, "حداقل یک مسافر بزرگسال انتخاب کنید.", Toast.LENGTH_SHORT).show();
                return;
            }

            passengerListener.setPassenger(adult,child,infant);
            dismiss();

            return;
        }


        if (i == R.id.tvPAdault) {
            if (adult + child + infant > 8)
                return;


            adult++;
            tvCAdault.setText(adult + "");
        }


        if (i == R.id.tvMAdault) {
            if (adult == 0)
                return;


            adult--;
            tvCAdault.setText(adult + "");
            if (infant >= adult) {
                infant = adult;
                tvCInfant.setText(infant + "");

            }
            if ((child % 2) != 0) {
                if (adult * 2 < child) {

                    child = adult + adult;
                    tvCChild.setText(child + "");
                }

                return;
            }
            if ((child % 2) == 0) {
                if (adult * 2 > child) {
                    return;
                }

            }

            if (adult * 2 != child) {
                child = adult + adult;
                tvCChild.setText(child + "");


            }


        }


        if (i == R.id.tvPChild) {
            if (adult + child + infant == 9)
                return;
            if (adult * 2 <= child)
                return;
            child++;
            tvCChild.setText(child+ "");
        }

        if (i == R.id.tvMChild) {
            if (child == 0)
                return;
            child--;
            tvCChild.setText(child+ "");
        }


        if (i == R.id.tvPInfant) {
            if (adult + child + infant == 9)
                return;

            if (adult * 2 <= child)
                return;


            if (adult <= infant)
                return;


            infant++;
            tvCInfant.setText(infant + "");

        }

        if (i == R.id.tvMInfant) {
            if (infant == 0)
                return;
            infant--;
            tvCInfant.setText(infant + "");

        }


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public interface PassengerListener{
        void setPassenger(int adult,int child,int infant);
    }


}
