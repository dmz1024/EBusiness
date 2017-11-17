// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateInfoActivity_ViewBinding implements Unbinder {
  private UpdateInfoActivity target;

  @UiThread
  public UpdateInfoActivity_ViewBinding(UpdateInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateInfoActivity_ViewBinding(UpdateInfoActivity target, View source) {
    this.target = target;

    target.mDmzBar = Utils.findRequiredViewAsType(source, R.id.dmzBar, "field 'mDmzBar'", DmzBar.class);
    target.mEtKey = Utils.findRequiredViewAsType(source, R.id.et_key, "field 'mEtKey'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDmzBar = null;
    target.mEtKey = null;
  }
}
