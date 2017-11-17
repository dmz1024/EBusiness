// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.orderdetail;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderItemActivity_ViewBinding implements Unbinder {
  private OrderItemActivity target;

  @UiThread
  public OrderItemActivity_ViewBinding(OrderItemActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderItemActivity_ViewBinding(OrderItemActivity target, View source) {
    this.target = target;

    target.mTvDate = Utils.findRequiredViewAsType(source, R.id.tv_date, "field 'mTvDate'", TextView.class);
    target.mTvType = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'mTvType'", TextView.class);
    target.mRecy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'mRecy'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderItemActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvDate = null;
    target.mTvType = null;
    target.mRecy = null;
  }
}
