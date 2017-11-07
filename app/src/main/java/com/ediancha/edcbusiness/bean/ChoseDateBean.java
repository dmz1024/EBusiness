package com.ediancha.edcbusiness.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/11/6.
 */

public class ChoseDateBean extends BaseBean<ChoseDateBean.Data> {

    public static class Data {
        public String dayName;
        public String id;
        public String spaceName;
        public String spaceImage;
        public ArrayList<String> days;
        public ArrayList<SpaceReserveBean> spaceReserve;

        public String getDayName() {
            return dayName;
        }

        public Data setDayName(String dayName) {
            this.dayName = dayName;
            return this;
        }

        public String getId() {
            return id;
        }

        public String getSpaceName() {
            return spaceName;
        }

        public String getSpaceImage() {
            return spaceImage;
        }

        public ArrayList<String> getDays() {
            return days;
        }

        public ArrayList<SpaceReserveBean> getSpaceReserve() {
            if(spaceReserve.size()>0){
                dayName=spaceReserve.get(0).getDayName();
                spaceReserve.remove(0);
            }
            return spaceReserve;
        }
    }

    public static class SpaceReserveBean extends ViewBaseType {
        public String type;
        public int dayIndex;
        public String dayId;
        public String dayName;
        public String splitName;
        public String stepId;
        public String stepTimeStart;
        public String stepTimeEnd;
        public int stepMoney;
        public int stepStatus;
        public boolean stepChecked;
        public String stepMark;
        public boolean cleanTime;
        public String stepDay;
        public int stepIndex;
        public boolean isClick;
        public boolean isChose;

        public SpaceReserveBean setClick(boolean click) {
            isClick = click;
            return this;
        }

        public boolean isClick() {
            if (stepStatus==2){
                isClick=false;
            }else {
                isClick=true;
            }
            return isClick;
        }

        public boolean isChose() {
            return isChose;
        }

        public SpaceReserveBean setChose(boolean chose) {
            isChose = chose;
            return this;
        }

        @Override
        public int getViewType() {
            switch (type) {
                case "day":
                    return 1;
                case "split":
                    return 1;
                default:
                    return 3;
            }
        }

        public String getType() {
            return type;
        }

        public SpaceReserveBean setType(String type) {
            this.type = type;
            return this;
        }

        public int getDayIndex() {
            return dayIndex;
        }

        public SpaceReserveBean setDayIndex(int dayIndex) {
            this.dayIndex = dayIndex;
            return this;
        }

        public String getDayId() {
            return dayId;
        }

        public SpaceReserveBean setDayId(String dayId) {
            this.dayId = dayId;
            return this;
        }

        public String getDayName() {
            return dayName;
        }

        public SpaceReserveBean setDayName(String dayName) {
            this.dayName = dayName;
            return this;
        }

        public String getSplitName() {
            return splitName;
        }

        public SpaceReserveBean setSplitName(String splitName) {
            this.splitName = splitName;
            return this;
        }

        public String getStepId() {
            return stepId;
        }

        public SpaceReserveBean setStepId(String stepId) {
            this.stepId = stepId;
            return this;
        }

        public String getStepTimeStart() {
            return stepTimeStart;
        }

        public SpaceReserveBean setStepTimeStart(String stepTimeStart) {
            this.stepTimeStart = stepTimeStart;
            return this;
        }

        public String getStepTimeEnd() {
            return stepTimeEnd;
        }

        public SpaceReserveBean setStepTimeEnd(String stepTimeEnd) {
            this.stepTimeEnd = stepTimeEnd;
            return this;
        }

        public int getStepMoney() {
            return stepMoney;
        }

        public SpaceReserveBean setStepMoney(int stepMoney) {
            this.stepMoney = stepMoney;
            return this;
        }

        public int getStepStatus() {
            return stepStatus;
        }

        public SpaceReserveBean setStepStatus(int stepStatus) {
            this.stepStatus = stepStatus;
            return this;
        }

        public boolean isStepChecked() {
            return stepChecked;
        }

        public SpaceReserveBean setStepChecked(boolean stepChecked) {
            this.stepChecked = stepChecked;
            return this;
        }

        public String getStepMark() {
            return stepMark;
        }

        public SpaceReserveBean setStepMark(String stepMark) {
            this.stepMark = stepMark;
            return this;
        }

        public boolean isCleanTime() {
            return cleanTime;
        }

        public SpaceReserveBean setCleanTime(boolean cleanTime) {
            this.cleanTime = cleanTime;
            return this;
        }

        public String getStepDay() {
            return stepDay;
        }

        public SpaceReserveBean setStepDay(String stepDay) {
            this.stepDay = stepDay;
            return this;
        }

        public int getStepIndex() {
            return stepIndex;
        }

        public SpaceReserveBean setStepIndex(int stepIndex) {
            this.stepIndex = stepIndex;
            return this;
        }
    }
}
