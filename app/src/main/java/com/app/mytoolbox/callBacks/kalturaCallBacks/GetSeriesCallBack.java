package com.app.mytoolbox.callBacks.kalturaCallBacks;

import com.kaltura.client.types.Asset;

import java.util.List;

public interface GetSeriesCallBack {
    void onSuccess(List<Asset> asset);
    void onFailure();
}
