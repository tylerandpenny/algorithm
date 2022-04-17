package Exam.pingan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strs = s.split(" ");
        Object[] a = new Object[strs.length];
//        for (int i = 0; i < strs.length; i++) {
//            a[i] = Integer.valueOf(strs[i]);
//            System.out.println(a[i]);
//        }
        a = oneClear(strs);
        a = sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // 去重
    public static Object[] oneClear(Object[] arr) {
        Set set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.toArray();
    }

    // 排序,从大到小
    public static Object[] sort(Object[] arr){
        Arrays.sort(arr);
        Object[] temp = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[arr.length - i -1];
        }
        return temp;
    }
}
