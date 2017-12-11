package com.youworkshop.teslanews.bean;

import java.util.List;

/**
 * Created by Tony on 2017/12/11.
 */

public class TabNewsBean {
    public NewTabBeanItem data;
    public String retcode;

    public class NewTabBeanItem{
        public String countcommenturl;
        public String more;
        public String title;

        public List<News> news;
        public List<Topnews> topnews;
        public List<Topic> topic;

    }
    public class News {
        public String comment;
        public String commentlist;
        public String commenturl;
        public String id;//此条新闻的唯一性
        public String listimage;
        public String listimage1;
        public String listimage2;
        public String pubdate;
        public String title;
        public String type;
        public String url;
    }
    public class Topnews{
        public boolean comment;
        public String commentlist;
        public String commenturl;
        public int id;
        public String pubdate;
        //标题
        public String title;
        //图片链接地址
        public String topimage;
        public String type;
        //详情页url地址
        public String url;
    }
    public class Topic{
        public String description;
        public int id;
        public String listimage;
        public String sort;
        public String title;
        public String url;
    }
}
