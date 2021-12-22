package com.app.mytoolbox.utils.helpers.carousel.indicators;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import androidx.core.content.res.ResourcesCompat;

import com.app.mytoolbox.R;


public class CircleIndicator extends IndicatorShape {

    public CircleIndicator(Context context) {
        super(context);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public CircleIndicator(Context context, int indicatorSize, boolean mustAnimateChanges) {
        super(context, indicatorSize, mustAnimateChanges);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.indicator_circle_unselected, null));
        } else {
            setBackgroundDrawable(getResources().getDrawable(R.drawable.indicator_circle_unselected));
        }
    }

    @Override
    public void onCheckedChange(boolean isChecked) {
        super.onCheckedChange(isChecked);
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.indicator_circle_selected, null));
            } else {
                setBackgroundDrawable(getResources().getDrawable(R.drawable.indicator_circle_selected));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.indicator_circle_unselected, null));
            } else {
                setBackgroundDrawable(getResources().getDrawable(R.drawable.indicator_circle_unselected));
            }
        }
    }
}
