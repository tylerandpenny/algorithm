package Exam.zhaoyin;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int [] arr = {20,12,19,6,10,5,7,3};
        Scanner sc  = new Scanner(System.in);
        int number = sc.nextInt();
        //将数据插入到新数组末尾当中。
        int [] new_arr  = new int[arr.length+1];
        for (int i = 0; i < new_arr.length; i++) {
            if(i == new_arr.length-1){
                new_arr[i] = number;
                break;
            }
            new_arr[i] = arr[i];
        }
        HeapInsert(new_arr);
        System.out.println(Arrays.toString(new_arr));
    }

    public static void HeapInsert(int [] new_arr){
        int start_index = new_arr.length-1;
        int parent_index  = (start_index-1)/2;
        while(start_index > 0){
            if(new_arr[parent_index]>new_arr[start_index]){
                break;
            }else{
                int temp = new_arr[start_index];
                new_arr[start_index] = new_arr[parent_index];
                new_arr[parent_index] = temp;
                start_index = parent_index;
                parent_index = (start_index-1)/2;
            }
        }
    }
}
