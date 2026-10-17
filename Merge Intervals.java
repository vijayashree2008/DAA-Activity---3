import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] result = new int[intervals.length][2];
        int count = 0;

        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        count = 1;

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= result[count - 1][1]) {
                result[count - 1][1] =
                    Math.max(result[count - 1][1], end);
            } else {
                result[count][0] = start;
                result[count][1] = end;
                count++;
            }
        }

        return Arrays.copyOf(result, count);
    }
}