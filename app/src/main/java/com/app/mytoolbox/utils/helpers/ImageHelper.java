package com.app.mytoolbox.utils.helpers;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.app.mytoolbox.utils.GlideApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;


public class ImageHelper {

    private static final ImageHelper ourInstance = new ImageHelper();
    private static Glide mGlideObj;
    private static RequestOptions requestOptions;
    private static Context context;
    DrawableCrossFadeFactory factory =
            new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

    public static ImageHelper getInstance(Context context) {
        mGlideObj = Glide.get(context);
        ImageHelper.context = context;
        requestOptions = new RequestOptions();
        return ourInstance;
    }

    public void loadImageTo(ImageView imageView, String imageUrl, int placeholder) {
        GlideApp.with(context).setDefaultRequestOptions(requestOptions).load(imageUrl)
                .apply(requestOptions.placeholder(placeholder))
                .thumbnail(0.6f)
                .into(imageView);

    }

    public void loadImageTo(ImageView imageView, String imageUrl) {
        GlideApp.with(context).setDefaultRequestOptions(requestOptions).load(imageUrl)
                .thumbnail(0.6f)
                .into(imageView);

    }


    public void loadImageToNil(ImageView imageView, String imageUrl, int placeholder) {
        GlideApp.with(context).load(placeholder)
                .transition(withCrossFade(factory))
                .apply(requestOptions.placeholder(placeholder))
                .thumbnail(0.6f)
                .into(imageView);

    }


    public void loadImageTo(ImageView imageView, String imageUrl, RequestOptions requestOptions) {
        GlideApp.with(context).setDefaultRequestOptions(requestOptions).
                load(imageUrl).thumbnail(0.1f).into(imageView);
    }

    public void loadImageTo(ImageView imageView, Uri imageUrl, int placeholder) {
        GlideApp.with(context).load(imageUrl)
                .apply(requestOptions.placeholder(placeholder))
                .thumbnail(0.1f).into(imageView);
    }

    public void loadImageTo(ImageView imageView, int alt, int placeholder) {

        GlideApp.with(context).load(alt)
                .transition(withCrossFade(factory))
                .apply(requestOptions.placeholder(placeholder))
                .thumbnail(0.1f).into(imageView);
    }


    @SuppressLint("CheckResult")
    public void loadImageToPotrait(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).override(1024, 768).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadImageToLandscape(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadImageToCarousal(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadImageToPortraitListing(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadImageToPortraitDetailListing(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadImageTocontinueWatchingListing(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadImageToLandscapeListingAdapter(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadImageToLandscapeDetailListingAdapter(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }

    public void loadImageToPlaceholder(ImageView imageView, Uri imageUrl, int placeholder) {

        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).thumbnail(0.1f).into(imageView);
        //setImageDescription(imageView, imageUrl.getPath());
    }

    public void setImageDescription(ImageView imageView, String imageUrl) {
        try {
            if (!StringUtils.isNullOrEmptyOrZero(imageUrl) && imageView != null) {
                if (imageUrl.length() > 20) {
                    String tempTitle = imageUrl.substring(imageUrl.length() - 15);
                    imageView.setContentDescription(tempTitle);
                } else {
                    imageView.setContentDescription(String.valueOf(System.currentTimeMillis()));
                }
            }
        } catch (Exception ignored) {

        }


    }

    @SuppressLint("CheckResult")
    public void loadImageOfGenre(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).thumbnail(0.6f).into(imageView);


    }

    @SuppressLint("CheckResult")
    public void loadQuickSearchImage(ImageView imageView, String imageUrl, int placeholder) {
        requestOptions.placeholder(placeholder);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(imageUrl).transition(DrawableTransitionOptions.withCrossFade(250)).thumbnail(0.6f).into(imageView);


    }


    @SuppressLint("CheckResult")
    public void loadPlaceHolder(ImageView imageView, int placeholder_square) {
        requestOptions.placeholder(placeholder_square);
        GlideApp.with(mGlideObj.getContext()).setDefaultRequestOptions(requestOptions).
                load(placeholder_square).thumbnail(0.6f).into(imageView);

    }
}