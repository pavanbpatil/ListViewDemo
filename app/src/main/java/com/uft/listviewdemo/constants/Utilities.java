package com.uft.listviewdemo.constants;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class Utilities {
    static ProgressDialog progressDialog;
    public static void showLoader(final Context context) {
        progressDialog=new ProgressDialog(context);
        if (progressDialog == null || progressDialog.isShowing()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                progressDialog.setTitle(Constant.AppConstants.LOADER_TEXT);
                progressDialog.show();

            }
        });
    }

    public static void hideLoader() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        });
    }
}
