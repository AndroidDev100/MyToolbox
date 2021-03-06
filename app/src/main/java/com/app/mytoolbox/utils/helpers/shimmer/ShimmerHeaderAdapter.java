package com.app.mytoolbox.utils.helpers.shimmer;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;
import com.app.mytoolbox.databinding.LayoutDemoGridBinding;

public class ShimmerHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private ArrayList<SingleItemModel> itemsList;
//    private Context mContext;

    public ShimmerHeaderAdapter() {
//        this.itemsList = itemsList;
//        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutDemoGridBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.layout_demo_grid, parent, false);
        return new SingleItemRowHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class SingleItemRowHolder extends RecyclerView.ViewHolder {

        final LayoutDemoGridBinding layoutDemoGridBinding;

        private SingleItemRowHolder(LayoutDemoGridBinding view) {
            super(view.getRoot());
            this.layoutDemoGridBinding = view;


        }
    }
}
