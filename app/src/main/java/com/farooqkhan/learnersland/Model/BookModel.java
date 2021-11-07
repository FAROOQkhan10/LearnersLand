package com.farooqkhan.learnersland.Model;

public class BookModel {

    String img,bookName,url;

    public BookModel() {
    }

    public BookModel(String img, String bookName, String url) {
        this.img = img;
        this.bookName = bookName;
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
