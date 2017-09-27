package com.ediancha.edcbusiness.bean.walletbean;

import com.dmz.library.dmzapi.api.bean.BaseBean;
import com.dmz.library.dmzapi.api.bean.ViewBaseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/9/26.
 * 帮助中心
 */

public class HelpCenterBean extends BaseBean<HelpCenterBean.Data> {


    public static class Data {
        public ArrayList<HotBean> hot;
        public ArrayList<TypeBean> type;

        public ArrayList<HotBean> getHot() {
            return hot;
        }



        public ArrayList<TypeBean> getType() {
            return type;
        }


        public static class HotBean extends ViewBaseType{

            public String title;
            public int ID;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }
        }

        public static class TypeBean extends ViewBaseType{


            public String title;
            public int ID;

            public String getTitle() {
                return title;
            }

            @Override
            public int getViewType() {
                return 1;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }
        }
    }
}
