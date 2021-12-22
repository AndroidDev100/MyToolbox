package com.app.mytoolbox.fragments.trailerFragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;
import com.app.mytoolbox.activities.parentalControl.viewmodels.ParentalControlViewModel;
import com.app.mytoolbox.baseModel.BaseBindingFragment;
import com.app.mytoolbox.beanModel.ksBeanmodel.RailCommonData;
import com.app.mytoolbox.callBacks.commonCallBacks.ParentalDialogCallbacks;
import com.app.mytoolbox.callBacks.commonCallBacks.TrailerAsset;
import com.app.mytoolbox.databinding.FragmentTrailerBinding;
import com.app.mytoolbox.fragments.dialog.AlertDialogSingleButtonFragment;
import com.app.mytoolbox.fragments.trailerFragment.adapter.TrailerAdapter;
import com.app.mytoolbox.fragments.trailerFragment.viewModel.TrailerFragmentViewModel;
import com.app.mytoolbox.modelClasses.dmsResponse.ParentalLevels;
import com.app.mytoolbox.modelClasses.dmsResponse.ResponseDmsModel;
import com.app.mytoolbox.networking.refreshToken.RefreshKS;
import com.app.mytoolbox.player.entitlementCheckManager.EntitlementCheck;
import com.app.mytoolbox.player.geoBlockingManager.GeoBlockingCheck;
import com.app.mytoolbox.player.houseHoldCheckManager.HouseHoldCheck;
import com.app.mytoolbox.player.ui.PlayerActivity;
import com.app.mytoolbox.utils.commonMethods.AppCommonMethods;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.app.mytoolbox.utils.helpers.AssetContent;
import com.app.mytoolbox.utils.helpers.DialogHelper;
import com.app.mytoolbox.utils.helpers.PrintLogging;
import com.app.mytoolbox.utils.ksPreferenceKey.KsPreferenceKey;
import com.kaltura.client.types.Asset;
import com.kaltura.client.types.ListResponse;
import com.kaltura.client.types.MultilingualStringValueArray;
import com.kaltura.client.types.UserAssetRule;
import com.kaltura.client.utils.response.base.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrailerFragment extends BaseBindingFragment<FragmentTrailerBinding> implements TrailerAsset, AlertDialogSingleButtonFragment.AlertDialogListener {

    private RailCommonData railCommonData;
    private int errorCode = AppLevelConstants.NO_ERROR;
    private boolean isParentalLocked = false;
    private Asset asset;
    private boolean playerChecksCompleted = false;
    private int assetRuleErrorCode = -1;
    private Map<String, MultilingualStringValueArray> map;
    private String defaultParentalRating = "";
    private String userSelectedParentalRating = "";
    private int userSelectedParentalPriority;
    private int priorityLevel;
    private String externalRefId;
    private TrailerAdapter trailerAdapter;
    private List<Asset> trailerData;
    private List<Asset> highLightData;


    private int assetRestrictionLevel;
    private String externalId = "";
    ArrayList<ParentalLevels> parentalLevels;


    private TrailerFragmentViewModel trailerFragmentViewModel;
    private boolean assetKey = false;

    public TrailerFragment() {
        // Required empty public constructor
    }


    @Override
    protected FragmentTrailerBinding inflateBindingLayout(@NonNull LayoutInflater inflater) {
        return FragmentTrailerBinding.inflate(inflater);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        railCommonData = getArguments().getParcelable(AppLevelConstants.RAIL_DATA_OBJECT);
        // AllChannelManager.getInstance().setRailCommonData(railCommonData);
        if (railCommonData != null && railCommonData.getObject() != null)
            asset = railCommonData.getObject();
        map = asset.getTags();
        if (asset.getExternalId() != null)
            externalId = asset.getExternalId();
        parentalLevels = new ArrayList<>();
        modelCall();
        checkTrailerOrHighlights();
        //   getRefId(asset.getType(), asset.getMetas());

    }

    private void checkTrailerOrHighlights() {
        trailerData = trailerFragmentViewModel.getTrailer();
        highLightData = trailerFragmentViewModel.getHighLights();
     try {
         if (trailerData.size() > 0)
          setTrailerUiComponents();

         if (highLightData.size() > 0)
          setHighLightUiComponents();
     }catch (NullPointerException e){
         PrintLogging.printLog("Exception", e.toString());

     }
        Log.d("trailerSIZE",trailerData.size()+"");
        Log.d("trailerSIZE",highLightData.size()+"");



    }

    private void modelCall() {
        trailerFragmentViewModel = ViewModelProviders.of(this).get(TrailerFragmentViewModel.class);
    }


    private void setTrailerUiComponents() {
//        getBinding().trailerText.setVisibility(View.VISIBLE);
        getBinding().trailerRecyclerView.setVisibility(View.VISIBLE);
        getBinding().trailerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        trailerAdapter = new TrailerAdapter(getActivity(), trailerData, this);
        getBinding().trailerRecyclerView.setAdapter(trailerAdapter);
    }

    private void setHighLightUiComponents() {
//        getBinding().highLightText.setVisibility(View.VISIBLE);
        getBinding().highLightREcycler.setVisibility(View.VISIBLE);
        getBinding().highLightREcycler.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        trailerAdapter = new TrailerAdapter(getActivity(), highLightData, this);
        getBinding().highLightREcycler.setAdapter(trailerAdapter);
    }

    private void playerChecks(final Asset railData) {
        new GeoBlockingCheck().aseetAvailableOrNot(getActivity(), railData, (status, response, totalCount, errorcode, message) -> {
            if (status) {
                if (totalCount != 0) {
                    checkBlockingErrors(response, railData);
                } else {
                    playerChecksCompleted = true;
                    checkErrors(railData);
                }
            } else {
                callProgressBar();
                showDialog(message);
            }
        });
    }

    private void checkEntitleMent(final Asset railCommonData) {
        String fileId = AppCommonMethods.getFileIdOfAssest(railCommonData);

        new EntitlementCheck().checkAssetType(getActivity(), fileId, (status, response, purchaseKey, errorCode1, message) -> {
            if (status) {
                playerChecksCompleted = true;
                if (purchaseKey.equalsIgnoreCase(getResources().getString(R.string.FOR_PURCHASE_SUBSCRIPTION_ONLY)) || purchaseKey.equals(getResources().getString(R.string.FREE))) {
                    errorCode = AppLevelConstants.NO_ERROR;
                    checkErrors(railCommonData);
                } else if (purchaseKey.equalsIgnoreCase(getResources().getString(R.string.FOR_PURCHASED))) {
                    errorCode = AppLevelConstants.FOR_PURCHASED_ERROR;
                    checkErrors(railCommonData);
                    //not play
                } else {
                    errorCode = AppLevelConstants.USER_ACTIVE_ERROR;
                    checkErrors(railCommonData);
                    //not play
                }
            } else {
                callProgressBar();
                if (message != "")
                    showDialog(message);
            }


        });

    }


    private void checkBlockingErrors(Response<ListResponse<UserAssetRule>> response, Asset
            railData) {
        if (response != null && response.results != null && response.results.getObjects() != null) {
            for (UserAssetRule userAssetRule :
                    response.results.getObjects()) {
                switch (userAssetRule.getRuleType()) {
                    case GEO:
                        assetRuleErrorCode = AppLevelConstants.GEO_LOCATION_ERROR;
                        playerChecksCompleted = true;
                        checkErrors(railData);
                        return;
//                    case PARENTAL:
//                        assetRuleErrorCode = AppLevelConstants.PARENTAL_BLOCK;
//                        checkEntitleMent(railData);
//                        break;
                    default:
                        playerChecksCompleted = true;
                        checkErrors(railData);
                        break;
                }
            }
        }
    }

    @Override
    public void getTrailerAsset(Asset trailerAsset) {

        callProgressBar();
        playerChecks(trailerAsset);
        //  new ActivityLauncher(getActivity()).trailerDirection(trailerAsset, AppConstants.Rail5);

    }

    private void checkErrors(Asset asset) {
        if (playerChecksCompleted) {
            if (assetRuleErrorCode == AppLevelConstants.GEO_LOCATION_ERROR) {
                getActivity().runOnUiThread(() -> DialogHelper.openDialougeforGeoLocation(1, getActivity()));
                callProgressBar();
            } else if (errorCode == AppLevelConstants.FOR_PURCHASED_ERROR) {
                getActivity().runOnUiThread(() -> DialogHelper.openDialougeForEntitleMent(getActivity()));
                callProgressBar();
            } else if (errorCode == AppLevelConstants.USER_ACTIVE_ERROR) {
                getActivity().runOnUiThread(() -> DialogHelper.openDialougeForEntitleMent(getActivity()));
                callProgressBar();
            }
//            else if (assetRuleErrorCode == AppLevelConstants.PARENTAL_BLOCK) {
//                isParentalLocked = true;
//                if (KsPreferenceKey.getInstance(getActivity()).getUserActive())
//                    validateParentalPin(asset);
//                else
//                    startPlayer(asset);
//            }
//            else if (errorCode == AppLevelConstants.NO_ERROR && (assetRuleErrorCode == AppLevelConstants.NO_ERROR || assetRuleErrorCode == -1)) {
//                if (KsPreferenceKey.getInstance(getActivity()).getUserActive())
//                    checkOnlyDevice(asset);
//                else {
//                    startPlayer(asset);
//                }
//            } else {
//                PrintLogging.printLog("", "elseValuePrint-->>" + assetRuleErrorCode + "  " + errorCode);
//            }
            else if (errorCode == AppLevelConstants.NO_ERROR) {
                if (KsPreferenceKey.getInstance(getActivity()).getUserActive()) {
                    parentalCheck(asset);
                } else {
                    startPlayer(asset);
                }
            }
        } else {
            callProgressBar();
            DialogHelper.showAlertDialog(getActivity(), getString(R.string.play_check_message), getString(R.string.ok), this);
        }
    }


    private void parentalCheck(Asset asset) {
        if (KsPreferenceKey.getInstance(getActivity()).getUserActive()) {
            if (KsPreferenceKey.getInstance(getActivity()).getParentalActive()) {
                ResponseDmsModel responseDmsModel = AppCommonMethods.callpreference(getActivity());
                defaultParentalRating = responseDmsModel.getParams().getDefaultParentalLevel();
                userSelectedParentalRating = KsPreferenceKey.getInstance(getActivity()).getUserSelectedRating();
                if (!userSelectedParentalRating.equalsIgnoreCase("")) {
                    assetKey = AssetContent.getAssetKey(asset.getTags(), userSelectedParentalRating, getActivity());
                    if (assetKey) {
                        assetRuleErrorCode = AppLevelConstants.NO_ERROR;
                        checkOnlyDevice(asset);
                    } else {
                        validateParentalPin(asset);
                    }

                } else {
                    assetKey = AssetContent.getAssetKey(asset.getTags(), defaultParentalRating, getActivity());
                    if (assetKey) {
                        assetRuleErrorCode = AppLevelConstants.NO_ERROR;
                        checkOnlyDevice(asset);
                    } else {
                        validateParentalPin(asset);
                    }
                }
            } else {
                assetRuleErrorCode = AppLevelConstants.NO_ERROR;
                checkOnlyDevice(asset);
            }
        }
    }


    private void checkOnlyDevice(Asset railData) {
        new HouseHoldCheck().checkHouseholdDevice(getActivity(), commonResponse -> {
            if (commonResponse != null) {
                if (commonResponse.getStatus()) {
                    getActivity().runOnUiThread(() -> {
                        startPlayer(railData);
                    });
                } else {
                    if (commonResponse.getErrorCode().equals(AppLevelConstants.KS_EXPIRE)) {
                        new RefreshKS(getActivity()).refreshKS(response -> checkDevice(railData));
                    } else {
                        callProgressBar();
                        showDialog(commonResponse.getMessage());
                    }
                }
            }

        });
    }

    private void checkDevice(final Asset railData) {
        new HouseHoldCheck().checkHouseholdDevice(getActivity(), commonResponse -> {
            if (commonResponse != null) {
                if (commonResponse.getStatus()) {
                    getActivity().runOnUiThread(() -> checkEntitleMent(railData));
                } else {
                    if (commonResponse.getErrorCode().equals(AppLevelConstants.KS_EXPIRE)) {
                        new RefreshKS(getActivity()).refreshKS(response -> checkDevice(railData));
                    } else {
                        callProgressBar();
                        showDialog(commonResponse.getMessage());
                    }
                }
            }
        });
    }


    private void validateParentalPin(Asset asset) {

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                DialogHelper.showValidatePinDialog(getActivity(), null, "TRAILER", new ParentalDialogCallbacks() {
                    @Override
                    public void onPositiveClick(String pinText) {
                        ParentalControlViewModel parentalViewModel = ViewModelProviders.of(getActivity()).get(ParentalControlViewModel.class);

                        parentalViewModel.validatePin(getActivity(), pinText).observe(getActivity(), commonResponse -> {
                            if (commonResponse.getStatus()) {
                                DialogHelper.hideValidatePinDialog();
                                assetRuleErrorCode = AppLevelConstants.NO_ERROR;
                                playerChecksCompleted = true;
                                // checkErrors(asset);
                                checkOnlyDevice(asset);
                            } else {
                                Toast.makeText(getActivity(), getString(R.string.incorrect_parental_pin), Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onNegativeClick() {
                        DialogHelper.hideValidatePinDialog();
                        callProgressBar();
                    }
                });
            }
        });
    }

    private void showDialog(String message) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        AlertDialogSingleButtonFragment alertDialog = AlertDialogSingleButtonFragment.newInstance(getResources().getString(R.string.dialog), message, getResources().getString(R.string.ok));
        alertDialog.setCancelable(false);
        alertDialog.setAlertDialogCallBack(this);
        alertDialog.show(fm, AppLevelConstants.TAG_FRAGMENT_ALERT);
    }

    @Override
    public void onFinishDialog() {

    }

    private void startPlayer(Asset asset) {
        callProgressBar();
        RailCommonData railCommonData = new RailCommonData();
        railCommonData.setObject(asset);
        railCommonData.setProgress(0);
        Intent intent = new Intent(getActivity(), PlayerActivity.class);
        intent.putExtra(AppLevelConstants.RAIL_DATA_OBJECT, railCommonData);
        startActivity(intent);
    }

    private void callProgressBar() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (getBinding().includeProgressbar.progressBar.getVisibility() == View.VISIBLE) {
                    getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
                } else {
                    getBinding().includeProgressbar.progressBar.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
