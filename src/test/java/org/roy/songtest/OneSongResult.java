package org.roy.songtest;

/**
 * @description:  获取单首歌的内容
 * @author: Ding Yawu
 * @create: 2022/1/10 14:33
 */
public class OneSongResult {
    private String playUrl;
    private String lyric;
    private int lyricType;
    private long expiryTime;

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public int getLyricType() {
        return lyricType;
    }

    public void setLyricType(int lyricType) {
        this.lyricType = lyricType;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Override
    public String toString() {
        return "OneSongResult{" +
                "playUrl='" + playUrl + '\'' +
                ", lyric='" + lyric + '\'' +
                ", lyricType=" + lyricType +
                ", expiryTime=" + expiryTime +
                '}';
    }
}
