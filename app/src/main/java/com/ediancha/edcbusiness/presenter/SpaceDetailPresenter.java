package com.ediancha.edcbusiness.presenter;

import com.dmz.library.dmzapi.api.DmzApi;
import com.dmz.library.dmzapi.api.DmzBuilder;
import com.dmz.library.dmzapi.api.OnMySuccessListener;
import com.dmz.library.dmzapi.api.view.IContextView;
import com.dmz.library.dmzapi.view.MyProgress;
import com.ediancha.edcbusiness.bean.SpaceDetailBean;
import com.ediancha.edcbusiness.constant.ApiContant;

/**
 * Created by Admin on 2017/10/17.
 */

public class SpaceDetailPresenter {

    private ISpaceDetailView mISpaceDetailView;

    public SpaceDetailPresenter(ISpaceDetailView spaceDetailView) {
        this.mISpaceDetailView = spaceDetailView;
    }

    public void getSpaceDetail(String id, String longitude, String latitude) {
        DmzApi._build().setDmzBuilder(DmzBuilder._builder()
                .setaClass(SpaceDetailBean.class)
                .setUrl(ApiContant.SPACEDETAIL_URL)
                .setAll(true)
                .setOnMySuccessListener(new OnMySuccessListener<SpaceDetailBean>() {
                    @Override
                    public void onSuccess(SpaceDetailBean bean) {
                        mISpaceDetailView.successCode(bean);
                    }
                })
                .setParms("id", id, "longitude", longitude, "latitude", latitude)
                .setiLoadingView(new MyProgress(mISpaceDetailView.getContext())))
                .excute();
    }


    public interface ISpaceDetailView extends IContextView {

        void successCode(SpaceDetailBean bean);
    }
}
