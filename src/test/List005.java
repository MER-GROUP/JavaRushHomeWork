package test;

import static java.util.Arrays.copyOfRange;

/**
 * Created by maxim on 20.07.2015.
 */
public class List005 {
    //узел односвязного списка
    public static class Node{
        //данные узла
        public int value;
        //ссылка на следующий узел
        public Node next;

        //конструктор узла
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        //перебор итерацией в перегруженном методе toString
        /*
        public String toString() {
            String result="";
            for (Node tail=this;tail!=null;tail=tail.next) {
                result+=tail.value+"->";
            }
            return result+"*";
        }
        */

        //рекурсивный перебор элементов в перегруженном toString
        public String toString(){
            /*тоже правильно
            Node tail=this;
            if (tail.next==null){
                return tail.value+"->*";
            }else{
                return tail.value+"->"+tail.next;
            }
            /* тоже правильно
            if (this.next==null){
                return this.value+"->*";
            }else{
                return this.value+"->"+this.next;
            }
            */
            return value+"->"+(next==null ? "*" : next.toString());
        }

        //рекурсивный перебор элементов в перегруженном toString
        public String toString(Node tail){
            /* тоже правильно
            if (tail==null){
                return "*";
            }else{
                return tail.value+"->"+toString(tail.next);
            }
            */
            return (tail==null)?"*":tail.value+"->"+toString(tail.next);
        }
    }

    //генерация списка
    public static Node generate(int length){
        /*тоже правильно
        // генерация списка итерацией
        Node tail=null;
        for (int i = 0; i < length; i++) {
            tail=new Node(1,tail);
        }
        return tail;
        */
        // генерация списка рекурсией
        /*
        if (0<length){
            return new Node(length,generate(length-1));
        }else{
            return null;
        }
        */
        // генерация списка рекурсией
        return (0==length)? null : new Node(length,generate(length-1));
    }

    //создание списка
    public static Node create(int... values){
        /*тоже правильно
        // создание списка итерацией
        Node tail=null;
        for (int i = values.length-1; 0 <= i; i--) {
            tail=new Node(values[i],tail);
        }
        return tail;
        */
        // создание списка рекурсией
        return values.length==0?null:new Node(values[0],create(copyOfRange(values, 1, values.length)));
    }

    //рекурсивное копирование списка
    public static Node copy(Node tail){
        return tail==null ? null : new Node(tail.value,copy(tail.next));
    }

    //рекурсивное сравнение списков
    public static boolean isEqual(Node t0,Node t1){
        if (t0!=null && t1!=null){
            return (t0.value==t1.value) && isEqual(t0.next, t1.next);
        }else{
            return t0==t1;
        }
    }

    //рекурсивный сортировочный метод слияния двух отсортированных списков
    public static Node merge(Node tailA, Node tailB){
        if (tailA!=null && tailB!=null){
            if (tailA.value<tailB.value){
                return new Node(tailA.value,merge(tailA.next,tailB));
            }else{
                return new Node(tailB.value,merge(tailA,tailB.next));
            }
        }else{
            return (tailA==null) ? tailB : tailA;
        }
    }

    //рекурсивный метод toString
    public static String toString(Node tail){
        return (tail==null) ? "*" : tail.value+"->"+toString(tail.next);
    }

    //поиск цикла в односвязном цикле
    private static boolean hasLoop(Node a){
        Node b=a.next;
        while (a!=b && b!=null){
            a=a.next;
            b=(b.next==null) ? null : b.next.next;
        }
        return a==b;
    }

    public static void main(String[] args) {
        //Node tail=create(3,2,1,0);
        //System.out.println(tail.toString(tail));
        //System.out.println(_(3,2,1,0));
        //Node tail=generate(5);
        //System.out.println(tail);
        /*
        Node tailA=generate(3);
        Node tailB=copy(tailA);
        System.out.println("a: "+tailA.toString(tailA));
        System.out.println("b: "+tailB.toString(tailB));
        System.out.println("isEqual: "+isEqual(tailA,tailB));
        System.out.println("---");
        tailB.next.next.value=1000;
        System.out.println("a: "+tailA.toString(tailA));
        System.out.println("b: "+tailB.toString(tailB));
        System.out.println("isEqual: "+isEqual(tailA,tailB));
        */
        /*
        Node tailA=new Node(1,new Node(1,new Node(10,new Node(11,null))));
        Node tailB=new Node(3,new Node(4,new Node(100,new Node(200,null))));
        System.out.println(tailA);
        System.out.println(tailB);
        System.out.println(merge(tailA,tailB));
        */
        Node tail=create(0,1,2,3,4,5,6,7,8,9);
        Node head=tail;
        System.out.println("tail = " + tail);
        System.out.println("head = " + head);
        System.out.println("---");
        for (;head.next!=null;head=head.next);
        System.out.println("head = " + head);
        System.out.println("---");
        head.next=tail.next.next.next.next.next;
        //System.out.println("head = " + head);//error
        //check
        System.out.println(hasLoop(head));
        System.out.println("---");

    }
}
