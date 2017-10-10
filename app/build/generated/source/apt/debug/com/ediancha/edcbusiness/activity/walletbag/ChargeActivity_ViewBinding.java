// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.walletbag;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChargeActivity_ViewBinding implements Unbinder {
  private ChargeActivity target;

  private View view2131689638;

  @UiThread
  public ChargeActivity_ViewBinding(ChargeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChargeActivity_ViewBinding(final ChargeActivity target, View source) {
    this.target = target;

    View view;
    target.mTvMoney = Utils.findRequiredViewAsType(source, R.id.tv_money, "field 'mTvMoney'", TextView.class);
    target.mRecy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'mRecy'", RecyclerView.class);
    target.mRbWechat = Utils.findRequiredViewAsType(source, R.id.rb_wechat, "field 'mRbWechat'", RadioButton.class);
    target.mRbPay = Utils.findRequiredViewAsType(source, R.id.rb_pay, "field 'mRbPay'", RadioButton.class);
    target.mRgPay = Utils.findRequiredViewAsType(source, R.id.rg_pay, "field 'mRgPay'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'mTvSubmit' and method 'onClick'");
    target.mTvSubmit = Utils.castView(view, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    view2131689638 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ChargeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvMoney = null;
    target.mRecy = null;
    target.mRbWechat = null;
    target.mRbPay = null;
    target.mRgPay = null;
    target.mTvSubmit = null;

    view2131689638.setOnClickListener(null);
    view2131689638 = null;
  }
}
