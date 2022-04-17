package DataStructure;

import java.util.*;

/**
 * CBEFDA CBAEDF
 * ABDCEF
 */
public class midAfter2Before {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String back = input.split(" ")[0];
        String mid = input.split(" ")[1];
        int count = back.length();

        BiTree b = new BiTree(mid, back, 0, 0, count);
        for (Character character : levelOrder(b.root)) {
            System.out.print(character);
        }
    }

    public static List<Character> levelOrder(BiTreeNode root) {
        List<Character> answer = new ArrayList<>();
        if (root == null)
            return answer;

        LinkedList<BiTreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int levelSize = treeNodes.size();
            for (int i = 0; i < levelSize; i++) {
                BiTreeNode currentNode = treeNodes.poll(); //get and remove the first one
                answer.add(currentNode.getData());
                if (currentNode.getLeftchild() != null)
                    treeNodes.add(currentNode.getLeftchild()); //add to the end
                if (currentNode.getRightchild() != null)
                    treeNodes.add(currentNode.getRightchild());
            }//遍历完一层
        }
        return answer;
    }
}

class BiTree {
    BiTreeNode root;

    public BiTree(String in, String po, int Inindex, int Poindex, int count) {
        if (count > 0) {
            char r = po.charAt(Poindex + count - 1);
            int i;
            for (i = 0; i < count; i++)
                if (r == in.charAt(Inindex + i))
                    break;
            root = new BiTreeNode(r);
            root.setLeftchild(new BiTree(in, po, Inindex, Poindex, i).root);
            root.setRightchild(new BiTree(in, po, i + 1 + Inindex, Poindex + i, count - i - 1).root);
        }
    }

}

class BiTreeNode {
    private char data;
    private BiTreeNode Leftchild;
    private BiTreeNode Rightchild;

    public BiTreeNode(char r) {
        data = r;
        Leftchild = null;
        Rightchild = null;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public BiTreeNode getLeftchild() {
        return Leftchild;
    }

    public void setLeftchild(BiTreeNode leftchild) {
        Leftchild = leftchild;
    }

    public BiTreeNode getRightchild() {
        return Rightchild;
    }

    public void setRightchild(BiTreeNode rightchild) {
        Rightchild = rightchild;
    }
}
