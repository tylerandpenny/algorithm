package Exam.PUFA;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String biaoda = in.nextLine();

        int top = 0;// 计数，左括号 1，右括号 -1，最后总和0则匹配
        boolean end = true;// true 表示匹配

        char[] biao = biaoda.toCharArray();// 将字符串转化成字符数组
        // 遍历表达式中所有字符
        for (int i = 0; i < biao.length; i++){
            // 如果是(则加1，进栈
            if (biao[i] == '('){
                top++;
            }else if (biao[i] == ')'){// 如果是)则-1，出栈
                if (!(top == 0)){
                    top--;
                }
                else {//top == 0,无左括号却有一个右括号，有一个右括号不匹配
                    end = false;
                    return;
                }
            }
        }

        // 循环结束时两种可能
        if (top == 0 && end){
            System.out.println(1);// 出循环stack空
        }
        else if (top != 0 && end){
            System.out.println(0);// 出循环时stack不空
        }

    }
}

