// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonDialog_ViewBinding implements Unbinder {
  private CommonDialog target;

  private View view2131689834;

  private View view2131689670;

  @UiThread
  public CommonDialog_ViewBinding(final CommonDialog target, View source) {
    this.target = target;

    View view;
    target.mTvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_cancel, "field 'mTvCancel' and method 'onClick'");
    target.mTvCancel = Utils.castView(view, R.id.tv_cancel, "field 'mTvCancel'", TextView.class);
    view2131689834 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_ok, "field 'mTvOk' and method 'onClick'");
    target.mTvOk = Utils.castView(view, R.id.tv_ok, "field 'mTvOk'", TextView.class);
    view2131689670 = view;
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
    CommonDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvTitle = null;
    target.mTvCancel = null;
    target.mTvOk = null;

    view2131689834.setOnClickListener(null);
    view2131689834 = null;
    view2131689670.setOnClickListener(null);
    view2131689670 = null;
  }
}
