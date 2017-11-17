// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChoseDateActvivity_ViewBinding implements Unbinder {
  private ChoseDateActvivity target;

  @UiThread
  public ChoseDateActvivity_ViewBinding(ChoseDateActvivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChoseDateActvivity_ViewBinding(ChoseDateActvivity target, View source) {
    this.target = target;

    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rvContent, "field 'rvContent'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ChoseDateActvivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvContent = null;
  }
}
