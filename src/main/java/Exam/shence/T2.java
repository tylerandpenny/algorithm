package Exam.shence;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ns = in.nextLine();
        String s = in.nextLine().trim();
        int n = Integer.valueOf(ns);
        System.out.println(n);
        System.out.println(s);
        System.out.println("length" + s.length());
        String toReverse = "";

        for (int i = 0; i <= 2*n - 1; i++) {
            toReverse = toReverse + s.charAt(i);
        }
        String left = "";
        for (int i = 2*n-1; i < s.length() - 1  ; i++) {
            left += s.charAt(i);
        }
        System.out.println(left +  reverse(toReverse));

    }

    /**
     * 字符串反转
     */
    public static String reverse(String s) {
        if (s.length() <= 0 || s == null) {
            return null;
        }
        String reverse = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }
}
