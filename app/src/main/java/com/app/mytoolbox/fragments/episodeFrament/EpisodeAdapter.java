package com.app.mytoolbox.fragments.episodeFrament;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;
import com.app.mytoolbox.beanModel.ksBeanmodel.RailCommonData;
import com.app.mytoolbox.callBacks.commonCallBacks.EpisodeCallBAck;
import com.app.mytoolbox.callBacks.commonCallBacks.EpisodeClickListener;
import com.app.mytoolbox.databinding.EpisodeItemBinding;
import com.app.mytoolbox.utils.commonMethods.AppCommonMethods;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.app.mytoolbox.utils.helpers.AssetContent;
import com.app.mytoolbox.utils.helpers.ImageHelper;
import com.app.mytoolbox.utils.helpers.PrintLogging;
import com.app.mytoolbox.utils.ksPreferenceKey.KsPreferenceKey;
import com.kaltura.client.types.Asset;
import com.kaltura.client.types.MediaImage;
import com.kaltura.client.types.MultilingualStringValue;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.SingleItemRowHolder> {
    private final List<RailCommonData> railList;
    private final Activity mContext;
    private int episodeNumber = 0;
    private int lineCount;
    EpisodeClickListener itemClickListener;
    EpisodeCallBAck episodeClickListner;
    KsPreferenceKey ksPreferenceKeys;
    private long lastClickTime = 0;
    boolean isLoggedIn = false;

    public EpisodeAdapter(Activity activity, List<RailCommonData> itemsList, int episodeNumber, EpisodeClickListener episodeClickListener, EpisodeCallBAck episodeCallBAck) {
        this.railList = itemsList;
        this.mContext = activity;
        this.itemClickListener = episodeClickListener;
        ksPreferenceKeys = new KsPreferenceKey(mContext);
        isLoggedIn = ksPreferenceKeys.getUserActive();
        this.episodeNumber = episodeNumber;
        this.episodeClickListner = episodeCallBAck;
        episodeClickListner.episodeList(railList);
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        EpisodeItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.episode_item, viewGroup, false);

        return new SingleItemRowHolder(itemBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull SingleItemRowHolder viewHolder, final int position) {
        try {
            RailCommonData singleItem = railList.get(position);
            Asset asset = singleItem.getObject();

            int value = AppCommonMethods.getEpisodeNumber(asset.getMetas());


            if (AssetContent.checkComingSoon(asset.getMetas())) {
                viewHolder.watchlistItemBinding.tvTitle.setText("Coming Soon");
                viewHolder.watchlistItemBinding.tvduration.setText("Premiering " + AssetContent.getPlayBackDate(asset.getMetas()));
            } else {

                String duration = AppCommonMethods.getURLDuration(asset);
                if (!TextUtils.isEmpty(duration)) {
                    viewHolder.watchlistItemBinding.tvduration.setVisibility(View.VISIBLE);
                    viewHolder.watchlistItemBinding.tvduration.setText(duration);
                } else {
                    viewHolder.watchlistItemBinding.tvduration.setText("");
                }
                if (value == -1) {
                    viewHolder.watchlistItemBinding.tvTitle.setText(asset.getName());
                } else {
                    viewHolder.watchlistItemBinding.tvTitle.setText("E" + value + ": " + asset.getName());
                }

                MultilingualStringValue stringValue = null;
                String description = "";
                if (asset.getMetas() != null)
                    stringValue = (MultilingualStringValue) asset.getMetas().get(AppLevelConstants.KEY_SHORT_DESCRIPTION);
                if (stringValue != null)
                    description = stringValue.getValue();

                viewHolder.watchlistItemBinding.tvDescription.setText(description);
                setExpandable(viewHolder);
                viewHolder.watchlistItemBinding.tvDescription.post(() -> {
                    lineCount =  viewHolder.watchlistItemBinding.tvDescription.getLineCount();
                    Log.d("linecountCheck", lineCount + "");
                    if (lineCount <= 3) {
                        viewHolder.watchlistItemBinding.shadow.setVisibility(View.GONE);
                        viewHolder.watchlistItemBinding.lessButton.setVisibility(View.GONE);

                    }else {
                        viewHolder.watchlistItemBinding.shadow.setVisibility(View.VISIBLE);
                        viewHolder.watchlistItemBinding.lessButton.setVisibility(View.VISIBLE);
                        Log.d("linecountCheck", "inelse");

                    }

                });

//                lineCount = viewHolder.watchlistItemBinding.tvDescription.getLineCount();
//                Log.d("linecountCheck", "inf" + lineCount);


                viewHolder.watchlistItemBinding.landscapeImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.moveToPlay(position, railList.get(position), 0, railList);
                    }
                });
            }
            if (singleItem.getProgress() == 0) {
                viewHolder.watchlistItemBinding.progressBar.setVisibility(View.GONE);
            } else {
                try {

                    long totalDuration = AppCommonMethods.getDurationFromUrl(asset);
                    boolean include = AppCommonMethods.checkContinueWatchingPercentage((int) totalDuration, singleItem.getProgress());
                    if (include) {
                        int progress = singleItem.getProgress() * 100 / (int) totalDuration;
                        viewHolder.watchlistItemBinding.progressBar.setProgress(progress);
                        viewHolder.watchlistItemBinding.progressBar.setVisibility(View.VISIBLE);
                    } else {
                        viewHolder.watchlistItemBinding.progressBar.setVisibility(View.GONE);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            viewHolder.watchlistItemBinding.lockIcon.setOnClickListener(v -> {
                itemClickListener.moveToPlay(position, railList.get(position), 1, railList);
            });
            if (singleItem.isEntitled()) {
                viewHolder.watchlistItemBinding.lockIcon.setVisibility(View.GONE);
                viewHolder.watchlistItemBinding.billingImage.setVisibility(View.VISIBLE);
                viewHolder.watchlistItemBinding.episodeTransparent.setVisibility(View.VISIBLE);
            } else {
                viewHolder.watchlistItemBinding.lockIcon.setVisibility(View.GONE);
                viewHolder.watchlistItemBinding.billingImage.setVisibility(View.GONE);
                viewHolder.watchlistItemBinding.episodeTransparent.setVisibility(View.GONE);
            }
            if (value == episodeNumber) {
                RailCommonData singleItems = railList.get(position);
                if (singleItems.getExpended()) {
                    singleItems.setExpended(false);
                    railList.remove(position);
                    railList.add(position, singleItems);
                    //AppCommonMethods.collapse(viewHolder.watchlistItemBinding.clRoot,1000,200);
                } else {
                    singleItems.setExpended(true);
                    railList.remove(position);
                    railList.add(position, singleItems);
                    // itemClickListener.expendedView(position);
                    //AppCommonMethods.expand(viewHolder.watchlistItemBinding.clRoot,1000,200);
                }
            }
            if (asset.getImages() != null && asset.getImages().size() > 0) {
                for (MediaImage mediaImages : asset.getImages()) {
                    if (mediaImages.getRatio().equalsIgnoreCase("16X9")) {
                        String image_url = mediaImages.getUrl();
                        String final_url = image_url + AppLevelConstants.WIDTH + (int) mContext.getResources().getDimension(R.dimen.landscape_image_width) + AppLevelConstants.HEIGHT + (int) mContext.getResources().getDimension(R.dimen.landscape_image_height) + AppLevelConstants.QUALITY;
                        ImageHelper.getInstance(viewHolder.watchlistItemBinding.landscapeImage.getContext()).loadImageTo(viewHolder.watchlistItemBinding.landscapeImage, final_url, R.drawable.ic_landscape_placeholder);
                    }
                }

            }
           /* if (singleItem.getExpended()) {
                viewHolder.watchlistItemBinding.clRoot.setVisibility(View.VISIBLE);
            } else {
                viewHolder.watchlistItemBinding.clRoot.setVisibility(View.GONE);
            }*/


            viewHolder.watchlistItemBinding.downloadIcon.setVisibility(View.GONE);


            viewHolder.watchlistItemBinding.mainLay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RailCommonData singleItem = railList.get(position);
                    if (singleItem.getExpended()) {
                        singleItem.setExpended(false);
                        railList.remove(position);
                        railList.add(position, singleItem);
                        //AppCommonMethods.collapse(viewHolder.watchlistItemBinding.clRoot,1000,200);
                        //itemClickListener.onClick(position);
                    } else {
                        singleItem.setExpended(true);
                        railList.remove(position);
                        railList.add(position, singleItem);
                        //AppCommonMethods.expand(viewHolder.watchlistItemBinding.clRoot,1000,200);
                    }

                }
            });
            viewHolder.watchlistItemBinding.episodeTransparent.setOnClickListener(v -> {
                itemClickListener.moveToPlay(position, railList.get(position), 1, railList);
            });


        } catch (Exception e) {
            Log.w("FSEFESFSEFESFESFESFSEF", e + "");
        }
    }

    private void setExpandable(SingleItemRowHolder viewHolder) {
        viewHolder.watchlistItemBinding.expandableLayout.setOnExpansionUpdateListener(expansionFraction -> viewHolder.watchlistItemBinding.lessButton.setRotation(0 * expansionFraction));
        viewHolder.watchlistItemBinding.lessButton.setOnClickListener(view -> {
            viewHolder.watchlistItemBinding.tvDescription.toggle();
            viewHolder.watchlistItemBinding.tvDescription.setEllipsis("...");
            if ( viewHolder.watchlistItemBinding.tvDescription.isExpanded()) {
                viewHolder.watchlistItemBinding.tvDescription.setEllipsize(null);
                viewHolder.watchlistItemBinding.shadow.setVisibility(View.GONE);

            } else {
//                if(getBinding().descriptionText.getLineCount() >3)
//            {
//                getBinding().descriptionText.setMaxLines(3);
                viewHolder.watchlistItemBinding.tvDescription.setEllipsize(TextUtils.TruncateAt.END);
                viewHolder.watchlistItemBinding.shadow.setVisibility(View.VISIBLE);

//            }
            }

            if ( viewHolder.watchlistItemBinding.expandableLayout.isExpanded()) {
                viewHolder.watchlistItemBinding.textExpandable.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
//                getBinding().textExpandable.setText(().getString(R.string.view_more));

            } else {
                viewHolder.watchlistItemBinding.textExpandable.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);

//                getBinding().textExpandable.setText(getResources().getString(R.string.view_less));
            }
            if (view != null) {
                viewHolder.watchlistItemBinding.expandableLayout.expand();
            }
            viewHolder.watchlistItemBinding.expandableLayout.collapse();
        });

    }


    @Override
    public int getItemCount() {
        return railList.size();
    }

    int itemAdded;
    //typeofdownload 1=single download 0=series download
    int typeOfDownload = 100;

    public void updateIcons(int i, int typeofDownload) {
        this.itemAdded = i;
        this.typeOfDownload = typeofDownload;
        PrintLogging.printLog("", "episodeAdapterValues" + itemAdded + "<---->" + typeOfDownload);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        final EpisodeItemBinding watchlistItemBinding;

        SingleItemRowHolder(EpisodeItemBinding binding) {
            super(binding.getRoot());
            this.watchlistItemBinding = binding;
            final String name = mContext.getClass().getSimpleName();
            // int layoutType= AppCommonMethods.getRailTypeAccToMedia(getLayoutPosition(),railList,i);
           /* watchlistItemBinding.getRoot().setOnClickListener(view -> {
                if (SystemClock.elapsedRealtime() - lastClickTime < 1000) {
                    return;
                }
                lastClickTime = SystemClock.elapsedRealtime();
                GAManager.getInstance().setEvent(GAManager.ENAGAGEMENT, GAManager.CLICK_VIDEO_WATCHLIST_PAGE, GAManager.ENGAGE_WATCHLIST, GAManager.TWENTY);
                new ActivityLauncher(mContext).railClickCondition("", "", name, railList.get(getLayoutPosition()), getLayoutPosition(), AppConstants.Rail5, (_url, position, type, commonData) -> {
                    //detailRailClick.detailItemClicked(_url,position,type,commonData);
                });


            });*/

        }

    }


}

