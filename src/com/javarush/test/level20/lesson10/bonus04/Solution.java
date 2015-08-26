package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>,Cloneable,Serializable {
    //main//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //чтобы меньше писать кода - инкапсуляцию и полиморфизм не соблюдаю !!!
    //т.к. этого я не соблюдаю то все пишу итерационными способами !!!
    public static void main(String[] args) throws CloneNotSupportedException {
        //если так задекларировать listTree то Solution не будет наследовать Object и
        //метод clone работать не будет.
        //List<String> listTree = new Solution();
        //поэтому объявляем так , Solution наследует Object
        Solution listTree = new Solution();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);

        System.out.println("---------isEmpty()-size()---------");
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new Solution();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new Solution();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("---------getParent()----------");
        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
        //System.out.println("listTree.get(5)="+listTree.get(5));//check exception
        System.out.println("---------remove()-getParent()---------");
        listTree.remove("5");
        System.out.println(listTree);
        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
        System.out.println("listTree.remove(\"1\")");
        listTree.remove("2");
        System.out.println(listTree);
        System.out.println("listTree.root.item="+listTree.root.item);
        System.out.println("---------clear()----------");
        listTree.clear();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        //For additional check correct work clone method
        System.out.println("---------clone()----------");
        Solution list = (Solution)listTree.clone();
        System.out.println("listTree = " + listTree);
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        System.out.println("list = " + list);
        System.out.println("Check isEmpty: " + list.isEmpty() + " Size: " + list.size());
        list.remove("5");
        System.out.println("listTree = " + listTree);
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        System.out.println("list = " + list);
        System.out.println("Check isEmpty: " + list.isEmpty() + " Size: " + list.size());

        System.out.println("-------------------------------");
        System.out.println("Start value with using clone: " + listTree);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        System.out.println("list = " + list);
//        //for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!

        System.out.println("list.getLastNode().item = "+list.getLastNode().item);
        System.out.println("listTree.getLastNode().item = "+listTree.getLastNode().item);

        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        System.out.println("list = " + list);
//        //for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!

        System.out.println("list.getLastNode().item = "+list.getLastNode().item);
        System.out.println("list.getLastNode().parent.item = "+list.getLastNode().parent.item);
        System.out.println("list.getLastNode().parent.right.item = "+list.getLastNode().parent.right.item);
        System.out.println("list.getLastNode().parent.left.item = "+list.getLastNode().parent.left.item);
        System.out.println("list.getLastNode().parent.parent.item = "+list.getLastNode().parent.parent.item);
        System.out.println("list.getLastNode().parent..parent.item = "+list.getLastNode().parent.parent.parent.item);

        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        System.out.println("list = " + list);
//        //for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!

        System.out.println("\n===== ADD 21 and ... 32 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        //list.add(null);
        System.out.println("list = " + list);
//        //for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!
        System.out.println("\n---------------------------------------");

        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent("11"));
        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //узел для Solution/////////////////////////////////////////////////////////////////////////////////////////////////
    private static class Node<E> {
        E item;//значение
        Node<E> next;//следующий узел
        Node<E> prev;//предыдущий узел
        Node<E> parent;//родительский узел
        Node<E> left;//левое поддерево
        Node<E> right;//правое поддерево

        //конструктор
        Node(E item) {
            this.item = item;
        }
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //получение родителя у узла/////////////////////////////////////////////////////////////////////////////////////////
    public String getParent(String value) {
        //have to be implemented
        //получаем мнимую голову
        Node<String> head=root.next;
        //ищем узел
        while (head!=null){
            if (value.equals(head.item)){
                //возвращаем родителя
                return head.parent.item;
            }
            head=head.next;
        }
        //иначе нет родителя
        return null;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //implements AbstractList///////////////////////////////////////////////////////////////////////////////////////////
    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //implements AbctractCollection/////////////////////////////////////////////////////////////////////////////////////
    //размер нашего дерева
    //помним что корень дерева root скрыт от заказчика
    @Override
    public int size() {
        //получаем мнимую голову
        Node<String> head=root.next;
        //счетчик узлов
        int count=0;
        //считаем количество узлов
        while (head!=null){
            count++;
            head=head.next;
        }
        //возвращаем количество узлов
        return count;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //добавление узлов в бинарную кучу//////////////////////////////////////////////////////////////////////////////////
    //корень бинарной кучи всегда есть у списка, но заказчик о его существовании  не должен знать
    Node<String> root=new Node<String>("0");
    //return true - добавление прошло успешно
    //return false - добавление не прошло
    @Override
    public boolean add(String value) {
        //создаем новый узел
        Node<String> newNode = new Node<String>(value);
        //если в дереве ничего не удалялось--------------------------------------------------------------
        if (!isDeletedNode) {
            //берем голову бинарной кучи (голово неизменна, неудаляема и не видна заказчику)
            Node<String> head = root;
            //создаем очередь нодов
            Queue<Node> queue = new LinkedList<Node>();
            //флаг для определения добавили мы узел или нет
            boolean isAddedNode = false;

            //покуда нод не null или очередь нодов не пуста----------------------------------------
            while (head != null || !queue.isEmpty())
            {
                //если нод не null--------------------------------------------------
                if (head != null)
                {
                    //если левое поддерево нода NULL -----------------
                    // и мы не добавляли узел-------------------------
                    if (head.left == null && !isAddedNode)
                    {
                        //присваиваем левому поддереву новый нод
                        head.left = newNode;
                        //присваиваем левому поддереву его родителя
                        head.left.parent = head;
                        //говорим флагу что мы добавили узел
                        isAddedNode = true;
                    }
                    //если правое поддерево нода NULL
                    // и мы не добавляли узел
                    if (head.right == null && !isAddedNode)
                    {
                        //присваиваем правому поддереву новый нод
                        head.right = newNode;
                        //присваиваем правову поддереву его родителя
                        head.right.parent = head;
                        //говорим флагу что мы добавили узел
                        isAddedNode = true;
                    }//-----------------------------------------------
                    //делаем следующую итерацию
                    //если левое поддерево нода не null
                    //то заносим нод в очередь
                    if (head.left != null)
                    {
                        queue.add(head.left);
                    }
                    //если правое поддерево нода не null
                    //то заносим нод в очередь
                    if (head.right != null)
                    {
                        queue.add(head.right);
                    }
                }//-----------------------------------------------------------------
                //если очередь не пуста---------------------------------------------
                if (!queue.isEmpty())
                {
                    //присваиваем указателю на следующий нод следующий нод
                    head.next = queue.poll();
                    //следующему ноду присваиваем предыдущий
                    head.next.prev = head;
                    //делаем инкремент нода
                    head = head.next;
                }//-----------------------------------------------------------------
                //если очередь пуста то нод зануляем чтобы выйти из цикла-----------
                if (queue.isEmpty()) head = null;//-----------------------------------
            }//------------------------------------------------------------------------------------
        }//----------------------------------------------------------------------------------------------
        //иначе было что-то удалено , значит мы изменяем алгоритм вставки--------------------------------
        //а по сути надо было сразу такой алгоритм делать , но додумался до этого как всегда - поздно !
        //(сдесь достаточно одного алгоритма вставки - ЭТОТ)
        else {
            //узнаем последний нод
            Node<String> lastNode=getLastNode();
            //если последний нод равен настоящей голове
            if (root==lastNode){
                //присваиваем родителя новому ноду
                newNode.parent=root;
                //левому поддереву нода присваиваем новый нод
                root.left=newNode;
                //и обновляем дерево
                refreshRoot();
            }
            //иначе применяем другой алгоритм вставки
            else{
                //если последний нод это левое поддерево родителя
                if (lastNode==lastNode.parent.left) {
                    //указываем новому ноду его родителя
                    newNode.parent=lastNode.parent;
                    //встявляем в правое поддерево родителя этот нод
                    lastNode.parent.right=newNode;
                    //и обновляем дерево
                    refreshRoot();
                }
                //если последний нод это правое поддерево родителя
                if (lastNode==lastNode.parent.right){
                    //берем следующий узел у родителя
                    Node<String> nextParentNode=lastNode.parent.next;
                    //если у следующего родителя левое поддерево null
                    if (nextParentNode.left==null){
                        //указываем новому ноду родителя
                        newNode.parent=nextParentNode;
                        //встявляем новый узел в левое поддерево
                        nextParentNode.left=newNode;
                        //и обновляем дерево
                        refreshRoot();
                    }
                    //если у следующего родителя правое поддерево null
                    else {
                        //указываем новому ноду родителя
                        newNode.parent=nextParentNode;
                        //встявляем новый узел в правое поддерево
                        nextParentNode.right=newNode;
                        //и обновляем дерево
                        refreshRoot();
                    }
                }
            }
        }//----------------------------------------------------------------------------------------------
        //возврат true если узел удачно вставился
        return true;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //перегружаем мнтод toString() для тестов///////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder("[");
        //незабываем что корень спрятан !
        Node<String> head=root.next;
        while (head!=null){
            builder.append(head.item).append(" ");
            head=head.next;
        }
        return builder.toString().trim()+"]";
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //перегружаем isEmpty(), пустое ли дерево или нет///////////////////////////////////////////////////////////////////
    //помним что корень от заказчика скрываем
    @Override
    public boolean isEmpty() {
        //если есть один из детей то дерево не пусто
        if (root.left!=null || root.right!=null) return false;
        //иначе дерево пустое (помним что сам корень root есть)
        return true;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //удаляем узел из дерева////////////////////////////////////////////////////////////////////////////////////////////
    //определим статическую булевскую переменную - было ли удалено что то из дерева или нет
    private static boolean isDeletedNode;
    static {
        isDeletedNode = false;
    }
    //помним что корень дерева root заказчику не виден
    //при удаление узла удаляются все дети, внуки , правнуки и тд.
    //после удаления на следует обновить дерево а точнее указатели next и prev
    @Override
    public boolean remove(Object o) {
        //пометили что в дереве что то удалили
        isDeletedNode=true;
        //задаем мнимую голову
        Node<String> head=root.next;
        //ищем узел
        while (head!=null){
            //если удаляемый узел есть
            if (o.equals(head.item)){
                //то у родителя зануляем левое или правое поддерево
                if (head.parent.left==head){
                    //у предыдущего нода обнуляем указатель на этот нод
                    head.prev.next=null;
                    //обнуляем указатель на следующий нод у этого нода
                    head.next=null;
                    //у родителя этого нода обнуляем левое поддерево
                    head.parent.left=null;
                }

                else if (head.parent.right==head){
                    //у предыдущего нода обнуляем указатель на этот нод
                    head.prev.next=null;
                    //обнуляем указатель на следующий нод у этого нода
                    head.next=null;
                    //у родителя этого нода обнуляем правое поддерево
                    head.parent.right=null;
                }
                //обновляем у всего дерева указатели next и prev
                refreshRoot();
                //удалили узел
                return true;
            }
            head=head.next;
        }
        //не нашли узел , поэтому ничего не удалили
        return false;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //обновляем у всего дерева указатели next и prev////////////////////////////////////////////////////////////////////
    private void refreshRoot(){
        //берем голову бинарной кучи (голово неизменна, неудаляема и не видна заказчику)
        Node<String> head=root;
        //создаем очередь нодов
        Queue<Node> queue=new LinkedList<Node>();
        //покуда нод не null или очередь нодов не пуста----------------------------------------
        while (head!=null || !queue.isEmpty()){
            //если очередь не пуста---------------------------------------------
            if (!queue.isEmpty()){
                //присваиваем указателю на следующий нод следующий нод
                head.next=queue.poll();
                //следующему ноду присваиваем предыдущий
                head.next.prev=head;
                //делаем инкремент нода
                head=head.next;
            }//-----------------------------------------------------------------
            //если нод не null--------------------------------------------------
            if (head!=null){
                //если левое поддерево нода не null
                //то заносим нод в очередь
                if (head.left!=null)queue.add(head.left);
                //если правое поддерево нода не null
                //то заносим нод в очередь
                if (head.right!=null) queue.add(head.right);
            }//-----------------------------------------------------------------
            //если очередь пуста то нод зануляем чтобы выйти из цикла-----------
            if (queue.isEmpty()) head=null;//-----------------------------------
        }//------------------------------------------------------------------------------------
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //обнуляем дерево (очищаем от узлов)////////////////////////////////////////////////////////////////////////////////
    //помним что сам корень дерева остается, он скрыт от заказчика - его не трогаем
    @Override
    public void clear() {
        root.left=null;
        root.right=null;
        root.next=null;
        root.prev=null;
        root.parent=null;
        //остальное уберет сборщик мусора
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //копирование дерева////////////////////////////////////////////////////////////////////////////////////////////////
    protected Object clone() throws CloneNotSupportedException {
        //вызываем родительский абстрактный метод, чтобы взять из него исключение CloneNotSupportedException
        //и пробросить его дальше
        super.clone();
        //создаем новое дерево
        //незабываем что при инициализации нового дерева создается корень root , скрытый от заказчика !
        Solution newTree = new Solution();
        //берем мнимую голову у клонированного дерева
        Node<String> headRoot=root.next;
        //копируем значения
        while (headRoot!=null){
            newTree.add(headRoot.item);
            headRoot=headRoot.next;
        }
        //возвращаем клон
        return newTree;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //получение последнего нода/////////////////////////////////////////////////////////////////////////////////////////
    private Node<String> getLastNode(){
        //берем настоящую голову
        Node<String> head=root;
        //ищем последний нод
        while (head.next!=null) head=head.next;
        //возвращаем последний нод
        return head;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}