// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SpaceOrderInProgeressDescActivity_ViewBinding implements Unbinder {
  private SpaceOrderInProgeressDescActivity target;

  @UiThread
  public SpaceOrderInProgeressDescActivity_ViewBinding(SpaceOrderInProgeressDescActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SpaceOrderInProgeressDescActivity_ViewBinding(SpaceOrderInProgeressDescActivity target,
      View source) {
    this.target = target;

    target.ivLogo = Utils.findRequiredViewAsType(source, R.id.ivLogo, "field 'ivLogo'", ImageView.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tvShopName, "field 'tvShopName'", TextView.class);
    target.tvTimeTip = Utils.findRequiredViewAsType(source, R.id.tvTimeTip, "field 'tvTimeTip'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tvTime, "field 'tvTime'", TextView.class);
    target.btYan = Utils.findRequiredViewAsType(source, R.id.btYan, "field 'btYan'", Button.class);
    target.tvMoneyTip = Utils.findRequiredViewAsType(source, R.id.tvMoneyTip, "field 'tvMoneyTip'", TextView.class);
    target.ivClose = Utils.findRequiredViewAsType(source, R.id.ivClose, "field 'ivClose'", ImageView.class);
    target.fgQw = Utils.findRequiredViewAsType(source, R.id.fg_qw, "field 'fgQw'", FrameLayout.class);
    target.ivMore = Utils.findRequiredViewAsType(source, R.id.ivMore, "field 'ivMore'", ImageView.class);
    target.ivAd = Utils.findRequiredViewAsType(source, R.id.ivAd, "field 'ivAd'", ImageView.class);
    target.tvOpen = Utils.findRequiredViewAsType(source, R.id.tvOpen, "field 'tvOpen'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SpaceOrderInProgeressDescActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivLogo = null;
    target.tvShopName = null;
    target.tvTimeTip = null;
    target.tvTime = null;
    target.btYan = null;
    target.tvMoneyTip = null;
    target.ivClose = null;
    target.fgQw = null;
    target.ivMore = null;
    target.ivAd = null;
    target.tvOpen = null;
  }
}
