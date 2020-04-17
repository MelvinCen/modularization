package com.melvin.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.melvin.base.R;
import com.melvin.tool.ResourceUtil;

public class LoadingDialogBuilder {


    public static Dialog init(Context context, String message) {
        Dialog progressDialog = new Dialog(context, R.style.base_loading_dialog);
        progressDialog.setContentView(R.layout.base_custom_loading_dialog);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = (TextView) progressDialog.findViewById(R.id.loading_dialog_msg);
        if (TextUtils.isEmpty(message)) {
            msg.setText(ResourceUtil.getString(R.string.base_loading));
        } else {
            msg.setText(message);
        }
        return progressDialog;
    }
}
