package hw4;

public class Assignment4_leetcode285 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode root = new TreeNode(2);
        root.left = one;
        root.right = three;
        inorderSuccessor(root, one);
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        if(root==null)return null;
        while(root!=null){
            if(root.val>p.val){
                ans = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ans;
    }
}
