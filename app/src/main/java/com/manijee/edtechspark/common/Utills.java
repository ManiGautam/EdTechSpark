package com.manijee.edtechspark.common;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Utills {
    private static Utills utills;
    public static Utills getInstance(){
        if (utills == null){
            utills = new Utills();
        }
        return utills;
    }
  public void ShowMessage(View context, String messeage)  {
      Snackbar.make(context.findViewById(android.R.id.content), ""+messeage, Snackbar.LENGTH_LONG)
              .setAction("Action", null).show();
  }

}
