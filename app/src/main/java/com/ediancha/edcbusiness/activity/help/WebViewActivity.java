package com.ediancha.edcbusiness.activity.help;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.WebViewHelper;

/**
 * Created by Admin on 2017/9/27.
 */
@Route(path = "/activity/help/webview")
public class WebViewActivity extends ToobarBaseActivity {

    private WebView mWebView;
    private ProgressBar mProgressBar;

    private WebViewHelper mHelper;

    @Autowired
    public String H5;

    @Override
    protected void initView() {
        super.initView();

        mWebView = findViewById(R.id.wv_show);
        mProgressBar = findViewById(R.id.pb_gress);

        mHelper = mHelper == null ? new WebViewHelper(mWebView) : mHelper;
        if (H5 == null) {
            H5 = "https://www.baidu.com";
        }
        initWV();
    }

    private void initWV() {
        mWebView.loadUrl(H5);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                dmzBar.setText(view.getTitle());
                return true;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);//加载完网页进度条消失
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    mProgressBar.setProgress(newProgress);//设置进度值
                }

            }
        });

    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setLeftImage(R.mipmap.icon_chahao);
    }

    @Override
    protected int getRid() {
        return R.layout.activity_webview;
    }


//    //设置返回键动作（防止按返回键直接退出程序)
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (mWebView.canGoBack()) {//当webview不是处于第一页面时，返回上一个页面
//                mWebView.goBack();
//                return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }


}
