public class leetcode725 {
    public static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Node three = new Node(3, null);
        Node two = new Node(2, three);
        Node head = new Node(1, two);
        System.out.println(splitListToParts(head,5));
    }
    private static int idx = 0;
    private static Node pre;
    public static Node[] splitListToParts(Node head, int k) {
        int n = countLen(head);//计算长度
        int ave = n/k;//计算平均长度
        int carry = n%k;//计算余数

        Node[] ans = new Node[k];

        pre = head;//创建遍历节点pre

        for(int i=0; i<carry; i++){//创建余数个长度为ave+1的链表
            int curLen = ave;
            Node curHead = pre;
            while(curLen-->0){
                pre = pre.next;
            }
            Node nex = pre.next;
            pre.next = null;
            ans[idx++] = curHead;
            pre = nex;
        }

        while(pre!=null){//为剩余部分创建长度为ave的链表
            int curLen = ave-1;
            Node curHead = pre;
            while(curLen-->0){
                pre = pre.next;
            }
            Node nex = pre.next;
            pre.next = null;
            ans[idx++] = curHead;
            pre = nex;
        }
        return ans;
    }

    public static int countLen(Node head){
        int countLen =0;
        while(head!=null){
            head = head.next;
            countLen+=1;
        }
        return countLen;
    }
}
