// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import com.zhouwei.mzbanner.MZBannerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131689733;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.mTvCenter = Utils.findRequiredViewAsType(source, R.id.tv_center, "field 'mTvCenter'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.tv_right, "field 'mTvRight' and method 'goMap'");
    target.mTvRight = Utils.castView(view, R.id.tv_right, "field 'mTvRight'", TextView.class);
    view2131689733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.goMap();
      }
    });
    target.mBanner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'mBanner'", MZBannerView.class);
    target.mTvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    target.mTvDetail = Utils.findRequiredViewAsType(source, R.id.tv_detail, "field 'mTvDetail'", TextView.class);
    target.mLnTitle = Utils.findRequiredViewAsType(source, R.id.ln_title, "field 'mLnTitle'", LinearLayout.class);
    target.mSpaceItem = Utils.findRequiredViewAsType(source, R.id.space_item, "field 'mSpaceItem'", RecyclerView.class);
    target.mTvTiyan = Utils.findRequiredViewAsType(source, R.id.tv_tiyan, "field 'mTvTiyan'", TextView.class);
    target.mTvTydetail = Utils.findRequiredViewAsType(source, R.id.tv_tydetail, "field 'mTvTydetail'", TextView.class);
    target.mRecyTiyan = Utils.findRequiredViewAsType(source, R.id.recy_tiyan, "field 'mRecyTiyan'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvCenter = null;
    target.mTvRight = null;
    target.mBanner = null;
    target.mTvTitle = null;
    target.mTvDetail = null;
    target.mLnTitle = null;
    target.mSpaceItem = null;
    target.mTvTiyan = null;
    target.mTvTydetail = null;
    target.mRecyTiyan = null;

    view2131689733.setOnClickListener(null);
    view2131689733 = null;
  }
}
