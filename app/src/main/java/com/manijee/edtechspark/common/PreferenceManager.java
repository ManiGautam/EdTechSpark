package com.manijee.edtechspark.common;
import android.content.Context;
import android.content.SharedPreferences;
//siglton pattern
public class PreferenceManager {
    private static PreferenceManager preferenceManager;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static PreferenceManager getInstance(Context ct) {
        if (preferenceManager == null) {
            preferenceManager = new PreferenceManager();
            preferences = ct.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
        return preferenceManager;
    }
    public void setInfo(String key , String value){
        editor.putString(key,value);
        editor.commit();
    }
    public String getInfo(String key){
        return  preferences.getString(key,"");
    }

public void logout(String key,String key2,String key3){
     editor.remove(key);
     editor.remove(key2);
     editor.remove(key3);
     editor.clear();
     editor.commit();
}
}