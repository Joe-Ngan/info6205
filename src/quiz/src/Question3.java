import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question3 {
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
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, four, null);
        TreeNode two = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, two, three);

        List<Integer> list = levelOrder(root);
        for(int l : list){
            System.out.println(l);
        }
    }

    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
                list.add(cur.val);
            }
        }
        return list;
    }
}
