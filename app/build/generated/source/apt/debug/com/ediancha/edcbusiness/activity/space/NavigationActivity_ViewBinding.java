// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amap.api.navi.AMapNaviView;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NavigationActivity_ViewBinding implements Unbinder {
  private NavigationActivity target;

  @UiThread
  public NavigationActivity_ViewBinding(NavigationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NavigationActivity_ViewBinding(NavigationActivity target, View source) {
    this.target = target;

    target.mNavView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'mNavView'", AMapNaviView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NavigationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNavView = null;
  }
}
