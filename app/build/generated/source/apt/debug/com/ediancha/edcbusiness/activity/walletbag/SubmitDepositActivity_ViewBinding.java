// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.walletbag;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SubmitDepositActivity_ViewBinding implements Unbinder {
  private SubmitDepositActivity target;

  @UiThread
  public SubmitDepositActivity_ViewBinding(SubmitDepositActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SubmitDepositActivity_ViewBinding(SubmitDepositActivity target, View source) {
    this.target = target;

    target.mTvMoney = Utils.findRequiredViewAsType(source, R.id.tv_money, "field 'mTvMoney'", TextView.class);
    target.mRbWechat = Utils.findRequiredViewAsType(source, R.id.rb_wechat, "field 'mRbWechat'", RadioButton.class);
    target.mRbPay = Utils.findRequiredViewAsType(source, R.id.rb_pay, "field 'mRbPay'", RadioButton.class);
    target.mRgPay = Utils.findRequiredViewAsType(source, R.id.rg_pay, "field 'mRgPay'", RadioGroup.class);
    target.mTvBmony = Utils.findRequiredViewAsType(source, R.id.tv_bmony, "field 'mTvBmony'", TextView.class);
    target.mTvSubmit = Utils.findRequiredViewAsType(source, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    target.mTvXysubmit = Utils.findRequiredViewAsType(source, R.id.tv_xysubmit, "field 'mTvXysubmit'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SubmitDepositActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvMoney = null;
    target.mRbWechat = null;
    target.mRbPay = null;
    target.mRgPay = null;
    target.mTvBmony = null;
    target.mTvSubmit = null;
    target.mTvXysubmit = null;
  }
}
