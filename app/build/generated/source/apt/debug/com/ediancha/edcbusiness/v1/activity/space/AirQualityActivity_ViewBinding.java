// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.space;

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

public class AirQualityActivity_ViewBinding implements Unbinder {
  private AirQualityActivity target;

  @UiThread
  public AirQualityActivity_ViewBinding(AirQualityActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AirQualityActivity_ViewBinding(AirQualityActivity target, View source) {
    this.target = target;

    target.ivIn = Utils.findRequiredViewAsType(source, R.id.ivIn, "field 'ivIn'", ImageView.class);
    target.tvInAir = Utils.findRequiredViewAsType(source, R.id.tvInAir, "field 'tvInAir'", TextView.class);
    target.tvInAirNum = Utils.findRequiredViewAsType(source, R.id.tvInAirNum, "field 'tvInAirNum'", TextView.class);
    target.tvInShiDu = Utils.findRequiredViewAsType(source, R.id.tvInShiDu, "field 'tvInShiDu'", TextView.class);
    target.tvInWenDu = Utils.findRequiredViewAsType(source, R.id.tvInWenDu, "field 'tvInWenDu'", TextView.class);
    target.tvInAddress = Utils.findRequiredViewAsType(source, R.id.tvInAddress, "field 'tvInAddress'", TextView.class);
    target.ivOut = Utils.findRequiredViewAsType(source, R.id.ivOut, "field 'ivOut'", ImageView.class);
    target.tvOutAir = Utils.findRequiredViewAsType(source, R.id.tvOutAir, "field 'tvOutAir'", TextView.class);
    target.tvOutAirNum = Utils.findRequiredViewAsType(source, R.id.tvOutAirNum, "field 'tvOutAirNum'", TextView.class);
    target.tvOutShiDu = Utils.findRequiredViewAsType(source, R.id.tvOutShiDu, "field 'tvOutShiDu'", TextView.class);
    target.tvOutWenDu = Utils.findRequiredViewAsType(source, R.id.tvOutWenDu, "field 'tvOutWenDu'", TextView.class);
    target.tvOutAddress = Utils.findRequiredViewAsType(source, R.id.tvOutAddress, "field 'tvOutAddress'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AirQualityActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivIn = null;
    target.tvInAir = null;
    target.tvInAirNum = null;
    target.tvInShiDu = null;
    target.tvInWenDu = null;
    target.tvInAddress = null;
    target.ivOut = null;
    target.tvOutAir = null;
    target.tvOutAirNum = null;
    target.tvOutShiDu = null;
    target.tvOutWenDu = null;
    target.tvOutAddress = null;
  }
}
