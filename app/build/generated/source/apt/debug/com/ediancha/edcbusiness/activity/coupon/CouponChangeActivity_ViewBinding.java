// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.coupon;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CouponChangeActivity_ViewBinding implements Unbinder {
  private CouponChangeActivity target;

  private View view2131689661;

  @UiThread
  public CouponChangeActivity_ViewBinding(CouponChangeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CouponChangeActivity_ViewBinding(final CouponChangeActivity target, View source) {
    this.target = target;

    View view;
    target.mEtNumber = Utils.findRequiredViewAsType(source, R.id.et_number, "field 'mEtNumber'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'mTvSubmit' and method 'onclick'");
    target.mTvSubmit = Utils.castView(view, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    view2131689661 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CouponChangeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEtNumber = null;
    target.mTvSubmit = null;

    view2131689661.setOnClickListener(null);
    view2131689661 = null;
  }
}
