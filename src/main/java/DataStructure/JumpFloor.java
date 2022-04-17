package DataStructure;

import java.util.Scanner;

/**
 * 猴子爬山
 * 一次3阶或者1阶
 * 递归
 */
public class JumpFloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt();
        System.out.println(jumpFloor(floor));
    }
    public static int jumpFloor(int n) {
        //青蛙选择跳 1 阶台阶或 3 阶台阶
        if (n == 1 || n == 2) {
            return 1;
        }else if (n == 3){
            return 2;
        }
        //有 N 阶台阶 F(N) 时，就有 F(N) = F(N - 1) + F(N - 3) 种跳法。
        return jumpFloor(n - 1) + jumpFloor(n - 3);
    }
}
