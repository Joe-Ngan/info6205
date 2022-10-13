package hw2;

import java.util.ArrayList;
import java.util.List;

public class Assignment2_leetcode103 {
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
        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode root = new TreeNode(3, nine, twenty);
        zigzagLevelOrder(root);
    }
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    public static void dfs(TreeNode node, int level){
        if(node==null)return;
        if(list.size()<=level){
            list.add(new ArrayList<>());
        }

        if(level%2==0){
            list.get(level).add(node.val);
        }else{
            list.get(level).add(0, node.val);
        }
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}
