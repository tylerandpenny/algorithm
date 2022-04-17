package Exam.xinwang;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] inputs = new String[count*2];
        for (int i = 0; i < count * 2; i++) {
            inputs[i] = in.next();
        }

        List<String> allStrs = new LinkedList<String>();
        for (int i = 0; i < count * 2 ; i++) {
            if (i % 2 == 1){
                allStrs.add(inputs[i]);
            }
        }

        for (String item : allStrs) {
            System.out.println(allChild(item));
        }

    }

    // 字符串有几个能吃
    public static int allChild(String str) {
        int canEatNum = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String child = str.substring(i, j);
                if (canEat(child)){
                    canEatNum++;
                }
            }
        }

        return canEatNum;
    }

    // 判断字符串能被吃不
    public static boolean canEat(String s) {
        Integer n = s.length();
        Integer total = 0;
        for (int i = 0; i < n; i++) {
            total += Integer.valueOf(s.charAt(i)) - 48;
        }

        if (n == total) {
            return true;
        } else {
            return false;
        }
    }
}
