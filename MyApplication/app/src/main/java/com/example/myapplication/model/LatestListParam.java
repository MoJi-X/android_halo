package com.example.myapplication.model;

import java.util.List;

public class LatestListParam {
    private int status;
    private String message;
    private String devMessage;
    public List<Data> data;
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
        private String logKey;
        private String type;
        private String content;
        private String ipAddress;
        private long createTime;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setLogKey(String logKey) {
            this.logKey = logKey;
        }
        public String getLogKey() {
            return logKey;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }
        public String getIpAddress() {
            return ipAddress;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }
        public long getCreateTime() {
            return createTime;
        }
    }
}
