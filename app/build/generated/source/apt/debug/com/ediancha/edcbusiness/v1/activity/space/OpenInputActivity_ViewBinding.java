// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OpenInputActivity_ViewBinding implements Unbinder {
  private OpenInputActivity target;

  private View view2131689714;

  private View view2131689715;

  @UiThread
  public OpenInputActivity_ViewBinding(OpenInputActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OpenInputActivity_ViewBinding(final OpenInputActivity target, View source) {
    this.target = target;

    View view;
    target.mEtInput = Utils.findRequiredViewAsType(source, R.id.et_input, "field 'mEtInput'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_open, "field 'mTvOpen' and method 'onClick'");
    target.mTvOpen = Utils.castView(view, R.id.tv_open, "field 'mTvOpen'", TextView.class);
    view2131689714 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mImgOpen = Utils.findRequiredViewAsType(source, R.id.img_open, "field 'mImgOpen'", ImageView.class);
    target.mTvStatus = Utils.findRequiredViewAsType(source, R.id.tv_status, "field 'mTvStatus'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ln_open, "method 'onClick'");
    view2131689715 = view;
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
    OpenInputActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEtInput = null;
    target.mTvOpen = null;
    target.mImgOpen = null;
    target.mTvStatus = null;

    view2131689714.setOnClickListener(null);
    view2131689714 = null;
    view2131689715.setOnClickListener(null);
    view2131689715 = null;
  }
}
