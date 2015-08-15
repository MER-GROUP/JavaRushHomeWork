package test;

/**
 * Created by maxim on 22.07.2015.
 */
public class List007 {
    //звено двусвязного списка
    public static class DoubleNode<Type>{
        public Type value;
        public DoubleNode prev;
        public DoubleNode next;

        //конструктор
        public DoubleNode(Type value, DoubleNode prev, DoubleNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    //main
    public static void main(String[] args) {
        //определение двусвязанного списка #1
        /*
        DoubleNode node3=new DoubleNode(3,null,null);
        DoubleNode node2=new DoubleNode(2,null,null);
        DoubleNode node1=new DoubleNode(1,null,null);
        DoubleNode node0=new DoubleNode(0,null,null);

        node3.prev=node2;
        node2.prev=node1;
        node1.prev=node0;

        node0.next=node1;
        node1.next=node2;
        node2.next=node3;

        DoubleNode ref=node0;
        */

        //определение двусвязанного списка #2
        /*
        DoubleNode node3=new DoubleNode(3,null,null);
        DoubleNode node2=new DoubleNode(2,null,node3);
        DoubleNode node1=new DoubleNode(1,null,node2);
        DoubleNode node0=new DoubleNode(0,null,node1);

        node3.prev=node2;
        node2.prev=node1;
        node1.prev=node0;

        DoubleNode ref=node0;
        */

        //определение двусвязанного списка #3
        /*
        DoubleNode node0=new DoubleNode(0,null,null);
        DoubleNode node1=new DoubleNode(1,node0,null);
        DoubleNode node2=new DoubleNode(2,node1,null);
        DoubleNode node3=new DoubleNode(3,node2,null);

        node0.next=node1;
        node1.next=node2;
        node2.next=node3;

        DoubleNode ref=node0;
        */

        //определение двусвязанного списка #4
        /*
        DoubleNode ref=new DoubleNode(0,null,new DoubleNode(1,null,new DoubleNode(2,null,new DoubleNode(3,null,null))));
        ref.next.prev=ref;
        ref.next.next.prev=ref.next;
        ref.next.next.next.prev=ref.next.next;
        */

        //удаление элемента из двусвязного списка
        //создаем двусвязный список {0,1,2,3}
        /*
        DoubleNode ref=new DoubleNode(0,null,new DoubleNode(1,null,new DoubleNode(2,null,new DoubleNode(3,null,null))));
        ref.next.prev=ref;
        ref.next.next.prev=ref.next;
        ref.next.next.next.prev=ref.next.next;
        //удаляем элемент 1 из {0,1,2,3}->{0,2,3}
        //шаг #1
        ref.next=ref.next.next;
        //шаг #2
        ref.next.prev=ref;
        //проверяем
        System.out.println(ref.value);
        System.out.println(ref.next.value);
        System.out.println(ref.next.next.value);
        */

        //вставка элемента в двусвязный список
        //создаем двусвязный список {0,1,2}
        DoubleNode ref=new DoubleNode(0,null,new DoubleNode(1,null,new DoubleNode(2,null,null)));
        ref.next.prev=ref;
        ref.next.next.prev=ref.next;
        //встявляем элемент 9 между 1 и 2 в {0,1,2}->{0,1,9,2}
        //шаг #1 создаем новый узел ссылающийся на 1 и 2
        DoubleNode newNode=new DoubleNode(9,ref.next,ref.next.next);
        //шаг #2
        ref.next.next.prev=newNode;
        //шаг #3
        ref.next.next=newNode;
        //проверяем
        System.out.println(ref.value);
        System.out.println(ref.next.value);
        System.out.println(ref.next.next.value);
        System.out.println(ref.next.next.next.value);
    }
}
