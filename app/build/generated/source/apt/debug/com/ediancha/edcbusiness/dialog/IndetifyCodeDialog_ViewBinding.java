// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IndetifyCodeDialog_ViewBinding implements Unbinder {
  private IndetifyCodeDialog target;

  private View view2131689724;

  @UiThread
  public IndetifyCodeDialog_ViewBinding(final IndetifyCodeDialog target, View source) {
    this.target = target;

    View view;
    target.mRecy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'mRecy'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tvCode, "field 'mTvCode' and method 'onClick'");
    target.mTvCode = Utils.castView(view, R.id.tvCode, "field 'mTvCode'", TextView.class);
    view2131689724 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mTvCodeTime = Utils.findRequiredViewAsType(source, R.id.tvCodeTime, "field 'mTvCodeTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IndetifyCodeDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecy = null;
    target.mTvCode = null;
    target.mTvCodeTime = null;

    view2131689724.setOnClickListener(null);
    view2131689724 = null;
  }
}
