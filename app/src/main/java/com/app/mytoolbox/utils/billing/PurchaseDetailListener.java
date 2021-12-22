package com.app.mytoolbox.utils.billing;

import com.android.billingclient.api.Purchase;

public interface PurchaseDetailListener {
    void response(Purchase purchaseObject);
}
