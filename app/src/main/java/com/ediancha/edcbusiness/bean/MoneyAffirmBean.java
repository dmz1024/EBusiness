package com.ediancha.edcbusiness.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

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
            time = in.createTypedArrayList(Time.CREATOR);
            isShowAll = in.readByte() != 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(spaceId);
            dest.writeString(spaceName);
            dest.writeTypedList(time);
            dest.writeByte((byte) (isShowAll ? 1 : 0));
        }

        @Override
        public int describeContents() {
            return 0;
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
            if (time.size() != 1) {
                if (isShowAll) {
                    if (time.size() >= 3 && time.get(2).getViewType() == 1) {
                        time.remove(2);
                    }
                } else {
                    if (time.size() > 2) {
                        time.add(2, (Time) new Time().setViewType(1));
                        return (ArrayList<Time>) time.subList(0, 2);
                    }
                }
            } else {
                time.get(0).setViewType(2);
            }

            return time;
        }

        private boolean isShowAll;

        public Data setShowAll(boolean showAll) {
            isShowAll = showAll;
            return this;
        }

        public boolean isShowAll() {
            return isShowAll;
        }

        public String getSpaceId() {
            return spaceId;
        }

        public String getSpaceName() {
            return spaceName;
        }

    }

    public static class Time extends ViewBaseType implements Parcelable {
        public long chargingStartTime;
        public long chargingEndTime;
        public double fifteenCharging;

        public Time() {

        }

        protected Time(Parcel in) {
            chargingStartTime = in.readLong();
            chargingEndTime = in.readLong();
            fifteenCharging = in.readDouble();
        }

        public static final Creator<Time> CREATOR = new Creator<Time>() {
            @Override
            public Time createFromParcel(Parcel in) {
                return new Time(in);
            }

            @Override
            public Time[] newArray(int size) {
                return new Time[size];
            }
        };

        public long getChargingEndTime() {
            return chargingEndTime;
        }

        public long getChargingStartTime() {
            return chargingStartTime;
        }

        public String getFifteenCharging() {
            return fifteenCharging + "元/小时";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(chargingStartTime);
            dest.writeLong(chargingEndTime);
            dest.writeDouble(fifteenCharging);
        }
    }


}
