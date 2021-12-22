package com.app.mytoolbox.utils.billing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;

import java.util.List;

public interface InAppProcessListener {
    void onBillingInitialized();

    void onPurchasesUpdated(@NonNull BillingResult billingResult, @Nullable List<Purchase> purchases);

    void onListOfSKUFetched(@Nullable List<SkuDetails> purchases);

    void onBillingError(@Nullable BillingResult error);

    void onUpgrade();

    void onDowngrade();

    void onAcknowledged(String productId, String purchaseToken, String orderId);
}
