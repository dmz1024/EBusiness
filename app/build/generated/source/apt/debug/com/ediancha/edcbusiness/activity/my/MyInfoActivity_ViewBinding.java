// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyInfoActivity_ViewBinding implements Unbinder {
  private MyInfoActivity target;

  @UiThread
  public MyInfoActivity_ViewBinding(MyInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyInfoActivity_ViewBinding(MyInfoActivity target, View source) {
    this.target = target;

    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rvContent, "field 'rvContent'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvContent = null;
  }
}
