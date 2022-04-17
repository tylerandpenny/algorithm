package Exam.huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new LinkedList<String>();
        while (scanner.hasNextLine()) {
            if (scanner.nextLine().length() != 1){
                inputs.add(scanner.nextLine());
            }else{
                break;
            }
        }
        inputs.add(scanner.nextLine());
        scanner.close();

        int n = inputs.size();
        if (n < 3) {
            return;
        }
        String target = inputs.get(n - 1);
        String a = inputs.get(n - 2);
        // 给定字符串的特征值
        String givedNum = getNums(target, a);
        // 遍历所有字符串，判断是否具有关联
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < n - 2; i++) {
            String currentStr = inputs.get(i);
            String singleNum = getNums(currentStr, a);
            if (singleNum.contains(givedNum)) {
                res.add(currentStr);
            }
        }
        for (String item : res) {
            System.out.println(item);
        }
    }

    // 特征值
    public static String getNums(String s, String a) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (a.compareTo(String.valueOf(s.charAt(i))) > 0) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
