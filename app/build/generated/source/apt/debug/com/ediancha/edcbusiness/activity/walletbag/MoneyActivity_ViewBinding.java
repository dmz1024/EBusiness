// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.walletbag;

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

public class MoneyActivity_ViewBinding implements Unbinder {
  private MoneyActivity target;

  private View view2131689638;

  @UiThread
  public MoneyActivity_ViewBinding(MoneyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MoneyActivity_ViewBinding(final MoneyActivity target, View source) {
    this.target = target;

    View view;
    target.mTvTotal = Utils.findRequiredViewAsType(source, R.id.tv_total, "field 'mTvTotal'", TextView.class);
    target.mTvCharge = Utils.findRequiredViewAsType(source, R.id.tv_charge, "field 'mTvCharge'", TextView.class);
    target.mTvGive = Utils.findRequiredViewAsType(source, R.id.tv_give, "field 'mTvGive'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'mTvSubmit' and method 'onClick'");
    target.mTvSubmit = Utils.castView(view, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    view2131689638 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.mTvXieyi = Utils.findRequiredViewAsType(source, R.id.tv_xieyi, "field 'mTvXieyi'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MoneyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvTotal = null;
    target.mTvCharge = null;
    target.mTvGive = null;
    target.mTvSubmit = null;
    target.mTvXieyi = null;

    view2131689638.setOnClickListener(null);
    view2131689638 = null;
  }
}
