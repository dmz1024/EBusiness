package com.ediancha.edcbusiness.v1.dialog;

import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2017/11/10.
 */

public class DealDialog extends NoTitleDialoggFragment {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvAgree)
    TextView tvAgree;
    @BindView(R.id.webview)
    WebView webview;

    public static DealDialog getInstance() {
        return new DealDialog();
    }


    @Override
    protected int getRid() {
        return R.layout.dialog_deal;
    }

    private String title;
    private String url;

    public DealDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public DealDialog setUrl(String url) {
        this.url = url;
        return this;
    }


    @Override
    protected int getH() {
        return (ScreenUtil.getScreenHeight() / 3) * 2;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        tvTitle.setText("《" + title + "》");
        webview.setWebViewClient(new WebViewClient() {
            // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                tvAgree.setText("正在加载：" + newProgress + "%");
                if (newProgress == 100) {
                    webview.setVisibility(View.VISIBLE);
                    tvAgree.setEnabled(true);
                    tvAgree.setAlpha(1f);
                    tvAgree.setText("同意协议");

                }
            }
        });


        WebSettings webSettings = webview.getSettings();

        webSettings.setSupportZoom(false);

        webSettings.setUseWideViewPort(true);
        //设置WebView加载页面的模式
        webSettings.setLoadWithOverviewMode(true);
        webview.loadUrl(url);
    }

    @OnClick(R.id.tvAgree)
    void agree() {
        dismiss();
    }

    @Override
    public void onPause() {
        super.onPause();

        if (webview != null) {

            webview.onPause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (webview != null) {
            webview.clearHistory();

        }
    }


    @Override
    protected int getGravity() {
        return Gravity.BOTTOM;
    }

}
