// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.help;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FanKuiActivity_ViewBinding implements Unbinder {
  private FanKuiActivity target;

  @UiThread
  public FanKuiActivity_ViewBinding(FanKuiActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FanKuiActivity_ViewBinding(FanKuiActivity target, View source) {
    this.target = target;

    target.mTvType = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'mTvType'", TextView.class);
    target.mEtContent = Utils.findRequiredViewAsType(source, R.id.et_content, "field 'mEtContent'", EditText.class);
    target.mLnImage = Utils.findRequiredViewAsType(source, R.id.ln_image, "field 'mLnImage'", LinearLayout.class);
    target.mIvImage = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'mIvImage'", ImageView.class);
    target.mTvSubmit = Utils.findRequiredViewAsType(source, R.id.tv_submit, "field 'mTvSubmit'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FanKuiActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvType = null;
    target.mEtContent = null;
    target.mLnImage = null;
    target.mIvImage = null;
    target.mTvSubmit = null;
  }
}
