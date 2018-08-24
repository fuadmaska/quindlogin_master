package com.example.fuadmaska.quindlogin;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by imastudio on 2/9/16.
 */
public class SessionManager {
    private static final String KEY_TOKEN = "tokenLogin";
    private static final String KEY_LOGIN = "isLogin";
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE =0;    Context c;

    //0 agar cuma bsa dibaca hp itu sendiri
    String PREF_NAME="QuindLogPref";

    //konstruktor
    public SessionManager(Context c){
        this.c = c;
        pref = c.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    //membuat session login
    public void cerateLoginSession(String token){
        editor.putString(KEY_TOKEN, token);
        editor.putBoolean(KEY_LOGIN, true);
        editor.commit();
        //commit digunakan untuk menyimpan perubahan
    }
    //mendapatkan token
    public String getToken(){
        return pref.getString(KEY_TOKEN, "");
    }
    //cek login
    public boolean isLogin(){
        return pref.getBoolean(KEY_LOGIN, false);
    }




}
