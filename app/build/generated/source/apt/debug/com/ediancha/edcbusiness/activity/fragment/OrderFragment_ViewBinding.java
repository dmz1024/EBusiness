// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderFragment_ViewBinding implements Unbinder {
  private OrderFragment target;

  @UiThread
  public OrderFragment_ViewBinding(OrderFragment target, View source) {
    this.target = target;

    target.mRbSpace = Utils.findRequiredViewAsType(source, R.id.rb_space, "field 'mRbSpace'", RadioButton.class);
    target.mRbShop = Utils.findRequiredViewAsType(source, R.id.rb_shop, "field 'mRbShop'", RadioButton.class);
    target.mRgOtype = Utils.findRequiredViewAsType(source, R.id.rg_otype, "field 'mRgOtype'", RadioGroup.class);
    target.mFrame = Utils.findRequiredViewAsType(source, R.id.frame, "field 'mFrame'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRbSpace = null;
    target.mRbShop = null;
    target.mRgOtype = null;
    target.mFrame = null;
  }
}
