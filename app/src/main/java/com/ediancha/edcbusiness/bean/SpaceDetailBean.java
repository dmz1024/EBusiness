package com.ediancha.edcbusiness.bean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/9/28.
 */

public class SpaceDetailBean extends BaseBean<SpaceDetailBean.Data> {

    public static class Data{

        private int id;
        private String spaceName;
        private String spaceImage;
        private String spaceGalley;
        private String spaceMoney;
        private int spaceLoadNumber;
        private int spaceSquareMetre;
        private String spaceAreaPath;
        private String spaceCover;
        private String spaceAttention;
        private int spaceStatus;
        private double latitude;
        private double longitude;
        private String shareImage;
        private String shareTitle;
        private String shareUrl;
        private String shareDesc;
        private ShareBean share;
        private AqiBean aqi;
        private String costStatement;
        private ArrayList<PurposeBean> purpose;
        private ArrayList<FacilitiesBean> facilities;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getShareImage() {
            return shareImage;
        }

        public void setShareImage(String shareImage) {
            this.shareImage = shareImage;
        }

        public String getShareTitle() {
            return shareTitle;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getShareDesc() {
            return shareDesc;
        }

        public void setShareDesc(String shareDesc) {
            this.shareDesc = shareDesc;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public String getCostStatement() {
            return costStatement;
        }

        public void setCostStatement(String costStatement) {
            this.costStatement = costStatement;
        }

        public ArrayList<PurposeBean> getPurpose() {
            return purpose;
        }

        public void setPurpose(ArrayList<PurposeBean> purpose) {
            this.purpose = purpose;
        }

        public ArrayList<FacilitiesBean> getFacilities() {
            return facilities;
        }

        public void setFacilities(ArrayList<FacilitiesBean> facilities) {
            this.facilities = facilities;
        }

        public static class ShareBean {


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

        public static class AqiBean {

            private InrdoorBean inrdoor;
            private OutdoorBean outdoor;

            public InrdoorBean getInrdoor() {
                return inrdoor;
            }

            public void setInrdoor(InrdoorBean inrdoor) {
                this.inrdoor = inrdoor;
            }

            public OutdoorBean getOutdoor() {
                return outdoor;
            }

            public void setOutdoor(OutdoorBean outdoor) {
                this.outdoor = outdoor;
            }

            public static class InrdoorBean {


                private String aqi;
                private String aq;
                private String a;
                private int type;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getAq() {
                    return aq;
                }

                public void setAq(String aq) {
                    this.aq = aq;
                }

                public String getA() {
                    return a;
                }

                public void setA(String a) {
                    this.a = a;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class OutdoorBean {


                private String aqi;
                private String aq;
                private String a;
                private int type;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getAq() {
                    return aq;
                }

                public void setAq(String aq) {
                    this.aq = aq;
                }

                public String getA() {
                    return a;
                }

                public void setA(String a) {
                    this.a = a;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }
        }
    }
    public static class PurposeBean extends ViewBaseType{

        private int id;
        private int type;
        private String targetName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

    public static class FacilitiesBean extends ViewBaseType{

        private int id;
        private int type;
        private String targetName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTargetName() {
            return targetName;
        }

        public void setTargetName(String targetName) {
            this.targetName = targetName;
        }

        @Override
        public int getViewType() {
            return 0;
        }
    }
}
