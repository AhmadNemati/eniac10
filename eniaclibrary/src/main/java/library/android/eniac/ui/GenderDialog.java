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

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import library.android.eniac.R;
import library.android.eniac.base.BaseDialog;

/**
 * Created by RezaNejati on 11/17/2018.
 */
@SuppressLint("ValidFragment")
public class GenderDialog extends BaseDialog implements View.OnClickListener {
    private Activity activity;
    private Dialog dialog;
    private CircularProgressButton btnConfirm;
    private TextView tvFemale,tvMale;
    private GenderDialogListener genderDialogListener;


    public GenderDialog(Activity activity, GenderDialogListener genderDialogListener) {
        this.activity = activity;
        this.genderDialogListener = genderDialogListener;

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new Dialog(activity, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.alert_dialog_gender);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        btnConfirm=dialog.findViewById(R.id.btnConfirm);
        tvFemale=dialog.findViewById(R.id.tvFemale);
        tvMale=dialog.findViewById(R.id.tvMale);


        tvFemale.setOnClickListener(this);
        tvMale.setOnClickListener(this);






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
        if (i == R.id.tvFemale) {
            genderDialogListener.onSelectGender(tvFemale.getText().toString());
            dismiss();
        }
        if (i == R.id.tvMale) {
            genderDialogListener.onSelectGender(tvMale.getText().toString());
            dismiss();


        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public interface GenderDialogListener{
        void onSelectGender(String name);


    }


}
