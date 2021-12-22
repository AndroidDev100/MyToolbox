package com.app.mytoolbox.fragments.livetv.ui;

import android.os.Bundle;

import com.app.mytoolbox.baseModel.TabsBaseFragment;
import com.app.mytoolbox.fragments.livetv.viewModel.LiveTvViewModel;

public class LiveTvFragment extends TabsBaseFragment<LiveTvViewModel> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewModel(LiveTvViewModel.class);
    }

    public void sameClick() {
        super.onSameClick();
    }
}
