package test;

/**
 * Created by maxim on 20.07.2015.
 */
public class List004 {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static Node $(int value){
        return $(value,null);
    }

    private static Node $(int value, Node next) {
        return new Node(value,next);
    }

    public static void main(String[] args) {
//        Node tail;
//        Node node0=new Node(0,null);
//        Node node1=new Node(1,null);
//        Node node2=new Node(2,null);
//        Node node3=new Node(3,null);
//
//        node3.next=node2;
//        node2.next=node1;
//        node1.next=node0;
//
//        tail=node3;

//        Node tail;
//        tail=new Node(0,null);
//        tail=new Node(1,tail);
//        tail=new Node(2,tail);
//        tail=new Node(3,tail);

//        Node tail=new Node(3,new Node(2,new Node(1,new Node(0,null))));

        Node tail=$(3,$(2,$(1,$(0))));
    }
}
