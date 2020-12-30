package com.example.myapplication.model;

import java.util.List;

/*
{"status":200,"message":"OK","devMessage":null,"data":[{"id":1,"title":"友情链接","fullPath":"http://47.113.204.48/links","routeName":"LinkList","available":true},{"id":2,"title":"图库页面","fullPath":"http://47.113.204.48/photos","routeName":"PhotoList","available":true},{"id":3,"title":"日志页面","fullPath":"http://47.113.204.48/journals","routeName":"JournalList","available":true}]}
 */
public class PageParam {

    private int status;
    private String message;
    private String devMessage;
    private List<Data> data;
    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }
    public String getDevMessage() {
        return devMessage;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
    }
    public static class Data{
        private int id;
        private String title;
        private String fullPath;
        private String routeName;
        private boolean available;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setFullPath(String fullPath) {
            this.fullPath = fullPath;
        }
        public String getFullPath() {
            return fullPath;
        }

        public void setRouteName(String routeName) {
            this.routeName = routeName;
        }
        public String getRouteName() {
            return routeName;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
        public boolean getAvailable() {
            return available;
        }

    }
}
