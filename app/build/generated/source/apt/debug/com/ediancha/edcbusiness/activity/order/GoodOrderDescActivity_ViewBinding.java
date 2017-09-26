// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GoodOrderDescActivity_ViewBinding implements Unbinder {
  private GoodOrderDescActivity target;

  @UiThread
  public GoodOrderDescActivity_ViewBinding(GoodOrderDescActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GoodOrderDescActivity_ViewBinding(GoodOrderDescActivity target, View source) {
    this.target = target;

    target.tvStatusInfo = Utils.findRequiredViewAsType(source, R.id.tvStatusInfo, "field 'tvStatusInfo'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    target.ivGoodImg = Utils.findRequiredViewAsType(source, R.id.ivGoodImg, "field 'ivGoodImg'", ImageView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tvPrice, "field 'tvPrice'", TextView.class);
    target.tvGoodName = Utils.findRequiredViewAsType(source, R.id.tvGoodName, "field 'tvGoodName'", TextView.class);
    target.tvInfo = Utils.findRequiredViewAsType(source, R.id.tvInfo, "field 'tvInfo'", TextView.class);
    target.tvCount = Utils.findRequiredViewAsType(source, R.id.tvCount, "field 'tvCount'", TextView.class);
    target.rvPayInfo = Utils.findRequiredViewAsType(source, R.id.rvPayInfo, "field 'rvPayInfo'", RecyclerView.class);
    target.rvOrderInfo = Utils.findRequiredViewAsType(source, R.id.rvOrderInfo, "field 'rvOrderInfo'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GoodOrderDescActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvStatusInfo = null;
    target.tvTitle = null;
    target.ivGoodImg = null;
    target.tvPrice = null;
    target.tvGoodName = null;
    target.tvInfo = null;
    target.tvCount = null;
    target.rvPayInfo = null;
    target.rvOrderInfo = null;
  }
}
