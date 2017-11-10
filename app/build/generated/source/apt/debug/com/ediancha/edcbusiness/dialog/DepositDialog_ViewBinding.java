// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DepositDialog_ViewBinding implements Unbinder {
  private DepositDialog target;

  private View view2131689643;

  private View view2131689736;

  @UiThread
  public DepositDialog_ViewBinding(final DepositDialog target, View source) {
    this.target = target;

    View view;
    target.mIvStyle = Utils.findRequiredViewAsType(source, R.id.iv_style, "field 'mIvStyle'", ImageView.class);
    target.mTvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'mTvContent'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_ok, "field 'mTvOk' and method 'click'");
    target.mTvOk = Utils.castView(view, R.id.tv_ok, "field 'mTvOk'", TextView.class);
    view2131689643 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel, "field 'mTvCancel' and method 'click'");
    target.mTvCancel = Utils.castView(view, R.id.tv_cancel, "field 'mTvCancel'", TextView.class);
    view2131689736 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DepositDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mIvStyle = null;
    target.mTvContent = null;
    target.mTvOk = null;
    target.mTvCancel = null;

    view2131689643.setOnClickListener(null);
    view2131689643 = null;
    view2131689736.setOnClickListener(null);
    view2131689736 = null;
  }
}
