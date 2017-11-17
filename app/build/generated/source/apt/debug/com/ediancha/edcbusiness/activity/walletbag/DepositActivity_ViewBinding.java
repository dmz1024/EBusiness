// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.walletbag;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DepositActivity_ViewBinding implements Unbinder {
  private DepositActivity target;

  private View view2131689661;

  @UiThread
  public DepositActivity_ViewBinding(DepositActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DepositActivity_ViewBinding(final DepositActivity target, View source) {
    this.target = target;

    View view;
    target.mDmzBar = Utils.findRequiredViewAsType(source, R.id.dmzBar, "field 'mDmzBar'", DmzBar.class);
    target.mTvTotal = Utils.findRequiredViewAsType(source, R.id.tv_total, "field 'mTvTotal'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'mTvSubmit' and method 'click'");
    target.mTvSubmit = Utils.castView(view, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    view2131689661 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    target.mTvShow = Utils.findRequiredViewAsType(source, R.id.tv_show, "field 'mTvShow'", TextView.class);
    target.mTvXieyi = Utils.findRequiredViewAsType(source, R.id.tv_xieyi, "field 'mTvXieyi'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DepositActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDmzBar = null;
    target.mTvTotal = null;
    target.mTvSubmit = null;
    target.mTvShow = null;
    target.mTvXieyi = null;

    view2131689661.setOnClickListener(null);
    view2131689661 = null;
  }
}
