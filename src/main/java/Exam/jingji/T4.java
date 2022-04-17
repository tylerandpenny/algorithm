package Exam.jingji;

import java.util.LinkedList;
import java.util.List;

public class T4 {
    public static void main(String[] args) {
        String s1 = "aaabaaa";
        String s2 = "aaaa";
        System.out.println(CycleString(s1, s2));
        System.out.println("aaaaaba".compareTo("aaaaaab"));
    }

    public static String CycleString(String S1, String S2) {
        // write code here
        List<String> allSub = reverseLeftWords(S1);
        int max = 0;
        String res = "";
//        for (String item : allSub) {
//            if (getCount2(S2, item) > max){
//                res = item;
//                max = getCount2(S2, item);
//            }else if(getCount2(S2, item) == max){
//                if (item.compareTo(res) < 0){
//                    res = item;
//                }
//            }
//            System.out.println("同构串" + item + "中s2出现了" + getCount2(S2, item) + "次" + "当前结果："  + res);
//        }
//        return res;

        int len = S1.length();
        for (int i = 0; i < len; i++) {
            String item = S1.substring(i, len) + S1.substring(0, i);
            if (getCount2(S2, item) > max) {
                res = item;
                max = getCount2(S2, item);
            } else if (getCount2(S2, item) == max) {
                if (item.compareTo(res) < 0) {
                    res = item;
                }
            }
            System.out.println("同构串" + item + "中s2出现了" + getCount2(S2, item) + "次" + "当前结果：" + res);
        }
        return res;
    }

    // 构成同构字符串
    public static List<String> reverseLeftWords(String s) {
        int len = s.length();
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < len; i++) {
            res.add(s.substring(i, len) + s.substring(0, i));
        }
        return res;
    }

    // 字符串在另一个字符串中出现的次数
    public static int getCount2(String target, String str) {
        int count = 0;    // 定义计数器
        int index = 0;    // 定义角标
        while ((index = str.indexOf(target, index)) != -1) {
            // sp("index="+index);
            index = index + target.length();    // 使角标值变为未被查找到目标字符串的子串开始角标值
            count++;
        }
        return count;
    }

}
