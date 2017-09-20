package com.dmz.library.dmzapi.api.list;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dmz.library.dmzapi.api.bean.IType;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dengmingzhi on 2017/9/5.
 */

public class AdapterHelper {

    protected Context ctx;
    protected RecyclerView rvContent;

    private AdapterHelper(Context ctx, RecyclerView rvContent) {
        this.ctx = ctx;
        this.rvContent = rvContent;
    }


    public List getDatas() {
        return adapter.getDatas();
    }

    public <T> T getT(int position) {
        return (T) adapter.getDatas().get(position);
    }

    public static AdapterHelper _instance(Context ctx, RecyclerView rvContent) {
        return new AdapterHelper(ctx, rvContent);
    }

    public AdapterHelper _initData(final ArrayList<IType> datas) {
        adapter = new MultiItemTypeAdapter(ctx, datas) {
            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (onLoadMoreInterface != null && position == datas.size() - 1) {
                    onLoadMoreInterface.loadMore();
                }
            }
        };
        rvContent.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                ViewTypeInfo viewTypeInfo = listenerMap.get(datas.get(position).getViewType());

                if (viewTypeInfo != null && viewTypeInfo.getOnClickListener() != null) {
                    viewTypeInfo.getOnClickListener().onItemClick(datas.get(position).getViewType(), AdapterHelper.this, position);
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                ViewTypeInfo viewTypeInfo = listenerMap.get(datas.get(position).getViewType());
                if (viewTypeInfo != null && viewTypeInfo.getOnLongClickListener() != null) {
                    viewTypeInfo.getOnLongClickListener().onLongClick(datas.get(position).getViewType(), AdapterHelper.this, position);
                    return true;
                }
                return false;
            }
        });
        return this;
    }


    public AdapterHelper addItemAnimator(RecyclerView.ItemAnimator animator) {
        rvContent.setItemAnimator(animator);
        return this;
    }


    private Map<Integer, ViewTypeInfo> listenerMap = new HashMap<>();

    public interface OnLoadMoreInterface {
        void loadMore();
    }

    private OnLoadMoreInterface onLoadMoreInterface;

    public AdapterHelper setOnLoadMoreInterface(OnLoadMoreInterface onLoadMoreInterface) {
        this.onLoadMoreInterface = onLoadMoreInterface;
        return this;
    }

    public RecyclerView getRvContent() {
        return rvContent;
    }

    public MultiItemTypeAdapter getAdapter() {
        return adapter;
    }


    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

    private MultiItemTypeAdapter adapter;

    public AdapterHelper setType(ArrayList<ViewTypeInfo> typeInfos) {
        if (typeInfos != null) {
            for (int i = 0; i < typeInfos.size(); i++) {
                final ViewTypeInfo typeInfo = typeInfos.get(i);
                setType(typeInfo);

            }
        }
        return this;
    }

    private void initListener(ViewTypeInfo typeInfo) {

        if (typeInfo.getOnClickListener() != null || typeInfo.getOnLongClickListener() != null) {
            listenerMap.put(typeInfo.getType(), typeInfo);
        }
    }

    public AdapterHelper setType(final ViewTypeInfo typeInfo) {
        adapter.addItemViewDelegate(new ItemViewDelegate<IType>() {
            @Override
            public int getItemViewLayoutId() {
                return typeInfo.getRid();
            }

            @Override
            public boolean isForViewType(IType item, int position) {
                return item.getViewType() == typeInfo.getType();
            }

            @Override
            public void convert(ViewHolder holder, IType d, int position) {
                if (typeInfo.getConvertInterface() != null) {
                    typeInfo.getConvertInterface().convert(d.getViewType(), holder, d, position);
                }
            }

        });

        initListener(typeInfo);

        return this;
    }

    public interface OnConvertInterface<D extends IType> {
        void convert(int viewType, ViewHolder holder, D d, int position);
    }

    public interface OnClickListener {
        void onItemClick(int viewType, AdapterHelper adapterHelper, int position);
    }

    public interface OnLongClickListener {
        void onLongClick(int viewType, AdapterHelper adapterHelper, int position);
    }


    public static class ViewTypeInfo {
        private int rid;
        private OnConvertInterface convertInterface;
        private int type;
        private OnClickListener onClickListener;
        private OnLongClickListener onLongClickListener;

        public ViewTypeInfo setOnClickListener(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }

        public OnClickListener getOnClickListener() {
            return onClickListener;
        }

        public OnLongClickListener getOnLongClickListener() {
            return onLongClickListener;
        }

        public ViewTypeInfo setOnLongClickListener(OnLongClickListener onLongClickListener) {
            this.onLongClickListener = onLongClickListener;
            return this;
        }

        public ViewTypeInfo setType(int type) {
            this.type = type;
            return this;
        }

        public int getRid() {
            return rid;
        }

        public int getType() {
            return type;
        }

        public OnConvertInterface getConvertInterface() {
            return convertInterface;
        }

        public ViewTypeInfo setRid(int rid) {
            this.rid = rid;
            return this;
        }

        public ViewTypeInfo setConvertInterface(OnConvertInterface convertInterface) {
            this.convertInterface = convertInterface;
            return this;
        }
    }

    public AdapterHelper setLayoutManager(RecyclerView.LayoutManager manager) {

        if (manager instanceof GridLayoutManager) {
            final int spanCount = ((GridLayoutManager) manager).getSpanCount();

            ((GridLayoutManager) manager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return ((IType) getDatas().get(position)).getViewType() >= 100000 ? spanCount : 1;
                }
            });
        }

        rvContent.setLayoutManager(manager);

        return this;
    }


}
