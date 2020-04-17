package com.melvin.list.adapter;

import android.content.Context;

import com.melvin.base.adapter.ListBaseAdapter;
import com.melvin.base.adapter.SuperViewHolder;
import com.melvin.list.R;

public class LrecyclerviewExampleAdapter extends ListBaseAdapter<String> {

    public LrecyclerviewExampleAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_lrecyclerview_example_item;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        holder.setText(R.id.lrecyclerview_item,getDataList().get(position));
    }
}
