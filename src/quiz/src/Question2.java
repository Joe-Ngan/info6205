public class Question2 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode threeP = new TreeNode(3, null, null);
        TreeNode twoP = new TreeNode(2, null, null);
        TreeNode p = new TreeNode(1, twoP, threeP);
        TreeNode threeQ = new TreeNode(3, null, null);
        TreeNode twoQ = new TreeNode(2, null, null);
        TreeNode q = new TreeNode(1, twoQ, threeQ);
        System.out.println(isSameTree(p, q));

        TreeNode twoPP = new TreeNode(2, null, null);
        TreeNode p1 = new TreeNode(1, null, twoPP);
        TreeNode twoQQ = new TreeNode(2, null, null);
        TreeNode q1 = new TreeNode(1, twoQQ, null);
        System.out.println(isSameTree(p1, q1));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.val != q.val)return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }


}
