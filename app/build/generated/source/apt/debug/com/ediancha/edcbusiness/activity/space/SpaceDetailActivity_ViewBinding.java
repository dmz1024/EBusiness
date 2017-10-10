// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import com.tmall.ultraviewpager.UltraViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SpaceDetailActivity_ViewBinding implements Unbinder {
  private SpaceDetailActivity target;

  private View view2131689815;

  private View view2131689763;

  private View view2131689820;

  @UiThread
  public SpaceDetailActivity_ViewBinding(SpaceDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SpaceDetailActivity_ViewBinding(final SpaceDetailActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_envir, "field 'mTvEnvir' and method 'open'");
    target.mTvEnvir = Utils.castView(view, R.id.tv_envir, "field 'mTvEnvir'", TextView.class);
    view2131689815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.open();
      }
    });
    target.mTvSname = Utils.findRequiredViewAsType(source, R.id.tv_sname, "field 'mTvSname'", TextView.class);
    target.mTvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'mTvStatus'", TextView.class);
    target.mTvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTvTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_local, "field 'mTvLocal' and method 'onClick'");
    target.mTvLocal = Utils.castView(view, R.id.tv_local, "field 'mTvLocal'", TextView.class);
    view2131689763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_number, "field 'mTvNumber' and method 'onClick'");
    target.mTvNumber = Utils.castView(view, R.id.tv_number, "field 'mTvNumber'", TextView.class);
    view2131689820 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mWvWebview = Utils.findRequiredViewAsType(source, R.id.wv_webview, "field 'mWvWebview'", WebView.class);
    target.mRyUser = Utils.findRequiredViewAsType(source, R.id.ry_user, "field 'mRyUser'", RecyclerView.class);
    target.mRyEquip = Utils.findRequiredViewAsType(source, R.id.ry_equip, "field 'mRyEquip'", RecyclerView.class);
    target.mTvXfdetail = Utils.findRequiredViewAsType(source, R.id.tv_xfdetail, "field 'mTvXfdetail'", TextView.class);
    target.mTvNotice = Utils.findRequiredViewAsType(source, R.id.tv_notice, "field 'mTvNotice'", TextView.class);
    target.mUvpPager = Utils.findRequiredViewAsType(source, R.id.uvp_pager, "field 'mUvpPager'", UltraViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SpaceDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvEnvir = null;
    target.mTvSname = null;
    target.mTvStatus = null;
    target.mTvTime = null;
    target.mTvLocal = null;
    target.mTvNumber = null;
    target.mWvWebview = null;
    target.mRyUser = null;
    target.mRyEquip = null;
    target.mTvXfdetail = null;
    target.mTvNotice = null;
    target.mUvpPager = null;

    view2131689815.setOnClickListener(null);
    view2131689815 = null;
    view2131689763.setOnClickListener(null);
    view2131689763 = null;
    view2131689820.setOnClickListener(null);
    view2131689820 = null;
  }
}
