package hw4;

import hw2.Assignment2_leetcode314;

import java.util.ArrayList;
import java.util.List;

public class Assignemnt4_leetcode173 {

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
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15, nine, twenty);
        TreeNode root = new TreeNode(7, three, fifteen);

        BSTIterator obj = new BSTIterator(root);
        int param_1 = obj.next();
        boolean param_2 = obj.hasNext();
        System.out.println(param_1);
        System.out.println(param_2);
    }
    public static class BSTIterator {
        private List<Integer> list = new ArrayList<>();
        private int i = 0;
        public BSTIterator(TreeNode root) {
            dfs(root, list);
        }

        private void dfs(TreeNode root, List<Integer> list){
            if(root==null)return;
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
        public int next() {
            return list.get(i++);
        }

        public boolean hasNext() {
            return i<list.size();
        }
    }
}
