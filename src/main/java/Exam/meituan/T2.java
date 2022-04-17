package Exam.meituan;

import java.util.*;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int maxDif = 0;

        for (int i = 0; i < s.length() ; i++) {
            for (int j = i+1; j < s.length()+1 ; j++) {
                int difOfEF = getDifOfEF(s.substring(i, j));
                if (difOfEF > maxDif){
                    maxDif = difOfEF;
                }
            }
        }
        System.out.println(maxDif);
    }
    // 获取字符串的所有连续子串

    public static List<String> getAllSubstrings(String s){
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i+1; j < s.length()+1 ; j++) {

                res.add(s.substring(i, j));
            }
        }

        return res;
    }

    //  计算一个字符串中E和F的个数差值
    public static  int getDifOfEF(String s){
        int n = s.length();
        int countE = 0;
        int countF = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'E'){
                countE++;
            }else if (s.charAt(i) == 'F'){
                countF++;
            }
        }

        return countE - countF;
    }
}
