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
 * Created by RezaNejati on 11/18/2018.
 */
@SuppressLint("ValidFragment")
public class IdTypeDialog extends BaseDialog implements View.OnClickListener {
    private Activity activity;
    private Dialog dialog;
    private CircularProgressButton btnConfirm;
    private TextView tvPassport,tvCard;
    private IdDialogListener idDialogListener;


    public IdTypeDialog(Activity activity, IdDialogListener idDialogListener) {
        this.activity = activity;
        this.idDialogListener = idDialogListener;

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new Dialog(activity, R.style.MyAlertDialogStyle);
        dialog.setContentView(R.layout.alert_dialog_id);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        btnConfirm=dialog.findViewById(R.id.btnConfirm);
        tvPassport=dialog.findViewById(R.id.tvPassport);
        tvCard=dialog.findViewById(R.id.tvCard);


        tvPassport.setOnClickListener(this);
        tvCard.setOnClickListener(this);






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
        if (i == R.id.tvPassport) {
            idDialogListener.onSelectIdType(tvPassport.getText().toString());
            dismiss();
        }
        if (i == R.id.tvCard) {
            idDialogListener.onSelectIdType(tvCard.getText().toString());
            dismiss();


        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public interface IdDialogListener{
        void onSelectIdType(String name);


    }


}
