package com.app.mytoolbox.callBacks.commonCallBacks;


import com.astro.sott.beanModel.ksBeanmodel.AssetCommonBean;
import com.astro.sott.beanModel.ksBeanmodel.RailCommonData;

public interface HeroItemClickListner {

    void heroItemClick(int position, RailCommonData railCommonData, AssetCommonBean commonData);
}
