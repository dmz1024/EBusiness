// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MoneyAffirmActivity_ViewBinding implements Unbinder {
  private MoneyAffirmActivity target;

  private View view2131689757;

  @UiThread
  public MoneyAffirmActivity_ViewBinding(MoneyAffirmActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MoneyAffirmActivity_ViewBinding(final MoneyAffirmActivity target, View source) {
    this.target = target;

    View view;
    target.ivLogo = Utils.findRequiredViewAsType(source, R.id.ivLogo, "field 'ivLogo'", ImageView.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tvShopName, "field 'tvShopName'", TextView.class);
    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rvContent, "field 'rvContent'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.btUse, "method 'userSpace'");
    view2131689757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.userSpace();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MoneyAffirmActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivLogo = null;
    target.tvShopName = null;
    target.rvContent = null;

    view2131689757.setOnClickListener(null);
    view2131689757 = null;
  }
}
