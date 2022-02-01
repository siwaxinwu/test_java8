package org.roy.songtest;

import java.util.Date;
import java.util.List;

/**
 * @description:  歌曲bean
 * @author: Ding Yawu
 * @create: 2022/1/10 13:53
 */

public class Song {

    private long songCode;
    private String name;
    private String singer;
    private String poster;
    private int duration;
    private List<Integer> lyricType;
    private int type;
    private String releaseTime;
    private int status;
    private long updateTime;
    private String mv;
    public void setSongCode(long songCode) {
        this.songCode = songCode;
    }
    public long getSongCode() {
        return songCode;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    public String getSinger() {
        return singer;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
    public String getPoster() {
        return poster;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }



    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
    public String getReleaseTime() {
        return releaseTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
    public long getUpdateTime() {
        return updateTime;
    }

    public void setMv(String mv) {
        this.mv = mv;
    }
    public String getMv() {
        return mv;
    }

    public List<Integer> getLyricType() {
        return lyricType;
    }

    public void setLyricType(List<Integer> lyricType) {
        this.lyricType = lyricType;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songCode=" + songCode +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", poster='" + poster + '\'' +
                ", duration=" + duration +
                ", lyricType=" + lyricType +
                ", type=" + type +
                ", releaseTime='" + releaseTime + '\'' +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", mv='" + mv + '\'' +
                '}';
    }
}