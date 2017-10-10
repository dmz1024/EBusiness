// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.message;

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

public class ActivityMessageActivity_ViewBinding implements Unbinder {
  private ActivityMessageActivity target;

  private View view2131689803;

  private View view2131689804;

  private View view2131689805;

  @UiThread
  public ActivityMessageActivity_ViewBinding(ActivityMessageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityMessageActivity_ViewBinding(final ActivityMessageActivity target, View source) {
    this.target = target;

    View view;
    target.rvActivity = Utils.findRequiredViewAsType(source, R.id.rvActivity, "field 'rvActivity'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tvShape, "field 'tvShape' and method 'onclick'");
    target.tvShape = Utils.castView(view, R.id.tvShape, "field 'tvShape'", TextView.class);
    view2131689803 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tvChong, "field 'tvChong' and method 'onclick'");
    target.tvChong = Utils.castView(view, R.id.tvChong, "field 'tvChong'", TextView.class);
    view2131689804 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tvDui, "field 'tvDui' and method 'onclick'");
    target.tvDui = Utils.castView(view, R.id.tvDui, "field 'tvDui'", TextView.class);
    view2131689805 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onclick(p0);
      }
    });
    target.rvMessage = Utils.findRequiredViewAsType(source, R.id.rvMessage, "field 'rvMessage'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ActivityMessageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvActivity = null;
    target.tvShape = null;
    target.tvChong = null;
    target.tvDui = null;
    target.rvMessage = null;

    view2131689803.setOnClickListener(null);
    view2131689803 = null;
    view2131689804.setOnClickListener(null);
    view2131689804 = null;
    view2131689805.setOnClickListener(null);
    view2131689805 = null;
  }
}
