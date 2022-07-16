package kexin;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 *
 * 此题自己处理失败
 * 需要查看题解，滑动窗口
 *
 *
 *思路：
 * 1、遍历字符串，匹配是否含有某个word。如果有，检查是否满足能够串联（只需要至少串联一个即可），可以则保留记录，否则继续逐个遍历字符串；
 */


public class licode30 {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
//        System.out.println(getMinMatchIndex(s,words));

        List<Integer> testRes = findSubstring(s,words);
        for (Integer item: testRes) {
            System.out.print(item + " ");
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>(16);
        if (null == words || null == s){
            return res;
        }
        int pLen = words[0].length();
        // 遍历并调用 getMinMatchIndex
        for (int i = 0; i < s.length() - pLen; i++) {
            System.out.println(s.substring(i,s.length()));
            System.out.println(s.substring(i + pLen,s.length()));

            int minIndex = getMinMatchIndex(s.substring(i,s.length()),words);
            System.out.println(minIndex);
            int nextMinIndex = getMinMatchIndex(s.substring(i + pLen,s.length()),words);
            System.out.println(nextMinIndex);
            if (minIndex == 0 && nextMinIndex == 0){
                System.out.println("找到串联的-------------------");
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 匹配是否有某个word,并返回相应最小的起始索引
     */
    public static int getMinMatchIndex(String s,  String[] words) {
        int min = s.length() - 1;
        for (int i = 0; i < words.length; i++) {
            // 返回-1就是没匹配的
            int temp = s.indexOf(words[i]);
            if (temp != -1 &&  temp<= min){
                System.out.println(words[i] + "在" + s + "中对应的起始索引为" + temp);
                min = temp;
            }
        }
        return min;
    }
}
