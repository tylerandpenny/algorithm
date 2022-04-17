package Exam.jianxin;

import java.util.Scanner;

/**
 * 正则表达式删除特定字符串
 * https://blog.csdn.net/u011026968/article/details/45584477
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replaceAll("coc|coC|cOc|cOC|Coc|CoC|COc|COC","");
        System.out.println(s);
    }
}
