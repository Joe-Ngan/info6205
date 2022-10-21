package hw4;

public class Assignment4_leetcode98 {

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
        TreeNode three = new TreeNode(3, null, null);
        TreeNode one = new TreeNode(1, null, null);
        TreeNode root = new TreeNode(2, one, three);
        System.out.println(isValidBST(root));
    }
    private static boolean flag = true;
    public static boolean isValidBST(TreeNode root) {
        if(root==null)return flag;
        dfs(root.left, Long.MIN_VALUE, root.val);
        dfs(root.right, root.val, Long.MAX_VALUE);
        return flag;
    }

    public static void dfs(TreeNode root, long low, long high){
        if(root==null)return;
        if(root.val<=low || root.val>=high){
            flag = false;
        }else{
            dfs(root.left, low, Math.min(high, root.val));
            dfs(root.right, Math.max(low, root.val), high);
        }
    }
}
