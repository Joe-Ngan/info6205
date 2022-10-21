package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment4_leetcode99 {

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
       TreeNode two = new TreeNode(2, null, null);
       TreeNode three = new TreeNode(3, null, two);
       TreeNode root = new TreeNode(1, three, null);
        recoverTree(root);
    }

    private static int a;
    private static int b;
    private static boolean flag;
    public static void recoverTree(TreeNode root) {
        if(root==null)return;
        List<Integer> list = new ArrayList<>();
        flag = false;
        inOrder(root, list);
        List<Integer> sort = new ArrayList<>(list);
        Collections.sort(sort);
        a = -1;
        b = -1;
        flag = true;
        for(int i=0; i<sort.size(); i++){
            if(sort.get(i)!=list.get(i)){
                a = sort.get(i);
                b = list.get(i);
                break;
            }
        }
        inOrder(root, list);
        return;
    }

    public static void inOrder(TreeNode root, List<Integer> list){
        if(root==null)return;
        inOrder(root.left, list);
        if(!flag){
            list.add(root.val);
        }else{
            if(root.val==a){
                root.val = b;
            }else if(root.val == b){
                root.val = a;
            }
        }
        inOrder(root.right, list);
    }
}
