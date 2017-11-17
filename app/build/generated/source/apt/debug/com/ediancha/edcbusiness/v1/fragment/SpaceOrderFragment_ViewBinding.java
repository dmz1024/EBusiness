// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SpaceOrderFragment_ViewBinding implements Unbinder {
  private SpaceOrderFragment target;

  @UiThread
  public SpaceOrderFragment_ViewBinding(SpaceOrderFragment target, View source) {
    this.target = target;

    target.mTabTitle = Utils.findRequiredViewAsType(source, R.id.tab_title, "field 'mTabTitle'", TabLayout.class);
    target.mVpShow = Utils.findRequiredViewAsType(source, R.id.vp_show, "field 'mVpShow'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SpaceOrderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTabTitle = null;
    target.mVpShow = null;
  }
}
