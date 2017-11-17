// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SpaceDescDialog_ViewBinding implements Unbinder {
  private SpaceDescDialog target;

  private View view2131689847;

  @UiThread
  public SpaceDescDialog_ViewBinding(final SpaceDescDialog target, View source) {
    this.target = target;

    View view;
    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rvContent, "field 'rvContent'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ivCancel, "method 'cancel'");
    view2131689847 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancel();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SpaceDescDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvContent = null;

    view2131689847.setOnClickListener(null);
    view2131689847 = null;
  }
}
