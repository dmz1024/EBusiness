// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MoneyAffirmActivity_ViewBinding implements Unbinder {
  private MoneyAffirmActivity target;

  @UiThread
  public MoneyAffirmActivity_ViewBinding(MoneyAffirmActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MoneyAffirmActivity_ViewBinding(MoneyAffirmActivity target, View source) {
    this.target = target;

    target.ivLogo = Utils.findRequiredViewAsType(source, R.id.ivLogo, "field 'ivLogo'", ImageView.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tvShopName, "field 'tvShopName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MoneyAffirmActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivLogo = null;
    target.tvShopName = null;
  }
}
