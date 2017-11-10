// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.walletbag;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyPackageActivity_ViewBinding implements Unbinder {
  private MyPackageActivity target;

  private View view2131689688;

  private View view2131689689;

  private View view2131689691;

  private View view2131689693;

  @UiThread
  public MyPackageActivity_ViewBinding(MyPackageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyPackageActivity_ViewBinding(final MyPackageActivity target, View source) {
    this.target = target;

    View view;
    target.mTvMoney = Utils.findRequiredViewAsType(source, R.id.tv_money, "field 'mTvMoney'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ln_money, "field 'mLnMoney' and method 'click'");
    target.mLnMoney = Utils.castView(view, R.id.ln_money, "field 'mLnMoney'", LinearLayout.class);
    view2131689688 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    target.mTvCoupon = Utils.findRequiredViewAsType(source, R.id.tv_coupon, "field 'mTvCoupon'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ln_coupon, "field 'mLnCoupon' and method 'click'");
    target.mLnCoupon = Utils.castView(view, R.id.ln_coupon, "field 'mLnCoupon'", LinearLayout.class);
    view2131689689 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    target.mTvDeposit = Utils.findRequiredViewAsType(source, R.id.tv_deposit, "field 'mTvDeposit'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ln_deposit, "field 'mLnDeposit' and method 'click'");
    target.mLnDeposit = Utils.castView(view, R.id.ln_deposit, "field 'mLnDeposit'", LinearLayout.class);
    view2131689691 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    target.mTvPass = Utils.findRequiredViewAsType(source, R.id.tv_pass, "field 'mTvPass'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ln_pass, "field 'mLnPass' and method 'click'");
    target.mLnPass = Utils.castView(view, R.id.ln_pass, "field 'mLnPass'", LinearLayout.class);
    view2131689693 = view;
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
    MyPackageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvMoney = null;
    target.mLnMoney = null;
    target.mTvCoupon = null;
    target.mLnCoupon = null;
    target.mTvDeposit = null;
    target.mLnDeposit = null;
    target.mTvPass = null;
    target.mLnPass = null;

    view2131689688.setOnClickListener(null);
    view2131689688 = null;
    view2131689689.setOnClickListener(null);
    view2131689689 = null;
    view2131689691.setOnClickListener(null);
    view2131689691 = null;
    view2131689693.setOnClickListener(null);
    view2131689693 = null;
  }
}
