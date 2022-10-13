package hw2;

import java.util.ArrayList;
import java.util.List;

public class Assignment2_leetcode199 {
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
        TreeNode three = new TreeNode(3, null, four);
        TreeNode two = new TreeNode(2, null, five);
        TreeNode root = new TreeNode(1, two, three);
        List<Integer> list = rightSideView(root);
        for(int l : list){
            System.out.println(l);
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    public static void dfs(TreeNode root, List<Integer> list, int depth){
        if(root==null)return;
        if(depth==list.size())list.add(root.val);
        dfs(root.right, list, depth+1);
        dfs(root.left, list, depth+1);
    }
}
