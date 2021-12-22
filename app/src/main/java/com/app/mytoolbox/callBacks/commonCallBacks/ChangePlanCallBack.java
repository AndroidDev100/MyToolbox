package com.app.mytoolbox.callBacks.commonCallBacks;

public interface ChangePlanCallBack {
    void onClick(String paymentType);
    void onCancel(String serviceId,String type,String date);
}
