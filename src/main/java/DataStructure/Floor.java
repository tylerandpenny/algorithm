package DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 3 2
 * 2 3 4
 */
public class Floor {
        public static void main(String []args) {
            Scanner sc = new Scanner(System.in);
            Integer N = sc.nextInt();
            Integer K = sc.nextInt();
            List<Integer> floors = new ArrayList();
            for(int i = 0; i<N; ++i){
                floors.add(sc.nextInt());
            }

            floors.sort((o1,o2) -> {
                return o2.compareTo(o1);
            });
            for(int i = 0; i <N; i++) {
                System.out.print(floors.get(i));
            }

            System.out.println(getCount(N, K, 0, floors));

        }

    private static int getCount(int n, int k, int index, List<Integer> list) {
        if (n <= k) {
            return (list.get(index) - 1) * 2;
        } else {
            return getCount(k, k, index, list) + getCount(n - k, k, index + k, list);
        }
    }

}
