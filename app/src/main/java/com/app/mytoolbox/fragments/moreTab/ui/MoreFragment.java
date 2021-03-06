package com.app.mytoolbox.fragments.moreTab.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;
import com.app.mytoolbox.activities.accountSettings.ui.AccountSettingsActivity;
import com.app.mytoolbox.activities.appSettings.ui.AppSettingsActivity;
import com.app.mytoolbox.activities.appSettings.ui.TabletAppSettingsActivity;
import com.app.mytoolbox.activities.deviceMangment.helper.RecyclerTouchListener;
import com.app.mytoolbox.activities.home.HomeActivity;
import com.app.mytoolbox.activities.loginActivity.LoginActivity;
import com.app.mytoolbox.activities.myplaylist.ui.MultiplePlaylistActivity;
import com.app.mytoolbox.activities.webview.ui.WebViewActivity;
import com.app.mytoolbox.adapter.moreTab.MoreListAdapter;
import com.app.mytoolbox.baseModel.BaseBindingFragment;
import com.app.mytoolbox.callBacks.commonCallBacks.ClickListener;
import com.app.mytoolbox.databinding.FragmentMoreBinding;
import com.app.mytoolbox.fragments.moreTab.viewModel.MoreFragmentViewModel;
import com.app.mytoolbox.utils.helpers.ActivityLauncher;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.app.mytoolbox.utils.helpers.NetworkConnectivity;
import com.app.mytoolbox.utils.ksPreferenceKey.KsPreferenceKey;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreFragment extends BaseBindingFragment<FragmentMoreBinding> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private MoreFragmentViewModel viewModel;
    private String oldLang, newLang;

    private OnFragmentInteractionListener mListener;
    private HomeActivity homeActivity;
    private List<String> alList;
    private boolean isLogin;

    public MoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoreFragment newInstance(String param1, String param2) {
        MoreFragment fragment = new MoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        connectionObserver();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        modelCall();
        UIinitialization();
        connectionObserver();
        oldLang = new KsPreferenceKey(getActivity()).getAppLangName();
        getBinding().myRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(homeActivity, getBinding().myRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                isLogin = KsPreferenceKey.getInstance(homeActivity).getUserActive();

                if (alList.get(position).equalsIgnoreCase(AppLevelConstants.APP_SETTINGS) || alList.get(position).equalsIgnoreCase("Tetapan aplikasi")) {
                    if (!getResources().getBoolean(R.bool.isTablet)) {
                        Intent intent = new Intent(homeActivity, AppSettingsActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(homeActivity, TabletAppSettingsActivity.class);
                        startActivity(intent);
                    }
                } else if (alList.get(position).equalsIgnoreCase(AppLevelConstants.DEVICE_MANAGEMENT) || alList.get(position).equalsIgnoreCase("Pengurusan peranti")) {

                   /* if (isLogin) {

                       // startActivity(new Intent(homeActivity, DeviceManagementActivity.class).putExtra("from", ""));

                    } else {
                        new ActivityLauncher(getActivity()).loginActivity(getActivity(), LoginActivity.class, 0, "");
                    }*/
                } else if (alList.get(position).equalsIgnoreCase(AppLevelConstants.LOGOUT)) {
                    //logout
                    confirmDeletion();
                } else if (alList.get(position).equalsIgnoreCase(AppLevelConstants.LOGIN)) {
                    new ActivityLauncher(getActivity()).loginActivity(getActivity(), LoginActivity.class, 0, "");
//                    forceLogin();
                } else if (alList.get(position).equalsIgnoreCase(AppLevelConstants.TNC) || alList.get(position).equalsIgnoreCase("Syarat & syarat")) {
                    Intent intent = new Intent(homeActivity, WebViewActivity.class);
                    intent.putExtra(AppLevelConstants.WEBVIEW, AppLevelConstants.TNC);
                    startActivity(intent);
                } else if (alList.get(position).equalsIgnoreCase(AppLevelConstants.HELP) || alList.get(position).equalsIgnoreCase("Tolonglah")) {
                    Intent intent = new Intent(homeActivity, WebViewActivity.class);
                    intent.putExtra(AppLevelConstants.WEBVIEW, AppLevelConstants.HELP);
                    startActivity(intent);
                } else if (alList.get(position).equalsIgnoreCase(AppLevelConstants.ACCOUNT_SETTINGS) || alList.get(position).equalsIgnoreCase("Tetapan akaun")) {
                    if (isLogin) {
                        new ActivityLauncher(getActivity()).accountSetting(getActivity(), AccountSettingsActivity.class);
                    } else {
                        new ActivityLauncher(getActivity()).loginActivity(getActivity(), LoginActivity.class, 0, "");
                    }


                } else if (alList.get(position).equalsIgnoreCase(AppLevelConstants.PLAYLIST) || alList.get(position).equalsIgnoreCase("Senarai main")) {

                    if (isLogin) {
                        new ActivityLauncher(getActivity()).multipleplaylistActivity(getActivity(), MultiplePlaylistActivity.class);
                    } else {
                        new ActivityLauncher(getActivity()).loginActivity(getActivity(), LoginActivity.class, 0, "");
                    }


                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }

            private void confirmDeletion() {
                AlertDialog.Builder builder = new AlertDialog.Builder(homeActivity, R.style.AlertDialogStyle);
                builder.setTitle(getResources().getString(R.string.dialog));
                if (getActivity() != null) {
                    builder.setMessage(getActivity().getResources().getString(R.string.logout_confirmation_message))
                            .setCancelable(true)
                            .setPositiveButton(getResources().getString(R.string.yes), (dialog, id) -> {
                                callLogoutApi();
                                KsPreferenceKey.getInstance(homeActivity).setUserActive(false);
                                KsPreferenceKey.getInstance(homeActivity).setUser(null);
                                KsPreferenceKey.getInstance(homeActivity).setStartSessionKs("");
                                KsPreferenceKey.getInstance(homeActivity).setMsisdn("");
                                KsPreferenceKey.getInstance(homeActivity).setUserSelectedRating("");
                                KsPreferenceKey.getInstance(homeActivity).setParentalActive(false);
                                KsPreferenceKey.getInstance(homeActivity).setUserType("");
                                new ActivityLauncher(getActivity()).homeActivity(getActivity(), HomeActivity.class);

                            })
                            .setNegativeButton(getResources().getString(R.string.no), (dialog, id) -> dialog.cancel());
                    AlertDialog alert = builder.create();
                    alert.show();
                    Button bn = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
                    bn.setTextColor(ContextCompat.getColor(homeActivity, R.color.white));
                    Button bp = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                    bp.setTextColor(ContextCompat.getColor(homeActivity, R.color.colorPrimary));
                }
            }


        }));
    }

    private void callLogoutApi() {
        getActivity().runOnUiThread(() -> viewModel.logoutApi().observe(getActivity(), commonResponse -> {

        }));
    }

//    private void forceLogin() {
//        new KalturaLogin(getActivity()).callUserLogin(new LoginCallBack() {
//            @Override
//            public void loginProcess(boolean status, int apiType, List<HouseholdDevice> list) {
//                startActivity(new Intent(homeActivity, DeviceManagementActivity.class).putExtra("from", ""));
////                if (status == true) {
////                    PrintLogging.printLog(this.getClass(), "", "kalturaLogin" + list.get(0).getName());
////                }
//            }
//        });
//    }

    private void modelCall() {
        viewModel = ViewModelProviders.of(this).get(MoreFragmentViewModel.class);
        isLogin = KsPreferenceKey.getInstance(homeActivity).getUserActive();

        connectionObserver();
    }

    private void connectionValidation(Boolean aBoolean) {
        if (aBoolean) {
            getBinding().noConnectionLayout.setVisibility(View.GONE);
            loadDataFromModel();
        } else {
            noConnectionLayout();
        }
    }

    private void noConnectionLayout() {
        getBinding().noConnectionLayout.setVisibility(View.VISIBLE);
        getBinding().connection.tryAgain.setOnClickListener(view -> connectionObserver());
    }

    private void connectionObserver() {


        if (NetworkConnectivity.isOnline(homeActivity)) {
            connectionValidation(true);
        } else {
            connectionValidation(false);
        }
    }

    private void loadDataFromModel() {
        viewModel.getAllSampleData().observe(homeActivity, sectionDataModels -> {
            if (sectionDataModels != null && sectionDataModels.size() > 0) {
                setUIComponets(sectionDataModels);

            }
        });
    }


    private void setUIComponets(final List<String> mList) {

        alList = mList;
        MoreListAdapter adapter = new MoreListAdapter(homeActivity, alList);
        getBinding().myRecyclerView.setAdapter(adapter);

    }

    private void UIinitialization() {
        //   swipeToRefresh();

        getBinding().myRecyclerView.hasFixedSize();
        getBinding().myRecyclerView.setNestedScrollingEnabled(false);
        getBinding().myRecyclerView.setLayoutManager(new LinearLayoutManager(homeActivity, RecyclerView.VERTICAL, false));
        getBinding().myRecyclerView.hasFixedSize();
        getBinding().myRecyclerView.setNestedScrollingEnabled(false);
        getBinding().myRecyclerView.setLayoutManager(new LinearLayoutManager(homeActivity, RecyclerView.VERTICAL, false));
        if (getResources().getBoolean(R.bool.isTablet)) {

        } else {

            DividerItemDecoration itemDecor = new DividerItemDecoration(homeActivity, LinearLayoutManager.VERTICAL);
            getBinding().myRecyclerView.addItemDecoration(itemDecor);
        }


    }

    @Override
    public FragmentMoreBinding inflateBindingLayout(@NonNull LayoutInflater inflater) {
        return FragmentMoreBinding.inflate(inflater);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        homeActivity = (HomeActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
