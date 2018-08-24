package com.example.fuadmaska.quindlogin;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class CustomDialogUnauthorized extends Dialog implements android.view.View.OnClickListener {

    public Activity activity;
    public Dialog dialog;
    public LinearLayout ok;

    public CustomDialogUnauthorized(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert_noemail_registered);
        ok = findViewById(R.id.ll_okunauothorized);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_okunauothorized:
                dismiss();
                break;
            default:
        }
    }
}
