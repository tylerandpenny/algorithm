package Exam.meicai;

import java.util.ArrayList;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split("#");
        int row = s1.length;
        int col = s1[0].split(",").length;
        int[][] matrix = new int[row][col];
        String[][] tempMatrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            tempMatrix[i] =  s1[i].split(",");
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.valueOf(tempMatrix[i][j]);
            }
        }

        ArrayList<Integer> res = printMatrix(matrix);
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + ",");
        }
        System.out.println(res.get(res.size() - 1));
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        // 二维数组行列
        int rows = matrix.length;
        int columns = matrix[0].length;
        // 保存返回序列的数组
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 功能函数：使用循环打印矩阵
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            // 打印一圈儿
            int endX = columns - 1 - start;
            int endY = rows - 1 - start;
            // 从左到右打印一行
            for (int i = start; i <= endX; ++i) {
                list.add(matrix[start][i]);
            }
            // 从上到下打印一列
            if (start < endY) {
                for (int i = start + 1; i <= endY; ++i) {
                    list.add(matrix[i][endX]);
                }
            }
            // 从右到左打印一行
            if (start < endX && start < endY) {
                for (int i = endX - 1; i >= start; --i) {
                    list.add(matrix[endY][i]);
                }
            }
            // 从下到上打印一列
            if (start < endX && start < endY - 1) {
                for (int i = endY - 1; i > start; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }
}

