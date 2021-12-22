package com.app.mytoolbox.utils.helpers;

import android.app.Activity;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;


public class RecyclerAnimator {
    private final Activity activity;
    public RecyclerAnimator(Activity ctx) {
        this.activity=ctx;
    }

    public void animate(RecyclerView myRecyclerView) {
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(activity, resId);
        myRecyclerView.setLayoutAnimation(animation);
    }
}
