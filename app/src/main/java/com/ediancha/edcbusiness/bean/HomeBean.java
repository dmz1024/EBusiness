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


    /**
     * data : {"spaceList":[{"id":2,"spaceName":"/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceAreaPath":"12","spaceDesc":"北方","howFar":0},{"id":3,"spaceName":"阿斯蒂芬","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceAreaPath":"安防1","spaceDesc":"北方","howFar":0},{"id":1,"spaceName":"北方明珠大厦-明珠店","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceAreaPath":"北方明珠大厦","spaceDesc":"北方","howFar":7940.81},{"id":4,"spaceName":"12","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceAreaPath":"123","spaceDesc":"北方","howFar":8088.82},{"id":5,"spaceName":"12","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceAreaPath":"123","spaceDesc":"北方","howFar":8088.82}]}
     */

    public static class Data {
        public ArrayList<SpaceListBean> spaceList;

        public ArrayList<SpaceListBean> getSpaceList() {
            return spaceList;
        }
    }


    public static class SpaceListBean extends ViewBaseType{
        /**
         * id : 2
         * spaceName : /uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
         * spaceImage : s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
         * spaceAreaPath : 12
         * spaceDesc : 北方
         * howFar : 0
         */
        public String id;
        public String spaceName;
        public String spaceImage;
        public String spaceAreaPath;
        public String spaceDesc;
        public String howFar;

        public String getId() {
            return id;
        }

        public String getSpaceName() {
            return spaceName;
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
    }
}
