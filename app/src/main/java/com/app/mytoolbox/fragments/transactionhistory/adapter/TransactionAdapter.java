package com.app.mytoolbox.fragments.transactionhistory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mytoolbox.R;
import com.app.mytoolbox.callBacks.commonCallBacks.PlanSelectedCallback;
import com.app.mytoolbox.databinding.ItemTransactionHistoryBinding;
import com.app.mytoolbox.fragments.transactionhistory.ui.TransactionHistory;
import com.app.mytoolbox.usermanagment.modelClasses.getPaymentV2.OrderItem;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;

import org.apache.commons.lang3.text.WordUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.SingleItemHolder> {
    private Fragment fragment;
    private List<OrderItem> orderItems;
    private boolean checkBoxVisible;
    private PlanSelectedCallback planSelectedCallback;

    public TransactionAdapter(TransactionHistory ctx, List<OrderItem> order, boolean checkBoxVisible) {
        this.fragment = ctx;
        orderItems = order;
        this.checkBoxVisible = checkBoxVisible;
        this.planSelectedCallback = (PlanSelectedCallback) ctx;
    }

    @NonNull
    @Override
    public SingleItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransactionHistoryBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_transaction_history, parent, false);
        return new SingleItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemHolder holder, int position) {
        if (orderItems.get(position) != null) {
            if (orderItems.get(position).getOrderProductInfo() != null && orderItems.get(position).getOrderProductInfo().get(0) != null && orderItems.get(position).getOrderProductInfo().get(0).getDisplayName() != null) {
                holder.binding.orderName.setText(orderItems.get(position).getOrderProductInfo().get(0).getDisplayName());
            }

            if (orderItems.get(position).getCurrencyCode() != null && orderItems.get(position).getPaymentsInfo().get(0)!= null) {
                holder.binding.currency.setText(orderItems.get(position).getCurrencyCode() + " " + orderItems.get(position).getPaymentsInfo().get(0).getAmount());
            } else {
                holder.binding.currency.setText("");
            }

            if (orderItems.get(position).getPaymentsInfo() != null && orderItems.get(position).getPaymentsInfo().get(0) != null && orderItems.get(position).getPaymentsInfo().get(0).getPaymentCategory() != null) {
                try {
                    holder.binding.paymentCategory.setText(WordUtils.capitalizeFully(orderItems.get(position).getPaymentsInfo().get(0).getPaymentCategory()));
                } catch (Exception e) {
                }
            }

            if (orderItems.get(position).getPaymentsInfo() != null && orderItems.get(position).getPaymentsInfo().get(0) != null && orderItems.get(position).getPaymentsInfo().get(0).getPaymentType() != null) {
                if (orderItems.get(position).getPaymentsInfo().get(0).getPaymentType().equalsIgnoreCase("Credit card")) {
                    String creditNumber = orderItems.get(position).getPaymentsInfo().get(0).getCreditCardNumber().replace("x", "");

                    holder.binding.creditNo.setText(orderItems.get(position).getPaymentsInfo().get(0).getPaymentType() + " " + creditNumber);
                } else {
                    holder.binding.creditNo.setText(orderItems.get(position).getPaymentsInfo().get(0).getPaymentType());
                }
            } else {
                holder.binding.creditNo.setText("");
            }
            if (orderItems.get(position).getOrderProductInfo() != null && orderItems.get(position).getOrderProductInfo().get(0) != null && orderItems.get(position).getOrderProductInfo().get(0).getStartDate() != null) {
                holder.binding.date.setText(getDate(orderItems.get(position).getOrderProductInfo().get(0).getStartDate()));

            } else {
                holder.binding.date.setText("");
            }
            if (orderItems.get(position).getPaymentsInfo().get(0).getPostingStatus().equalsIgnoreCase("Posted")) {
                if (orderItems.get(position).getPaymentsInfo().get(0).getPaymentType().equalsIgnoreCase(AppLevelConstants.GOOGLE_WALLET) || orderItems.get(position).getPaymentsInfo().get(0).getPaymentType().equalsIgnoreCase("App Store Billing")) {
                    holder.binding.checkbox.setVisibility(View.GONE);
                } else {
                    if (checkBoxVisible) {
                        holder.binding.checkbox.setVisibility(View.VISIBLE);
                    } else {
                        holder.binding.checkbox.setVisibility(View.GONE);
                    }
                }
            } else {
                holder.binding.checkbox.setVisibility(View.GONE);

            }
            holder.binding.checkbox.setOnClickListener(v -> {
                if (!holder.binding.checkbox.isChecked()) {
                    planSelectedCallback.onPlanUnselected(orderItems.get(position).getPaymentsInfo().get(0).getPaymentID());
                } else {
                    planSelectedCallback.onPlanSelected(orderItems.get(position).getPaymentsInfo().get(0).getPaymentID());
                }
            });
            if (orderItems.get(position).getPaymentsInfo().get(0).getPostingStatus().equalsIgnoreCase("declined")) {
                if (orderItems.get(position).getPaymentsInfo().get(0).getGatewayResponse() != null)
                    holder.binding.failedText.setText(orderItems.get(position).getPaymentsInfo().get(0).getGatewayResponse());
                holder.binding.failedText.setVisibility(View.VISIBLE);
            } else {
                holder.binding.failedText.setVisibility(View.GONE);

            }
        }
    }

    public String getDate(long timestamp) {
        try {
            Calendar calendar = Calendar.getInstance();
            TimeZone tz = TimeZone.getDefault();
            calendar.setTimeInMillis(timestamp);
            calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd/MM/yyyy", Locale.getDefault());
            Date currenTimeZone = (Date) calendar.getTime();
            return sdf.format(currenTimeZone);
        } catch (Exception e) {
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class SingleItemHolder extends RecyclerView.ViewHolder {
        final ItemTransactionHistoryBinding binding;

        public SingleItemHolder(ItemTransactionHistoryBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}

