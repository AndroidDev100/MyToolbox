package com.app.mytoolbox.callBacks.kalturaCallBacks;

import com.kaltura.client.utils.response.base.Response;

public interface NotificationStatusCallback {
    void getnotificationstatus(Response<Boolean> result);
}
