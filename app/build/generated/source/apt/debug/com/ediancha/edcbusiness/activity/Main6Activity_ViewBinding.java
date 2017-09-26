// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Main6Activity_ViewBinding implements Unbinder {
  private Main6Activity target;

  @UiThread
  public Main6Activity_ViewBinding(Main6Activity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Main6Activity_ViewBinding(Main6Activity target, View source) {
    this.target = target;

    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tvContent, "field 'tvContent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Main6Activity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvContent = null;
  }
}
