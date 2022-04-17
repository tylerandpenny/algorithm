package Exam.idong;

public class T2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int[] prices = new int[n];
//        int[] value = new int[n];
//        for (int i = 0; i < n; i++) {
//            prices[i] = in.nextInt();
//            value[i] = 1;
//        }
//
//        System.out.println(knapsack(value, prices, k));

        int[] value = {6,3,5,4,6};
        int[] weight = {2,2,6,5,4};
        int cap = 10;
        System.out.println(knapsack(value, weight, cap));

    }

    /**
     * 0-1背包
     * @param val 价值
     * @param weight 重量
     * @param W 背包容量
     * @return 最优解
     */
    public static int knapsack(int[] val, int[] weight, int W) {
        int N = weight.length;   //记录所有的物品数
        int[][] V = new int[N + 1][W + 1];  //创建背包矩阵
        for (int col = 0; col <= W; col++) { //列，背包容量为0
            V[0][col] = 0;
        }
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item = 1; item <= N; item++) {  //一行一行填充值
            for (int wt = 1; wt <= W; wt++) {  //一列一列填充值
                if (weight[item - 1] <= wt) {  //如果当前物品重量小于等于背包中的当前重量 item为1是，weight[0]是第一个物品的重量
                    //比较不加入该物品时该重量的最大价值（前一行）与当前物品的价值+可以容纳的剩余重量的价值
                    V[item][wt] = Math.max(val[item-1] + V[item-1][wt - weight[item-1]],V[item-1][wt]);
                } else { //如果当前物品重量大于背包中的当前重量
                    V[item][wt]=V[item-1][wt];  //直接使用前一行的最优解
                }
            }
        }
        // 打印矩阵
        for (int[] rows: V) {
            for (int col : rows) {
                System.out.format("%5d",col);
            }
            System.out.println();
        }
        return V[N][W];
    }
}

