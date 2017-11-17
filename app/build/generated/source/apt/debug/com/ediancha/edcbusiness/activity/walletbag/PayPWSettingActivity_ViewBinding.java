// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.walletbag;

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

public class PayPWSettingActivity_ViewBinding implements Unbinder {
  private PayPWSettingActivity target;

  private View view2131689661;

  @UiThread
  public PayPWSettingActivity_ViewBinding(PayPWSettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PayPWSettingActivity_ViewBinding(final PayPWSettingActivity target, View source) {
    this.target = target;

    View view;
    target.mEtTel = Utils.findRequiredViewAsType(source, R.id.et_tel, "field 'mEtTel'", EditText.class);
    target.mEtPass = Utils.findRequiredViewAsType(source, R.id.et_pass, "field 'mEtPass'", EditText.class);
    target.mEtPassyz = Utils.findRequiredViewAsType(source, R.id.et_passyz, "field 'mEtPassyz'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'mTvSubmit' and method 'click'");
    target.mTvSubmit = Utils.castView(view, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    view2131689661 = view;
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
    PayPWSettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEtTel = null;
    target.mEtPass = null;
    target.mEtPassyz = null;
    target.mTvSubmit = null;

    view2131689661.setOnClickListener(null);
    view2131689661 = null;
  }
}
