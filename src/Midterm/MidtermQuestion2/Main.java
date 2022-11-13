package Midterm.MidtermQuestion2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BinTree b = getTree();
        b.populateParent();
        System.out.println("the node "+b.root.right.data+" has its parent value of "+b.root.right.parent.data+".");
    }

    private static BinTree<Integer> getTree(){
        BinTree<Integer> tree = new BinTree<>();

        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);


        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);


        return tree;
    }
}