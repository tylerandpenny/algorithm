package DataStructure;


import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/fbc417f314f745b1978fc751a54ac8cb?tpId=37&tqId=21290&rp=1&ru=/ta/huawei&qru=/ta/huawei&difficulty=&judgeStatus=&tags=/question-ranking
 *
 * 描述
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且不考虑括号运算
 * 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
 * 输入描述：
 * 本题有多组案例。对于每组案例读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 *
 * 输出描述：
 * 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 *
 * 示例1
 * 输入：
 * 7 2 1 10
 * 复制
 * 输出：
 * true
 *
 *
 *
 */

/**
 * 思想：
 * 算法流程：
 *
 * 通过递归+dfs，首先定义递归函数功能：当前已经使用了数组的u个数字，前面数字的运算结果为tmp，返回是否运算结果为24
 * 确定递归终止条件：已经使用了数组四个元素，同时结果为24，满足题意
 * 通过加减乘除四种运算，加减乘除当前数字num[i]，不断递归运算，直到已经使用了数组四个元素，同时结果为24，满足题意
 */

public class twenty_four_v1 {

    static int[] nums = new int[4];
    static boolean[] visit = new boolean[4];
    static int flag = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] a = in.nextLine().split(" ");
            for(int i = 0; i < 4; i ++)
                nums[i] = Integer.parseInt(a[i]);
            dfs(0, 0);
            System.out.println( flag == 1 );
        }
    }


    // 递归实现dfs
    public static Boolean dfs(int u, float tmp){
        // 递归终止条件：已经使用了数组四个元素，同时结果为24，满足题意
        if(tmp == 24 && u == 4){
            flag = 1;
            return true;
        }

        for(int i = 0; i < 4; i ++){
            if(visit[i] == false){
                visit[i] = true;
                // 加减乘除当前数字num[i]
                if( dfs(u + 1, tmp + nums[i]) ||
                        dfs(u + 1, tmp - nums[i])  ||
                        dfs(u + 1,tmp * nums[i]) ||
                        dfs(u + 1, tmp / nums[i])){
                    return true;
                }
                // 相当于回溯
                visit[i] = false;
            }
        }
        return false;
    }

}


