// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.message;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityMessageActivity_ViewBinding implements Unbinder {
  private ActivityMessageActivity target;

  @UiThread
  public ActivityMessageActivity_ViewBinding(ActivityMessageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityMessageActivity_ViewBinding(ActivityMessageActivity target, View source) {
    this.target = target;

    target.rvActivity = Utils.findRequiredViewAsType(source, R.id.rvActivity, "field 'rvActivity'", RecyclerView.class);
    target.tvShape = Utils.findRequiredViewAsType(source, R.id.tvShape, "field 'tvShape'", TextView.class);
    target.tvChong = Utils.findRequiredViewAsType(source, R.id.tvChong, "field 'tvChong'", TextView.class);
    target.tvDui = Utils.findRequiredViewAsType(source, R.id.tvDui, "field 'tvDui'", TextView.class);
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
  }
}
