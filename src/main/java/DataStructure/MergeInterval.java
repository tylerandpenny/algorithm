package DataStructure;

import java.util.*;

/**
 * 合并区间
 */

public class MergeInterval {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 重写比较\排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[1];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < len; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                // 如果合并数组为空或者当前区间不能重合,则添加区间
                merged.add(new int[]{L, R});
            } else {
                // 能重合,更新区间右端点
                merged.get(merged.size() - 1)[1] = Math.max(R, merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
