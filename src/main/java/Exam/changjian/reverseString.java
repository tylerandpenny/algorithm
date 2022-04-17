package Exam.changjian;

public class reverseString {
    public static void main(String[] args) {
        String s = "do something ";
        System.out.println(reverseString(s));
    }

    /**
     * 翻转字符串
     * 调用函数
     */
    public static String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
