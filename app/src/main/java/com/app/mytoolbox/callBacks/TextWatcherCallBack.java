package com.app.mytoolbox.callBacks;

import android.text.Editable;

public interface TextWatcherCallBack {

    void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2);
    void onTextChanged(CharSequence charSequence, int i, int i1, int i2);
    void afterTextChanged(Editable editable);
}


