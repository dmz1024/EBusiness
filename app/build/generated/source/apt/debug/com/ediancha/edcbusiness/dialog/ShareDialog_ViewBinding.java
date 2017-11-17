// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.dialog;

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

public class ShareDialog_ViewBinding implements Unbinder {
  private ShareDialog target;

  @UiThread
  public ShareDialog_ViewBinding(ShareDialog target, View source) {
    this.target = target;

    target.mTvCancel = Utils.findRequiredViewAsType(source, R.id.tv_cancel, "field 'mTvCancel'", TextView.class);
    target.mRecy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'mRecy'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShareDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvCancel = null;
    target.mRecy = null;
  }
}
