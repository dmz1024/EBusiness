package com.ediancha.edcbusiness.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/10/9.
 */

public class HomeBean extends BaseBean<HomeBean.Data> {

    public static class Data {
        public ArrayList<SpaceBean> space;
        public ArrayList<CommentBean> comment;
        public ArrayList<AdsBean> ads;

        public ArrayList<SpaceBean> getSpaceList() {
            return space;
        }

        public ArrayList<CommentBean> getComment() {
            return comment;
        }

        public ArrayList<AdsBean> getAds() {
            return ads;
        }
    }


    public static class SpaceBean{

        public String title;
        public String subTitle;
        public ArrayList<SpaceListBean> spaceList;

        public String getTitle() {
            return title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public ArrayList<SpaceListBean> getSpaceList() {
            return spaceList;
        }
    }

    public static class CommentBean{

        public String title;
        public String subTitle;
        public ArrayList<SpaceCommentBean> spaceList;

        public String getTitle() {
            return title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public ArrayList<SpaceCommentBean> getSpaceList() {
            return spaceList;
        }
    }

    /**
     * 广告
     */
    public static class AdsBean{
        public String id;
        public String link_url;
        public String images;
        public String jump_type;

        public String getId() {
            return id;
        }

        public String getLink_url() {
            return link_url;
        }

        public String getImages() {
            return images;
        }

        public String getJump_type() {
            return jump_type;
        }
    }

    /**
     * 空间推荐
     */
    public static class SpaceListBean extends ViewBaseType{
        public String id;
        public String spaceName;
        public String spaceLoadNumber;
        public String spaceImage;
        public String spaceAreaPath;
        public String spaceDesc;
        public String howFar;
        public String is_tui;
        public String[] labelname;

        public String getId() {
            return id;
        }

        public String getSpaceName() {
            return spaceName;
        }

        public String getSpaceLoadNumber() {
            return spaceLoadNumber;
        }

        public String getSpaceImage() {
            return spaceImage;
        }

        public String getSpaceAreaPath() {
            return spaceAreaPath;
        }

        public String getSpaceDesc() {
            return spaceDesc;
        }

        public String getHowFar() {
            return howFar;
        }

        public String getIs_tui() {
            return is_tui;
        }

        public String[] getLabelname() {
            return labelname;
        }
    }

    /**
     * 为你推荐
     */
    public static class SpaceCommentBean extends ViewBaseType{
        public String content;
        public String images;
        public String createTime;
        public String nickname;
        public String head_img;

        public String getContent() {
            return content;
        }

        public String getImages() {
            return images;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getNickname() {
            return nickname;
        }

        public String getHead_img() {
            return head_img;
        }
    }

}
