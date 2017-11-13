package com.ediancha.edcbusiness.v1.dialog;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.dmz.library.dmzapi.view.NoTitleDialoggFragment;
import com.ediancha.edcbusiness.R;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dengmingzhi on 2017/11/13.
 */

public class SpaceDescDialog extends NoTitleDialoggFragment implements AdapterHelper.OnConvertInterface<SpaceDescDialog.DescBean> {


    @BindView(R.id.rvContent)
    RecyclerView rvContent;

    public static SpaceDescDialog getInstance() {
        return new SpaceDescDialog();
    }

    @Override
    protected int getRid() {
        return R.layout.dialog_space_desc;
    }

    @Override
    protected int getGravity() {
        return Gravity.BOTTOM;
    }


    @Override
    protected void initData(View view) {
        super.initData(view);
        ArrayList<DescBean> datas = new ArrayList<>();
        datas.add(new DescBean("可容纳人数：15人"));
        datas.add(new DescBean("空间面积：15m"));
        datas.add(new DescBean("空间楼层：15层"));
        AdapterHelper._instance(getContext(), rvContent)
                ._initData(datas)
                .setLayoutManager(new LinearLayoutManager(getContext()))
                .setType(new AdapterHelper.ViewTypeInfo()
                        .setRid(R.layout.item_space_desc_dialog).setConvertInterface(this));
    }


    @OnClick(R.id.ivCancel)
    void cancel() {
        dismiss();
    }

    @Override
    public void convert(int viewType, ViewHolder holder, DescBean descBean, int position) {
        holder.setText(R.id.tvContent, descBean.getContent());
    }


    public static class DescBean extends ViewBaseType {
        public String content;

        public String getContent() {
            return content;
        }

        public DescBean(String content) {
            this.content = content;
        }
    }
}
