// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.view.ViewpagerNoScroll;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  private View view2131689710;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(final HomeActivity target, View source) {
    this.target = target;

    View view;
    target.mVpShow = Utils.findRequiredViewAsType(source, R.id.vp_show, "field 'mVpShow'", ViewpagerNoScroll.class);
    target.mRbOne = Utils.findRequiredViewAsType(source, R.id.rb_one, "field 'mRbOne'", RadioButton.class);
    target.mRbTwo = Utils.findRequiredViewAsType(source, R.id.rb_two, "field 'mRbTwo'", RadioButton.class);
    target.mRbThree = Utils.findRequiredViewAsType(source, R.id.rb_three, "field 'mRbThree'", RadioButton.class);
    target.mRgChose = Utils.findRequiredViewAsType(source, R.id.rg_chose, "field 'mRgChose'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.fgQw, "method 'qw'");
    view2131689710 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.qw();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mVpShow = null;
    target.mRbOne = null;
    target.mRbTwo = null;
    target.mRbThree = null;
    target.mRgChose = null;

    view2131689710.setOnClickListener(null);
    view2131689710 = null;
  }
}
