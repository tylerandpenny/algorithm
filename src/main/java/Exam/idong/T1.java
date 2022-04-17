package Exam.idong;

public class T1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int count = in.nextInt();
//        int[] nArr = new int[count];
//        for (int i = 0; i < count; i++) {
//            nArr[i] = in.nextInt();
//        }
//
//        for (int i = 0; i < count; i++) {
//            int times = 0;
//            winner(nArr[i], times);
//            printWinner(times);
//        }

        System.out.println(isPow(1));
    }

    // 输出获胜者
    public static void printWinner(int times){
        if (times % 2 == 0){
            // 偶数次
            System.out.println("Richard");
        }else{
            // 奇数此
            System.out.println("Louise");
        }
    }

    // 进行游戏，计数
    public static void winner(int n, int times) {
        // 游戏进行一次,计数
        times++;
        if (n == 1 || n < 1){
            // 终止条件
            return;
        }
        if (isPow(n)) {
            // 是2的幂，减半
            n = n / 2;
            winner(n, times);
        } else {
            // 不是2的幂，减去一个最接近的2的幂
            n -= highTwo(n)/2;
            winner(n,times);
        }
    }

    // 判断是不是2的幂
    public static boolean isPow(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    // 获取大于一个数且最近的2的幂
    private static int highTwo(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        if (n < 0) {
            return 1;
        } else {
            return n + 1;
        }
    }
}
