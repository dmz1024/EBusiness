package com.ediancha.edcbusiness.v1.activity.my;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;


import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.list.CommonAdapterHelper;
import com.dmz.library.dmzapi.dialog.ChooseStringDialog;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.utils.ResUtil;
import com.dmz.library.dmzapi.view.activity.NotNetBaseActivity;
import com.dmz.library.dmzapi.view.custom.ChooseStringView;
import com.dmz.library.dmzapi.view.custom.TipView;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.user.UserInfoUtil;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.constant.NormalContant;
import com.ediancha.edcbusiness.helper.PhotoHelper;
import com.ediancha.edcbusiness.helper.login.ILoginResultInterface;
import com.ediancha.edcbusiness.helper.login.Login;
import com.ediancha.edcbusiness.helper.login.QQLogin;
import com.ediancha.edcbusiness.presenter.my.BindThreadPresenter;
import com.ediancha.edcbusiness.presenter.my.UpdateHeaderPresenter;
import com.ediancha.edcbusiness.presenter.my.UpdateNamePresenter;
import com.ediancha.edcbusiness.router.Go;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import java.util.ArrayList;
import butterknife.BindView;

/**
 * Created by dengmingzhi on 2017/9/26.
 */
@Route(path = "/v1/activity/my/myInfo")
public class MyInfoActivity extends NotNetBaseActivity implements AdapterHelper.OnConvertInterface<CommonAdapterHelper.CommonBean>, AdapterHelper.OnClickListener, UpdateNamePresenter.IUpDateNameView, UpdateHeaderPresenter.IUpdateHeaderView, BindThreadPresenter.IBindThreadView {

    @BindView(R.id.rvContent)
    RecyclerView rvContent;
    private ArrayList<CommonAdapterHelper.CommonBean> datas;
    private AdapterHelper adapterHelper;
    private PhotoHelper mHelper;

    private UpdateNamePresenter mUpdateNamePresenter;
    private BindThreadPresenter mBindThreadPresenter;
    private UpdateHeaderPresenter mHeaderPresenter;
    private String path;
    private int type;


    @Override
    protected void initData() {
        super.initData();
        mUpdateNamePresenter = mUpdateNamePresenter != null ? mUpdateNamePresenter : new UpdateNamePresenter(this);
        mHeaderPresenter = mHeaderPresenter != null ? mHeaderPresenter : new UpdateHeaderPresenter(this);
        mBindThreadPresenter = mBindThreadPresenter != null ? mBindThreadPresenter : new BindThreadPresenter(this);


        mHelper = new PhotoHelper(this);
        datas = CommonAdapterHelper.getDatas(this, "my_info.json");
        datas.get(0).setRightImage(UserInfoUtil.getUserPhoto());
        datas.get(1).setContent(UserInfoUtil.getUserName());
        datas.get(2).setContent(UserInfoUtil.getUserSex());
        datas.get(3).setContent(UserInfoUtil.getBrithday());
        datas.get(4).setContent(UserInfoUtil.getRzInfo());
        datas.get(6).setContent(UserInfoUtil.getUserPhone());
        datas.get(7).setContent(UserInfoUtil.getWxInfo());
        datas.get(8).setContent(UserInfoUtil.getQqInfo());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setAutoMeasureEnabled(true);
        adapterHelper = AdapterHelper._instance(this, rvContent)._initData(datas).setLayoutManager(manager)
                .setType(new AdapterHelper.ViewTypeInfo().setType(4).setRid(ResUtil.getLayoutId(4)))
                .setType(new AdapterHelper.ViewTypeInfo().setType(6).setRid(ResUtil.getLayoutId(6)))
                .setType(new AdapterHelper.ViewTypeInfo().setType(5).setRid(ResUtil.getLayoutId(5)).setConvertInterface(this).setOnClickListener(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(3).setRid(ResUtil.getLayoutId(3)).setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    public void convert(int viewType, ViewHolder holder, CommonAdapterHelper.CommonBean commonBean, int position) {
        holder.setText(R.id.tvTitle, commonBean.getTitle());
        switch (viewType) {
            case 5:
                Glide.with(this).load(commonBean.getRightImage()).into(holder.<ImageView>getView(R.id.ivRight));
                break;
            case 3:
                holder.setText(R.id.tvContent, commonBean.getContent());
                TextView textView = holder.<TextView>getView(R.id.tvContent);
                textView.setCompoundDrawables(null, null, ResUtil.setDra(this, ResUtil.getMipResId(this, commonBean.getRightImage())), null);
                break;
        }
    }

    QQLogin login;

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {

        switch (position) {
            case 0:
                ChooseStringDialog.getInstance()
                        .setiChooseItem(new ChooseStringView.IChooseItem() {
                            @Override
                            public void position(int pos) {
                                if(pos==0){
                                    mHelper.openPhoto();
                                }else {
                                    mHelper.showCameraAction();
                                }
                            }
                        }).addData("相册选择", "拍照").show(this);
                break;
            case 1:
                Go.goUpdateInfoActivity(this, "修改昵称");
                break;
            case 4:
                if(UserInfoUtil.getRz()==1){
                    Go.goUserAuther();
                }
                break;
            case 7:
                type = 1;
                if (UserInfoUtil.getWx() == 1) {
                    Login.getLogin(0).setListener(loginResultInterface).start(this);
                } else {
                    unBindThird();
                }
                break;
            case 8:
                type = 2;
                if (UserInfoUtil.getQq() == 1) {
                    login = (QQLogin) Login.getLogin(1);
                    login.setListener(loginResultInterface).start(this);
                } else {
                    unBindThird();

                }
                break;
        }
    }

    private ILoginResultInterface loginResultInterface = new ILoginResultInterface() {
        @Override
        public void onSuccess(String info) {
            String token = type == 1 ? "" : info.split(",")[1];
            String key = type == 1 ? info : info.split(",")[0];
            mBindThreadPresenter.bindThread(type, token, key);
        }

        @Override
        public void onCancel() {
            MyToast.normal("您取消了"+(type == 1 ? "微信" : "QQ")+"绑定!");
        }

        @Override
        public void onFaile() {
            MyToast.normal((type == 1 ? "微信" : "QQ")+"绑定失败!");
        }
    };

    private void unBindThird() {
        String typeInfo = type == 1 ? "微信" : "QQ";
        TipView.getInstance()
                .setTitle("解除" + typeInfo + "绑定")
                .setContent("解除" + typeInfo + "绑定后您将不能使用" + typeInfo + "进行快捷登录！")
                .setBottom(new TipView.BottomInfo("确定解除", new TipView.OnClickListener() {
                    @Override
                    public void OnClick() {
                        mBindThreadPresenter.unBindThread(type);
                    }
                })).show(this);
    }

    @Override
    protected int getRid() {
        return R.layout.activity_my_info;
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("我的资料");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == NormalContant.RESULT_NAME_CODE) {
            String name = data.getStringExtra(NormalContant.KEY);
            if (!TextUtils.isEmpty(name)) {
                UserInfoUtil.saveProperty("userName", name);
                datas.get(1).setContent(UserInfoUtil.getUserName());
                adapterHelper.notifyDataSetChanged();
            }
        } else {
            if (mHelper.chcckPhoto(requestCode, resultCode)) {
                String path = mHelper.onActivityResult(requestCode, data);
                mHeaderPresenter.updateHeader(path);
            }
        }

        if (login != null) {
            login.onActivity(requestCode, resultCode, data);
        }
    }

    @Override
    public void responseCode(BaseBean bean) {
        if (bean.getCode() == NormalContant.SUCCESS_CODE) {
            UserInfoUtil.saveProperty("userPhoto", ApiContant.BASE_API_HOST + path);
            datas.get(0).setRightImage(UserInfoUtil.getUserPhoto());
            adapterHelper.notifyDataSetChanged();
        }
    }

    @Override
    public void success(String path) {
        this.path = path;
        mUpdateNamePresenter.UpdateName(UserInfoUtil.getUserName(), path);
    }

    @Override
    public void successCode() {
        MyToast.normal("绑定成功!");
        UserInfoUtil.saveProperty(type == 2 ? "qq" : "wx", 2);
        adapterHelper.notifyDataSetChanged();
    }

    @Override
    public void unBindSuccess() {
        MyToast.normal("解除绑定成功!");
        UserInfoUtil.saveProperty(type == 2 ? "qq" : "wx", 1);
        adapterHelper.notifyDataSetChanged();
    }
}
