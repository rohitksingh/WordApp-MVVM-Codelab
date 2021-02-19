package com.rohitksingh.wordapp.utilities;

import androidx.databinding.BindingConversion;

public class BindingConverters {

    @BindingConversion
    public static String intToString(int value){
        return String.valueOf(value);
    }
}
