// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AutherDialog_ViewBinding implements Unbinder {
  private AutherDialog target;

  private View view2131689645;

  private View view2131689643;

  @UiThread
  public AutherDialog_ViewBinding(final AutherDialog target, View source) {
    this.target = target;

    View view;
    target.mTvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    target.mTvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mTvName'", TextView.class);
    target.mTvCard = Utils.findRequiredViewAsType(source, R.id.tv_card, "field 'mTvCard'", TextView.class);
    target.mTvInfo = Utils.findRequiredViewAsType(source, R.id.tv_info, "field 'mTvInfo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_back, "field 'mTvBack' and method 'onClick'");
    target.mTvBack = Utils.castView(view, R.id.tv_back, "field 'mTvBack'", TextView.class);
    view2131689645 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_ok, "field 'mTvOk' and method 'onClick'");
    target.mTvOk = Utils.castView(view, R.id.tv_ok, "field 'mTvOk'", TextView.class);
    view2131689643 = view;
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
    AutherDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvTitle = null;
    target.mTvName = null;
    target.mTvCard = null;
    target.mTvInfo = null;
    target.mTvBack = null;
    target.mTvOk = null;

    view2131689645.setOnClickListener(null);
    view2131689645 = null;
    view2131689643.setOnClickListener(null);
    view2131689643 = null;
  }
}
