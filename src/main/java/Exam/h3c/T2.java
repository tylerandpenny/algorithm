package Exam.h3c;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String s = null;


        if (str.charAt(0) == 'M')
            s = "Monday";
        else if (str.charAt(0) == 'W')
            s = "Wednesday";
        else if (str.charAt(0) == 'F')
            s = "Friday";
        else if (str.charAt(0) == 'T') {
            if (str.length() == 1) {
                s = "Tuesday Thursday";
            } else if (str.charAt(1) == 'u')
                s = "Tuesday";
            else if (str.charAt(1) == 'h')
                s = "Thursday";
            else
                s = "No match";
        } else if (str.charAt(0) == 'S') {
            if (str.length() == 1) {
                s = "Saturday Sunday";
            } else if (str.charAt(1) == 'a')
                s = "Saturday";
            else if (str.charAt(1) == 'u')
                s = "Sunday";
            else
                s = "No match";
        } else
            s = "No match";
    }
}
