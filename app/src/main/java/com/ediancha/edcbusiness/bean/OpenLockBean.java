package com.ediancha.edcbusiness.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.dmz.library.dmzapi.api.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/10/10.
 */

public class OpenLockBean extends BaseBean<OpenLockBean.Data> {
    public static class Data implements Parcelable{
        public String orderId;
        public String spaceId;
        public String spaceName;
        public long orderStartTime;
        public Data(){}
        protected Data(Parcel in) {
            orderId = in.readString();
            spaceId = in.readString();
            spaceName = in.readString();
            orderStartTime = in.readLong();
        }

        public static final Creator<Data> CREATOR = new Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public Data[] newArray(int size) {
                return new Data[size];
            }
        };

        public String getSpaceName() {
            return spaceName;
        }

        public String getSpaceId() {
            return spaceId;
        }

        public String getOrderId() {
            return orderId;
        }

        public long getOrderStartTime() {
            return orderStartTime;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(orderId);
            dest.writeString(spaceId);
            dest.writeString(spaceName);
            dest.writeLong(orderStartTime);
        }
    }
}
