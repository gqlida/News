package com.youworkshop.teslanews.bean;

import java.util.List;

/**
 * Created by Tony on 2017/12/10.
 */

public class NewCenterBean {
    public int retcode;
    public List<NewCenterBeanItem> data;
    public List<String> extend;

    public class NewCenterBeanItem{
        public List<Children> children;
        public String id;
        public String title;
        public String type;
        public String url;
        public String url1;
        public String dayurl;
        public String excurl;
        public String weekurl;
    }
    public class Children{
        public String id;
        public String title;
        public String type;
        public String url;
    }
}
