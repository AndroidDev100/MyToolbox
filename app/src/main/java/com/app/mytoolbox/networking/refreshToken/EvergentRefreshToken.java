package com.app.mytoolbox.networking.refreshToken;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.app.mytoolbox.usermanagment.EvergentServices.EvergentServices;
import com.app.mytoolbox.usermanagment.callBacks.EvergentRefreshTokenCallBack;
import com.app.mytoolbox.usermanagment.modelClasses.EvergentCommonResponse;
import com.app.mytoolbox.usermanagment.modelClasses.refreshToken.RefreshTokenResponse;
import com.app.mytoolbox.utils.userInfo.UserInfo;

import org.jetbrains.annotations.NotNull;

public class EvergentRefreshToken {

    public static LiveData<EvergentCommonResponse> refreshToken(Context context, String refreshToken) {
        MutableLiveData<EvergentCommonResponse> mutableLiveData = new MutableLiveData<>();
        EvergentCommonResponse evergentCommonResponse = new EvergentCommonResponse();
        EvergentServices.Companion.getInstance().refreshToken(context, refreshToken, new EvergentRefreshTokenCallBack() {


            @Override
            public void onFailure(@NotNull String errorMessage, @NotNull String errorCode) {
                evergentCommonResponse.setStatus(false);
                evergentCommonResponse.setErrorMessage(errorMessage);
                evergentCommonResponse.setErrorCode(errorCode);
                mutableLiveData.postValue(evergentCommonResponse);
            }

            @Override
            public void onSuccess(@NotNull RefreshTokenResponse createUserResponse) {
                evergentCommonResponse.setStatus(false);
                evergentCommonResponse.setRefreshTokenResponse(createUserResponse);
                UserInfo.getInstance(context).setAccessToken(createUserResponse.getRefreshTokenResponseMessage().getAccessToken());
                mutableLiveData.postValue(evergentCommonResponse);

            }
        });
        return mutableLiveData;
    }
}
