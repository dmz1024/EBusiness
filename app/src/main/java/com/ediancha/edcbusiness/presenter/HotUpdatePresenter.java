package com.ediancha.edcbusiness.presenter;

import com.ediancha.edcbusiness.interfaces.OnHotUpdateRelaunch;
import com.ediancha.edcbusiness.model.HotUpdateModel;
import com.taobao.sophix.SophixManager;

/**
 * Created by dengmingzhi on 2017/9/13.
 */

public class HotUpdatePresenter {
    private HotUpdateModel hotUpdateModel;

    public HotUpdatePresenter(OnHotUpdateRelaunch onHotUpdateRelaunch) {
        hotUpdateModel = new HotUpdateModel(onHotUpdateRelaunch);
    }

    public void checkUpdate(int handlePatchVersion) {
        hotUpdateModel.checkUpdate(handlePatchVersion);
    }


    public void kill() {
//        Intent intent = ctx.getPackageManager()
//                .getLaunchIntentForPackage(ctx.getPackageName());
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        ctx.startActivity(intent);
        SophixManager.getInstance().killProcessSafely();
    }

}
