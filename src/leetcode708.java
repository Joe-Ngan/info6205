public class leetcode708 {
    public static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Node one = new Node(1, null);
        Node four = new Node(4, one);
        Node head = new Node(3, four);
        one.next = head;
        System.out.println(insert(head, 2));
    }

    public static Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if(head==null){
            insert.next = insert;
            return insert;
        }

        Node dummy = new Node();
        dummy = head;

        while(dummy.next!=head){
            int cur = dummy.val;
            int nex = dummy.next.val;
            //normally, nex is larger than cur, and [cur<insert<nex]
            if(nex>=cur){
                if(cur<=insertVal && insertVal<nex)break;
            }else{
                if(insertVal<=nex || cur<=insertVal)break;
            }
            dummy = dummy.next;
        }
        Node nexNode = dummy.next;
        dummy.next = insert;
        insert.next = nexNode;
        return head;
    }
}
