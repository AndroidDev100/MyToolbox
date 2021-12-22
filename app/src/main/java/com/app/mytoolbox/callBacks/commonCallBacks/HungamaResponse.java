package com.app.mytoolbox.callBacks.commonCallBacks;

public interface HungamaResponse {
    void onSuccess(String url);
    void onFailureFailure();
    void onError(Throwable ex);
}
