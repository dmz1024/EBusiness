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
import com.ediancha.edcbusiness.R;
import com.tmall.ultraviewpager.UltraViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131689731;

  private View view2131689733;

  private View view2131689736;

  private View view2131689738;

  private View view2131689739;

  private View view2131689740;

  private View view2131689735;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_left, "field 'mTvLeft' and method 'onClick'");
    target.mTvLeft = Utils.castView(view, R.id.tv_left, "field 'mTvLeft'", TextView.class);
    view2131689731 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mTvCenter = Utils.findRequiredViewAsType(source, R.id.tv_center, "field 'mTvCenter'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_right, "field 'mTvRight' and method 'onClick'");
    target.mTvRight = Utils.castView(view, R.id.tv_right, "field 'mTvRight'", TextView.class);
    view2131689733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mRecy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'mRecy'", RecyclerView.class);
    target.mIvArrows = Utils.findRequiredViewAsType(source, R.id.iv_arrows, "field 'mIvArrows'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.fg_arrows, "field 'mFgArrows' and method 'onClick'");
    target.mFgArrows = Utils.castView(view, R.id.fg_arrows, "field 'mFgArrows'", RelativeLayout.class);
    view2131689736 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fg_qw, "field 'mFgQw' and method 'onClick'");
    target.mFgQw = Utils.castView(view, R.id.fg_qw, "field 'mFgQw'", FrameLayout.class);
    view2131689738 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_bottom_header, "field 'mIvBottomHeader' and method 'onClick'");
    target.mIvBottomHeader = Utils.castView(view, R.id.iv_bottom_header, "field 'mIvBottomHeader'", ImageView.class);
    view2131689739 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_bottom_message, "field 'mIvBottomMessage' and method 'onClick'");
    target.mIvBottomMessage = Utils.castView(view, R.id.iv_bottom_message, "field 'mIvBottomMessage'", ImageView.class);
    view2131689740 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.llBottom, "field 'mLlBottom' and method 'onClick'");
    target.mLlBottom = Utils.castView(view, R.id.llBottom, "field 'mLlBottom'", LinearLayout.class);
    view2131689735 = view;
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
    target.mIvArrows = null;
    target.mFgArrows = null;
    target.mFgQw = null;
    target.mIvBottomHeader = null;
    target.mIvBottomMessage = null;
    target.mLlBottom = null;
    target.mUvpPager = null;

    view2131689731.setOnClickListener(null);
    view2131689731 = null;
    view2131689733.setOnClickListener(null);
    view2131689733 = null;
    view2131689736.setOnClickListener(null);
    view2131689736 = null;
    view2131689738.setOnClickListener(null);
    view2131689738 = null;
    view2131689739.setOnClickListener(null);
    view2131689739 = null;
    view2131689740.setOnClickListener(null);
    view2131689740 = null;
    view2131689735.setOnClickListener(null);
    view2131689735 = null;
  }
}
