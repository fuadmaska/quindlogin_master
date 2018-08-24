package com.example.fuadmaska.quindlogin;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class CustomDialogNewPassword extends Dialog implements android.view.View.OnClickListener {
    public Activity activity;
    public EditText typenew, typeconfirmnew;
    public TextView cancel, ok;

    public CustomDialogNewPassword(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert_new_password);
        typenew = findViewById(R.id.edt_enternewpass);
        typeconfirmnew = findViewById(R.id.edt_enterconfirmnewpass);
        cancel = findViewById(R.id.tv_cancelnewpass);
        ok = findViewById(R.id.tv_oknewpass);

    }
}