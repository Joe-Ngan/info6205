package hw1;

public class Assignment1_leetcode1721 {
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
        System.out.println(swapNodes(head,2));
    }

    public static Node swapNodes(Node head, int k) {
        int n = countLen(head);//计算长度
        if(n==0 || n-k+1==k)return head;//特殊化处理

        Node dummy = new Node();//创建dummy节点
        dummy.next = head;
        Node pre = dummy;

        int pre1 = k-1, pre2 = n-k;//要交换n-k+1和k的值，先找到n-k和k-1
        while(pre1-->0){
            pre = pre.next;
        }
        Node node1 = pre.next;//记录k节点
        pre = dummy;
        while(pre2-->0){
            pre = pre.next;
        }
        Node node2 = pre.next;//记录n-k+1节点

        int temp = node1.val;//交换节点
        node1.val = node2.val;
        node2.val = temp;

        return dummy.next;
    }

    public static int countLen(Node head){
        int countLen = 0;
        while(head!=null){
            head = head.next;
            countLen+=1;
        }
        return countLen;
    }
}
