package hw4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Assignment4_leetcode449 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode root = new TreeNode(2);
        root.left = one;
        root.right = three;
        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans);
    }
    public static class Codec {

        // Encodes a tree to a single string.
        private String s = "";
        public String serialize(TreeNode root) {
            if(root==null)return "null";
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                s+=root.val;
                s+=",";
                if(root.right!=null)stack.push(root.right);
                if(root.left!=null)stack.push(root.left);
            }
            System.out.println(s);
            return s;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.println(data);
            if(data=="null")return null;
            String[] nums = data.split(",");
            Queue<Integer> q = new LinkedList<>();
            for(String num : nums){
                int curNum = Integer.parseInt(num);
                q.offer(curNum);
            }
            return dfs(q);
        }
        public TreeNode dfs(Queue<Integer> right){
            if(right.isEmpty())return null;
            TreeNode r = new TreeNode(right.poll());
            Queue<Integer> left = new LinkedList<>();
            while(!right.isEmpty() && right.peek() < r.val)left.offer(right.poll());
            r.left = dfs(left);
            r.right = dfs(right);
            return r;
        }

    }

}
