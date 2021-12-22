package com.app.mytoolbox.utils.helpers;

import android.content.Context;
import android.view.Gravity;

import androidx.core.content.ContextCompat;

import com.app.mytoolbox.R;

public class ToastHandler {
    private static ToastHandler toastHandler;

    private ToastHandler() {

    }

    public static ToastHandler getInstance() {
        if (toastHandler == null) {
            toastHandler = new ToastHandler();
        }

        return toastHandler;
    }

    public static void show(String message, Context context) {
        MaterialToast.show(message, ContextCompat.getDrawable(context, R.drawable.toast_drawable),
                ContextCompat.getColor(context, R.color.colorAccent),
                Gravity.BOTTOM, context);
    }

    public static void display(String message, Context context) {
        MaterialToast.display(message, ContextCompat.getDrawable(context, R.drawable.toast_drawable),
                ContextCompat.getColor(context, R.color.colorAccent),
                Gravity.BOTTOM, context);
    }

}
