package com.farooqkhan.learnersland.Model;

public class categoryVideoModel {
    public categoryVideoModel() {
    }

    String categoryVideoId,categoryVideoName,categoryVideoImg,categoryVideoUrl;

    public categoryVideoModel(String categoryVideoId, String categoryVideoName, String categoryVideoImg, String categoryVideoUrl) {
        this.categoryVideoId = categoryVideoId;
        this.categoryVideoName = categoryVideoName;
        this.categoryVideoImg = categoryVideoImg;
        this.categoryVideoUrl = categoryVideoUrl;
    }

    public String getCategoryVideoId() {
        return categoryVideoId;
    }

    public void setCategoryVideoId(String categoryVideoId) {
        this.categoryVideoId = categoryVideoId;
    }

    public String getCategoryVideoName() {
        return categoryVideoName;
    }

    public void setCategoryVideoName(String categoryVideoName) {
        this.categoryVideoName = categoryVideoName;
    }

    public String getCategoryVideoImg() {
        return categoryVideoImg;
    }

    public void setCategoryVideoImg(String categoryVideoImg) {
        this.categoryVideoImg = categoryVideoImg;
    }

    public String getCategoryVideoUrl() {
        return categoryVideoUrl;
    }

    public void setCategoryVideoUrl(String categoryVideoUrl) {
        this.categoryVideoUrl = categoryVideoUrl;
    }
}
