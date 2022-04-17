package Exam.xinye;


public class T1 {
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    //设置字符数组
    //可以添加任意不重复字符，提高能转换的进制的上限
    static char chs[] = new char[36];
    static {
        for(int i = 0; i < 10 ; i++) {
            chs[i] = (char)('0' + i);
        }
        for(int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i - 10));
        }
    }

    public String changeFormatNumber (String number) {
        // write code here
        String s2 =  transRadix(number,10,2);
        s2 = format16(s2);
        String s16 = transRadix(number,10,16);
        s16 = format4(s16);
        String res = s2 +","+s16;
        return res;
    }

    /**
     * 转换方法
     * @param num       元数据字符串
     * @param fromRadix 元数据的进制类型
     * @param toRadix   目标进制类型
     * @return
     */
    static String transRadix(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(chs[number%toRadix]);
            number = number / toRadix;
        }
        return sb.reverse().toString();
    }


    /**
     * 补全16位
     * @param
     */
    public static String format16(String s){
        int n = s.length();
        StringBuilder res  = new StringBuilder();
        if (n < 16 && n > 0){
            int dif = 16 - n;
            for (int i = 0; i < dif; i++) {
                res.append("0");
            }
        }
        return res.append(s).toString();
    }

    /**
     * 补全4位
     * @param s
     * @return
     */
    public static String format4(String s){
        int n = s.length();
        StringBuilder res  = new StringBuilder();
        if (n < 4 && n > 0){
            int dif = 4 - n;
            for (int i = 0; i < dif; i++) {
                res.append("0");
            }
        }
        return res.append(s).toString();
    }
}
