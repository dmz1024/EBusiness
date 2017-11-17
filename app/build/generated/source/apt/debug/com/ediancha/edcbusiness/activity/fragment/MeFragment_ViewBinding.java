// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MeFragment_ViewBinding implements Unbinder {
  private MeFragment target;

  private View view2131689865;

  private View view2131689776;

  private View view2131689869;

  private View view2131689870;

  private View view2131689871;

  private View view2131689857;

  @UiThread
  public MeFragment_ViewBinding(final MeFragment target, View source) {
    this.target = target;

    View view;
    target.mTvCenter = Utils.findRequiredViewAsType(source, R.id.tv_center, "field 'mTvCenter'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_userhead, "field 'mImgUserhead' and method 'onClick'");
    target.mImgUserhead = Utils.castView(view, R.id.img_userhead, "field 'mImgUserhead'", ImageView.class);
    view2131689865 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mTvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mTvName'", TextView.class);
    target.mTvDetail = Utils.findRequiredViewAsType(source, R.id.tv_detail, "field 'mTvDetail'", TextView.class);
    target.mTvRz = Utils.findRequiredViewAsType(source, R.id.tv_rz, "field 'mTvRz'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_order, "method 'onClick'");
    view2131689776 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_bag, "method 'onClick'");
    view2131689869 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_friend, "method 'onClick'");
    view2131689870 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_help, "method 'onClick'");
    view2131689871 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_setting, "method 'onClick'");
    view2131689857 = view;
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
    MeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvCenter = null;
    target.mImgUserhead = null;
    target.mTvName = null;
    target.mTvDetail = null;
    target.mTvRz = null;

    view2131689865.setOnClickListener(null);
    view2131689865 = null;
    view2131689776.setOnClickListener(null);
    view2131689776 = null;
    view2131689869.setOnClickListener(null);
    view2131689869 = null;
    view2131689870.setOnClickListener(null);
    view2131689870 = null;
    view2131689871.setOnClickListener(null);
    view2131689871 = null;
    view2131689857.setOnClickListener(null);
    view2131689857 = null;
  }
}
