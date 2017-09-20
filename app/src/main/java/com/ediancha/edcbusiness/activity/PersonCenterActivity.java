package com.ediancha.edcbusiness.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.dmz.library.dmzapi.view.activity.BaseActivity;
import com.ediancha.edcbusiness.R;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

public class PersonCenterActivity extends BaseActivity implements View.OnClickListener, AdapterHelper.OnConvertInterface<IType> {
    private View ivCha;
    private RecyclerView rvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_center);
        ivCha = findViewById(R.id.ivCha);
        rvContent = findViewById(R.id.rvContent);
        ivCha.setOnClickListener(this);
        scaleAndTran();
        initRv();
    }

    private ArrayList<IType> datas = new ArrayList<>();
    private String[] titles = {"我的行程", "我的钱包", "邀请好友", "兑优惠券", "我的客服"};

    private void initRv() {

        final AdapterHelper adapterHelper = AdapterHelper._instance(this, rvContent)
                ._initData(datas)
                .setLayoutManager(new LinearLayoutManager(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setRid(R.layout.item_person_center_info).setConvertInterface(this))
                .setType(new AdapterHelper.ViewTypeInfo().setType(2).setRid(R.layout.item_title_view).setConvertInterface(this));


        ivCha.postDelayed(new Runnable() {
            @Override
            public void run() {
                datas.add(new TleInfo().setTel("183****7257").setContent("已认证.信用分 100").setViewType(1));
                adapterHelper.notifyDataSetChanged();
            }
        }, 300);

        for (int i = 0; i < titles.length; i++) {
            final int finalI = i;
            ivCha.postDelayed(new Runnable() {
                @Override
                public void run() {
                    datas.add(new ItemInfo().setTitle(titles[finalI]).setViewType(2));
                    adapterHelper.notifyDataSetChanged();
                }
            }, (i + 2) * 300);
        }
    }


    private void scaleAndTran() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(ivCha, "X",
                ScreenUtil.getScreenWidth(getContext()), ScreenUtil.getScreenWidth(getContext()) - ScreenUtil.dp2px(this, 40));
        anim.setDuration(800);
        anim.start();
    }


    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void convert(int viewType, ViewHolder holder, IType iType, int position) {
        switch (viewType) {
            case 1:
                TleInfo telInfo = (TleInfo) iType;
                holder.setText(R.id.tvTle, telInfo.getTel()).setText(R.id.tvContent, telInfo.getContent());
                break;
            case 2:
                ItemInfo itemInfo = (ItemInfo) iType;
                holder.setText(R.id.tvTitle, itemInfo.getTitle());
                break;
        }
    }

    public static class TleInfo extends ViewBaseType {
        private String tel;
        private String content;

        public String getContent() {
            return content;
        }

        public String getTel() {
            return tel;
        }

        public TleInfo setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public TleInfo setContent(String content) {
            this.content = content;
            return this;
        }
    }


    public static class ItemInfo extends ViewBaseType {
        private String title;


        public String getTitle() {
            return title;
        }

        public ItemInfo setTitle(String title) {
            this.title = title;
            return this;
        }
    }
}
