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

  private View viewSource;

  @UiThread
  public PayPWSettingActivity_ViewBinding(PayPWSettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PayPWSettingActivity_ViewBinding(final PayPWSettingActivity target, View source) {
    this.target = target;

    target.mEtTel = Utils.findRequiredViewAsType(source, R.id.et_tel, "field 'mEtTel'", EditText.class);
    target.mEtCode = Utils.findRequiredViewAsType(source, R.id.et_code, "field 'mEtCode'", EditText.class);
    target.mTvCode = Utils.findRequiredViewAsType(source, R.id.tv_code, "field 'mTvCode'", TextView.class);
    target.mEtPass = Utils.findRequiredViewAsType(source, R.id.et_pass, "field 'mEtPass'", EditText.class);
    target.mEtPassyz = Utils.findRequiredViewAsType(source, R.id.et_passyz, "field 'mEtPassyz'", EditText.class);
    target.mTvSubmit = Utils.findRequiredViewAsType(source, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    viewSource = source;
    source.setOnClickListener(new DebouncingOnClickListener() {
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
    target.mEtCode = null;
    target.mTvCode = null;
    target.mEtPass = null;
    target.mEtPassyz = null;
    target.mTvSubmit = null;

    viewSource.setOnClickListener(null);
    viewSource = null;
  }
}
