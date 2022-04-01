package com.example.toastlibrary;

import android.content.Context;
import android.widget.Toast;

public class Toaster {
    public static void showMyToast(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
