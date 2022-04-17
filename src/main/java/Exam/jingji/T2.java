package Exam.jingji;

import java.util.LinkedList;
import java.util.List;

public class T2 {
    public static void main(String[] args) {

    }


    public static void threeOrders(TreeNode root) {
        // write code here
        List<Integer> forwardS = new LinkedList<Integer>();
        List<Integer> midS = new LinkedList<Integer>();
        List<Integer> backwardS = new LinkedList<Integer>();
        dfsforwardS(root, forwardS);
        dfsmidS(root,midS);
        dfsbackwardS(root,backwardS);
        int n = forwardS.size();
        int[][] res = new int[3][n];

        for (int i = 0; i < n; i++) {
            res[0][i] = forwardS.get(i);
            res[1][i] = midS.get(i);
            res[2][i] = backwardS.get(i);
        }
    }

    // 先序
    private static void dfsforwardS(TreeNode tree, List<Integer> res) {
        // 根
        res.add(tree.val);
        // 左
        if (tree.left != null) {
            dfsforwardS(tree.left, res);
        }
        // 右
        if (tree.right != null) {
            dfsforwardS(tree.right, res);
        }
    }

    // 中序
    private static void dfsmidS(TreeNode tree, List<Integer> res) {
        // 左
        if (tree.left != null) {
            dfsmidS(tree.left, res);
        }
        // 根
        res.add(tree.val);
        // 右
        if (tree.right != null) {
            dfsmidS(tree.right, res);
        }
    }

    // 后序
    private static void dfsbackwardS(TreeNode tree, List<Integer> res) {
        // 左
        if (tree.left != null) {
            dfsbackwardS(tree.left, res);
        }
        // 右
        if (tree.right != null) {
            dfsbackwardS(tree.right, res);
        }
        // 根
        res.add(tree.val);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}