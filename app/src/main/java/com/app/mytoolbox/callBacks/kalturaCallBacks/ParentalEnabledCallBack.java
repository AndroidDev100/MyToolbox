package com.app.mytoolbox.callBacks.kalturaCallBacks;

import com.kaltura.client.types.APIException;

public interface ParentalEnabledCallBack {
    void onParentalEnableSuccess();
    void onParentalEnableFailure(APIException error);
}
