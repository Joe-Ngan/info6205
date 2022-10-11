public class Assignment1_leetcode203 {
    public static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Node seven = new Node(6, null);
        Node six = new Node(5, seven);
        Node five = new Node(4, six);
        Node four = new Node(3, five);
        Node three = new Node(6, four);
        Node two = new Node(2, three);
        Node head = new Node(1, two);
        System.out.println(removeElements(head,6));
    }

    public static Node removeElements(Node head, int val) {
        Node dummy = new Node(0, head);
        Node pre = dummy;
        while(pre!=null && pre.next!=null){
            while(pre.next!=null && pre.next.val==val){
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return dummy.next;
    }
}
