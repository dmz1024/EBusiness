// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DepositDialog_ViewBinding implements Unbinder {
  private DepositDialog target;

  private View view2131689670;

  private View view2131689834;

  @UiThread
  public DepositDialog_ViewBinding(final DepositDialog target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_ok, "method 'click'");
    view2131689670 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel, "method 'click'");
    view2131689834 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131689670.setOnClickListener(null);
    view2131689670 = null;
    view2131689834.setOnClickListener(null);
    view2131689834 = null;
  }
}
