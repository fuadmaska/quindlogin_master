package com.example.fuadmaska.quindlogin;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class CustomDialogResetPassword extends Dialog implements android.view.View.OnClickListener {
    public Activity activity;
    public Dialog dialog;
    public TextView cancel, ok;

    public CustomDialogResetPassword(Activity activity) {
        super(activity);
        this.activity = activity;

    }

    @Override

    public void onClick(View view) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert_reset_password);
        ok = findViewById(R.id.tv_okmail);
        cancel = findViewById(R.id.tv_cancelemail);

    }
}
