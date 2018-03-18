package com.youngfeng.androidclient.common;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * BaseActivity
 *
 * @author Scott Smith 2018-03-18 16:27
 */
public class BaseActivity extends AppCompatActivity {
    private AlertDialog mDialog;
    private ProgressDialog mProgressDialog;

    protected void promptError(String error, DialogInterface.OnClickListener onClickListener) {
        if(null == mDialog) {
            mDialog = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .create();
        }

        mDialog.setMessage(error);
        mDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", onClickListener);

        if(!mDialog.isShowing()) mDialog.show();
    }

    protected void promptError(String error) {
        promptError(error, null);
    }

    protected void showLoading(boolean show) {
        if(null == mProgressDialog) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setCanceledOnTouchOutside(true);
        }

        if(!mProgressDialog.isShowing() && show) mProgressDialog.show();
        if(mProgressDialog.isShowing() && !show) mProgressDialog.dismiss();
    }
}
