// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.v1.view.RoundlProgresWithNum;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderingActivity_ViewBinding implements Unbinder {
  private OrderingActivity target;

  @UiThread
  public OrderingActivity_ViewBinding(OrderingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderingActivity_ViewBinding(OrderingActivity target, View source) {
    this.target = target;

    target.mDmzBar = Utils.findRequiredViewAsType(source, R.id.dmzBar, "field 'mDmzBar'", DmzBar.class);
    target.mTvUserlong = Utils.findRequiredViewAsType(source, R.id.tv_userlong, "field 'mTvUserlong'", TextView.class);
    target.mTvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTvTime'", TextView.class);
    target.mTvEnd = Utils.findRequiredViewAsType(source, R.id.tv_end, "field 'mTvEnd'", TextView.class);
    target.mImgLock = Utils.findRequiredViewAsType(source, R.id.img_lock, "field 'mImgLock'", ImageView.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", RoundlProgresWithNum.class);
    target.mRlPress = Utils.findRequiredViewAsType(source, R.id.rl_press, "field 'mRlPress'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDmzBar = null;
    target.mTvUserlong = null;
    target.mTvTime = null;
    target.mTvEnd = null;
    target.mImgLock = null;
    target.mProgress = null;
    target.mRlPress = null;
  }
}
