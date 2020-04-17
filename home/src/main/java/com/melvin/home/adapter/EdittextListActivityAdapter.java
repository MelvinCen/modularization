package com.melvin.home.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.melvin.base.adapter.SuperViewHolder;
import com.melvin.common.callback.OnConfirmCallBackListener;
import com.melvin.home.R;
import com.melvin.home.constant.HomeFuncDataName;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EdittextListActivityAdapter extends RecyclerView.Adapter<SuperViewHolder> {

    private Context mContext;
    private List<String> datas = new ArrayList<>();
    //有焦点的position
    private int etFocusPos = -1;
    //存储各个输入框输入的内容
    private SparseArray<String> etTextAry = new SparseArray();

    public EdittextListActivityAdapter(Context context,List<String> data) {
        mContext = context;
        this.datas = data;
    }


    @NonNull
    @Override
    public SuperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.home_item_activity_edittext_list, parent, false);
        return new SuperViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperViewHolder holder, int position) {
        TextView name = holder.getView(R.id.home_edittext_list_text);
        name.setText(datas.get(position));


       EditText editText = holder.getView(R.id.home_edittext_list_edittext);
       //根据存的记录显示
        editText.setText(etTextAry.get(position));
       //记录焦点
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    etFocusPos = position;
                }
            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            //数据
            etTextAry.put(etFocusPos,s.toString());
        }
    };

    @Override
    public void onViewAttachedToWindow(@NonNull SuperViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        EditText inputAmount = holder.getView(R.id.home_edittext_list_edittext);
        inputAmount.addTextChangedListener(textWatcher);
        if (etFocusPos == holder.getAdapterPosition()) {
            inputAmount.requestFocus();
            inputAmount.setSelection(inputAmount.getText().toString().length());
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull SuperViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        EditText inputAmount = holder.getView(R.id.home_edittext_list_edittext);
        inputAmount.removeTextChangedListener(textWatcher);
        inputAmount.clearFocus();
    }

    public List<String> getDatas(){
        return datas;
    }
}
