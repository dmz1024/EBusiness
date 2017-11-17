// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.order;

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

public class OrderShopActivity_ViewBinding implements Unbinder {
  private OrderShopActivity target;

  @UiThread
  public OrderShopActivity_ViewBinding(OrderShopActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderShopActivity_ViewBinding(OrderShopActivity target, View source) {
    this.target = target;

    target.mImgShow = Utils.findRequiredViewAsType(source, R.id.img_show, "field 'mImgShow'", ImageView.class);
    target.mTvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mTvName'", TextView.class);
    target.mTvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'mTvPrice'", TextView.class);
    target.mTvNum = Utils.findRequiredViewAsType(source, R.id.tv_num, "field 'mTvNum'", TextView.class);
    target.mRecyItem = Utils.findRequiredViewAsType(source, R.id.recy_item, "field 'mRecyItem'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderShopActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImgShow = null;
    target.mTvName = null;
    target.mTvPrice = null;
    target.mTvNum = null;
    target.mRecyItem = null;
  }
}
