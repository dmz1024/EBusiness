// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.my;

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

  private View view2131689753;

  @UiThread
  public MoneyActivity_ViewBinding(MoneyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MoneyActivity_ViewBinding(final MoneyActivity target, View source) {
    this.target = target;

    View view;
    target.tvMoney = Utils.findRequiredViewAsType(source, R.id.tvMoney, "field 'tvMoney'", TextView.class);
    target.tvCmoney = Utils.findRequiredViewAsType(source, R.id.tvCmoney, "field 'tvCmoney'", TextView.class);
    target.tvSmoney = Utils.findRequiredViewAsType(source, R.id.tvSmoney, "field 'tvSmoney'", TextView.class);
    target.tvXieyi = Utils.findRequiredViewAsType(source, R.id.tvXieyi, "field 'tvXieyi'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btSubmit, "method 'onClick'");
    view2131689753 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MoneyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMoney = null;
    target.tvCmoney = null;
    target.tvSmoney = null;
    target.tvXieyi = null;

    view2131689753.setOnClickListener(null);
    view2131689753 = null;
  }
}
