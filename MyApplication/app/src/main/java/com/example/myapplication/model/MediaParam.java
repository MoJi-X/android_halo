package com.example.myapplication.model;

import java.util.List;
/*
{"status":200,"message":"OK","devMessage":null,"data":{"content":[{"id":2,"name":"wallhaven-2eroxm","path":"http://47.113.204.48/upload/2020/11/wallhaven-2eroxm-992f763f68bb476e9e237ec02af1c965.jpg","fileKey":"upload/2020/11/wallhaven-2eroxm-992f763f68bb476e9e237ec02af1c965.jpg","thumbPath":"http://47.113.204.48/upload/2020/11/wallhaven-2eroxm-992f763f68bb476e9e237ec02af1c965-thumbnail.jpg","mediaType":"image/jpeg","suffix":"jpg","width":2000,"height":1333,"size":465624,"type":"LOCAL","createTime":1605364770472},{"id":1,"name":"QQ图片20180830100324","path":"http://47.113.204.48/upload/2020/11/QQ图片20180830100324-92410e0114fc403794d749b9743195b1.jpg","fileKey":"upload/2020/11/QQ图片20180830100324-92410e0114fc403794d749b9743195b1.jpg","thumbPath":"http://47.113.204.48/upload/2020/11/QQ图片20180830100324-92410e0114fc403794d749b9743195b1-thumbnail.jpg","mediaType":"image/jpeg","suffix":"jpg","width":1537,"height":1200,"size":214591,"type":"LOCAL","createTime":1605170763423}],"pages":1,"total":2,"page":0,"rpp":18,"hasNext":false,"hasPrevious":false,"isFirst":true,"isLast":true,"isEmpty":false,"hasContent":true}}
 */
public class MediaParam {
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

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }
    public String getDevMessage() {
        return devMessage;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }
    public static class Data{
        private List<Content> content;
        private int pages;
        private int total;
        private int page;
        private int rpp;
        private boolean hasNext;
        private boolean hasPrevious;
        private boolean isFirst;
        private boolean isLast;
        private boolean isEmpty;
        private boolean hasContent;

        public List<Content> getContent() {
            return content;
        }

        public int getPages() {
            return pages;
        }

        public int getTotal() {
            return total;
        }

        public int getPage() {
            return page;
        }

        public int getRpp() {
            return rpp;
        }

        public boolean isHasNext() {
            return hasNext;
        }

        public boolean isHasPrevious() {
            return hasPrevious;
        }

        public boolean isFirst() {
            return isFirst;
        }

        public boolean isLast() {
            return isLast;
        }

        public boolean isEmpty() {
            return isEmpty;
        }

        public boolean isHasContent() {
            return hasContent;
        }

        public static class Content{
            private int id;
            private String name;
            private String path;
            private String fileKey;
            private String thumbPath;
            private String mediaType;
            private String suffix;
            private int width;
            private int height;
            private int size;
            private String type;
            private long createTime;
            public void setId(int id) {
                this.id = id;
            }
            public int getId() {
                return id;
            }

            public void setName(String name) {
                this.name = name;
            }
            public String getName() {
                return name;
            }

            public void setPath(String path) {
                this.path = path;
            }
            public String getPath() {
                return path;
            }

            public void setFileKey(String fileKey) {
                this.fileKey = fileKey;
            }
            public String getFileKey() {
                return fileKey;
            }

            public void setThumbPath(String thumbPath) {
                this.thumbPath = thumbPath;
            }
            public String getThumbPath() {
                return thumbPath;
            }

            public void setMediaType(String mediaType) {
                this.mediaType = mediaType;
            }
            public String getMediaType() {
                return mediaType;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }
            public String getSuffix() {
                return suffix;
            }

            public void setWidth(int width) {
                this.width = width;
            }
            public int getWidth() {
                return width;
            }

            public void setHeight(int height) {
                this.height = height;
            }
            public int getHeight() {
                return height;
            }

            public void setSize(int size) {
                this.size = size;
            }
            public int getSize() {
                return size;
            }

            public void setType(String type) {
                this.type = type;
            }
            public String getType() {
                return type;
            }

            public void setCreateTime(int createTime) {
                this.createTime = createTime;
            }
            public long getCreateTime() {
                return createTime;
            }
        }
    }
}
