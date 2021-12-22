package com.app.mytoolbox.networking.retrofit;


import com.app.mytoolbox.activities.SelectAccount.SelectAccountModel.Response;
import com.app.mytoolbox.modelClasses.DTVContactInfoModel;
import com.app.mytoolbox.modelClasses.OtpModel;
import com.app.mytoolbox.modelClasses.TokenModel;
import com.app.mytoolbox.modelClasses.WaterMark.WaterMarkModel;
import com.app.mytoolbox.modelClasses.dmsResponse.ResponseDmsModel;
import com.app.mytoolbox.modelClasses.playbackContext.PlaybackContextResponse;
import com.app.mytoolbox.utils.constants.AppConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("configurations/action/serveByDevice")
    Call<ResponseDmsModel> getDMS(@Body JsonObject apiVersion);


    @POST("asset/action/getPlaybackContext")
    Call<PlaybackContextResponse> getPlaybackContext(@Body JsonObject apiVersion);

    @POST("asset/action/getPlaybackContext")
    Call<PlaybackContextResponse> getAdContext(@Body JsonObject apiVersion);


    @GET(AppConstants.SMS_API_END_POINT)
    Call<OtpModel> getmPin(@Query("number") String msisdn);

    @POST(AppConstants.SMS_API_END_POINT)
    Call<OtpModel> sendOTP(@Body JsonObject msisdn);

    @POST(AppConstants.VERIFY_OTP)
    Call<OtpModel> verifyPin(@Body JsonObject verifyOtpPayload);

    @POST(AppConstants.DTV_ACC_NUM)
    Call<DTVContactInfoModel> getDTVContactInfo(@Body JsonObject jsonObject);

    @POST(AppConstants.CONNETION_DETAILS)
    Call<Response> getConnectionDetails(@Body JsonObject jsonObject);

    @GET("cd_service_metasea2_dialogviu_stream_url_api.php?")
    Call<JsonElement> getHungama(@Query("content_id") String content_id, @Query("user_id") String user_id, @Header("PRODUCT") String product, @Header("APP-KEY") String app_key, @Header("deviceId") String deviceId);


    @GET("QA/getAPIToken_QA")
    Call<TokenModel> getToken();

    @GET(".")
    Call<OtpModel> getMsisdn();

    @POST("/api/p/3209/service/JwtGenerator/action/GetToken")
    Call<WaterMarkModel> getJwtToken(@Body JsonObject verifyOtpPayload);
}
