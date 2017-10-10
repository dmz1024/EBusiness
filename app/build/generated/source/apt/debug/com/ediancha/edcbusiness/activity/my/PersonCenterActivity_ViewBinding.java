// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonCenterActivity_ViewBinding implements Unbinder {
  private PersonCenterActivity target;

  private View view2131689700;

  private View view2131689659;

  @UiThread
  public PersonCenterActivity_ViewBinding(PersonCenterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonCenterActivity_ViewBinding(final PersonCenterActivity target, View source) {
    this.target = target;

    View view;
    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rvContent, "field 'rvContent'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.iv_header, "field 'ivHeader' and method 'onClick'");
    target.ivHeader = Utils.castView(view, R.id.iv_header, "field 'ivHeader'", ImageView.class);
    view2131689700 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ivCha, "field 'ivCha' and method 'onClick'");
    target.ivCha = Utils.castView(view, R.id.ivCha, "field 'ivCha'", ImageView.class);
    view2131689659 = view;
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
    PersonCenterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvContent = null;
    target.ivHeader = null;
    target.ivCha = null;

    view2131689700.setOnClickListener(null);
    view2131689700 = null;
    view2131689659.setOnClickListener(null);
    view2131689659 = null;
  }
}
