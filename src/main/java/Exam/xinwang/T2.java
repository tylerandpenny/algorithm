package Exam.xinwang;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        String[] inputs = new String[count*2];
        List<int[]> allArr = new LinkedList<int[]>();
        for (int i = 0; i < count * 2; i++) {
            if (i % 2 == 0){
                int n = in.nextInt();
                int[] singleArr = new int[n];
                for (int j = 0; j < n; j++) {
                    singleArr[j] = in.nextInt();
                }
                allArr.add(singleArr);
            }
        }

        for (int[] item: allArr) {
            System.out.println(timeToSuccess(item));
        }

    }

    // 判断一个数组需要多少次变化满足不减
    public static int timeToSuccess(int[] intArr){
        int timeToSuccess = 0;
        int n  = intArr.length;
        for (int i = n -1 ; i > 0 ; i--) {
            if (intArr[i] < intArr[i - 1]){
                // 当前值比前一位小，需要变化这么多次
                timeToSuccess += intArr[i - 1] - intArr[i] ;
            }
        }

        return timeToSuccess;
    }
}
