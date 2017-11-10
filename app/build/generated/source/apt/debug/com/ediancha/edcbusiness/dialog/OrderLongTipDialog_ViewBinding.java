// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderLongTipDialog_ViewBinding implements Unbinder {
  private OrderLongTipDialog target;

  private View view2131689737;

  @UiThread
  public OrderLongTipDialog_ViewBinding(final OrderLongTipDialog target, View source) {
    this.target = target;

    View view;
    target.ivCha = Utils.findRequiredViewAsType(source, R.id.ivCha, "field 'ivCha'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btOut, "method 'onClick'");
    view2131689737 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderLongTipDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivCha = null;

    view2131689737.setOnClickListener(null);
    view2131689737 = null;
  }
}
