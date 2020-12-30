package com.example.myapplication.model;

import java.util.List;

/*
{"status":200,"message":"OK",
"devMessage":null,
"data":[{"id":3,
        "author":"sky",
        "email":"sky@163.com",
        "ipAddress":"127.0.0.1",
        "authorUrl":"http://47.113.204.48/",
        "gravatarMd5":"7bde4428b1fe79a95c6e82d3ca001458",
        "content":"this is a test",
        "status":"AUDITING",
        "userAgent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.193 Safari/537.36",
        "parentId":0,"isAdmin":false,
        "allowNotification":true,
        "createTime":1608407033173,
        "post":{"id":1,"title":"Hello Halo","status":"PUBLISHED",
            "slug":"hello-halo",
             "editorType":"MARKDOWN",
            "updateTime":1605169656559,
            "createTime":1605169656559,
             "editTime":1605169656559,
             "metaKeywords":null,
             "metaDescription":null,
             "fullPath":"http://47.113.204.48/archives/hello-halo"}}]}
 */
public class LatestParam {
    private int status;
    private String message;
    private String devmessage;
    private List<Data> data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDevmessage() {
        return devmessage;
    }

    public List<Data> getData() {
        return data;
    }

    public static class Data{
        private int id;
        private String author;
        private String email;
        private String ipaddress;
        private String authorurl;
        private String gravatarmd5;
        private String content;
        private String status;
        private String useragent;
        private int parentid;
        private boolean isadmin;
        private boolean allownotification;
        private long createTime;
        private Post post;

       public int getId() {
           return id;
       }

       public String getAuthor() {
           return author;
       }

       public String getEmail() {
           return email;
       }

       public String getIpaddress() {
           return ipaddress;
       }

       public String getAuthorurl() {
           return authorurl;
       }

       public String getGravatarmd5() {
           return gravatarmd5;
       }

       public String getContent() {
           return content;
       }

       public String getStatus() {
           return status;
       }

       public String getUseragent() {
           return useragent;
       }

       public int getParentid() {
           return parentid;
       }

       public boolean isIsadmin() {
           return isadmin;
       }

       public boolean isAllownotification() {
           return allownotification;
       }

       public long getCreatetime() {
           return createTime;
       }

       public Post getPost() {
           return post;
       }

       static class Post{
            private int id;
            private String title;
            private String status;
            private String slug;
            private String editortype;
            private int updatetime;
            private int createtime;
            private int edittime;
            private String metakeywords;
            private String metadescription;
            private String fullpath;

            public int getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getStatus() {
                return status;
            }

            public String getSlug() {
                return slug;
            }

            public String getEditortype() {
                return editortype;
            }

            public int getUpdatetime() {
                return updatetime;
            }

            public int getCreatetime() {
                return createtime;
            }

            public int getEdittime() {
                return edittime;
            }

            public String getMetakeywords() {
                return metakeywords;
            }

            public String getMetadescription() {
                return metadescription;
            }

            public String getFullpath() {
                return fullpath;
            }
        }
    }

}
