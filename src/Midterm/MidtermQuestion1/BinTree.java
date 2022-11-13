package Midterm.MidtermQuestion1;

import java.util.LinkedList;
import java.util.Queue;

public class BinTree <T> {
    public Node<T> root;

    public BinTree() {
        this.root = new Node<T>();
    }

    public void populateNextRight(){
        if(root==null)return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node cur = q.poll();
                if(cur.right!=null)q.offer(cur.right);
                if(cur.left!=null)q.offer(cur.left);
                cur.nextLeft = q.isEmpty()?null:q.peek();
            }
        }
    }
}