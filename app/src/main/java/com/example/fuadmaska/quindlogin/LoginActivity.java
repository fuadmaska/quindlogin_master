package com.example.fuadmaska.quindlogin;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fuadmaska.quindlogin.Response.ApiServices;
import com.example.fuadmaska.quindlogin.Response.HomeTestActivity;
import com.example.fuadmaska.quindlogin.Response.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout logpass, logemail;
    TextInputEditText tielogmail, tielogpass;
    Button btnlog;
    TextView tvlogforpas;
    TextWatcher emailPasswordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            validateEmailPassword();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void validateEmailPassword() {
        if (!tielogmail.getText().toString().equals("") &&

                tielogpass.getText().length() > 0) {
            btnlog.setEnabled(true);
        } else btnlog.setEnabled(false);

    }

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        logpass = findViewById(R.id.til_logpass);
        logemail = findViewById(R.id.til_logemail);
        logpass.setHintTextAppearance(R.style.TextInputLayoutHintText);
        logemail.setHintTextAppearance(R.style.TextInputLayoutHintText);


        btnlog = findViewById(R.id.btn_log);
        tvlogforpas = findViewById(R.id.tv_logforpass);
        tielogmail = findViewById(R.id.edt_logemail);
        tielogpass = findViewById(R.id.edt_logpass);
        tielogmail.addTextChangedListener(emailPasswordTextWatcher);
        tielogpass.addTextChangedListener(emailPasswordTextWatcher);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionLogin();
            }
        });
        tvlogforpas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogResetPassword cdrp = new CustomDialogResetPassword(LoginActivity.this);
//                cdrp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdrp.show();
            }
        });
    }

    private void actionLogin() {

        final String email = tielogmail.getText().toString();
        String password = tielogpass.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            tielogmail.setError("Email required");


        } else if (password.isEmpty()) {
            tielogpass.setError("Password required");
            tielogpass.requestFocus();

        } else {
            final ProgressDialog progress = new ProgressDialog(LoginActivity.this);
            progress.setMessage("loading");
            progress.setIcon(R.mipmap.ic_launcher);
            progress.setCancelable(false);
            progress.show();

            //get inisialisasi retrofit
            ApiServices api = ConfigRetrofit.getInstanceRetrofit();
            //get request
            Call<ResponseLogin> call = api.request_login(email, password);
            //get response
            call.enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                    progress.dismiss();

                    if (response.isSuccessful()) {

                        Boolean result = response.body().getResult();
                        if (result == true) {
                            startActivity(new Intent(LoginActivity.this, HomeTestActivity.class));
                            finish();
                        }

                    }


                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {

                }
            });
        }
    }


}


