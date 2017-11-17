// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DealDialog_ViewBinding implements Unbinder {
  private DealDialog target;

  private View view2131689835;

  @UiThread
  public DealDialog_ViewBinding(final DealDialog target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tvAgree, "field 'tvAgree' and method 'agree'");
    target.tvAgree = Utils.castView(view, R.id.tvAgree, "field 'tvAgree'", TextView.class);
    view2131689835 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.agree();
      }
    });
    target.webview = Utils.findRequiredViewAsType(source, R.id.webview, "field 'webview'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DealDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.tvAgree = null;
    target.webview = null;

    view2131689835.setOnClickListener(null);
    view2131689835 = null;
  }
}
