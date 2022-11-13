package Midterm.MidtermQuestion2;


public class BinTree<T> {
    public Node<T> root;

    public BinTree() {
        this.root = new Node<T>();
    }

    public void populateParent(){
        if(root==null)return;
        root.parent = root;
        dfs(root);
    }

    private void dfs(Node<T> root) {
        if(root==null) return;
        if(root.left!=null){
            root.left.parent = root;
            dfs(root.left);
        }
        if(root.right!=null){
            root.right.parent = root;
            dfs(root.right);
        }
    }
}