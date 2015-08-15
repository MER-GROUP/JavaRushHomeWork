package test;

/**
 * Created by maxim on 21.07.2015.
 */
public class List006 {
    public static class Node<Type>{
        private Type value;
        private Node next;
        private static boolean check;

        //конструктор по умолчанию
        public Node() {
        }

        //перегруженный конструктор
        public Node(Type value,Node next) {
            this.value = value;
            this.next = next;
        }

        //добавить элемент в список
        public void add(Type value){
            Node node=this;
            if (node!=null && check){
                for (;node!=null;node=node.next){
                    if (node.next==null){
                        Node tail=new Node();
                        tail.value=value;
                        node.next=tail;
                        break;
                    }
                }
            }else{
                this.value = value;
                check=true;
            }
        }

        //распечатать список
        public void print(){
            Node node=this;
            while (node!=null){
                System.out.println(node.value);
                node=node.next;
            }
        }

        //перегруженный toString()
        public String toString(){
            return this.value+" "+(this.next==null ? "" : this.next.toString());
        }

        //удаляет ближайщее входящее значение
        public void del(Type value){
            Node node=this;
            int count=0;
            for (;node!=null; node=node.next){
                count++;
                //если элемент в списке совподоет
                if (node.value.equals(value)){
                    //если это только один элемент
                    if (node.next==null && 1==count){
                        //node=null;//сработалобы если бы элементы односвязного списка сделал бы в отдельном классе
                        node.value=null;
                        node.next=null;
                        break;
                    }
                    //если элемент первый
                    else if (node.next!=null && 1==count){
                        //node=node.next;//сработалобы если бы элементы односвязного списка сделал бы в отдельном классе
                        node.value=node.next.value;
                        node.next=node.next.next;
                        /*
                        Node nodeEnd=this;
                        int countEnd=0;
                        count++;
                        for (;nodeEnd!=null;nodeEnd=nodeEnd.next){
                            countEnd++;
                            if (count==countEnd){
                                node.value=nodeEnd.value;
                                node.next=nodeEnd.next;
                                break;
                            }
                        }
                        */
                        break;
                    }
                    //если элемент в конце
                    else if (node.next==null){
                        Node nodeEnd=this;
                        int countEnd=0;
                        count--;
                        for (;nodeEnd!=null;nodeEnd=nodeEnd.next){
                            countEnd++;
                            if (count==countEnd){
                                nodeEnd.next=null;
                                break;
                            }
                        }
                        break;
                    }
                    //если элемент не в конце (в середине)
                    else{
                        Node nodeEnd=this;
                        int countEnd=0;
                        count--;
                        for (;nodeEnd!=null;nodeEnd=nodeEnd.next){
                            countEnd++;
                            if (count==countEnd){
                                nodeEnd.next=node.next;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }

        //изменяет ближайшее значение
        public void set(Type t1,Type t2){
            Node node=this;
            for (;node!=null;node=node.next){
                if (node.value.equals(t1)){
                    node.value=t2;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node=new Node();
        node.add(5);
        node.add(55);
        node.add("MAX");
        node.add(555);
        node.add(5555);
        //test/////////
        node.print();//
        System.out.println("---");
        System.out.println("node = " + node);
        System.out.println("---");
        node.del(5);
        System.out.println("node = " + node);
        System.out.println("---");
        node.set(555,"RAMANENKA");
        System.out.println("node = " + node);
        System.out.println("---");
    }
}
