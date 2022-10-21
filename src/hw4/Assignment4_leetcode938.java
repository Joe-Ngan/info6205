package hw4;

public class Assignment4_leetcode938 {
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
        TreeNode eighteen = new TreeNode(18, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode fifteen = new TreeNode(15, null, eighteen);
        TreeNode five = new TreeNode(5, three, seven);
        TreeNode root = new TreeNode(10, five, fifteen);
        System.out.println(rangeSumBST(root, 7, 15));
    }
    private static int cnt;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        cnt = 0;
        dfs(root, low, high);
        return cnt;
    }

    public static void dfs(TreeNode root, int low, int high){
        if(root==null){
            return;
        }
        if(root.val<=high && root.val>=low){
            cnt+= root.val;
        }

        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }
}
