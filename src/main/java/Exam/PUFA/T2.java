package Exam.PUFA;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int beishu = in.nextInt();
        System.out.println(fib(13) * beishu);
    }

    public static int fib(int n) {
    	if(n==1 || n==2)
            return 1;
	    else
            return fib(n-1) + fib(n-2);
    }

}

