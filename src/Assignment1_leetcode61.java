public class Assignment1_leetcode61 {
    public static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Node five = new Node(5, null);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node head = new Node(1, two);
        System.out.println(rotateRight(head,2));
    }

    public static Node rotateRight(Node head, int k) {
        int len = findLength(head);
        Node dummy = new Node();
        dummy.next = head;
        Node pre = dummy;
        if(len==0 || k%len==0)return head;
        int cnt = len-k%len;
        while(cnt-->0){
            pre = pre.next;
        }
        Node newHead = pre.next;
        pre.next = null;

        pre = newHead;
        while(pre.next!=null){
            pre = pre.next;
        }
        pre.next = head;
        return newHead;
    }

    public static int findLength(Node head){
        int lengthCnt = 0;
        while(head!=null){
            head = head.next;
            lengthCnt+=1;
        }
        return lengthCnt;
    }
}
