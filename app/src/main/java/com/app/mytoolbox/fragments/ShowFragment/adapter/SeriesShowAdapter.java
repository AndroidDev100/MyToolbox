package com.app.mytoolbox.fragments.ShowFragment.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;
import com.app.mytoolbox.beanModel.ksBeanmodel.RailCommonData;
import com.app.mytoolbox.callBacks.commonCallBacks.DetailRailClick;
import com.app.mytoolbox.callBacks.commonCallBacks.MediaTypeCallBack;
import com.app.mytoolbox.databinding.RelatedItemBinding;
import com.app.mytoolbox.utils.constants.AppConstants;
import com.app.mytoolbox.utils.helpers.ActivityLauncher;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.app.mytoolbox.utils.helpers.ImageHelper;
import com.app.mytoolbox.utils.helpers.NetworkConnectivity;
import com.app.mytoolbox.utils.helpers.ToastHandler;
import com.kaltura.client.types.MediaImage;

import java.util.List;

public class SeriesShowAdapter extends RecyclerView.Adapter<SeriesShowAdapter.SingleItemViewHolder> {
    private List<RailCommonData> similarItemList;
    private Activity mContext;
    private boolean isMovieShow;
    private DetailRailClick detailRailClick;


    public SeriesShowAdapter(Activity context, List<RailCommonData> loadedList, boolean isMovieShow) {
        similarItemList = loadedList;
        this.isMovieShow = isMovieShow;
        mContext = context;
        try {
            this.detailRailClick = ((DetailRailClick) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement AdapterCallback.");
        }
    }

    @NonNull
    @Override
    public SingleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelatedItemBinding landscapeItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.related_item, parent, false);
        return new SingleItemViewHolder(landscapeItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemViewHolder holder, int position) {
        if (similarItemList.get(position).getObject().getMediaFiles() != null && similarItemList.get(position).getObject().getMediaFiles().size() > 0) {
            List<MediaImage> media = similarItemList.get(position).getObject().getImages();
            for (MediaImage mediaFile : media) {
                if (mediaFile.getRatio().equalsIgnoreCase("16x9")) {
                    String image_url = mediaFile.getUrl();
                    String final_url = image_url + AppLevelConstants.WIDTH + (int) mContext.getResources().getDimension(R.dimen.landscape_image_width) + AppLevelConstants.HEIGHT + (int) mContext.getResources().getDimension(R.dimen.landscape_image_height) + AppLevelConstants.QUALITY;
                    ImageHelper.getInstance(holder.landscapeItemBinding.image.getContext()).loadImageTo(holder.landscapeItemBinding.image, final_url, R.drawable.ic_landscape_placeholder);
                }
            }
        }

    }


    @Override
    public int getItemCount() {
        return similarItemList.size();
    }


    class SingleItemViewHolder extends RecyclerView.ViewHolder {
        RelatedItemBinding landscapeItemBinding;

        public SingleItemViewHolder(@NonNull RelatedItemBinding itemView) {
            super(itemView.getRoot());
            landscapeItemBinding = itemView;
            final String name = mContext.getClass().getSimpleName();


            landscapeItemBinding.cardView.setOnClickListener(v -> {
                new ActivityLauncher(mContext).railClickCondition("", "", name, similarItemList.get(getLayoutPosition()), getLayoutPosition(), AppConstants.Rail5, similarItemList, new MediaTypeCallBack() {
                    @Override
                    public void detailItemClicked(String _url, int position, int type, RailCommonData commonData) {
                        if (NetworkConnectivity.isOnline(mContext)) {
                            detailRailClick.detailItemClicked(_url, position, type, commonData);
                        } else {
                            ToastHandler.show(mContext.getResources().getString(R.string.no_internet_connection), mContext);
                        }
                    }
                });
            });

        }


    }

}
