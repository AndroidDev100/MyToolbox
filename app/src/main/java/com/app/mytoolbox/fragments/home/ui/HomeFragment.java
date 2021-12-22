package com.app.mytoolbox.fragments.home.ui;

import android.os.Bundle;

import com.app.mytoolbox.baseModel.TabsBaseFragment;
import com.app.mytoolbox.fragments.home.viewModel.HomeFragmentViewModel;


public class HomeFragment extends TabsBaseFragment<HomeFragmentViewModel> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewModel(HomeFragmentViewModel.class);
    }
    public void sameClick(){
        super.onSameClick();
    }
}
