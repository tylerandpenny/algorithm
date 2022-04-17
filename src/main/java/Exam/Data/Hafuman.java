package Exam.Data;

import java.util.ArrayList;

/**
 * 哈夫曼树
 */

public class Hafuman {
    public static void main(String[] args){
        HalfTree tree = new HalfTree();
        tree.create_tree("aaabbccccddddddee");
        System.out.println("先序遍历：");
        tree.before_output(tree.root);
        System.out.println("----------------");
        System.out.println("中序遍历：");
        tree.middle_output(tree.root);
        System.out.println("----------------");
        System.out.println("后序遍历：");
        tree.behind_output(tree.root);
    }
}

/**
 * 哈夫曼树
 */
class HalfTree {
    static Node root;
    String s = "";
    //用来存放节点
    ArrayList<Node> list = new ArrayList<Node>();

    /**
     * 生成哈夫曼树
     *
     * @param str
     */
    public void create_tree(String str) {
        //统计字符及出现的次数
        int[] count = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            count[ch]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                char ch = (char) i;        //强制转换为char类型
                int number = count[i];
                Node node = new Node(ch + "");
                node.weight = number;
                list.add(node);
            }
        }

        while (list.size() > 1) {
            //根据权值进行排序
            this.sort();
            Node left = list.remove(0);
            Node right = list.remove(0);
            String s = left.data + right.data;
            Node father = new Node(s);
            father.setWeight(left.weight + right.weight);
            father.setLeft(left);
            father.setRight(right);
            list.add(0, father);
        }
        root = list.get(0);
    }

    //根据节点的权值从小到大进行排序
    public void sort() {
        Node temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).weight > list.get(j).weight) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    //先序遍历(根--->左--->右)
    public void before_output(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.getData() + " " + node.getWeight());
            before_output(node.getLeft());
            before_output(node.getRight());
        }
    }

    //中序遍历(左---根--->右 )
    public void middle_output(Node node) {
        if (node.getLeft() != null) {
            middle_output(node.getLeft());
        }
        System.out.println(node.getData() + " " + node.getWeight());
        if (node.getRight() != null) {
            middle_output(node.getRight());
        }
    }

    //后序遍历(左--->右--->根)
    public void behind_output(Node node) {
        if (node.getLeft() != null) {
            behind_output(node.getLeft());
        }
        if (node.getRight() != null) {
            behind_output(node.getRight());
        }
        System.out.println(node.getData() + " " + node.getWeight());
    }
}

/**
 * node类
 * 左右子节点
 * 数据
 * 权重
 */
class Node {

    Node left, right;
    String data;
    int weight;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}