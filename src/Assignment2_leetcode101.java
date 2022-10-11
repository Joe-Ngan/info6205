import javax.swing.tree.TreeNode;

public class Assignment2_leetcode101 {

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
        TreeNode fourL = new TreeNode(4);
        TreeNode fourR = new TreeNode(4);
        TreeNode threeL = new TreeNode(3);
        TreeNode threeR = new TreeNode(3);
        TreeNode twoL = new TreeNode(2, threeL, fourL);
        TreeNode twoR = new TreeNode(2, threeR, fourR);
        TreeNode root = new TreeNode(1, twoL, twoR);
        isSymmetric(root);
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSym(root.left, root.right);
    }
    public static boolean isSym(TreeNode l, TreeNode r){
        if(l==null && r==null)return true;
        if(l==null || r==null)return false;
        if(l.val != r.val)return false;
        return isSym(l.left, r.right)&&isSym(l.right, r.left);
    }

}
