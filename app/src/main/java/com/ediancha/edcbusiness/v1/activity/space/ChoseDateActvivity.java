package com.ediancha.edcbusiness.v1.activity.space;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.bean.IType;
import com.dmz.library.dmzapi.api.list.AdapterHelper;
import com.dmz.library.dmzapi.api.presenter.IBasePresenter;
import com.dmz.library.dmzapi.utils.MyToast;
import com.dmz.library.dmzapi.view.activity.SingleDataBaseActivity;
import com.dmz.library.dmzapi.view.custom.DmzBar;
import com.dmz.library.dmzapi.view.custom.TipView;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.bean.ChoseDateBean;
import com.ediancha.edcbusiness.constant.ApiContant;
import com.ediancha.edcbusiness.helper.ImageLoader;
import com.github.czy1121.view.CornerLabelView;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;


import butterknife.BindView;


/**
 * 选择时段
 *
 * @author Admin
 * @date 2017/11/6
 */
@Route(path = "/v1/activity/space/chosedate")
public class ChoseDateActvivity extends SingleDataBaseActivity<ChoseDateBean, ChoseDateBean.Data> implements AdapterHelper.OnConvertInterface, AdapterHelper.OnClickListener {
//    @BindView(R.id.img_show)
//    ImageView mImgShow;
//    @BindView(R.id.tv_name)
//    TextView mTvName;
//    @BindView(R.id.tv_location)
//    TextView mTvLocation;
//    @BindView(R.id.tv_num)
//    TextView mTvNum;


//    @BindView(R.id.tv_price)
//    TextView mTvPrice;
//    @BindView(R.id.tv_detail)
//    TextView mTvDetail;
//    @BindView(R.id.tv_submit)
//    TextView mTvSubmit;
//    @BindView(R.id.tvTime)
//    TextView tvTime;

    @BindView(R.id.rvContent)
    RecyclerView rvContent;

    private ImageView ivHome;
    private TextView tvTitle;
    private TextView tvAddress;
    private TextView tvDesc;

    AdapterHelper adapterHelper;

    @Override
    protected void initView() {
        super.initView();
        ivHome = findViewById(R.id.ivHome);
        tvTitle = findViewById(R.id.tvTitle);
        tvAddress = findViewById(R.id.tvAddress);
        tvDesc = findViewById(R.id.tvDesc);

//        Glide.with(this).load(ApiContant.IMAGE).into(ivHome);
        ImageLoader.loadCircu(this, ApiContant.IMAGE, ivHome);
    }

    @Override
    public void onSuccess(IBasePresenter presenter, final ChoseDateBean.Data data) {

        ArrayList<ChoseDateBean.SpaceReserveBean> spaceReserve = data.getSpaceReserve();
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(ctx, 4);

        adapterHelper = AdapterHelper._instance(this, rvContent)._initData(spaceReserve).setLayoutManager(gridLayoutManager)
                .setType(new AdapterHelper.ViewTypeInfo().setType(1).setConvertInterface(this).setRid(R.layout.item_datechose))
//                .setType(new AdapterHelper.ViewTypeInfo().setType(2).setConvertInterface(this).setRid(R.layout.item_datechose))
                .setType(new AdapterHelper.ViewTypeInfo().setType(3).setConvertInterface(this).setRid(R.layout.item_chose)
                        .setOnClickListener(this));
        adapterHelper.getRvContent().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                ChoseDateBean.SpaceReserveBean t = adapterHelper.getT(firstVisibleItemPosition);
//                tvTime.setText(t.getDayName());
            }
        });

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                switch (adapterHelper.getAdapter().getItemViewType(i)) {
                    case 1:
                        return 1;
                    case 2:
                        return 1;
                    default:
                        return 4;
                }
            }
        });

//        tvTime.setText(data.getDayName());
    }

    @Override
    protected void initDataBuilder() {
        mBuilder.setSuccessRid(R.layout.success_recyle_view);
    }

    @Override
    protected void initDmzBuilder() {
        dBuilder.setaClass(ChoseDateBean.class)
                .setUrl(ApiContant.CHOSEDTAE_URL);
    }

    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("选择时段")
                .addItemView(new DmzBar.DmzBarItemInfo().setTvColor("#fcc01f").setTitle("计费规则"))
                .setOnItemOnClickListener(new DmzBar.OnItemOnClickListener() {
                    @Override
                    public void itemClick(int index) {
                        TipView.getInstance().setTitle("计费规则")
                                .setContent("以半小时为准，每半小时前15分钟内扫码需多支付15分钟费用，角标显示为半价后15分钟内扫码无需支付费用，角标显示赠送。")
                                .setShowCancel(false).setBottom("确定").show(getContext());
                    }
                });
    }

//    @OnClick({R.id.tv_submit})
//    void click(View view) {
//        switch (view.getId()) {
//            case R.id.tv_submit:
//                Go.goCheckOrderActivity();
//                break;
//        }
//    }


    @Override
    public void convert(final int viewType, ViewHolder holder, IType iType, final int position) {
        final ChoseDateBean.SpaceReserveBean spaceReserveBean = (ChoseDateBean.SpaceReserveBean) iType;
        switch (viewType) {
            case 1:
                if (TextUtils.isEmpty(spaceReserveBean.getSplitName())) {
                    holder
                            .setText(R.id.tv_data, spaceReserveBean.getDayName());
                } else {
                    holder
                            .setText(R.id.tv_data, spaceReserveBean.getSplitName());
                }
                break;
            case 3:
                String stepTimeStart = spaceReserveBean.getStepTimeStart() + "\n￥" + spaceReserveBean.getStepMoney();
                holder.setText(R.id.rb_chose, stepTimeStart);
                CornerLabelView labelView = holder.<CornerLabelView>getView(R.id.img_status);
                if (!TextUtils.isEmpty(spaceReserveBean.getStepMark())) {
                    labelView.setVisibility(View.VISIBLE);
                    labelView.setText1(spaceReserveBean.getStepMark());
                } else {
                    labelView.setVisibility(View.GONE);
                }
                boolean isChoose = spaceReserveBean.isChose;
                holder.setChecked(R.id.rb_chose, isChoose);
                break;
        }

    }


    private int location;//点击的位置
    private int nextLocation;//根据选中的判断
    private boolean isFirst;//false 表示第一次点击

    //chose表示选择
    @Override
    public void onItemClick(int viewType, AdapterHelper adapterHelper, int position) {
        ChoseDateBean.SpaceReserveBean spaceReserveBean = adapterHelper.getT(position);
        if (!spaceReserveBean.isClick()) {
            return;
        }
        ArrayList<ChoseDateBean.SpaceReserveBean> spaceReserveBeans = (ArrayList<ChoseDateBean.SpaceReserveBean>) adapterHelper.getDatas();

        int size = spaceReserveBeans.size();

        int maxIndex = -1;
        int minIndex = -1;
        for (int i = 0; i < size; i++) {
            if (spaceReserveBeans.get(i).getViewType() == 3 && spaceReserveBeans.get(i).isChose()) {
                minIndex = i;
                break;
            }
        }
        if (minIndex != -1) {
            for (int i = size - 1; i >= minIndex; i--) {
                Log.d("maxi", i + "");
                if (spaceReserveBeans.get(i).getViewType() == 3 && spaceReserveBeans.get(i).isChose()) {
                    maxIndex = i;
                    break;
                }
            }
        }
        if (minIndex != -1) {
            if (position < minIndex) {
                int canChooseCount = 0;
                int noChoosePosition = -1;
                for (int i = position; i <= minIndex; i++) {
                    if (spaceReserveBeans.get(i).getViewType() == 3) {
                        if (spaceReserveBeans.get(i).isClick()) {
                            canChooseCount += 1;
                        } else {
                            noChoosePosition = position;
                            break;
                        }
                    }
                }

                if (canChooseCount <= 1) {
                    int i = position - 1;
                    if (i >= 0) {
                        if (spaceReserveBeans.get(i).getViewType() == 3 && spaceReserveBeans.get(i).isClick()) {
                            canChooseCount += 1;
                        }
                    }
                }

                if (canChooseCount > 1) {
                    if (noChoosePosition != -1) {
                        for (int i = minIndex; i <= maxIndex; i++) {
                            ChoseDateBean.SpaceReserveBean bean = spaceReserveBeans.get(i);
                            if (bean.getViewType() == 3) {
                                bean.setChose(false);
                            }
                        }
                        spaceReserveBean.setChose(true);
                    } else {
                        for (int i = position; i <= maxIndex; i++) {
                            ChoseDateBean.SpaceReserveBean bean = spaceReserveBeans.get(i);
                            if (bean.getViewType() == 3) {
                                bean.setChose(true);
                            }
                        }
                    }

                } else {
                    MyToast.warn("请至少选择两个连续的时间段");
                }
            } else if (position > maxIndex) {

                int canChooseCount = 0;
                int noChoosePosition = -1;
                for (int i = maxIndex; i <= position; i++) {
                    if (spaceReserveBeans.get(i).getViewType() == 3) {
                        if (spaceReserveBeans.get(i).isClick()) {
                            canChooseCount += 1;
                        } else {
                            noChoosePosition = position;
                            break;
                        }
                    }
                }
                if (canChooseCount <= 1) {
                    int i = maxIndex - 1;
                    if (i >= 0) {
                        if (spaceReserveBeans.get(i).getViewType() == 3 && spaceReserveBeans.get(i).isClick()) {
                            canChooseCount += 1;
                        }
                    }
                }

                if (canChooseCount > 1) {
                    if (noChoosePosition != -1) {
                        for (int i = minIndex; i <= maxIndex; i++) {
                            ChoseDateBean.SpaceReserveBean bean = spaceReserveBeans.get(i);
                            if (bean.getViewType() == 3) {
                                bean.setChose(false);
                            }
                        }
                        spaceReserveBean.setChose(true);
                    } else {
                        for (int i = maxIndex; i <= position; i++) {
                            ChoseDateBean.SpaceReserveBean bean = spaceReserveBeans.get(i);
                            if (bean.getViewType() == 3) {
                                bean.setChose(true);
                            }
                        }
                    }

                } else {
                    MyToast.warn("请至少选择两个连续的时间段");
                }
            }else {
                int min = Math.abs(position - minIndex);
                int max = Math.abs(maxIndex - position);
                if (min>=max){
                    for (int i = position; i <= maxIndex; i++) {
                        ChoseDateBean.SpaceReserveBean bean = spaceReserveBeans.get(i);
                        if (bean.getViewType() == 3) {
                            bean.setChose(false);
                        }
                    }
                }else{
                    for (int i = minIndex; i <= position; i++) {
                        ChoseDateBean.SpaceReserveBean bean = spaceReserveBeans.get(i);
                        if (bean.getViewType() == 3) {
                            bean.setChose(false);
                        }
                    }
                }
            }
        } else {
            spaceReserveBean.setChose(true);
        }
        adapterHelper.notifyDataSetChanged();
    }

    /**
     * 选择
     */
    private void setFirstChose() {

    }


    @Override
    protected int getRid() {
        return R.layout.activity_choose_time;
    }
}
