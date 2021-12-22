package com.app.mytoolbox.callBacks.commonCallBacks;

import com.astro.sott.beanModel.login.CommonResponse;

public interface CommonCallBack {

    void response(boolean status, CommonResponse response);
}
