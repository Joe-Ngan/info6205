public class Assignment2_leetcode236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        two.left = seven;
        two.right = four;
        TreeNode six = new TreeNode(6);
        TreeNode one = new TreeNode(1);
        one.left = zero;
        one.right = eight;
        TreeNode five = new TreeNode(5);
        five.left = six;
        five.right = two;
        TreeNode root = new TreeNode(3);
        root.left = five;
        root.right = one;
        TreeNode ans = lowestCommonAncestor(root, five, one);
        System.out.println(ans.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(root.val==p.val || root.val==q.val)return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if(l!=null && r!=null)return root;
        if(l!=null && r==null)return l;
        if(l==null && r!=null)return r;
        return null;
    }

}
