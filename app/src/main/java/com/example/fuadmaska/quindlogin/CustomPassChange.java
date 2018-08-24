package com.example.fuadmaska.quindlogin;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class CustomPassChange extends Dialog implements android.view.View.OnClickListener {

    public Activity activity;
    public Dialog dialog;
    public LinearLayout ok;

    public CustomPassChange(Activity activity) {
        super(activity);
        this.activity = activity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert_password_changed);
        ok = findViewById(R.id.ll_okpassenmail);

    }

    @Override
    public void onClick(View view) {

    }
}
