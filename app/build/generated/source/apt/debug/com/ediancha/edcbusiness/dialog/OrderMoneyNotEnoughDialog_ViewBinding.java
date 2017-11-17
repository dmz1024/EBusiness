// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.dialog;

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

public class OrderMoneyNotEnoughDialog_ViewBinding implements Unbinder {
  private OrderMoneyNotEnoughDialog target;

  private View view2131689846;

  @UiThread
  public OrderMoneyNotEnoughDialog_ViewBinding(final OrderMoneyNotEnoughDialog target,
      View source) {
    this.target = target;

    View view;
    target.ivCha = Utils.findRequiredViewAsType(source, R.id.ivCha, "field 'ivCha'", ImageView.class);
    target.tvMoney = Utils.findRequiredViewAsType(source, R.id.tvMoney, "field 'tvMoney'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btChoog, "method 'choose'");
    view2131689846 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.choose(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderMoneyNotEnoughDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivCha = null;
    target.tvMoney = null;

    view2131689846.setOnClickListener(null);
    view2131689846 = null;
  }
}
