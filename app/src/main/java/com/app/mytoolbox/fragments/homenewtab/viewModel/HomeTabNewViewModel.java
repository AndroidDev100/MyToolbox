package com.app.mytoolbox.fragments.homenewtab.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.app.mytoolbox.baseModel.ChannelLayer;
import com.app.mytoolbox.baseModel.HomeBaseViewModel;
import com.app.mytoolbox.beanModel.VIUChannel;
import com.app.mytoolbox.beanModel.ksBeanmodel.AssetCommonBean;
import com.app.mytoolbox.repositories.homeTab.HomeFragmentRepository;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;

import java.util.List;

public class HomeTabNewViewModel extends HomeBaseViewModel {
    public HomeTabNewViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<AssetCommonBean>> getListLiveData(long channelID, List<VIUChannel> list, int counter, int swipeToRefresh, List<AssetCommonBean> loadedList) {
        return HomeFragmentRepository.getInstance().loadData(getApplication().getApplicationContext(), channelID, list, counter, swipeToRefresh, loadedList,1);
    }

    public LiveData<AssetCommonBean> getChannelList() {
        return ChannelLayer.getInstance().getChannelList(getApplication().getApplicationContext(), AppLevelConstants.TAB_HOME);
    }

    public void resetObject() {
        HomeFragmentRepository.resetObject();
    }

    public void resetFragment() {

    }

}
