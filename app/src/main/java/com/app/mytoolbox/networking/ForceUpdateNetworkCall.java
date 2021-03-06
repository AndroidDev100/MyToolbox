package com.app.mytoolbox.networking;

import android.content.Context;
import android.os.Handler;

import com.app.mytoolbox.BuildConfig;
import com.app.mytoolbox.callBacks.commonCallBacks.VersionValidator;
import com.app.mytoolbox.modelClasses.dmsResponse.ResponseDmsModel;
import com.app.mytoolbox.utils.commonMethods.AppCommonMethods;
import com.app.mytoolbox.utils.helpers.PrintLogging;
import com.app.mytoolbox.utils.helpers.SharedPrefHelper;

public class ForceUpdateNetworkCall {

    private Context context;
    private VersionValidator versionValidator;
    private int appCVesion = 0;
    private int updateVersion = 0;
    String appVersion = "";

    public ForceUpdateNetworkCall(Context applicationContext) {
        this.context = applicationContext;
    }

    public void checkCurrentVersion(int currentVersion, VersionValidator callBack) {
        checkPlaystoreVersion(currentVersion, callBack);
    }

    private void checkPlaystoreVersion(final int currentVersion, final VersionValidator callBack) {
        PrintLogging.printLog("", "in");
        versionValidator = callBack;

        new Handler().postDelayed(() -> {
            SharedPrefHelper.getInstance(context).setInt("current_version", currentVersion);
            SharedPrefHelper.getInstance(context).setInt("playstore_version", BuildConfig.VERSION_CODE);
            SharedPrefHelper.getInstance(context).setString("update_type", "force");
            ResponseDmsModel responseDmsModel = AppCommonMethods.callpreference(context);
            if (responseDmsModel.getParams() != null) {
                if (responseDmsModel.getParams().getUpdatedVersion() != null) {
                    appVersion = responseDmsModel.getParams().getUpdatedVersion();
                    // String appVersion = "21.6.7";
                    appVersion = appVersion.trim();
                    if (!appVersion.equalsIgnoreCase("")) {
                        if (appVersion.contains(".")) {
                            appVersion = appVersion.replace(".", "");
                            if (!appVersion.equalsIgnoreCase("")) {
                                updateVersion = Integer.parseInt(appVersion);
                                String version = BuildConfig.VERSION_NAME.replace(".", "");
                                String[] versionSplit = version.split("\\(");
                                version = versionSplit[0];
                                appCVesion = Integer.parseInt(version);
                                versionValidator.version(false, appCVesion, updateVersion);
                                PrintLogging.printLog("", "versionPrinted" + appCVesion + " " + updateVersion);
                            } else {
                                versionValidator.version(true, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE);
                            }
                        } else {
                            versionValidator.version(true, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE);
                        }
                    } else {
                        versionValidator.version(true, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE);
                    }
                } else {
                    versionValidator.version(true, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE);
                }
            } else {
                versionValidator.version(true, BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE);
            }
        }, 100);
    }


}
