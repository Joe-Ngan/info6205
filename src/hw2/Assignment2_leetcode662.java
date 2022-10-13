package hw2;

import java.util.ArrayList;
import java.util.List;

public class Assignment2_leetcode662 {

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
        TreeNode nine = new TreeNode(9);
        TreeNode five = new TreeNode(5);
        TreeNode three2 = new TreeNode(3);
        TreeNode two = new TreeNode(2, null, nine);
        TreeNode three = new TreeNode(3, five, three2);
        TreeNode root = new TreeNode(1, three, two);
        System.out.println(widthOfBinaryTree(root));

    }
    public static int ans = Integer.MIN_VALUE;
    public static List<List<Integer>> list = new ArrayList<>();
    public static int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return ans;
    }

    public static void dfs(TreeNode root, int k, int level){
        if(list.size()==level-1)list.add(new ArrayList<>());
        list.get(level-1).add(k);
        List<Integer> temp = list.get(level-1);
        ans = Math.max(ans, temp.get(temp.size()-1)-temp.get(0)+1);
        if(root.left!=null) dfs(root.left, 2*k, level+1);
        if(root.right!=null) dfs(root.right, 2*k+1, level+1);
    }
}
