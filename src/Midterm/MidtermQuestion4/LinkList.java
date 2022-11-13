package Midterm.MidtermQuestion4;

public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data){

       if(head==null){
           head = new Node(data);
       }else if(head.data>=data){
           Node cur = new Node(data);
           cur.next = head;
           head = cur;
       }else{
           boolean insert = false;
           Node cur = new Node(data);
           Node dummy = new Node(Integer.MIN_VALUE);
           dummy.next = head;
           Node pre = dummy;
           while(pre.next!=null){
               if(pre.data<data && pre.next.data>=data){
                   Node nex = pre.next;
                   cur.next = nex;
                   pre.next = cur;
                   insert = true;
                   break;
               }
               pre = pre.next;
           }
           if(!insert) pre.next = cur;
       }
        length++;
    }
}
