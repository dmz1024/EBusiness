package com.ediancha.edcbusiness.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/9/28.
 */

public class SpaceDetailBean extends BaseBean<SpaceDetailBean.Data> {


    /**
     * data : {"id":2,"spaceName":"/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceGalley":"","spaceMoney":"123.00","spaceLoadNumber":22,"spaceSquareMetre":12,"spaceAreaPath":"12","spaceCover":"","spaceAttention":"","spaceStatus":3,"latitude":0,"longitude":0,"purpose":[{"id":194,"targetName":"情景舒适"},{"id":195,"targetName":"视野辽阔"}],"facilities":[{"id":192,"targetName":"电视"},{"id":193,"targetName":"沙发"}],"share":{"name":"/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","url":"www.baidu.com","info":"详细信息","logo":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg"},"aqi":[],"costStatement":"空间使用费每小时123.00元,每6分钟多少"}
     */

    public static class Data {

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
        public int latitude;
        public int longitude;
        public ShareBean share;
        public String costStatement;
        public ArrayList<Purpose> purpose;
        public ArrayList<Facilities> facilities;
        public ArrayList<?> aqi;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSpaceName() {
            return spaceName;
        }

        public void setSpaceName(String spaceName) {
            this.spaceName = spaceName;
        }

        public String getSpaceImage() {
            return spaceImage;
        }

        public void setSpaceImage(String spaceImage) {
            this.spaceImage = spaceImage;
        }

        public String getSpaceGalley() {
            return spaceGalley;
        }

        public void setSpaceGalley(String spaceGalley) {
            this.spaceGalley = spaceGalley;
        }

        public String getSpaceMoney() {
            return spaceMoney;
        }

        public void setSpaceMoney(String spaceMoney) {
            this.spaceMoney = spaceMoney;
        }

        public int getSpaceLoadNumber() {
            return spaceLoadNumber;
        }

        public void setSpaceLoadNumber(int spaceLoadNumber) {
            this.spaceLoadNumber = spaceLoadNumber;
        }

        public int getSpaceSquareMetre() {
            return spaceSquareMetre;
        }

        public void setSpaceSquareMetre(int spaceSquareMetre) {
            this.spaceSquareMetre = spaceSquareMetre;
        }

        public String getSpaceAreaPath() {
            return spaceAreaPath;
        }

        public void setSpaceAreaPath(String spaceAreaPath) {
            this.spaceAreaPath = spaceAreaPath;
        }

        public String getSpaceCover() {
            return spaceCover;
        }

        public void setSpaceCover(String spaceCover) {
            this.spaceCover = spaceCover;
        }

        public String getSpaceAttention() {
            return spaceAttention;
        }

        public void setSpaceAttention(String spaceAttention) {
            this.spaceAttention = spaceAttention;
        }

        public int getSpaceStatus() {
            return spaceStatus;
        }

        public void setSpaceStatus(int spaceStatus) {
            this.spaceStatus = spaceStatus;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public String getCostStatement() {
            return costStatement;
        }


        public ArrayList<Purpose> getPurpose() {
            return purpose;
        }


        public ArrayList<Facilities> getFacilities() {
            return facilities;
        }

        public List<?> getAqi() {
            return aqi;
        }


        public static class ShareBean {
            /**
             * name : /uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
             * url : www.baidu.com
             * info : 详细信息
             * logo : s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
             */

            private String name;
            private String url;
            private String info;
            private String logo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
        }
    }
    public static class Purpose extends ViewBaseType{
        /**
         * id : 194
         * targetName : 情景舒适
         */

        public int id;
        public String targetName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTargetName() {
            return targetName;
        }

        public void setTargetName(String targetName) {
            this.targetName = targetName;
        }

        @Override
        public int getViewType() {
            return 1;
        }
    }

    public static class Facilities extends ViewBaseType{
        /**
         * id : 192
         * targetName : 电视
         */

        public int id;
        public String targetName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTargetName() {
            return targetName;
        }

        public void setTargetName(String targetName) {
            this.targetName = targetName;
        }

    }
}
