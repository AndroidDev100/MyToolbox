package com.app.mytoolbox.fragments.homenewtab.ui;

import android.os.Bundle;

import com.app.mytoolbox.baseModel.TabsBaseFragment;
import com.app.mytoolbox.fragments.homenewtab.viewModel.HomeTabNewViewModel;

public class HomeTabNew extends TabsBaseFragment<HomeTabNewViewModel> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewModel(HomeTabNewViewModel.class);
    }
    public void sameClick(){
        super.onSameClick();
    }
}
