package Exam.PUFA;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = Integer.valueOf(s.charAt(s.length() - 1)) - 48;
//        System.out.println(n);
        s = s.replace('[', ' ');
        s = s.replace(']', ' ');
        String[] all = s.trim().split(",");

//        for (int i = 0; i < all.length - 1; i++) {
//            System.out.print(all[i] + " ");
//        }

        Map<String, Integer> appTime = new HashMap<String, Integer>();
        appTime.put(all[0],1);
        for (int i = 1; i < all.length - 1; i++) {
           if (appTime.keySet().contains(all[i])){
               // 元素出现过
               int old = appTime.get(all[i]);
               appTime.put(all[i],old + 1);
           }else {
               // 没出现过
               appTime.put(all[i],1);
           }
        }
        // 对出现次数排序，取前n个
       StringBuilder res = new StringBuilder();
        Set<Map.Entry<String, Integer>> treeSet = new TreeSet<Map.Entry<String, Integer>>(
                new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> o1,
                                       Map.Entry<String, Integer> o2) {
                        Integer d1 = o1.getValue();
                        Integer d2 = o2.getValue();
                        int r = d2.compareTo(d1);

                        if (r != 0)
                            return r;
                        else
                            return o2.getKey().compareTo(o1.getKey());
                    }

                });
        treeSet.addAll(appTime.entrySet());
        int m =0;
        for(Map.Entry<String, Integer> mapoutReusutby:treeSet){
            if(m<10){
                mapoutReusutby.getKey();
                mapoutReusutby.getValue();
                res.append(mapoutReusutby.getKey());
            }
        }
        // 输出
        System.out.print("[");
        for (int i = 0; i < n-1; i++) {
            System.out.print(res.charAt(i) + ",");
        }
        System.out.print(res.charAt(n-1));
        System.out.print("]");


    }


}
