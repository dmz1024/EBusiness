package com.ediancha.edcbusiness.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;
import com.ediancha.edcbusiness.helper.share.Share;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/9/28.
 */

public class SpaceDetailBean extends BaseBean<SpaceDetailBean.Data> {


    /**
     * data : {"id":2,"spaceName":"/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceGalley":"","spaceMoney":"123.00","spaceLoadNumber":22,"spaceSquareMetre":12,"spaceAreaPath":"12","spaceCover":"","spaceAttention":"","spaceStatus":3,"spaceDesc":"北方","purpose":[{"id":194,"targetName":"情景舒适"},{"id":195,"targetName":"视野辽阔"}],"facilities":[{"id":192,"targetName":"电视"},{"id":193,"targetName":"沙发"}],"share":{"name":"/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","url":"www.baidu.com","info":"详细信息","logo":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg"},"aqi":[],"costStatement":"空间使用费每小时123.00元,每6分钟多少","howFar":0}
     */

    public static class Data {
        /**
         * id : 2
         * spaceName : /uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
         * spaceImage : s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
         * spaceGalley : 
         * spaceMoney : 123.00
         * spaceLoadNumber : 22
         * spaceSquareMetre : 12
         * spaceAreaPath : 12
         * spaceCover : 
         * spaceAttention : 
         * spaceStatus : 3
         * spaceDesc : 北方
         * purpose : [{"id":194,"targetName":"情景舒适"},{"id":195,"targetName":"视野辽阔"}]
         * facilities : [{"id":192,"targetName":"电视"},{"id":193,"targetName":"沙发"}]
         * share : {"name":"/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","url":"www.baidu.com","info":"详细信息","logo":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg"}
         * aqi : []
         * costStatement : 空间使用费每小时123.00元,每6分钟多少
         * howFar : 0
         */

        public String id;
        public String spaceName;
        public String spaceImage;
        public String spaceGalley;
        public String spaceMoney;
        public int spaceLoadNumber;
        public int spaceSquareMetre;
        public String spaceAreaPath;
        public String spaceCover;
        public String spaceAttention;
        public int spaceStatus;
        public String spaceDesc;
        public ShareBean share;
        public String costStatement;
        public String latitude;
        public String longitude;
        public int howFar;
        public ArrayList<PurposeBean> purpose;
        public ArrayList<FacilitiesBean> facilities;
        public ArrayList<?> aqi;

        public String getLatitude() {
            return latitude;
        }

        public String getLongitude() {
            return longitude;
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

        public String getSpaceGalley() {
            return spaceGalley;
        }

        public String getSpaceMoney() {
            return spaceMoney;
        }

        public int getSpaceLoadNumber() {
            return spaceLoadNumber;
        }

        public int getSpaceSquareMetre() {
            return spaceSquareMetre;
        }

        public String getSpaceAreaPath() {
            return spaceAreaPath;
        }

        public String getSpaceCover() {
            return spaceCover;
        }

        public String getSpaceAttention() {
            return spaceAttention;
        }

        public int getSpaceStatus() {
            return spaceStatus;
        }

        public String getSpaceDesc() {
            return spaceDesc;
        }

        public ShareBean getShare() {
            return share;
        }

        public String getCostStatement() {
            return costStatement;
        }

        public int getHowFar() {
            return howFar;
        }

        public ArrayList<PurposeBean> getPurpose() {
            return purpose;
        }

        public ArrayList<FacilitiesBean> getFacilities() {
            return facilities;
        }

        public ArrayList<?> getAqi() {
            return aqi;
        }
    }

    public static class ShareBean implements Share.ShareInfo{
        /**
         * name : /uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
         * url : www.baidu.com
         * info : 详细信息
         * logo : s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
         */

        public String name;
        public String url;
        public String info;
        public String logo;
        public int type;


        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public String getTitle() {
            return name;
        }

        @Override
        public String getContent() {
            return info;
        }

        @Override
        public int getType() {
            return type;
        }

        public ShareBean setType(int type) {
            this.type = type;
            return this;
        }

        @Override
        public String getAppName() {
            return null;
        }

        @Override
        public String getLogo() {
            return logo;
        }
    }

    public static class PurposeBean extends ViewBaseType {
        /**
         * id : 194
         * targetName : 情景舒适
         */

        public int id;
        public String targetName;

        @Override
        public int getViewType() {
            return 1;
        }

        public int getId() {
            return id;
        }

        public String getTargetName() {
            return targetName;
        }
    }

    public static class FacilitiesBean extends ViewBaseType{
        /**
         * id : 192
         * targetName : 电视
         */

        public int id;
        public String targetName;

        @Override
        public int getViewType() {
            return 0;
        }

        public int getId() {
            return id;
        }

        public String getTargetName() {
            return targetName;
        }
    }
}
