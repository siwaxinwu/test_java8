package org.roy;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-14 13:35
 */
public class SegmentUtils {

    public static List<Segment> getSegments(long minId, long maxId, int size) {
        List<Segment> segments = Lists.newArrayList();
        if (maxId - minId > size) {
            long num = (maxId - minId) / size;
            long start = minId;
            for (long i = 1; i <= num; i++) {
                Segment segment = new Segment();
                segment.setStart(start);
                segment.setEnd(start + size - 1);
                start = segment.getEnd() + 1;
                segments.add(segment);
            }
            if (maxId >= start) {
                Segment segment = new Segment();
                segment.setStart(start);
                segment.setEnd(maxId);
                segments.add(segment);
            }
        } else {
            Segment segment = new Segment();
            segment.setStart(minId);
            segment.setEnd(maxId);
            segments.add(segment);
        }
        return segments;
    }

    public static void main(String[] args) {
        List<Segment> segments = getSegments(23, 100, 10);
        for (Segment segment : segments) {
            System.out.println(segment);
        }
    }
}
