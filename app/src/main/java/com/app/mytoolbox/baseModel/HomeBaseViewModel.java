package com.app.mytoolbox.baseModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.astro.sott.beanModel.VIUChannel;
import com.astro.sott.beanModel.ksBeanmodel.AssetCommonBean;

import java.util.List;


public abstract class HomeBaseViewModel extends AndroidViewModel{
    protected HomeBaseViewModel(@NonNull Application application) {
        super(application);
    }


   // public abstract LiveData<List<AssetCommonBean>> getListLiveData(long channelID, List<VIUChannel> list, int counter, int swipeToRefresh);
   // public abstract LiveData<List<AssetCommonBean>> getListLiveData(long channelID, List<VIUChannel> list, int counter, int swipeToRefresh,boolean isCrousalInjected);
    public abstract LiveData<List<AssetCommonBean>> getListLiveData(long channelID, List<VIUChannel> list,int counter,int swipeToRefresh,List<AssetCommonBean> loadedList);
    public abstract LiveData<AssetCommonBean> getChannelList();

    public abstract void resetObject();

}
