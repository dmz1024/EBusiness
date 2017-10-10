// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.tmall.ultraviewpager.UltraViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131689675;

  private View view2131689677;

  private View view2131689678;

  private View view2131689679;

  private View view2131689674;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.mTvLeft = Utils.findRequiredViewAsType(source, R.id.tv_left, "field 'mTvLeft'", TextView.class);
    target.mTvCenter = Utils.findRequiredViewAsType(source, R.id.tv_center, "field 'mTvCenter'", TextView.class);
    target.mTvRight = Utils.findRequiredViewAsType(source, R.id.tv_right, "field 'mTvRight'", TextView.class);
    target.mRecy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'mRecy'", RecyclerView.class);
    target.mDmzBar = Utils.findRequiredViewAsType(source, R.id.dmzBar, "field 'mDmzBar'", DmzBar.class);
    target.mIvArrows = Utils.findRequiredViewAsType(source, R.id.iv_arrows, "field 'mIvArrows'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.fg_arrows, "field 'mFgArrows' and method 'onClick'");
    target.mFgArrows = Utils.castView(view, R.id.fg_arrows, "field 'mFgArrows'", RelativeLayout.class);
    view2131689675 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fg_qw, "field 'mFgQw' and method 'onClick'");
    target.mFgQw = Utils.castView(view, R.id.fg_qw, "field 'mFgQw'", FrameLayout.class);
    view2131689677 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_bottom_header, "field 'mIvBottomHeader' and method 'onClick'");
    target.mIvBottomHeader = Utils.castView(view, R.id.iv_bottom_header, "field 'mIvBottomHeader'", ImageView.class);
    view2131689678 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_bottom_message, "field 'mIvBottomMessage' and method 'onClick'");
    target.mIvBottomMessage = Utils.castView(view, R.id.iv_bottom_message, "field 'mIvBottomMessage'", ImageView.class);
    view2131689679 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.llBottom, "field 'mLlBottom' and method 'onClick'");
    target.mLlBottom = Utils.castView(view, R.id.llBottom, "field 'mLlBottom'", LinearLayout.class);
    view2131689674 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mUvpPager = Utils.findRequiredViewAsType(source, R.id.uvp_pager, "field 'mUvpPager'", UltraViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvLeft = null;
    target.mTvCenter = null;
    target.mTvRight = null;
    target.mRecy = null;
    target.mDmzBar = null;
    target.mIvArrows = null;
    target.mFgArrows = null;
    target.mFgQw = null;
    target.mIvBottomHeader = null;
    target.mIvBottomMessage = null;
    target.mLlBottom = null;
    target.mUvpPager = null;

    view2131689675.setOnClickListener(null);
    view2131689675 = null;
    view2131689677.setOnClickListener(null);
    view2131689677 = null;
    view2131689678.setOnClickListener(null);
    view2131689678 = null;
    view2131689679.setOnClickListener(null);
    view2131689679 = null;
    view2131689674.setOnClickListener(null);
    view2131689674 = null;
  }
}
