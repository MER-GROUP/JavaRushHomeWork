package test;

/**
 * Created by maxim on 20.07.2015.
 */
public class List {
    //односвязный список
    public static class Node {
        private int element;
        private Node next;

        public int getElement(){
            return element;
        }

        public void setElement(int e){
            element = e;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }
    }

    public static void main(String[] args) {
        Node node=new Node();
        node.setElement(2);
        node.setNext(node);

        System.out.println(node.element);
        System.out.println(node.getNext());
        System.out.println(node.getNext().element);
        System.out.println(node.getElement());
        System.out.println(node.getNext().getElement());
    }
}
