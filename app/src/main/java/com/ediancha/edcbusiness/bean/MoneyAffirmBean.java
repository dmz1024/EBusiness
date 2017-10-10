package com.ediancha.edcbusiness.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.dmz.library.dmzapi.api.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/10/9.
 */

public class MoneyAffirmBean extends BaseBean<MoneyAffirmBean.Data> {
    public static class Data implements Parcelable {
        public String spaceId;
        public String spaceName;
        public ArrayList<Time> time;

        public Data() {
        }

        protected Data(Parcel in) {
            spaceId = in.readString();
            spaceName = in.readString();
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

        public ArrayList<Time> getTime() {
            return time;
        }

        public String getSpaceId() {
            return spaceId;
        }

        public String getSpaceName() {
            return spaceName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(spaceId);
            dest.writeString(spaceName);
        }
    }

    public static class Time {
        public long chargingStartTime;
        public long chargingEndTime;
        public double fifteenCharging;

        public long getChargingEndTime() {
            return chargingEndTime;
        }

        public long getChargingStartTime() {
            return chargingStartTime;
        }

        public double getFifteenCharging() {
            return fifteenCharging;
        }
    }


}
