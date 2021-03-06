package com.app.mytoolbox.callBacks.kalturaCallBacks;

import com.kaltura.client.types.APIException;

public interface OttUserDetailsCallBack {
    void onSuccess(String userPreferenceForParental);
    void onFailure(APIException error);
    void onUserParentalDetailsNotFound();
}
