package Exam.yaxin;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] eArr = new int[n];
        for (int i = 0; i < n; i++) {
            eArr[i] = in.nextInt();
        }
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i){
                    int curMul = eArr[i] * eArr[j];
                    if (curMul > max){
                        max = curMul;
                        res = eArr[i] + eArr[j];
                    }
                }

            }
        }
        System.out.println(res);
    }
}
