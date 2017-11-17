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

public class ConsumeDetailActivity_ViewBinding implements Unbinder {
  private ConsumeDetailActivity target;

  @UiThread
  public ConsumeDetailActivity_ViewBinding(ConsumeDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConsumeDetailActivity_ViewBinding(ConsumeDetailActivity target, View source) {
    this.target = target;

    target.mTvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mTvName'", TextView.class);
    target.mTvMoney = Utils.findRequiredViewAsType(source, R.id.tv_money, "field 'mTvMoney'", TextView.class);
    target.mTvType = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'mTvType'", TextView.class);
    target.mRecy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'mRecy'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConsumeDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvName = null;
    target.mTvMoney = null;
    target.mTvType = null;
    target.mRecy = null;
  }
}
