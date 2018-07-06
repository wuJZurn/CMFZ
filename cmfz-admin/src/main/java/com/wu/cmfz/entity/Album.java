package com.wu.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wu on 2018/7/6.
 */
public class Album implements Serializable{
    private String albumId;
    private String albumName;
    private String albumAuthor;
    private String albumCv;
    private int albumCount;
    private double albumScore;
    private String albumSrc;
    private Date albumDate;
    private String content;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumAuthor() {
        return albumAuthor;
    }

    public void setAlbumAuthor(String albumAuthor) {
        this.albumAuthor = albumAuthor;
    }

    public String getAlbumCv() {
        return albumCv;
    }

    public void setAlbumCv(String albumCv) {
        this.albumCv = albumCv;
    }

    public int getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(int albumCount) {
        this.albumCount = albumCount;
    }

    public double getAlbumScore() {
        return albumScore;
    }

    public void setAlbumScore(double albumScore) {
        this.albumScore = albumScore;
    }

    public String getAlbumSrc() {
        return albumSrc;
    }

    public void setAlbumSrc(String albumSrc) {
        this.albumSrc = albumSrc;
    }

    public Date getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(Date albumDate) {
        this.albumDate = albumDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Album(String albumId, String albumName, String albumAuthor, String albumCv, int albumCount, double albumScore, String albumSrc, Date albumDate, String content) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumAuthor = albumAuthor;
        this.albumCv = albumCv;
        this.albumCount = albumCount;
        this.albumScore = albumScore;
        this.albumSrc = albumSrc;
        this.albumDate = albumDate;
        this.content = content;
    }

    public Album() {

    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumAuthor='" + albumAuthor + '\'' +
                ", albumCv='" + albumCv + '\'' +
                ", albumCount=" + albumCount +
                ", albumScore=" + albumScore +
                ", albumSrc='" + albumSrc + '\'' +
                ", albumDate=" + albumDate +
                ", content='" + content + '\'' +
                '}';
    }
}
