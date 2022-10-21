package hw4;

public class Assignment4_leetcode426 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public static void main(String[] args) {
        Node three = new Node(3);
        Node one = new Node(1);
        Node five = new Node(5);
        Node two = new Node(2, one, three);
        Node root = new Node(4, two, five);
        Node ans = treeToDoublyList(root);
        Node iterate = ans;
        do {
            System.out.println(iterate.val);
            iterate = iterate.right;
        }while(iterate!=ans);
    }

    private static Node dummy;
    public static Node treeToDoublyList(Node root) {
        if(root==null)return root;
        Node head = new Node();
        dummy = head;
        dfs(root);
        Node start = head.right;
        dummy.right = start;
        start.left = dummy;
        return head.right;
    }

    public static void dfs(Node root){
        if(root==null)return;
        Node l = root.left;
        Node r = root.right;
        dfs(l);
        dummy.right = root;
        root.left = dummy;
        dummy = dummy.right;

        dfs(r);
    }
}
