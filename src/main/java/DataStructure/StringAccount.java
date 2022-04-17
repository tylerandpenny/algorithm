package DataStructure;

import java.util.*;

/**
 * 字符统计与重排
 *
 *给出⼀个仅包含字⺟的字符串，不包含空格，统计字符串中各个字⺟（区分⼤⼩写）出现的次数，并按照字⺟出现次数从⼤到⼩的顺序输出各个
 * 字⺟及其出现次数。如果次数相同，按照⾃然顺序进⾏排序，且⼩写字⺟在⼤写字⺟之前。
 * 输⼊描述：
 *
 * 输⼊⼀⾏，为⼀个仅包含字⺟的字符串。
 *
 * 输出描述：
 *
 * 按照字⺟出现次数从⼤到⼩的顺序输出各个字⺟和字⺟次数，⽤英⽂分号分隔，注意末尾的分号；字⺟和次数间⽤英⽂冒号分隔。
 *
 * 示例1：
 * 输入
 *
 * xyxyXX
 *
 * 输出
 *
 * x:2;y:2;X:2
 */
public class StringAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) {
              if (m1.getValue() ==  m2.getValue()){
                  int m1a = (int) m1.getKey();
                  int m2a = (int) m2.getKey();
                  System.out.println(m1a);
                  System.out.println(m2a);
                  if ((m1a < 91 && m2a >96) || (m1a >96 && m2a < 91)){
                      System.out.println("一大一小");
                      return (int) m2.getKey() - (int) m1.getKey();
                  }
                  return (int) m1.getKey() - (int) m2.getKey();
              }
              return m2.getValue() - m1.getValue();
            }
        });

        StringBuffer sb = new StringBuffer();
        StringBuffer sbB = new StringBuffer();

        for (int i = 0; i < list.size() - 1; i++) {
//            if ((int)list.get(i).getKey() < 91 ){
//                sbB.append(list.get(i).getKey()).append(":").append(list.get(i).getValue()).append(";");
//                continue;
//            }
            sb.append(list.get(i).getKey()).append(":").append(list.get(i).getValue()).append(";");
        }

        sb.append(list.get(list.size() - 1).getKey()).append(":").append(list.get(list.size() - 1).getValue()).append(";");//.append(";" + sbB);

        System.out.println(sb.toString());
    }

}
