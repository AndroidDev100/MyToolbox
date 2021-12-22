package com.app.mytoolbox.fragments.sports.ui;

import android.os.Bundle;

import com.app.mytoolbox.baseModel.TabsBaseFragment;
import com.app.mytoolbox.fragments.sports.viewModel.SportsViewModel;

public class SportsFragment extends TabsBaseFragment<SportsViewModel> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewModel(SportsViewModel.class);
    }

    public void sameClick() {
        super.onSameClick();
    }
}
