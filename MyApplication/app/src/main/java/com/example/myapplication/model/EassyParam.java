package com.example.myapplication.model;

import java.util.List;

public class EassyParam {
    private int status;
    private String message;
    private String devmessage;
    public Data data;

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
        public static class Content{
            private int id;
            private String title;
            private String status;
            private String slug;
            private String editorType;
            private long updateTime;
            private long createTime;
            private long editTime;
            private String metaKeywords;
            private String metaDescription;
            private String fullPath;
            private String summary;
            private String thumbnail;
            private int visits;
            private boolean disallowComment;
            private String password;
            private String template;
            private int topPriority;
            private int likes;
            private int wordCount;
            private int commentCount;
            private List<String> tags;
            private List<Categories> categories;
            private Metas metas;
            private boolean topped;
            static class Metas{

            }
            public static class Categories {

                private int id;
                private String name;
                private String slug;
                private String description;
                private String thumbnail;
                private int parentid;
                private int createtime;
                private String fullpath;
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

                public void setSlug(String slug) {
                    this.slug = slug;
                }
                public String getSlug() {
                    return slug;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
                public String getDescription() {
                    return description;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }
                public String getThumbnail() {
                    return thumbnail;
                }

                public void setParentid(int parentid) {
                    this.parentid = parentid;
                }
                public int getParentid() {
                    return parentid;
                }

                public void setCreatetime(int createtime) {
                    this.createtime = createtime;
                }
                public int getCreatetime() {
                    return createtime;
                }

                public void setFullpath(String fullpath) {
                    this.fullpath = fullpath;
                }
                public String getFullpath() {
                    return fullpath;
                }

            }
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

            public void setStatus(String status) {
                this.status = status;
            }
            public String getStatus() {
                return status;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }
            public String getSlug() {
                return slug;
            }

            public void setEditorType(String editorType) {
                this.editorType = editorType;
            }
            public String getEditorType() {
                return editorType;
            }

            public void setUpdateTime(int updateTime) {
                this.updateTime = updateTime;
            }
            public long getUpdateTime() {
                return updateTime;
            }

            public void setCreateTime(int createTime) {
                this.createTime = createTime;
            }
            public long getCreateTime() {
                return createTime;
            }

            public void setEditTime(int editTime) {
                this.editTime = editTime;
            }
            public long getEditTime() {
                return editTime;
            }

            public void setMetaKeywords(String metaKeywords) {
                this.metaKeywords = metaKeywords;
            }
            public String getMetaKeywords() {
                return metaKeywords;
            }

            public void setMetaDescription(String metaDescription) {
                this.metaDescription = metaDescription;
            }
            public String getMetaDescription() {
                return metaDescription;
            }

            public void setFullPath(String fullPath) {
                this.fullPath = fullPath;
            }
            public String getFullPath() {
                return fullPath;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }
            public String getSummary() {
                return summary;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
            public String getThumbnail() {
                return thumbnail;
            }

            public void setVisits(int visits) {
                this.visits = visits;
            }
            public int getVisits() {
                return visits;
            }

            public void setDisallowComment(boolean disallowComment) {
                this.disallowComment = disallowComment;
            }
            public boolean getDisallowComment() {
                return disallowComment;
            }

            public void setPassword(String password) {
                this.password = password;
            }
            public String getPassword() {
                return password;
            }

            public void setTemplate(String template) {
                this.template = template;
            }
            public String getTemplate() {
                return template;
            }

            public void setTopPriority(int topPriority) {
                this.topPriority = topPriority;
            }
            public int getTopPriority() {
                return topPriority;
            }

            public void setLikes(int likes) {
                this.likes = likes;
            }
            public int getLikes() {
                return likes;
            }

            public void setWordCount(int wordCount) {
                this.wordCount = wordCount;
            }
            public int getWordCount() {
                return wordCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }
            public int getCommentCount() {
                return commentCount;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }
            public List<String> getTags() {
                return tags;
            }

            public void setCategories(List<Categories> categories) {
                this.categories = categories;
            }
            public List<Categories> getCategories() {
                return categories;
            }

            public void setMetas(Metas metas) {
                this.metas = metas;
            }
            public Metas getMetas() {
                return metas;
            }

            public void setTopped(boolean topped) {
                this.topped = topped;
            }
            public boolean getTopped() {
                return topped;
            }
        }
        public void setContent(List<Content> content) {
            this.content = content;
        }
        public List<Content> getContent() {
            return content;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
        public int getPages() {
            return pages;
        }

        public void setTotal(int total) {
            this.total = total;
        }
        public int getTotal() {
            return total;
        }

        public void setPage(int page) {
            this.page = page;
        }
        public int getPage() {
            return page;
        }

        public void setRpp(int rpp) {
            this.rpp = rpp;
        }
        public int getRpp() {
            return rpp;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }
        public boolean getHasNext() {
            return hasNext;
        }

        public void setHasPrevious(boolean hasPrevious) {
            this.hasPrevious = hasPrevious;
        }
        public boolean getHasPrevious() {
            return hasPrevious;
        }

        public void setFirst(boolean first) {
            this.isFirst = first;
        }
        public boolean getFirst() {
            return isFirst;
        }

        public void setLast(boolean last) {
            this.isLast = last;
        }
        public boolean getLast() {
            return isLast;
        }

        public void setEmpty(boolean empty) {
            this.isEmpty = empty;
        }
        public boolean getEmpty() {
            return isEmpty;
        }

        public void setHasContent(boolean hasContent) {
            this.hasContent = hasContent;
        }
        public boolean getHasContent() {
            return hasContent;
        }

    }
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
        this.devmessage = devmessage;
    }
    public String getDevmessage() {
        return devmessage;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }
}
