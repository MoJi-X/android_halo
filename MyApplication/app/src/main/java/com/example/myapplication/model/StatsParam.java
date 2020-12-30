package com.example.myapplication.model;

public class StatsParam {
    private int status;
    private String message;
    private String devMessage;
    private Data data;
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

    public void setDevmessage(String devmessage) {
        this.devMessage = devmessage;
    }
    public String getDevmessage() {
        return devMessage;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }
    public static class Data{
     //   @JsonProperty("postCount")
        private int postCount;
     //   @JsonProperty("commentCount")
        private int commentCount;
       // @JsonProperty("categoryCount")
        private int categoryCount;
       // @JsonProperty("attachmentCount")
        private String attachmentCount;
      //  @JsonProperty("tagCount")
        private int tagCount;
      //  @JsonProperty("journalCount")
        private int journalCount;
        private long birthday;
       // @JsonProperty("establishDays")
        private int establishDays;
      //  @JsonProperty("linkCount")
        private int linkCount;
      //  @JsonProperty("visitCount")
        private int visitCount;
      //  @JsonProperty("likeCount")
        private int likeCount;
        public void setPostcount(int postcount) {
            this.postCount = postcount;
        }
        public int getPostcount() {
            return postCount;
        }

        public void setCommentcount(int commentcount) {
            this.commentCount = commentcount;
        }
        public int getCommentcount() {
            return commentCount;
        }

        public void setCategoryCount(int categoryCount) {
            this.categoryCount = categoryCount;
        }
        public int getCategoryCount() {
            return categoryCount;
        }

        public void setAttachmentCount(String attachmentCount) {
            this.attachmentCount = attachmentCount;
        }
        public String getAttachmentCount() {
            return attachmentCount;
        }

        public void setTagCount(int tagCount) {
            this.tagCount = tagCount;
        }
        public int getTagCount() {
            return tagCount;
        }

        public void setJournalCount(int journalCount) {
            this.journalCount = journalCount;
        }
        public int getJournalCount() {
            return journalCount;
        }

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }
        public long getBirthday() {
            return birthday;
        }

        public void setEstablishdays(int establishdays) {
            this.establishDays = establishdays;
        }
        public int getEstablishdays() {
            return establishDays;
        }

        public void setLinkcount(int linkcount) {
            this.linkCount = linkcount;
        }
        public int getLinkcount() {
            return linkCount;
        }

        public void setVisitCount(int visitCount) {
            this.visitCount = visitCount;
        }
        public int getVisitCount() {
            return visitCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }
        public int getLikeCount() {
            return likeCount;
        }
    }
}
