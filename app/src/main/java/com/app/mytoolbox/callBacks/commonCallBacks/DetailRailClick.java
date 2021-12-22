package com.app.mytoolbox.callBacks.commonCallBacks;


import com.astro.sott.beanModel.ksBeanmodel.RailCommonData;

public interface DetailRailClick {
    void detailItemClicked(String _url, int position, int type, RailCommonData commonData);
}
