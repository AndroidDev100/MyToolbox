package com.app.mytoolbox.utils.helpers.shimmer;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;


public class ShimmerViewHolder extends RecyclerView.ViewHolder {

    private final ShimmerLayout mShimmerLayout;

    public ShimmerViewHolder(LayoutInflater inflater, ViewGroup parent, int innerViewResId) {
        super(inflater.inflate(R.layout.viewholder_shimmer, parent, false));
        mShimmerLayout = (ShimmerLayout) itemView;

        inflater.inflate(innerViewResId, mShimmerLayout, true);
    }

    public void setShimmerAngle(int angle) {
        mShimmerLayout.setShimmerAngle(angle);
    }

    public void setShimmerColor(int color) {
        mShimmerLayout.setShimmerColor(color);
    }

    public void setShimmerMaskWidth(float maskWidth) {
        mShimmerLayout.setMaskWidth(maskWidth);
    }

    public void setShimmerViewHolderBackground(Drawable viewHolderBackground) {
        if (viewHolderBackground != null) {

            mShimmerLayout.setBackground(viewHolderBackground);
//            setBackground(viewHolderBackground);
        }
    }

    public void setShimmerAnimationDuration(int duration) {
        mShimmerLayout.setShimmerAnimationDuration(duration);
    }

    public void setAnimationReversed(boolean animationReversed) {
        mShimmerLayout.setAnimationReversed(animationReversed);
    }

    public void bind() {
        mShimmerLayout.startShimmerAnimation();
    }

//    private void setBackground(Drawable background) {
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
//            mShimmerLayout.setBackground(background);
//        } else {
//            mShimmerLayout.setBackgroundDrawable(background);
//        }
//    }
}
