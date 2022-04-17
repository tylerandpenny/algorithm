package Exam.shence;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = yasuoSpace(s);
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String item : strs){
            res.append(reverse(item) + " ");
        }
        System.out.println(res.toString());
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

    /**
     * 压缩空格
     */
    public static String yasuoSpace(String s){
        if (s.length() <= 0 || s == null) {
            return null;
        }
        boolean isSpace = false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                isSpace = false;
                res.append(s.charAt(i));
            } //end 当前不是空格
            else if (!isSpace) {
                isSpace = true;
                res.append(s.charAt(i));
            }//end 当前是空格，但前一个不是空格
        }
        return res.toString();
    }

}
