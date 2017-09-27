package com.dmz.library.dmzapi.view.custom;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmz.library.dmzapi.R;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.utils.ScreenUtil;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/9/27.
 */

public class ChooseStringView extends LinearLayout implements AdapterHelper.OnConvertInterface<ChooseStringView.IChooseString>, AdapterHelper.OnClickListener {
    private RecyclerView rvContent;

    public ChooseStringView(Context context) {
        this(context, null);
    }

    public ChooseStringView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private ArrayList<IChooseString> datas = new ArrayList<>();
    private AdapterHelper adapterHelper;

    private void init(Context context) {
        View.inflate(context, R.layout.success_recyle_view, this);
        rvContent = findViewById(R.id.rvContent);

        adapterHelper = AdapterHelper._instance(context, rvContent)._initData(datas).setLayoutManager(new LinearLayoutManager(getContext()))
                .setType(new AdapterHelper.ViewTypeInfo()
                        .setRid(R.layout.item_choose_string).setConvertInterface(this).setOnClickListener(this))
                .setType(new AdapterHelper.ViewTypeInfo()
                        .setRid(R.layout.item_choose_string).setType(1).setConvertInterface(this).setOnClickListener(this));
    }

    public <T extends IChooseString> void setData(ArrayList<T> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        this.datas.add(new ChooseStringBean().setTitle("取消").setViewType(1));

//        LayoutParams layoutParams = (LayoutParams) rvContent.getLayoutParams();
//        layoutParams.height = datas.size() > 7 ? (ScreenUtil.dp2px(7 * 45)) : ScreenUtil.dp2px(datas.size() * 45);
        adapterHelper.notifyDataSetChanged();
    }

    @Override
    public void convert(int viewType, ViewHolder holder, IChooseString iChooseString, int position) {
        holder.setText(R.id.tvTitle, iChooseString.getTitle());
        holder.<TextView>getView(R.id.tvTitle).setTextColor(Color.parseColor(viewType == 0 ? "#333333" : "#999999"));
    }

    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        Log.d("点击", position + "");
        switch (viewType) {
            case 1:
                iChooseCancel.cancel();
                break;
            case 0:
                iChooseCancel.cancel();
                if (iChooseItem != null) {
                    iChooseItem.position(position);
                }
                if (itemTitle != null) {
                    iChooseCancel.cancel();
                    itemTitle.content(position, datas.get(position));
                }
                break;
        }
    }

    public interface IChooseItem {
        void position(int position);
    }

    public interface IChooseItemTitle<T extends IChooseString> {
        void content(int position, T title);
    }

    public interface IChooseCancel {
        void cancel();
    }

    private IChooseItem iChooseItem;
    private IChooseItemTitle itemTitle;
    private IChooseCancel iChooseCancel;

    public ChooseStringView setItemTitle(IChooseItemTitle itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }

    public ChooseStringView setiChooseCancel(IChooseCancel iChooseCancel) {
        this.iChooseCancel = iChooseCancel;
        return this;
    }

    public ChooseStringView setiChooseItem(IChooseItem iChooseItem) {
        this.iChooseItem = iChooseItem;
        return this;
    }

    public interface IChooseString extends IType {
        String getTitle();
    }

    public static class ChooseStringBean implements IChooseString {
        private String title;

        public ChooseStringBean setTitle(String title) {
            this.title = title;
            return this;
        }

        private int iViewType;

        @Override
        public int getViewType() {
            return iViewType;
        }

        @Override
        public ChooseStringBean setViewType(int type) {
            this.iViewType = type;
            return this;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }
}
