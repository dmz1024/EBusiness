// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.my;

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

public class AutherActivity_ViewBinding implements Unbinder {
  private AutherActivity target;

  private View view2131689661;

  @UiThread
  public AutherActivity_ViewBinding(AutherActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AutherActivity_ViewBinding(final AutherActivity target, View source) {
    this.target = target;

    View view;
    target.mTvInfo = Utils.findRequiredViewAsType(source, R.id.tv_info, "field 'mTvInfo'", TextView.class);
    target.mTvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'mTvName'", EditText.class);
    target.mTvCard = Utils.findRequiredViewAsType(source, R.id.tv_card, "field 'mTvCard'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'mTvSubmit' and method 'click'");
    target.mTvSubmit = Utils.castView(view, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
    view2131689661 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AutherActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvInfo = null;
    target.mTvName = null;
    target.mTvCard = null;
    target.mTvSubmit = null;

    view2131689661.setOnClickListener(null);
    view2131689661 = null;
  }
}
