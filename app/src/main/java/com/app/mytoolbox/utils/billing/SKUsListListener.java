package com.app.mytoolbox.utils.billing;

import androidx.annotation.Nullable;

import java.util.List;

public interface SKUsListListener {
    void onListOfSKU(@Nullable List<SkuDetails> purchases);
}
