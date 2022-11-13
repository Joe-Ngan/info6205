package Midterm.MidtermQuestion4;

public class Main {
    private static LinkList list;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        list = new LinkList();
        insertOne(3);
        insertOne(0);
        insertOne(6);
        insertOne(-2);
        insertOne(4);
        insertOne(7);
        insertOne(0);
        insertOne(0);
    }

    private static void insertOne(int i) {
        list.insert(i);
        System.out.println("Now the length is "+list.length+ " and the head is: "+list.head.data);
        Node iter = list.head;
        while(iter!=null){
            System.out.print(iter.data);
            iter = iter.next;
            if(iter!=null)System.out.print(",");
        }
        System.out.println("");
    }
}