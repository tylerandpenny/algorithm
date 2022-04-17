package Exam.jingji;

import java.util.ArrayList;
import java.util.List;

public class T3 {
    public static void main(String[] args) {
        int number = 5;
        String str = "";
        for (int i = 0; i < number; i++) {
            str += i;
        }

        int[] si = {-5,8,6,2,8};
        int[] fi = {7,-6,-3,1,-5};
        System.out.println(smartSum(5,si,fi));
    }

    public static int smartSum (int number, int[] si, int[] fi) {
        // write code here
        String s = "";
        for (int i = 0; i < number; i++) {
            s += i;
        }
        int max = 0;
        for (int i = 1; i <= number ; i++) {
            // 选择i个人，统计，看满足条件不
            List<String> cmnList = getCombinationResult(i,s);
            for (String cmn : cmnList) {
                max = judge(cmn, si, fi, max);
            }
        }
        return max;
    }

    /**
     * 得到组合结果 无序 Cmn cmn
     * @param num   从N个数中选取num个数
     * @param str   包含Ng个元素的字符串
     * @return  组合结果
     */
    public static List<String> getCombinationResult(int num, String str) {
        List<String> result = new ArrayList<String>();
        if (num == 1) {
            for (char c : str.toCharArray()) {
                result.add(String.valueOf(c));
            }
            return result;
        }
        if (num >= str.length()) {
            result.add(str);
            return result;
        }
        int strlen = str.length();
        for (int i = 0; i < (strlen - num + 1); i++) {
            List<String> cr = getCombinationResult(num - 1, str.substring(i + 1));//从i+1处直至字符串末尾
            char c = str.charAt(i);//得到上面被去掉的字符，进行组合
            for (String s : cr) {
                result.add(c + s);
            }
        }
        return result;
    }

    /**
     * 判断是否满足条件，更新最大值
     */
    public static int judge(String cmn, int[] si, int[] fi, int tempMax){
        int total = 0, workHard = 0, smart = 0;
        int n = cmn.length();
        for (int i = 0; i < n; i++) {
            int index = Integer.valueOf(cmn.charAt(i)) - 48;
            total += si[index] + fi[index];
            workHard += fi[index];
            smart += si[index];
        }
        if (total > tempMax && total > 0 && workHard > 0 && smart > 0){
            System.out.println(cmn + "对应和" + total );
            tempMax = total;
            return tempMax;
        }else{
            return tempMax;
        }
    }
}
