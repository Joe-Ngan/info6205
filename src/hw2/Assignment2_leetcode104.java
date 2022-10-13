package hw2;

public class Assignment2_leetcode104 {

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
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r)+1;
    }
}
