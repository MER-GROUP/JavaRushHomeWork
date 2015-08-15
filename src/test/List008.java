package test;

/**
 * Created by maxim on 22.07.2015.
 */
public class List008 {
    //узел двусвязного списка//-----------------------------------------------------------------------------------------
    private static class Node<Type>{
        //переменные узла
        private Type value;
        private Node next;
        private Node prev;
        //конструктор по умолчанию
        public Node() {
        }
        //конструктор
        public Node(Type value,Node next,Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }//-----------------------------------------------------------------------------------------------------------------

    //двусвязный список//-----------------------------------------------------------------------------------------------
    public static class doubleList<Type>{
        private Node node;

        //вставка элемента в конец списка///////////////////////////////////////////////////////////////////////////////
        public void add(Type value){
            //если список пустой
            if (node==null){
                Node tail=new Node(value,null,null);
                node=tail;
            }else{
                Node tail=new Node(value,null,null);
                Node head=node;
                for (;head!=null;head=head.next){
                    if (head.next==null){
                        head.next=tail;
                        tail.prev=head;
                        break;
                    }
                }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //вставка элемента по индексу///////////////////////////////////////////////////////////////////////////////////
        public void add(int x,Type t){
            //если список пустой
            if (null==node){
                Node head=new Node(t,null,null);
                node=head;
            }else{
                int count=0;
                Node head=node;
                for (;head!=null;head=head.next){
                    count++;
                    if (count==x){
                        //инициализируем вставляемый новый узел
                        Node newNode=new Node(t,null,null);
                        //ссылаю вставляемый новый узел на текущий
                        newNode.next=head;
                        //и текущий узел ссылаю на новый
                        if (head.prev!=null){
                            //то новый узел ссылаю на предыдущий
                            newNode.prev=head.prev;
                            //и предыдущий узел ссылаю на новый
                            head.prev.next=newNode;
                            //и текущий узел ссылаю на новый
                            head.prev=newNode;
                        }
                        //иначе элемент в списке стоял первым поэтому обновляем голову
                        else{
                            //текущий узел ссылаю на новый
                            head.prev=newNode;
                            node=newNode;
                        }
                        break;
                    }
                }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //вставка элемента в начало списка//////////////////////////////////////////////////////////////////////////////
        public void front(Type value){
            //если список пустой
            if (null==node){
                Node head=new Node(value,null,null);
                node=head;
            }else{
                Node head=new Node(value,null,null);
                Node tail=node;
                head.next=tail;
                tail.prev=head;
                node=head;
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //распечатка листа в консоль////////////////////////////////////////////////////////////////////////////////////
        public void print(){
            Node head=node;
            for (;head!=null;head=head.next){
                System.out.print(head.value + " ");
            }
            System.out.println();
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //распечатка листа в консоль в обратном порядке/////////////////////////////////////////////////////////////////
        public void printDown(){
            Node head=node;
            for (;head!=null;head=head.next){
                if (head.next==null){
                    Node tail=head;
                    for (;tail!=null;tail=tail.prev){
                        System.out.print(tail.value + " ");
                    }
                    break;
                }
            }
            System.out.println();
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //перегружаем toString//////////////////////////////////////////////////////////////////////////////////////////
        public String toString(){
            Node head=node;
            StringBuilder stringBuilder=new StringBuilder();
            for (;head!=null;head=head.next){
                stringBuilder.append(head.value).append(" ");
            }
            return stringBuilder.toString().trim();
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //заменяем ближайшее значение на другое/////////////////////////////////////////////////////////////////////////
        public void set(Type t1,Type t2){
            Node head=node;
            for (;head!=null;head=head.next){
                if (head.value.equals(t1)){
                    head.value=t2;
                    break;
                }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //заменяем значение на другое по индексу////////////////////////////////////////////////////////////////////////
        public void set(int x,Type t,boolean check){
            Node head=node;
            int count=0;
            for (;head!=null;head=head.next){
                count++;
                if (count==x){
                    head.value=t;
                    break;
                }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //удаляем последний элемент в списке////////////////////////////////////////////////////////////////////////////
        public void del(){
            //если список пустой
            if (null==node){
                return;
            }else{
                Node head=node;
                for (;head!=null;head=head.next){
                    if (head.next==null){
                        //если в списке был только один элемент
                        if (head.prev==null){
                            node=null;
                        }
                        //иначе обнуляем последний элемент
                        else {
                            head.prev.next=null;
                        }
                        break;
                    }
                }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //удаляем элемент из списка по ближайшему совпадению////////////////////////////////////////////////////////////
        public void del(Type t){
            //если список пустой
            if (null==node){
                return;
            }else{
                Node head=node;
                for (;head!=null;head=head.next){
                    if (head.value.equals(t)){
                        //если в списке был только один элемент или он первый
                        if (head.prev==null){
                            //если в списке один элемент
                            if (head.next==null){
                                node=null;
                            }
                            //иначе если в списке элемент стоит первым
                            else{
                                node=head.next;
                                node.prev=null;
                            }
                        }
                        //иначе если элемент в списке стоит последним или в середине
                        else{
                            //если в списке элемент последний
                            if (head.next==null){
                                head.prev.next=null;
                            }
                            //иначе элемент в середине
                            else{
                                head.prev.next=head.next;
                                head.next.prev=head.prev;
                            }
                        }
                        break;
                    }
                }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //удаляем элемент из списка по индексу//////////////////////////////////////////////////////////////////////////
        public void del(int x,boolean bool){
            //если список пустой
            if (null==node){
                return;
            }else{
                int count=0;
                Node head=node;
                for (;head!=null;head=head.next){
                    count++;
                    if (count==x){
                        //если элемент в списке первый или один
                        if (head.prev==null){
                            //если в списке элемент один
                            if (head.next==null){
                                node=null;
                            }
                            //иначе в списке элемент первый
                            else{
                                node=head.next;
                                node.prev=null;
                            }
                        }
                        //иначе в списке элемент последний или в середине
                        else{
                            //элемент в списке последний
                            if (head.next==null){
                                head.prev.next=null;
                            }
                            //иначе элемент в середине
                            else{
                                head.prev.next=head.next;
                                head.next.prev=head.prev;
                            }
                        }
                        break;
                    }
                }
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //реверсируем список////////////////////////////////////////////////////////////////////////////////////////////
        public void reverse(){
            //если список пустой
            if (null==node){
                return;
            }else{
                Node head=node;
                for (;head!=null;head=head.next){
                    if (head.next==null){
                        break;
                    }
                }

                Node tail=head;
                doubleList list=new doubleList();

                for (;tail!=null;tail=tail.prev){
                    list.add(tail.value);
                }

                Node reverse=list.node;

                node=reverse;
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //сортировать шаблонный список нельзя т.к. мы можем хранить в первом элементе байт, во втором некий класс///////
        //поэтому сделаем сортировку для заданного типа , например int /////////////////////////////////////////////////
        public void sort(int x){
            //если список пустой
            if (null==node){
                return;
            }else{
                Node head=node;
                int length=0;
                for (;head!=null;head=head.next){
                    length++;
                }
                int[] array=new int[length];
                head=node;
                for (int i=0;head!=null;head=head.next,i++){
                    array[i]=(int)head.value;
                }
                for (int i = 0; i < length; i++) {
                    for (int j = i; j < length; j++) {
                        if (array[i]>array[j]){
                            int temp=array[i];
                            array[i]=array[j];
                            array[j]=temp;
                        }
                    }
                }
                doubleList list=new doubleList();
                for (int i = 0; i < length; i++) {
                    list.add(array[i]);
                }
                node=list.node;
            }
        }///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }//-----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("test000----------------------------");
        //создание списка
        doubleList list=new doubleList();
        //тест является ли список null
        if (list.node==null){
            System.out.println("list.node is : nul");
        }else{
            System.out.println("list.node is : not nul");
        }
        //System.out.println("list.node.value = " + list.node.value);
        //list.print();
        System.out.println("test001----------------------------");
        //тест вставки элементов в конец
        list.add(555);
        list.add(9);
        list.add(10);
        //тест правильности заполнения
        System.out.println(list.node.value);
        System.out.println(list.node.next.value);
        System.out.println(list.node.next.next.value);
        System.out.println("test002----------------------------");
        //тест вывода в консоль
        list.print();
        list.add(777);
        list.print();
        list.print();
        System.out.println("test003----------------------------");
        //тест вывода в консоль в обратном порядке
        list.printDown();
        System.out.println("test004----------------------------");
        //тест вывода toString
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test005----------------------------");
        //тест замены ближайшего значения
        list.set(9,333);
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test006----------------------------");
        //тест замены значения по индексу
        list.set(3,222,true);
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test007----------------------------");
        //тест вставки элемента в начало
        list.front(999);
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test008----------------------------");
        //тест вставки элемента по индексу
        list.add(3,1111);
        System.out.println(list);
        list.printDown();
        list.print();
        list.add(1,5656);
        System.out.println(list);
        list.printDown();
        list.print();
        list.add(7,888888888);
        System.out.println(list);
        list.printDown();
        list.print();
        list.add(9,4545454);
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test009----------------------------");
        //тест удаления последнего элемента в списке
        list.del();
        System.out.println(list);
        list.printDown();
        list.print();
        doubleList list2=new doubleList();
        list2.del();
        list2.add(555);
        list2.print();
        list2.del();
        list2.print();
        list.del();
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test010----------------------------");
        //тест удаления элемента в списке по ближайшему значению
        list.del(222);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(555);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(5656);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(6666666);
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println(list2);
        list2.del(1);
        System.out.println(list2);
        list2.print();
        list2.printDown();
        list2.print();
        list.del(6666666);
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test011----------------------------");
        //тест удаления элемента в списке по индексу
        list.add(555);
        list.add(777);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(5,true);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(3,true);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(1,true);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(1,true);
        System.out.println(list);
        list.printDown();
        list.print();
        list.del(1,true);
        System.out.println(list);
        list.printDown();
        list.print();
        list.add(333);
        list.add(555);
        list.add(999);
        list.add(777);
        list.add(444);
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test012----------------------------");
        //тест на реверс листа
        list.reverse();
        System.out.println(list);
        list.printDown();
        list.print();
        System.out.println("test013----------------------------");
        //тест на сортировку листа
        list.sort(1);
        System.out.println(list);
        list.printDown();
        list.print();
    }
}
