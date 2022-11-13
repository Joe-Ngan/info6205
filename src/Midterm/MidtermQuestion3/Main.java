package Midterm.MidtermQuestion3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Node<Integer> node = getBST();
        int[] res = inRange(node, 5, 8);
        for(int r : res){
            System.out.println(r);
        }
    }

    private static List<Integer> list = new ArrayList<>();
    private static int[] inRange(Node<Integer> root, int l, int r) {
        dfs(root, l, r);
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++)res[i] = list.get(i);
        return res;
    }

    private static void dfs(Node<Integer> root, int l, int r){
        if(root==null)return;
        if(root.data>=l && root.data<=r)list.add(root.data);
        dfs(root.right, l, r);
        dfs(root.left, l, r);
    }

    private static Node<Integer> getBST(){
        Node<Integer> root = new Node<>(8);
        root.parent = root;

        root.left = new Node<>(3);
        root.right = new Node<>(10);
        root.left.parent = root;
        root.right.parent = root;


        root.left.left = new Node<>(1);
        root.left.right = new Node<>(6);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.right.right = new Node<>(14);
        root.right.right.parent = root.right;

        root.left.right.left = new Node<>(4);
        root.left.right.right = new Node<>(17);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;


        root.right.right.left = new Node<>(13);
        root.right.right.left.parent = root.right.right;

        return root;
    }

}