package Exam.h3c;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Long> res = getFactors(n);
        for (Long integer: res) {
            System.out.print(integer + " ");
        }
        int size = res.size();
        if(size % 2 == 0){
            System.out.println(res.get(size/2-1));
        }else{
            System.out.println(res.get(size/2));
        }
    }

    //输入一个数，输出这个数的所有因子
    public static List<Long> getFactors(long n) {
        List<Long> res = new LinkedList<Long>();
        if (n == 0)
            return res;
        else {
            res.add((long) 1);
            for (long i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    res.add((long) i);
                    res.add(n/i);
                }
            }
            res.add(n);
        }
        return res;
    }
}
