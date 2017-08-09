package com.hy.ioms.view.ui.recycler;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 通用adapter
 * Created by Administrator on 2017/2/22.
 */

public class MultipleTypeAdapter extends RecyclerView.Adapter<MultipleTypeAdapter.ItemViewHolder> {

    @Inject
    public MultipleTypeAdapter() {
    }

    public interface IItem {
        int getLayout();

        int getVariableId();
    }

    private List<IItem> mItems = new ArrayList<>();

    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemViewHolder.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bindTo(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public int findPos(IItem item) {
        return mItems.indexOf(item);
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getLayout();
    }

    public void setItem(IItem iItem) {
        clearItems();
        addItem(iItem);
    }

    public void setItem(List<IItem> iItems) {
        clearItems();
        addItems(iItems);
    }

    public void addItem(IItem item) {
        mItems.add(item);
        this.notifyItemInserted(mItems.size() - 1);
    }

    public void addItem(IItem item, int index) {
        mItems.add(index, item);
    }

    public void addItems(List<IItem> items) {
        this.mItems.addAll(items);
        this.notifyDataSetChanged();
    }

    public void removeItem(IItem item) {
        int index = mItems.indexOf(item);
        if (index > -1) {
            mItems.remove(index);
            this.notifyItemRemoved(index);
        }

    }

    public void clearItems() {
        mItems.clear();
    }

    public List<IItem> getData() {
        return mItems;
    }

    public void setData(List<IItem> data) {
        this.mItems = data;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        static ItemViewHolder create(ViewGroup parent, int viewType) {
            ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    viewType, parent, false);
            return new ItemViewHolder(binding);
        }

        ItemViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindTo(IItem item) {
            binding.setVariable(item.getVariableId(), item);
            binding.executePendingBindings();
        }
    }
}
