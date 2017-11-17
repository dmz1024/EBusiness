// Generated code from Butter Knife. Do not modify!
package com.ediancha.edcbusiness.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ediancha.edcbusiness.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131689718;

  private View view2131689724;

  private View view2131689726;

  private View view2131689727;

  private View view2131689729;

  private View view2131689730;

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
    view2131689718 = view;
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
    view2131689724 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tvCodeTime = Utils.findRequiredViewAsType(source, R.id.tvCodeTime, "field 'tvCodeTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btLogin, "field 'btLogin' and method 'onClick'");
    target.btLogin = Utils.castView(view, R.id.btLogin, "field 'btLogin'", Button.class);
    view2131689726 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tvXieyi, "field 'mTvXieyi' and method 'onClick'");
    target.mTvXieyi = Utils.castView(view, R.id.tvXieyi, "field 'mTvXieyi'", TextView.class);
    view2131689727 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.img_wechat, "field 'mImgWechat' and method 'onClick'");
    target.mImgWechat = Utils.castView(view, R.id.img_wechat, "field 'mImgWechat'", ImageView.class);
    view2131689729 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.img_qq, "field 'mTvQq' and method 'onClick'");
    target.mTvQq = Utils.castView(view, R.id.img_qq, "field 'mTvQq'", ImageView.class);
    view2131689730 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mThread = Utils.findRequiredViewAsType(source, R.id.thread, "field 'mThread'", LinearLayout.class);
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
    target.mTvXieyi = null;
    target.mImgWechat = null;
    target.mTvQq = null;
    target.mThread = null;

    view2131689718.setOnClickListener(null);
    view2131689718 = null;
    view2131689724.setOnClickListener(null);
    view2131689724 = null;
    view2131689726.setOnClickListener(null);
    view2131689726 = null;
    view2131689727.setOnClickListener(null);
    view2131689727 = null;
    view2131689729.setOnClickListener(null);
    view2131689729 = null;
    view2131689730.setOnClickListener(null);
    view2131689730 = null;
  }
}
