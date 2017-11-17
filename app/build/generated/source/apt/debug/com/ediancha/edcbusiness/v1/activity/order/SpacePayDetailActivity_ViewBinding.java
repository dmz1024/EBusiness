// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.order;

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

public class SpacePayDetailActivity_ViewBinding implements Unbinder {
  private SpacePayDetailActivity target;

  @UiThread
  public SpacePayDetailActivity_ViewBinding(SpacePayDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SpacePayDetailActivity_ViewBinding(SpacePayDetailActivity target, View source) {
    this.target = target;

    target.mTvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'mTvTime'", TextView.class);
    target.mRecyItem = Utils.findRequiredViewAsType(source, R.id.recy_item, "field 'mRecyItem'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SpacePayDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvTime = null;
    target.mRecyItem = null;
  }
}
