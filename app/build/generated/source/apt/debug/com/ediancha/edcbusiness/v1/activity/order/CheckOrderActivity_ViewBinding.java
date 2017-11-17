// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CheckOrderActivity_ViewBinding implements Unbinder {
  private CheckOrderActivity target;

  private View view2131689681;

  private View view2131689682;

  private View view2131689683;

  private View view2131689686;

  @UiThread
  public CheckOrderActivity_ViewBinding(CheckOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CheckOrderActivity_ViewBinding(final CheckOrderActivity target, View source) {
    this.target = target;

    View view;
    target.mImgShow = Utils.findRequiredViewAsType(source, R.id.img_show, "field 'mImgShow'", ImageView.class);
    target.mTvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mTvName'", TextView.class);
    target.mTvLocation = Utils.findRequiredViewAsType(source, R.id.tv_location, "field 'mTvLocation'", TextView.class);
    target.mTvNum = Utils.findRequiredViewAsType(source, R.id.tv_num, "field 'mTvNum'", TextView.class);
    target.mTvStarttime = Utils.findRequiredViewAsType(source, R.id.tv_starttime, "field 'mTvStarttime'", TextView.class);
    target.mTvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTvTime'", TextView.class);
    target.mTvEndtime = Utils.findRequiredViewAsType(source, R.id.tv_endtime, "field 'mTvEndtime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_price, "field 'mTvPrice' and method 'click'");
    target.mTvPrice = Utils.castView(view, R.id.tv_price, "field 'mTvPrice'", TextView.class);
    view2131689681 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_coupon, "field 'mTvCoupon' and method 'click'");
    target.mTvCoupon = Utils.castView(view, R.id.tv_coupon, "field 'mTvCoupon'", TextView.class);
    view2131689682 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_deposit, "field 'mTvDeposit' and method 'click'");
    target.mTvDeposit = Utils.castView(view, R.id.tv_deposit, "field 'mTvDeposit'", TextView.class);
    view2131689683 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_yue, "field 'mTvYue' and method 'check'");
    target.mTvYue = Utils.castView(view, R.id.tv_yue, "field 'mTvYue'", RadioButton.class);
    view2131689686 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.check();
      }
    });
    target.mTvWechat = Utils.findRequiredViewAsType(source, R.id.tv_wechat, "field 'mTvWechat'", RadioButton.class);
    target.mTvAlipay = Utils.findRequiredViewAsType(source, R.id.tv_alipay, "field 'mTvAlipay'", RadioButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CheckOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImgShow = null;
    target.mTvName = null;
    target.mTvLocation = null;
    target.mTvNum = null;
    target.mTvStarttime = null;
    target.mTvTime = null;
    target.mTvEndtime = null;
    target.mTvPrice = null;
    target.mTvCoupon = null;
    target.mTvDeposit = null;
    target.mTvYue = null;
    target.mTvWechat = null;
    target.mTvAlipay = null;

    view2131689681.setOnClickListener(null);
    view2131689681 = null;
    view2131689682.setOnClickListener(null);
    view2131689682 = null;
    view2131689683.setOnClickListener(null);
    view2131689683 = null;
    ((CompoundButton) view2131689686).setOnCheckedChangeListener(null);
    view2131689686 = null;
  }
}
