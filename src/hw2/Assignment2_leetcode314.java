package hw2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Assignment2_leetcode314 {

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
        List<List<Integer>> ans = verticalOrder(root);
    }
    static class Node{
        TreeNode node;
        int i;
        public Node(){}
        public Node(TreeNode n, int i){
            this.node = n;
            this.i = i;
        }
    }
    public static int min = 0, max = 0;
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        dfs(root, 0);
        for(int i=min; i<=max; i++)list.add(new ArrayList<>());
        Queue<Node> q = new LinkedList<>();
        if(root==null)return new ArrayList<>();
        q.offer(new Node(root, -min));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node cur = q.poll();
                TreeNode curNode = cur.node;
                int v = cur.i;
                if(curNode.left!=null)q.offer(new Node(curNode.left, v-1));
                if(curNode.right!=null)q.offer(new Node(curNode.right, v+1));
                list.get(v).add(curNode.val);
            }
        }
        return list;
    }
    public static void dfs(TreeNode node, int i){
        if(node==null)return;
        min = Math.min(min,i);
        max = Math.max(max,i);
        dfs(node.left, i-1);
        dfs(node.right, i+1);

    }
}
