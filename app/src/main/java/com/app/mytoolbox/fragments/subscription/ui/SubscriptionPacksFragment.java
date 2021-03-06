package com.app.mytoolbox.fragments.subscription.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.billingclient.api.SkuDetails;
import com.app.mytoolbox.activities.home.HomeActivity;
import com.app.mytoolbox.activities.subscriptionActivity.ui.SubscriptionDetailActivity;
import com.app.mytoolbox.baseModel.BaseBindingFragment;
import com.app.mytoolbox.callBacks.commonCallBacks.CardCLickedCallBack;
import com.app.mytoolbox.databinding.FragmentSubscriptionPacksBinding;
import com.app.mytoolbox.fragments.subscription.adapter.SubscriptionAdapter;
import com.app.mytoolbox.fragments.subscription.vieModel.SubscriptionViewModel;
import com.app.mytoolbox.modelClasses.InApp.PackDetail;
import com.app.mytoolbox.networking.refreshToken.EvergentRefreshToken;
import com.app.mytoolbox.usermanagment.modelClasses.getProducts.ProductsResponseMessageItem;
import com.app.mytoolbox.utils.billing.SKUsListListener;
import com.app.mytoolbox.utils.commonMethods.AppCommonMethods;
import com.app.mytoolbox.utils.helpers.ActivityLauncher;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.app.mytoolbox.utils.userInfo.UserInfo;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubscriptionPacksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubscriptionPacksFragment extends BaseBindingFragment<FragmentSubscriptionPacksBinding> implements CardCLickedCallBack {
    private SubscriptionViewModel subscriptionViewModel;
    private SkuDetails skuDetails;
    private List<PackDetail> packDetailList;
    private List<String> productList;
    private String[] subscriptionIds;
    private String posterImageUrl = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String from, date;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SubscriptionPacksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubscriptionPacksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubscriptionPacksFragment newInstance(String param1, String param2) {
        SubscriptionPacksFragment fragment = new SubscriptionPacksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            from = getArguments().getString("from");
            date = getArguments().getString(AppLevelConstants.DATE);
        }

        if (getArguments().getSerializable(AppLevelConstants.SUBSCRIPTION_ID_KEY) != null)
            subscriptionIds = (String[]) getArguments().getSerializable(AppLevelConstants.SUBSCRIPTION_ID_KEY);

        if (getArguments().getString(AppLevelConstants.POSTER_IMAGE_URL) != null) {
            posterImageUrl = getArguments().getString(AppLevelConstants.POSTER_IMAGE_URL);
        } else {
            posterImageUrl = "";
        }

        productList = (ArrayList<String>) getArguments().getSerializable("productList");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        UIinitialization();
        modelCall();
        getProducts();


    }


    private void modelCall() {
        subscriptionViewModel = ViewModelProviders.of(this).get(SubscriptionViewModel.class);
    }

    private void loadDataFromModel(List<PackDetail> productsResponseMessage) {
        SubscriptionAdapter adapter = new SubscriptionAdapter(getActivity(), productsResponseMessage, productList, date, posterImageUrl);
        getBinding().recyclerView.setAdapter(adapter);
    }

    private void getProducts() {
        getBinding().includeProgressbar.progressBar.setVisibility(View.VISIBLE);
        if (!UserInfo.getInstance(getActivity()).isActive()) {
            getProductsForLogout();
        } else {
            if (subscriptionIds != null) {
                JsonArray jsonArray = new JsonArray();
                for (String id : subscriptionIds) {
                    jsonArray.add(id);
                }
                subscriptionViewModel.getProductForLogin(UserInfo.getInstance(getActivity()).getAccessToken(), jsonArray, from).observe(this, evergentCommonResponse -> {
                    getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
                    if (evergentCommonResponse.isStatus()) {
                        if (evergentCommonResponse.getGetProductResponse() != null && evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage() != null && evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage().getProductsResponseMessage() != null && evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage().getProductsResponseMessage().size() > 0) {
                            checkIfDetailAvailableOnPlaystore(evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage().getProductsResponseMessage());
                        }
                    } else {
                        if (evergentCommonResponse.getErrorCode().equalsIgnoreCase("eV2124") || evergentCommonResponse.getErrorCode().equals("111111111")) {
                            EvergentRefreshToken.refreshToken(getActivity(), UserInfo.getInstance(getActivity()).getRefreshToken()).observe(this, evergentCommonResponse1 -> {
                                if (evergentCommonResponse.isStatus()) {
                                    getProducts();
                                } else {
                                    AppCommonMethods.removeUserPrerences(getActivity());
                                }
                            });
                        } else {

                        }
                    }
                });
            } else {
                getProductsForLogout();
            }
        }
    }

    private void getProductsForLogout() {
      /*  subscriptionViewModel.getProduct().observe(this, evergentCommonResponse -> {
            getBinding().includeProgressbar.progressBar.setVisibility(View.GONE);
            if (evergentCommonResponse.isStatus()) {
                if (evergentCommonResponse.getGetProductResponse() != null && evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage() != null && evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage().getProductsResponseMessage() != null && evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage().getProductsResponseMessage().size() > 0) {
                    checkIfDetailAvailableOnPlaystore(evergentCommonResponse.getGetProductResponse().getGetProductsResponseMessage().getProductsResponseMessage());
                }
            } else {

            }
        });*/
    }

    private void checkIfDetailAvailableOnPlaystore(List<ProductsResponseMessageItem> productsResponseMessage) {
        packDetailList = new ArrayList<>();
        List<String> subSkuList = AppCommonMethods.getSubscriptionSKUs(productsResponseMessage, getActivity());
        List<String> productsSkuList = AppCommonMethods.getProductSKUs(productsResponseMessage, getActivity());
        if (getActivity() instanceof SubscriptionDetailActivity) {
            ((SubscriptionDetailActivity) getActivity()).onListOfSKUs(subSkuList, productsSkuList, new SKUsListListener() {
                @Override
                public void onListOfSKU(@Nullable List<SkuDetails> purchases) {
                    // Log.w("valuessAdded--->>",purchases.size()+"");
                    // Log.w("valuessAdded--->>",purchases.get(0).getDescription());

                    for (ProductsResponseMessageItem responseMessageItem : productsResponseMessage) {
                        if (responseMessageItem.getAppChannels() != null && responseMessageItem.getAppChannels().get(0) != null && responseMessageItem.getAppChannels().get(0).getAppChannel() != null && responseMessageItem.getAppChannels().get(0).getAppChannel().equalsIgnoreCase("Google Wallet") && responseMessageItem.getAppChannels().get(0).getAppID() != null) {
                            Log.w("avname", getActivity().getClass().getName() + "");
                            if (getActivity() instanceof HomeActivity) {
                                skuDetails = ((HomeActivity) getActivity()).getSubscriptionDetail(responseMessageItem.getAppChannels().get(0).getAppID());
                            } else if (getActivity() instanceof SubscriptionDetailActivity) {
                                if (responseMessageItem.getServiceType().equalsIgnoreCase("ppv")) {
                                    skuDetails = ((SubscriptionDetailActivity) getActivity()).getPurchaseDetail(responseMessageItem.getAppChannels().get(0).getAppID());
                                } else {
                                    skuDetails = ((SubscriptionDetailActivity) getActivity()).getSubscriptionDetail(responseMessageItem.getAppChannels().get(0).getAppID());

                                }
                            }
                            if (skuDetails != null) {
                                PackDetail packDetail = new PackDetail();
                                packDetail.setSkuDetails(skuDetails);
                                packDetail.setProductsResponseMessageItem(responseMessageItem);
                                packDetailList.add(packDetail);
                            }
                        }
                    }

                    if (packDetailList.size() > 0)
                        loadDataFromModel(packDetailList);

                }
            });
        }

    }

    public static void dataFeched(List<SkuDetails> purchases) {


    }

    private void UIinitialization() {
        if (from.equalsIgnoreCase("detail") || from.equalsIgnoreCase("Live Event")) {
            //  getBinding().toolbar.setVisibility(View.GONE);
            getBinding().closeIcon.setVisibility(View.VISIBLE);
        }
        getBinding().recyclerView.hasFixedSize();
        getBinding().recyclerView.setNestedScrollingEnabled(false);
        getBinding().recyclerView.hasFixedSize();
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        getBinding().learnMore.setOnClickListener(v -> {
            new ActivityLauncher(getActivity()).profileSubscription("Content Detail Page");
        });
        getBinding().closeIcon.setOnClickListener(v -> {
            if (getActivity() != null)
                getActivity().onBackPressed();
        });
        getBinding().terms.setOnClickListener(v -> {
            new ActivityLauncher(getActivity()).termAndCondition(getActivity());
        });
    }

    @Override
    protected FragmentSubscriptionPacksBinding inflateBindingLayout(@NonNull LayoutInflater inflater) {
        return FragmentSubscriptionPacksBinding.inflate(inflater);
    }


    @Override
    public void onCardClicked(String productId, String serviceType, String a, String name, Long price) {

    }
}