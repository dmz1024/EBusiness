package com.ediancha.edcbusiness.v1.activity.my;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dmz.library.dmzapi.api.contract.SingleDataBuilder;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.list.CommonAdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.utils.ResUtil;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.TipView;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.router.Go;
import com.ediancha.edcbusiness.v1.bean.SetBean;
import com.ediancha.edcbusiness.v1.dialog.DealDialog;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by dengmingzhi on 2017/11/13.
 */
@Route(path = "/v1/activity/my/set")
public class SetActivity extends SingleDataBaseActivity<SetBean, SetBean.Data> implements AdapterHelper.OnConvertInterface<CommonAdapterHelper.CommonBean>, AdapterHelper.OnClickListener {
    @BindView(R.id.rvContent)
    RecyclerView rvContent;
    private ArrayList<CommonAdapterHelper.CommonBean> datas;
    private AdapterHelper adapterHelper;

    @Override
    public void onSuccess(IBasePresenter presenter, SetBean.Data bean) {

        datas.get(0).setType(bean.getSpaceMessage());
        datas.get(1).setType(bean.getMoneyMessage());
        datas.get(2).setType(bean.getActivityMessage());
        adapterHelper.notifyDataSetChanged();
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setCurrentViewEnum(SingleDataBuilder.ShowViewEnum.SUCCESSVIEW)
                .setSuccessRid(R.layout.success_set);
    }

    @Override
    protected void initData() {
        super.initData();
        datas = CommonAdapterHelper.getDatas(this, "my_set.json");
        adapterHelper = AdapterHelper._instance(this, rvContent)._initData(datas).setLayoutManager(new LinearLayoutManager(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(4).setRid(ResUtil.getLayoutId(4)))
                .setType(new AdapterHelper.ViewTypeInfo().setType(7).setRid(ResUtil.getLayoutId(7)).setConvertInterface(this).setOnClickListener(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(8).setRid(ResUtil.getLayoutId(8)).setConvertInterface(this).setOnClickListener(this));
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setUrl(ApiContant.SET).setaClass(SetBean.class);
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("设置");
    }

    @Override
    public void convert(int viewType, ViewHolder holder, CommonAdapterHelper.CommonBean commonBean, int position) {
        holder.setText(R.id.tvTitle, commonBean.getTitle());
        switch (viewType) {
            case 8:
                TextView textView = holder.getView(R.id.tvTitle);
                textView.setCompoundDrawables(null, null, ResUtil.setDra(this, ResUtil.getMipResId(this, commonBean.getRightImage())), null);
                break;
            case 7:
                ImageView imageView = holder.getView(R.id.ivRight);
                imageView.setImageResource(ResUtil.getDraResId(this, commonBean.getRightImage()));
                imageView.setImageLevel(commonBean.getType());
                break;
        }
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        switch (position) {
            case 0:
                datas.get(0).setType(datas.get(0).getType() == 0 ? 1 : 0);
                adapterHelper.notifyDataSetChanged();
                break;
            case 1:
                datas.get(1).setType(datas.get(1).getType() == 0 ? 1 : 0);
                adapterHelper.notifyDataSetChanged();
                break;
            case 2:
                datas.get(2).setType(datas.get(2).getType() == 0 ? 1 : 0);
                adapterHelper.notifyDataSetChanged();
                break;
            case 4:
                //用户协议
                DealDialog.getInstance().setTitle("用户协议").setUrl("https://www.baidu.com").show(this);
                break;
            case 6:
                //关于我们
                DealDialog.getInstance().setTitle("关于我们").setUrl("https://www.baidu.com").show(this);
                break;
            case 5:
                TipView.getInstance().setTitle("清除缓存").setContent("缓存清除后将会重新请求网络资源！").setBottom("确定清除", new TipView.OnClickListener() {
                    @Override
                    public void OnClick() {
                        MyToast.normal("成功清除缓存");
                    }
                }).show(this);
                break;

            case 8:
                Go.goLimitsActivity();
                break;

        }
    }
}
