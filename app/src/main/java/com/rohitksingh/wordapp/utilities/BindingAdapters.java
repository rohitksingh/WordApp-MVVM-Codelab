package com.rohitksingh.wordapp.utilities;

import android.util.Log;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    private static final String TAG = "BindingAdapters";

    @BindingAdapter("profileImageUrl")
    public static void setImageFromCloud(TextView textView, String value){
        Log.d(TAG, "testingAdapter: "+value);
    }
}
