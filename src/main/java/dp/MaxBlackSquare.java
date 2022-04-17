package dp;

/**
 *给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 *
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *    [1,0,1],
 *    [0,0,1],
 *    [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 * 示例 2:
 *
 * 输入:
 * [
 *    [0,1,1],
 *    [1,0,1],
 *    [1,1,0]
 * ]
 * 输出: [0,0,1]
 * 提示：
 *
 * matrix.length == matrix[0].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-black-square-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class MaxBlackSquare {

    public static void main(String[] args) {

    }
    public int[] findSquare(int[][] grid) {
        int n = grid.length;
        //dp[i][j][0]: i,j左边连续的0的个数
        //dp[i][j][1]: i,j上边连续的0的个数
        int[][][] dp = new int[n][n][2];
        int size = 0; // "最大黑方阵"的边长
        int r = -1, c = -1; // "最大黑方阵"左上角的行号和列号
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    dp[i][j][0] = 1 + (j > 0 ? dp[i][j-1][0] : 0);
                    dp[i][j][1] = 1 + (i > 0 ? dp[i-1][j][1] : 0);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 枚举以[i,j]为右下角的正方形的可能边长side
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--){
                    if (dp[i][j-side+1][1] >= side && dp[i-side+1][j][0] >= side){
                        if(side > size){
                            size = side;
                            r = i - side + 1;
                            c = j - side + 1;
                            break; // 更短的就没必要考虑了
                        }
                    }
                }
            }
        }
        if(r == -1 && c == -1) return new int[0];
        else return new int[]{r, c, size};
    }
}
