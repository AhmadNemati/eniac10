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
import android.widget.RadioButton;
import android.widget.TextView;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import library.android.eniac.R;
import library.android.eniac.base.BaseDialog;

/**
 * Created by RezaNejati on 10/29/2018.
 */
@SuppressLint("ValidFragment")
public class ClassDialog  extends BaseDialog implements View.OnClickListener {
    private Activity activity;
    private Dialog dialog;
    private CircularProgressButton btnConfirm;
    private TextView tvBusiness,tvFirst,tvPremium,tvEconomy;
    private ClassDialogListener classDialogListener;


    public ClassDialog(Activity activity,ClassDialogListener classDialogListener) {
        this.activity = activity;
        this.classDialogListener = classDialogListener;

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new Dialog(activity, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.alert_dialog_class);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        btnConfirm=dialog.findViewById(R.id.btnConfirm);
        tvBusiness=dialog.findViewById(R.id.tvBusiness);
        tvFirst=dialog.findViewById(R.id.tvFirst);
        tvPremium=dialog.findViewById(R.id.tvPremium);
        tvEconomy=dialog.findViewById(R.id.tvEconomy);

        tvEconomy.setOnClickListener(this);
        tvBusiness.setOnClickListener(this);
        tvFirst.setOnClickListener(this);
        tvPremium.setOnClickListener(this);





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
        if (i == R.id.tvEconomy) {
            classDialogListener.inSelectClass(tvEconomy.getText().toString());
            dismiss();
        }
        if (i == R.id.tvBusiness) {
            classDialogListener.inSelectClass(tvBusiness.getText().toString());
            dismiss();


        }
        if (i == R.id.tvFirst) {
            classDialogListener.inSelectClass(tvFirst.getText().toString());
            dismiss();


        }
        if (i == R.id.tvPremium) {
            classDialogListener.inSelectClass(tvPremium.getText().toString());
            dismiss();


        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public interface ClassDialogListener{
        void inSelectClass(String name);


    }


}
