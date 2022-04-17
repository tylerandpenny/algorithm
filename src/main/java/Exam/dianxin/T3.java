package Exam.dianxin;

/**
 * abcd
 */
public class T3 {
    public static void main(String[] args) {
        for (int a = 1; a <= 7; a++) {
            for (int b = 1 ; b <= 7; b++) {
                for (int c = 6; c <= 9 ; c++) {
                    for (int d = 0; d <= 9; d++) {
                            int num1 = (int) (a * Math.pow(10, 3 ) + b * Math.pow(10, 2) + c * Math.pow(10, 1 ) + d);
                            int num2 = (int) (b * Math.pow(10, 3 ) + c * Math.pow(10, 2) + d * Math.pow(10, 1 ) + a);
                            if (num1 + num2 == 8888){
                                System.out.print(a + " " );
                                System.out.print(b + " " );
                                System.out.print(c + " " );
                                System.out.println(d);
                            }
                    }
                }
            }
        }
    }
}
