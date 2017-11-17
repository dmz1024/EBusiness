// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.help;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HelpCenterActivity_ViewBinding implements Unbinder {
  private HelpCenterActivity target;

  private View view2131689959;

  @UiThread
  public HelpCenterActivity_ViewBinding(HelpCenterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HelpCenterActivity_ViewBinding(final HelpCenterActivity target, View source) {
    this.target = target;

    View view;
    target.mRecyOne = Utils.findRequiredViewAsType(source, R.id.recy_one, "field 'mRecyOne'", RecyclerView.class);
    target.mRecyTwo = Utils.findRequiredViewAsType(source, R.id.recy_two, "field 'mRecyTwo'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_fankuai, "field 'mTvFankuai' and method 'onClick'");
    target.mTvFankuai = Utils.castView(view, R.id.tv_fankuai, "field 'mTvFankuai'", TextView.class);
    view2131689959 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HelpCenterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyOne = null;
    target.mRecyTwo = null;
    target.mTvFankuai = null;

    view2131689959.setOnClickListener(null);
    view2131689959 = null;
  }
}
