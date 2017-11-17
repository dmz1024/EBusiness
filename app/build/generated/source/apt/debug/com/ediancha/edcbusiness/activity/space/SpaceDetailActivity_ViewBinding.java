// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SpaceDetailActivity_ViewBinding implements Unbinder {
  private SpaceDetailActivity target;

  private View view2131689884;

  private View view2131689885;

  private View view2131689831;

  private View view2131689661;

  private View view2131689881;

  @UiThread
  public SpaceDetailActivity_ViewBinding(SpaceDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SpaceDetailActivity_ViewBinding(final SpaceDetailActivity target, View source) {
    this.target = target;

    View view;
    target.mTvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTvTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_local, "field 'mTvLocal' and method 'onClick'");
    target.mTvLocal = Utils.castView(view, R.id.tv_local, "field 'mTvLocal'", TextView.class);
    view2131689884 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_number, "field 'mTvNumber' and method 'onClick'");
    target.mTvNumber = Utils.castView(view, R.id.tv_number, "field 'mTvNumber'", TextView.class);
    view2131689885 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mRyUser = Utils.findRequiredViewAsType(source, R.id.ry_user, "field 'mRyUser'", RecyclerView.class);
    target.mTvNotice = Utils.findRequiredViewAsType(source, R.id.tv_notice, "field 'mTvNotice'", TextView.class);
    target.mRecyActivity = Utils.findRequiredViewAsType(source, R.id.recy_activity, "field 'mRecyActivity'", RecyclerView.class);
    target.mImgSpace = Utils.findRequiredViewAsType(source, R.id.img_space, "field 'mImgSpace'", ImageView.class);
    target.mTvMoney = Utils.findRequiredViewAsType(source, R.id.tv_money, "field 'mTvMoney'", TextView.class);
    target.mTvPm = Utils.findRequiredViewAsType(source, R.id.tv_pm, "field 'mTvPm'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_title, "field 'mTvTitle' and method 'onClick'");
    target.mTvTitle = Utils.castView(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    view2131689831 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mWebview = Utils.findRequiredViewAsType(source, R.id.webview, "field 'mWebview'", WebView.class);
    target.mRlUser = Utils.findRequiredViewAsType(source, R.id.rl_user, "field 'mRlUser'", LinearLayout.class);
    target.mTvKj = Utils.findRequiredViewAsType(source, R.id.tv_kj, "field 'mTvKj'", TextView.class);
    target.mTvPrices = Utils.findRequiredViewAsType(source, R.id.tv_prices, "field 'mTvPrices'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'mTvSubmit' and method 'onClick'");
    target.mTvSubmit = Utils.castView(view, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    view2131689661 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mTvEnvir = Utils.findRequiredViewAsType(source, R.id.tv_envir, "field 'mTvEnvir'", TextView.class);
    target.mLnLabel = Utils.findRequiredViewAsType(source, R.id.ln_label, "field 'mLnLabel'", LinearLayout.class);
    target.mLnSize = Utils.findRequiredViewAsType(source, R.id.ln_size, "field 'mLnSize'", LinearLayout.class);
    target.mRlWv = Utils.findRequiredViewAsType(source, R.id.rl_wv, "field 'mRlWv'", LinearLayout.class);
    target.mRlActivity = Utils.findRequiredViewAsType(source, R.id.rl_activity, "field 'mRlActivity'", LinearLayout.class);
    target.mRlPrice = Utils.findRequiredViewAsType(source, R.id.rl_price, "field 'mRlPrice'", LinearLayout.class);
    target.mRlNotice = Utils.findRequiredViewAsType(source, R.id.rl_notice, "field 'mRlNotice'", LinearLayout.class);
    target.mScrollview = Utils.findRequiredViewAsType(source, R.id.scrollview, "field 'mScrollview'", ScrollView.class);
    view = Utils.findRequiredView(source, R.id.ln_pm, "method 'onClick'");
    view2131689881 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SpaceDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvTime = null;
    target.mTvLocal = null;
    target.mTvNumber = null;
    target.mRyUser = null;
    target.mTvNotice = null;
    target.mRecyActivity = null;
    target.mImgSpace = null;
    target.mTvMoney = null;
    target.mTvPm = null;
    target.mTvTitle = null;
    target.mWebview = null;
    target.mRlUser = null;
    target.mTvKj = null;
    target.mTvPrices = null;
    target.mTvSubmit = null;
    target.mTvEnvir = null;
    target.mLnLabel = null;
    target.mLnSize = null;
    target.mRlWv = null;
    target.mRlActivity = null;
    target.mRlPrice = null;
    target.mRlNotice = null;
    target.mScrollview = null;

    view2131689884.setOnClickListener(null);
    view2131689884 = null;
    view2131689885.setOnClickListener(null);
    view2131689885 = null;
    view2131689831.setOnClickListener(null);
    view2131689831 = null;
    view2131689661.setOnClickListener(null);
    view2131689661 = null;
    view2131689881.setOnClickListener(null);
    view2131689881 = null;
  }
}
