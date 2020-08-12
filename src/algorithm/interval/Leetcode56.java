package algorithm.interval;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/7/27 20:32
 * @Description:合并区间
 */
public class Leetcode56 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                intervals[i - 1] = null;
            }
        }
        int cnt = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                cnt++;
            }
        }
        int[][] ans = new int[cnt][2];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                ans[idx][0] = intervals[i][0];
                ans[idx][1] = intervals[i][1];
                idx++;
            }
        }
        return ans;
    }
}
