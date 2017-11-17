// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.v1.activity.space;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amap.api.maps.MapView;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MapSpaceActivity_ViewBinding implements Unbinder {
  private MapSpaceActivity target;

  private View view2131689748;

  private View view2131689689;

  @UiThread
  public MapSpaceActivity_ViewBinding(MapSpaceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MapSpaceActivity_ViewBinding(final MapSpaceActivity target, View source) {
    this.target = target;

    View view;
    target.rlTop = Utils.findRequiredViewAsType(source, R.id.rlTop, "field 'rlTop'", RelativeLayout.class);
    target.map = Utils.findRequiredViewAsType(source, R.id.map, "field 'map'", MapView.class);
    target.ivSpace = Utils.findRequiredViewAsType(source, R.id.ivSpace, "field 'ivSpace'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    target.tvAddress = Utils.findRequiredViewAsType(source, R.id.tvAddress, "field 'tvAddress'", TextView.class);
    target.tvDesc = Utils.findRequiredViewAsType(source, R.id.tvDesc, "field 'tvDesc'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ivLoad, "field 'ivLoad' and method 'load'");
    target.ivLoad = Utils.castView(view, R.id.ivLoad, "field 'ivLoad'", ImageView.class);
    view2131689748 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.load();
      }
    });
    target.ivWo = Utils.findRequiredViewAsType(source, R.id.ivWo, "field 'ivWo'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ivHome, "method 'goHome'");
    view2131689689 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.goHome();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MapSpaceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rlTop = null;
    target.map = null;
    target.ivSpace = null;
    target.tvTitle = null;
    target.tvAddress = null;
    target.tvDesc = null;
    target.ivLoad = null;
    target.ivWo = null;

    view2131689748.setOnClickListener(null);
    view2131689748 = null;
    view2131689689.setOnClickListener(null);
    view2131689689 = null;
  }
}
