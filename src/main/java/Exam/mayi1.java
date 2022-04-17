package Exam;

import java.util.Scanner;

/**
 *
 */
public class mayi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int n = 1000005;
        int[] next = new int[n];
        char[] nums = new char[s.length()];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            nums[i] = s.charAt(i);
        }
        int minIndex = express(nums, len, 0) + 1;
        int maxIndex = express(nums, len, 1) + 1;

        getNext(nums, len, next);
        for (int i = 0; i < len; i++) {
            System.out.print(next[i]+" ");
        }
        System.out.println(" ");

        System.out.println(minIndex);
        System.out.println(maxIndex);

    }


    public static int express(char[] str, int len, int flag) {
        int i = 0, j = 1, k = 0;
        for (; i < len && j < len && k < len; ) {
            int ie = (i + k) % len;
            int je = (j + k) % len;
            if (str[ie] == str[je]) {
                k++;
                continue;
            }
            if ((str[ie] > str[je] && flag == 1) || (flag == 0 && str[ie] < str[je])) {
                j = j + k + 1;
                if (j <= i) {
                    j = i + 1;
                }
            } else {
                i = i + k + 1;
                if (i <= j) {
                    i = j + 1;
                }
            }
            k = 0;
        }

        return i > j ? j : i;
    }

    public static void getNext(char[] str, int len, int[] next) {
        if (len == 0) {
            return;
        }
        next[0] = -1;
        if (len == 1) {
            return;
        }
        next[1] = 0;
        if (len == 2) {
            return;
        }
        int i = 2, j = 0;
        for (; i <= len; ) {
            if (str[i - 1] == str[j]) {
                next[i++] = ++j;
            } else if (j > 0) {
                j = next[j];
            } else {
                next[i++] = 0;
            }
        }
    }


}
