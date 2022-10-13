package hw2;

import java.util.ArrayList;
import java.util.List;

public class Assignment2_leetcode366 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode root = new TreeNode(1, two, three);
        findLeaves(root);
        System.out.println(list);
    }

    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> findLeaves(TreeNode root) {
        countDepth(root);
        return list;
    }
    public static int countDepth(TreeNode node){
        if(node==null)return 0;
        int l = countDepth(node.left);
        int r = countDepth(node.right);
        int cur = Math.max(l,r)+1;
        if(list.size()==cur-1)list.add(new ArrayList<>());
        list.get(cur-1).add(node.val);
        return cur;
    }
}
