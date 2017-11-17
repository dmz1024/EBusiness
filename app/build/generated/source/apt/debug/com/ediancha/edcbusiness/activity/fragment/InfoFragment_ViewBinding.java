// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InfoFragment_ViewBinding implements Unbinder {
  private InfoFragment target;

  private View view2131689860;

  private View view2131689861;

  private View view2131689862;

  @UiThread
  public InfoFragment_ViewBinding(final InfoFragment target, View source) {
    this.target = target;

    View view;
    target.mTvCenter = Utils.findRequiredViewAsType(source, R.id.tv_center, "field 'mTvCenter'", TextView.class);
    target.mTvSetting = Utils.findRequiredViewAsType(source, R.id.tv_setting, "field 'mTvSetting'", ImageView.class);
    target.mRvActivity = Utils.findRequiredViewAsType(source, R.id.rvActivity, "field 'mRvActivity'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tvShape, "field 'mTvShape' and method 'onclick'");
    target.mTvShape = Utils.castView(view, R.id.tvShape, "field 'mTvShape'", TextView.class);
    view2131689860 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tvChong, "field 'mTvChong' and method 'onclick'");
    target.mTvChong = Utils.castView(view, R.id.tvChong, "field 'mTvChong'", TextView.class);
    view2131689861 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tvDui, "field 'mTvDui' and method 'onclick'");
    target.mTvDui = Utils.castView(view, R.id.tvDui, "field 'mTvDui'", TextView.class);
    view2131689862 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclick(p0);
      }
    });
    target.mRvMessage = Utils.findRequiredViewAsType(source, R.id.rvMessage, "field 'mRvMessage'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InfoFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvCenter = null;
    target.mTvSetting = null;
    target.mRvActivity = null;
    target.mTvShape = null;
    target.mTvChong = null;
    target.mTvDui = null;
    target.mRvMessage = null;

    view2131689860.setOnClickListener(null);
    view2131689860 = null;
    view2131689861.setOnClickListener(null);
    view2131689861 = null;
    view2131689862.setOnClickListener(null);
    view2131689862 = null;
  }
}
