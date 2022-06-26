package com.example.novelscholar;

public class Book {
    int id;
    String title,author,review;
    long started,finished;

    public Book() {
    }

    public Book(int id, String title, String author, String review, long started, long finished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.review = review;
        this.started = started;
        this.finished = finished;
    }

    public Book(String title, String author, String review, long started, long finished) {
        this.title = title;
        this.author = author;
        this.review = review;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
