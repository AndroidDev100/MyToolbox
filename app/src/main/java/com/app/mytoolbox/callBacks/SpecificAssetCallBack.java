package com.app.mytoolbox.callBacks;

import com.kaltura.client.types.Asset;

public interface SpecificAssetCallBack {
    void getAsset(boolean status, Asset asset);
    void cancelReminder(Asset asset);
}
