package org.roy;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-14 13:36
 */
public class Segment {

    private Long start;

    private Long end;

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return start+"-"+end;
    }
}
