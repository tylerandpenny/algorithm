package DataStructure;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
/**
 * 对一个保存英文文章的文本文档进行统计，最后给出每个英文字符的出现次数，按降幂排列
 */
public class StringAccount2 {
    static final Hashtable<String, Integer> h = new Hashtable<String, Integer>();
    public static void main(String args[]) {
        try {
            FileInputStream fis = new FileInputStream("str.txt");
            InputStreamReader dis = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(dis);
            String s = null;
            //统计字母
            while ((s = reader.readLine()) != null) {
                for (int i = 0; i < s.length(); i++) {
                    int temp = 0;
                    if (h.containsKey(String.valueOf(s.charAt(i))))
                        temp = h.get(String.valueOf(s.charAt(i))) + 1;
                    else
                        temp = 1;
                    h.remove(String.valueOf(s.charAt(i)));
                    h.put(String.valueOf(s.charAt(i)), temp);
                }
            }
            dis.close();
            //排序
            List<String> sortedKeys = new ArrayList<String>(h.keySet());
            Collections.sort(sortedKeys, new Comparator<Object>() {
                public int compare(Object arg0, Object arg1) {
                    return h.get(arg1) - (h.get(arg0));
                }
            });

            // 输出
            for (String str : sortedKeys)
                System.out.println("'" + str + "':" + h.get(str));
        } catch (IOException e) {
        }
    }
}
