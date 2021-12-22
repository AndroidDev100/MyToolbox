package com.app.mytoolbox.fragments.video.ui;

import android.os.Bundle;

import com.app.mytoolbox.baseModel.TabsBaseFragment;
import com.app.mytoolbox.fragments.video.viewModel.VideoViewModel;


public class VideoFragment extends TabsBaseFragment<VideoViewModel> {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewModel(VideoViewModel.class);
    }

    public void sameClick() {
        super.onSameClick();
    }
}
