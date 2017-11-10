package com.ediancha.edcbusiness.v1.dialog;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.dmz.library.dmzapi.dialog.BaseSheetDialog;

/**
 * Created by dengmingzhi on 2017/11/10.
 */

public class LoginDealDialog extends BaseSheetDialog {

    public static LoginDealDialog getInstance() {
        return new LoginDealDialog();
    }


    @Override
    protected View getItemView() {
        return new WebView(getContext());
    }

    private WebView webView;

    @Override
    protected void initView(View view) {
        super.initView(view);

        webView = (WebView) this.itemView;

        webView.loadUrl("https://www.baidu.com");
    }

    @Override
    public void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        webView.clearHistory();
        llRoot.removeView(webView);
    }
}
