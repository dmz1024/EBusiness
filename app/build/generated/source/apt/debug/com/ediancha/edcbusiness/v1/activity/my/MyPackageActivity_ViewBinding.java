// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyPackageActivity_ViewBinding implements Unbinder {
  private MyPackageActivity target;

  private View view2131689765;

  private View view2131689758;

  private View view2131689759;

  private View view2131689761;

  private View view2131689763;

  @UiThread
  public MyPackageActivity_ViewBinding(MyPackageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyPackageActivity_ViewBinding(final MyPackageActivity target, View source) {
    this.target = target;

    View view;
    target.tvMoney = Utils.findRequiredViewAsType(source, R.id.tvMoney, "field 'tvMoney'", TextView.class);
    target.tvYhq = Utils.findRequiredViewAsType(source, R.id.tvYhq, "field 'tvYhq'", TextView.class);
    target.tvYj = Utils.findRequiredViewAsType(source, R.id.tvYj, "field 'tvYj'", TextView.class);
    target.tvSetPass = Utils.findRequiredViewAsType(source, R.id.tvSetPass, "field 'tvSetPass'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fgSetPass, "field 'fgSetPass' and method 'click'");
    target.fgSetPass = Utils.castView(view, R.id.fgSetPass, "field 'fgSetPass'", FrameLayout.class);
    view2131689765 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    target.ivOpen = Utils.findRequiredViewAsType(source, R.id.ivOpen, "field 'ivOpen'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.llMoeny, "method 'click'");
    view2131689758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.llYhq, "method 'click'");
    view2131689759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.llYj, "method 'click'");
    view2131689761 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fgOpen, "method 'click'");
    view2131689763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MyPackageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMoney = null;
    target.tvYhq = null;
    target.tvYj = null;
    target.tvSetPass = null;
    target.fgSetPass = null;
    target.ivOpen = null;

    view2131689765.setOnClickListener(null);
    view2131689765 = null;
    view2131689758.setOnClickListener(null);
    view2131689758 = null;
    view2131689759.setOnClickListener(null);
    view2131689759 = null;
    view2131689761.setOnClickListener(null);
    view2131689761 = null;
    view2131689763.setOnClickListener(null);
    view2131689763 = null;
  }
}
