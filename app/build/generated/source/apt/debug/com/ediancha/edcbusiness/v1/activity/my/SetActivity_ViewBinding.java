// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetActivity_ViewBinding implements Unbinder {
  private SetActivity target;

  @UiThread
  public SetActivity_ViewBinding(SetActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SetActivity_ViewBinding(SetActivity target, View source) {
    this.target = target;

    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rvContent, "field 'rvContent'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SetActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvContent = null;
  }
}
