package Exam.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static boolean[] visited=new boolean[10];
    static HashSet<String> result=new HashSet<String>();
    static int length;
    static StringBuilder tmp=new StringBuilder();
    static String str;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()){
            str=sc.next();
            length=str.length();
            result.clear();
            tmp.delete(0, tmp.length());
            Arrays.fill(visited, false);
            getResult(1);
            System.out.println(result.size());


        }

    }

    public static void getResult(int n){

        if (n == length+1){
            result.add(tmp.toString());
        }

        for (int i=0;i<length;i++){

            if (!visited[i]){
                tmp.append(str.charAt(i));
                visited[i]=true;
                getResult(n+1);
                visited[i]=false;
                tmp.delete(tmp.length()-1, tmp.length());

            }

        }
    }
}
