package org.roy.songtest;

import java.util.List;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/1/10 13:48
 */
public class DataResult {

    private int pageType;
    private int size;
    private int pageCode;
    private int count;
    private long expiryTime;
    private List<Song> list;
    public void setPageType(int pageType) {
        this.pageType = pageType;
    }
    public int getPageType() {
        return pageType;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }
    public int getPageCode() {
        return pageCode;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }
    public long getExpiryTime() {
        return expiryTime;
    }

    public List<Song> getList() {
        return list;
    }

    public void setList(List<Song> list) {
        this.list = list;
    }
}