package test;

/**
 * Created by maxim on 20.07.2015.
 */
public class List003 {

    //узел списка
    static class ListElement<E>{
        //следующий узел
        ListElement next;
        //данные узла
        E data;
    }

    //список
    static class List<E>{
        //указатель на первый элемент
        private ListElement head;
        //указатель на последний элемент
        private ListElement tail;

        //добавить спереди
        void addFront(E data){
            //создаем новый элемент
            ListElement a=new ListElement();
            //указатель на следующий элемент автоматически инициализируется как null
            a.data=data;
            //если список пуст
            if (head==null){
                //то указываем ссылки начала и конца на новый элемент т.е. список состоит из одного элемента
                head=a;
                tail=a;
            }
            //иначе новый элемент ссылается на бывший первый
            else{
                a.next=head;
                //а указатель на первый элемент теперь ссылается на новый элемент
                head=a;
            }
        }

        //добавление в конец списка
        void addBack(E data){
            //создаем новый элемент
            ListElement a=new ListElement();
            a.data=data;
            //если список пуст
            if (tail==null){
                //то указываем ссылки начала и конца на новый элемент т.е. список теперь состоит из одного элемента
                head=a;
                tail=a;
            }else {
                //иначе старый последний элемент теперь ссылается на новый
                tail.next=a;
                //а в указатель на последний элемент записываем адресс нового элемента
                tail=a;
            }
        }

        //печать списка
        void printList(){
            //получаем ссылку на первый элемент
            ListElement t=head;
            //пока элемент существует
            while (t!=null){
                //печатаем его данные
                System.out.print(t.data + " ");
                //и переключаемся на следующий
                t=t.next;
            }
        }

        //удаление элемента
        void delEl(E data){
            //если список пуст
            if (head==null){
                //ничего не делаем
                return;
            }
            //если список состоит из одного элемента
            if (head==tail){
                //очищаем указатели начала и конца и выходит
                head=null;
                tail=null;
                return;
            }
            //если первый элемент - тот, что нам нужен переключаем указатель начала на второй элемент и выходим
            if (head.data==data){
                head=head.next;
                return;
            }
            //иначе начинаем искать
            ListElement t=head;
            //пока следующий элемент существует
            while (t.next!=null){
                //проверяем следующий элемент
                if (t.next.data==data){
                    //если он последний
                    if (tail==t.next){
                        //то переключаем указатель на последний элемент на текущий
                        tail=t;
                    }
                    //найденный элемент выкидываем
                    t.next=t.next.next;
                    //и выходим
                    return;
                }
                //иначе ищем дальше
                t=t.next;
            }
        }
    }

    public static void main(String[] args) {
        List ml = new List();
        ml.addBack(1.0);
        ml.addBack(2);
        ml.addBack("brrr");
        ml.addFront(6);

        ml.printList();
        System.out.println();
    }
}
