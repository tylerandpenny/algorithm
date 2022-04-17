package Exam.meicai;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(strToInt(s));
    }

    public static int strToInt(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        int start = 0;
        if (charArray[0] == '-') {
            // 有可能是负数，start+1
            start++;
        }
        int result = charArrayToInt(charArray, start, charArray.length - 1);
        return start == 1 ? -result : result;

    }

    // 字符数组[start,end]转换成一个数字
    private static int charArrayToInt(char[] charArray, int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            return 0;
        }
        long result = 0;
        result = charToNum(charArray[end]) + (long) 10 * charArrayToInt(charArray, start, end - 1);
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (start > 0 && result > (long) Integer.MAX_VALUE + 1) {// 负数
            return Integer.MIN_VALUE;
        }
        if (end != charArray.length - 1 && result == 0) {
            return 0;
        }
        return (int) result;
    }

    // 把char转换成0-9的数字
    private static int charToNum(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return 0;
        }
    }

}
