package hw4;

public class Assignment4_leetcode109 {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
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
         ListNode nine = new ListNode(9, null);
         ListNode five = new ListNode(5, nine);
         ListNode zero = new ListNode(0, five);
         ListNode minus3 = new ListNode(-3, zero);
         ListNode head = new ListNode(-10, minus3);
         TreeNode ans = sortedListToBST(head);
    }
    public static TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }
    public static TreeNode dfs(ListNode start, ListNode end){
        if(start==end){
            return null;
        }
        ListNode f = start;
        ListNode s = start;
        while(f!=end && f.next!=end){
            f = f.next.next;
            s = s.next;
        }
        TreeNode node = new TreeNode(s.val);
        node.left = dfs(start, s);
        node.right = dfs(s.next, end);
        return node;
    }
}
