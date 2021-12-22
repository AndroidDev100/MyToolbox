package com.app.mytoolbox.fragments.signUp;


import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.app.mytoolbox.BuildConfig;
import com.app.mytoolbox.R;
import com.app.mytoolbox.activities.loginActivity.LoginActivity;
import com.app.mytoolbox.activities.loginActivity.viewModel.LoginViewModel;
import com.app.mytoolbox.baseModel.BaseBindingFragment;
import com.app.mytoolbox.databinding.FragmentSignUpBinding;
import com.app.mytoolbox.fragments.dialog.AlertDialogSingleButtonFragment;
import com.app.mytoolbox.utils.commonMethods.AppCommonMethods;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.app.mytoolbox.utils.helpers.CustomTextviewWatcher;
import com.app.mytoolbox.utils.helpers.NetworkConnectivity;
import com.app.mytoolbox.utils.ksPreferenceKey.KsPreferenceKey;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends BaseBindingFragment<FragmentSignUpBinding> implements TextView.OnEditorActionListener, AlertDialogSingleButtonFragment.AlertDialogListener {

    private OnFragmentInteractionListener mListener;
    private LoginActivity loginActivity;
    private LoginViewModel viewModel;
    private String msisdn;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public FragmentSignUpBinding inflateBindingLayout(@NonNull LayoutInflater inflater) {
        return FragmentSignUpBinding.inflate(inflater);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
       // getAutoMsisdn();
        setCLicks();

        getBinding().etPhoneno.addTextChangedListener(new CustomTextviewWatcher(getBinding().errorText, getBinding().etPhoneno));
        getBinding().etPhoneno.setOnEditorActionListener(this);
        getBinding().etPhoneno.requestFocus();

    }

    private void getAutoMsisdn() {
        getBinding().includeProgressbar.progressBar.setVisibility(View.VISIBLE);
        viewModel.getMsisdn().observe(this, otpModel -> {
            getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
            if (otpModel != null) {
                switch (otpModel.getResponseCode()) {
                    case 200: {
                        if (!otpModel.getMsisdn().equals("")) {
                            String msisdn = otpModel.getMsisdn();
                            getBinding().etPhoneno.append(msisdn);
//                            if (msisdn.startsWith(AppConstants.SL_COUNTRY_CODE)) {
//                                msisdn = msisdn.substring(2);
//                                msisdn = "0".concat(msisdn);
//                                getBinding().etPhoneno.append(msisdn);
//                            }
                            goToVerification(true);
                        }
                    }
                    break;
                }
            }
        });

    }

    private void setCLicks() {
        getBinding().cancelText.setOnClickListener(view -> {
            InputMethodManager mgr = (InputMethodManager) loginActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (mgr != null)
                mgr.hideSoftInputFromWindow(getBinding().etPhoneno.getWindowToken(), 0);
            loginActivity.finish();
        });
        getBinding().alreadyUserText.setOnClickListener(view -> mListener.onFragmentInteraction(AppLevelConstants.SIGN_UP, AppLevelConstants.ALREADY_USER, "", "", false,null));

        getBinding().tvContinue.setOnClickListener(v -> goToVerification(false));


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context != null) {
            if (context instanceof LoginActivity) {
                loginActivity = (LoginActivity) context;
                mListener = (OnFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            goToVerification(false);
            return true;
        }
        return false;

    }

    private void goToVerification(Boolean isAutoMsisdn) {
        if (isAutoMsisdn) {
            String msisdn = getBinding().etPhoneno.getText().toString().trim();
//            if (msisdn.startsWith("0")) {
//                msisdn = msisdn.substring(1);
//                msisdn = AppConstants.SL_COUNTRY_CODE.concat(msisdn);
//            }
            String finalMsisdn = msisdn;
            mListener.onFragmentInteraction(AppLevelConstants.SIGN_UP, AppLevelConstants.CONTINUE, finalMsisdn, "", true,null);
        } else {

            if (getBinding().etPhoneno.getText() != null) {
                if (TextUtils.isEmpty(getBinding().etPhoneno.getText().toString().trim())) {
                    getBinding().errorText.setVisibility(View.VISIBLE);
                    getBinding().errorText.setText(getResources().getString(R.string.phone_no_required));
                    getBinding().etPhoneno.getBackground().setColorFilter(getActivity().getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
                    AppCommonMethods.requestFocus(loginActivity, getBinding().etPhoneno);
                } else if (getBinding().etPhoneno.getText().toString().trim().length() < 9) {
                    getBinding().errorText.setVisibility(View.VISIBLE);
                    getBinding().errorText.setText(getResources().getString(R.string.incorrect_phone_number));
                    getBinding().etPhoneno.getBackground().setColorFilter(getActivity().getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
                    AppCommonMethods.requestFocus(loginActivity, getBinding().etPhoneno);
                }
//                else if (getBinding().etPhoneNo.getText().toString().startsWith("0") && getBinding().etPhoneNo.getText().toString().trim().length() == 9) {
//                    getBinding().errorText.setText(getResources().getString(R.string.incorrect_phone_number));
//                    AppCommonMethods.requestFocus(loginActivity, getBinding().etPhoneNo);
                // }
                else {
                    getBinding().etPhoneno.getBackground().clearColorFilter();
                    getBinding().errorText.setVisibility(View.GONE);
                    getBinding().includeProgressbar.progressBar.setVisibility(View.VISIBLE);
                    getMpin();
                }
            }


//            if (getBinding().etPhoneno.getText() != null) {
//                if (TextUtils.isEmpty(getBinding().etPhoneno.getText().toString().trim())) {
//                    getBinding().numberEditTextLayout.setError(getResources().getString(R.string.phone_no_required));
//                    AppCommonMethods.requestFocus(loginActivity, getBinding().numberEditTextLayout);
//                } else if (getBinding().etPhoneno.getText().toString().trim().length() < 10) {
//                    getBinding().numberEditTextLayout.setError(getResources().getString(R.string.incorrect_phone_number));
//                    AppCommonMethods.requestFocus(loginActivity, getBinding().numberEditTextLayout);
//                } else if (!getBinding().etPhoneno.getText().toString().startsWith("0")) {
//                    getBinding().numberEditTextLayout.setError(getResources().getString(R.string.incorrect_phone_number));
//                    AppCommonMethods.requestFocus(loginActivity, getBinding().numberEditTextLayout);
//                } else {
//                    getBinding().includeProgressbar.progressBar.setVisibility(View.VISIBLE);
//                    getMpin();
//                }
//            }
        }
    }

    private void getMpin() {
        getBinding().includeProgressbar.progressBar.setVisibility(View.VISIBLE);
        if (getBinding().etPhoneno.getText() != null) {
            String msisdn = getBinding().etPhoneno.getText().toString().trim();
//            if (msisdn.startsWith("0")) {
//                msisdn = msisdn.substring(1);
//                msisdn = AppConstants.SL_COUNTRY_CODE.concat(msisdn);
//            }
            String finalMsisdn = msisdn;
            if (getActivity() != null && NetworkConnectivity.isOnline(getActivity())) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("qa")) {
                if(finalMsisdn.equalsIgnoreCase("763742892") || finalMsisdn.equalsIgnoreCase("768468718") || finalMsisdn.equalsIgnoreCase("767413749") ||
                        finalMsisdn.equalsIgnoreCase("774098897") || finalMsisdn.equalsIgnoreCase("777301080") || finalMsisdn.equalsIgnoreCase("765111864")
                        || finalMsisdn.equalsIgnoreCase("765111924") || finalMsisdn.equalsIgnoreCase("777338767")) {
                    getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
                    KsPreferenceKey.getInstance(getActivity()).setMsisdn(finalMsisdn);
                    mListener.onFragmentInteraction(AppLevelConstants.SIGN_UP, AppLevelConstants.CONTINUE, getBinding().etPhoneno.getText().toString().trim(), "" + "123456", false, "");
                }else {
                    viewModel.getMpin(finalMsisdn).observe(this, otpModel -> {
                        getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
                        if (otpModel != null) {


                            if (TextUtils.isEmpty(String.valueOf(otpModel.getmPin())) || otpModel.getResponseCode() == 1 || otpModel.getResponseCode() == 2) {
                                showDialog(getActivity().getResources().getString(R.string.something_went_wrong));
                            } else {
                                mListener.onFragmentInteraction(AppLevelConstants.SIGN_UP, AppLevelConstants.CONTINUE, getBinding().etPhoneno.getText().toString().trim(), "" + otpModel.getmPin(), false, otpModel.getTxnId());
                            }

                        } else {
                            showDialog(getResources().getString(R.string.error_sms_failure));
                        }

                    });
                }

                }else {

                    viewModel.getMpin(finalMsisdn).observe(this, otpModel -> {
                        getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
                        if (otpModel != null) {


                            if (TextUtils.isEmpty(String.valueOf(otpModel.getmPin())) || otpModel.getResponseCode() == 1 || otpModel.getResponseCode() == 2) {
                                showDialog(getActivity().getResources().getString(R.string.something_went_wrong));
                            } else {
                                mListener.onFragmentInteraction(AppLevelConstants.SIGN_UP, AppLevelConstants.CONTINUE, getBinding().etPhoneno.getText().toString().trim(), "" + otpModel.getmPin(), false, otpModel.getTxnId());
                            }

                        } else {
                            showDialog(getResources().getString(R.string.error_sms_failure));
                        }

                    });
                }
            } else {
                getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();
            }
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String fragment, String event, String userName, String otp, Boolean isAutoMsisdn, String txnId);
    }

    @Override
    public void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            InputMethodManager mgr = (InputMethodManager) loginActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (mgr != null)
                mgr.showSoftInput(getBinding().etPhoneno, InputMethodManager.SHOW_IMPLICIT);
            getBinding().etPhoneno.requestFocus();
        }, 200);
    }


    private void showDialog(String message) {
        FragmentManager fm = getFragmentManager();
        AlertDialogSingleButtonFragment alertDialog = AlertDialogSingleButtonFragment.newInstance(getResources().getString(R.string.dialog), message, getResources().getString(R.string.ok));
        alertDialog.setCancelable(false);
        alertDialog.setAlertDialogCallBack(this);
        if (fm != null)
            alertDialog.show(fm, AppLevelConstants.TAG_FRAGMENT_ALERT);
    }

    @Override
    public void onFinishDialog() {

    }

}
