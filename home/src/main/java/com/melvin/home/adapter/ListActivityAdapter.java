package com.melvin.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.melvin.base.adapter.SuperViewHolder;
import com.melvin.common.callback.OnConfirmCallBackListener;
import com.melvin.home.R;
import com.melvin.home.constant.ListFuncData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivityAdapter extends RecyclerView.Adapter<SuperViewHolder> {

    private Context mContext;
    private List<String> datas = new ArrayList<>();

    public ListActivityAdapter(Context context) {
        mContext = context;

        datas.addAll(ListFuncData.funcList());
    }

    private OnConfirmCallBackListener<Integer> mOnConfirmCallBackListener;
    public void setOnConfirmCallBackListener(OnConfirmCallBackListener<Integer> onConfirmCallBackListener) {
        this.mOnConfirmCallBackListener = onConfirmCallBackListener;
    }

    @NonNull
    @Override
    public SuperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.home_item_activity_main, parent, false);
        return new SuperViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperViewHolder holder, int position) {
        TextView item = holder.getView(R.id.item_activity_main);
        item.setText(datas.get(position));
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnConfirmCallBackListener != null) {
                    mOnConfirmCallBackListener.callback(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
