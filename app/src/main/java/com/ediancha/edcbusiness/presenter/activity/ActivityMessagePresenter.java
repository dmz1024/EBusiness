package com.ediancha.edcbusiness.presenter.activity;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.view.IContextView;

/**
 * Created by Admin on 2017/10/13.
 */

public class ActivityMessagePresenter {

    private IActivityMessageView mActivityMessageView;

    public ActivityMessagePresenter(IActivityMessageView mActivityMessageView) {
        this.mActivityMessageView = mActivityMessageView;
    }

    public void activityMessage() {

    }


    public interface IActivityMessageView extends IContextView {

    }
}
