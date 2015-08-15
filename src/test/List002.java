package test;

/**
 * Created by maxim on 20.07.2015.
 */
public class List002 {
    //узел линейного односвязного списка
    static class ListElement{
        //указатель на следующий элемент
        ListElement next;
        //данные
        int data;
    }

    //список
    static class List{
        //указатель на первый элемент
        private ListElement head;
        //указатель на второй элемент
        private ListElement tail;

        //добавить спереди
        void addFront(int data){
            //создаем новый элемент
            ListElement a=new ListElement();
            //инициализируем данные
            a.data=data;//указатель на следующий элемент автоматически инициализируется как null
            //если список пуст то указываем ссылки начала и конца на новый элемент т.е. спичок теперь состоит из одного элемента
            if (head==null){
                head=a;
                tail=a;
            }else{
                //иначе новый элемент ссылается на бывший первый
                a.next=head;
                //а указатель на первый элемент теперь ссылается на новый элемент
                head=a;
            }
        }

        //добавление в конец сптска
        void addBack(int data){
            //создаем новый элемент
            ListElement a=new ListElement();
            a.data=data;
            //если список пуст то указываем ссылки начала и конца на новый элемент т.е. список состоит из одного элемента
            if (tail==null){
                head=a;
                tail=a;
            }else{
                //иначе старый последний элемент теперь ссылается на новый
                tail.next=a;
                //а в указатель на последний элемент записываем адрес нового элемента
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
        void delEl(int data){
            //если список пуст
            if (head==null){
                //ничего не делаем
                return;
            }
            //если список состоит из одного элемента
            if (head==tail){
                //очищаем указатели начала и конца
                head=null;
                tail=null;
                //и выходим
                return;
            }
            //если первый элемент тот, что нам нужен
            if (head.data==data){
                //переключаем указатель начала на второй элемент и выходим
                head= head.next;
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
        List list=new List();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.addBack(4);
        list.printList();
        System.out.println();

        list.addFront(0);
        list.printList();
        System.out.println();

        list.delEl(3);
        list.delEl(10);
        list.printList();
    }
}
