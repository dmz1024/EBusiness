// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CashPledgeActivity_ViewBinding implements Unbinder {
  private CashPledgeActivity target;

  private View view2131689753;

  @UiThread
  public CashPledgeActivity_ViewBinding(CashPledgeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CashPledgeActivity_ViewBinding(final CashPledgeActivity target, View source) {
    this.target = target;

    View view;
    target.tvMoney = Utils.findRequiredViewAsType(source, R.id.tvMoney, "field 'tvMoney'", TextView.class);
    target.tvStatus = Utils.findRequiredViewAsType(source, R.id.tvStatus, "field 'tvStatus'", TextView.class);
    target.tvTip = Utils.findRequiredViewAsType(source, R.id.tvTip, "field 'tvTip'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btSubmit, "field 'btSubmit' and method 'submit'");
    target.btSubmit = Utils.castView(view, R.id.btSubmit, "field 'btSubmit'", Button.class);
    view2131689753 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CashPledgeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMoney = null;
    target.tvStatus = null;
    target.tvTip = null;
    target.btSubmit = null;

    view2131689753.setOnClickListener(null);
    view2131689753 = null;
  }
}
