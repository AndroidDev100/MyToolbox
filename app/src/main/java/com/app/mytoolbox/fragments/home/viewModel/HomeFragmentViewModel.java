package com.app.mytoolbox.fragments.home.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.app.mytoolbox.activities.movieDescription.layers.YouMayAlsoLike;
import com.app.mytoolbox.baseModel.ChannelLayer;
import com.app.mytoolbox.baseModel.HomeBaseViewModel;
import com.app.mytoolbox.beanModel.VIUChannel;
import com.app.mytoolbox.beanModel.ksBeanmodel.AssetCommonBean;
import com.app.mytoolbox.repositories.homeTab.HomeFragmentRepository;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.kaltura.client.types.MultilingualStringValueArray;

import java.util.List;
import java.util.Map;

public class HomeFragmentViewModel extends HomeBaseViewModel {

    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<AssetCommonBean>> getListLiveData(long channelID, List<VIUChannel> list, int counter, int swipeToRefresh, List<AssetCommonBean> loadedList) {
        return HomeFragmentRepository.getInstance().loadData(getApplication().getApplicationContext(), channelID, list, counter, swipeToRefresh, loadedList,1);
    }

    public LiveData<AssetCommonBean> getChannelList() {
        return ChannelLayer.getInstance().getChannelList(getApplication().getApplicationContext(), AppLevelConstants.TAB_HOME);
    }
    public LiveData<List<AssetCommonBean>> getYouMayAlsoLike(int assetId,
                                                             int counter,
                                                             int assetType,
                                                             Map<String, MultilingualStringValueArray> map
    ) {
        return YouMayAlsoLike.getInstance().fetchSimilarMovie(getApplication().getApplicationContext(), assetId, counter, assetType, map);
    }


    public void resetObject() {
        HomeFragmentRepository.resetObject();
    }

    public void resetFragment() {

    }
}
