// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131689659;

  private View view2131689665;

  private View view2131689668;

  private View view2131689669;

  private View view2131689667;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ivCha, "field 'ivCha' and method 'onClick'");
    target.ivCha = Utils.castView(view, R.id.ivCha, "field 'ivCha'", ImageView.class);
    view2131689659 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.etName = Utils.findRequiredViewAsType(source, R.id.etName, "field 'etName'", AutoCompleteTextView.class);
    target.etCode = Utils.findRequiredViewAsType(source, R.id.etCode, "field 'etCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tvCode, "field 'tvCode' and method 'onClick'");
    target.tvCode = Utils.castView(view, R.id.tvCode, "field 'tvCode'", TextView.class);
    view2131689665 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tvCodeTime = Utils.findRequiredViewAsType(source, R.id.tvCodeTime, "field 'tvCodeTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btLogin, "field 'btLogin' and method 'onClick'");
    target.btLogin = Utils.castView(view, R.id.btLogin, "field 'btLogin'", Button.class);
    view2131689668 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tvNoLogin, "field 'tvNoLogin' and method 'onClick'");
    target.tvNoLogin = Utils.castView(view, R.id.tvNoLogin, "field 'tvNoLogin'", TextView.class);
    view2131689669 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tvXieyi, "method 'onClick'");
    view2131689667 = view;
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
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivCha = null;
    target.etName = null;
    target.etCode = null;
    target.tvCode = null;
    target.tvCodeTime = null;
    target.btLogin = null;
    target.tvNoLogin = null;

    view2131689659.setOnClickListener(null);
    view2131689659 = null;
    view2131689665.setOnClickListener(null);
    view2131689665 = null;
    view2131689668.setOnClickListener(null);
    view2131689668 = null;
    view2131689669.setOnClickListener(null);
    view2131689669 = null;
    view2131689667.setOnClickListener(null);
    view2131689667 = null;
  }
}
