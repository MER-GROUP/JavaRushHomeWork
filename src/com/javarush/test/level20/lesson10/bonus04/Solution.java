package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

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
    //serialVersionUID//////////////////////////////////////////////////////////////////////////////////////////////////
    public static final long serialVersionUID = 12412468751456431L;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //main//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //чтобы меньше писать кода - инкапсуляцию и полиморфизм не соблюдаю !!!
    //т.к. этого я не соблюдаю то все пишу итерационными способами !!!
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //если так задекларировать listTree то Solution не будет наследовать Object и
        //метод clone работать не будет.
        //List<String> listTree = new Solution();
        //поэтому объявляем так , Solution наследует Object

//        Solution listTree = new Solution();
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//
//        for (int i = 1; i < 16; i++) {
//            listTree.add(String.valueOf(i));
//        }
//        System.out.println(listTree);
//
//        System.out.println("---------isEmpty()-size()---------");
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        List<String> list2222 = new Solution();
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        list2222.add("test");
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        List<String> list1111 = new Solution();
//        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());
//
//        System.out.println("---------getParent()----------");
//        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
//        //System.out.println("listTree.get(5)="+listTree.get(5));//check exception
//        System.out.println("---------remove()-getParent()---------");
//        listTree.remove("5");
//        System.out.println(listTree);
//        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
//        System.out.println("listTree.remove(\"1\")");
//        listTree.remove("2");
//        System.out.println(listTree);
//        System.out.println("listTree.root.item="+listTree.root.item);
//        System.out.println("---------clear()----------");
//        listTree.clear();
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        for (int i = 1; i < 16; i++) {
//            listTree.add(String.valueOf(i));
//        }
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        //For additional check correct work clone method
//        System.out.println("---------clone()----------");
//        Solution list = (Solution)listTree.clone();
//        System.out.println("listTree = " + listTree);
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        System.out.println("list = " + list);
//        System.out.println("Check isEmpty: " + list.isEmpty() + " Size: " + list.size());
//        list.remove("5");
//        System.out.println("listTree = " + listTree);
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        System.out.println("list = " + list);
//        System.out.println("Check isEmpty: " + list.isEmpty() + " Size: " + list.size());
//
//        System.out.println("-------------------------------");
//        System.out.println("Start value with using clone: " + listTree);
//        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
//        list.remove("2");
//        list.remove("9");
//        System.out.println("list = " + list);
//        for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!
//        System.out.println();
//
//        System.out.println("list.getLastNode().item = "+list.getLastNode().item);
//        System.out.println("listTree.getLastNode().item = "+listTree.getLastNode().item);
//
//        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
//        list.add("16");
//        list.add("17");
//        list.add("18");
//        list.add("19");
//        list.add("20");
//        System.out.println("list = " + list);
//        for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!
//        System.out.println();
//
//        System.out.println("list.getLastNode().item = "+list.getLastNode().item);
//        System.out.println("list.getLastNode().parent.item = "+list.getLastNode().parent.item);
//        System.out.println("list.getLastNode().parent.right.item = "+list.getLastNode().parent.right.item);
//        System.out.println("list.getLastNode().parent.left.item = "+list.getLastNode().parent.left.item);
//        System.out.println("list.getLastNode().parent.parent.item = "+list.getLastNode().parent.parent.item);
//        System.out.println("list.getLastNode().parent..parent.item = "+list.getLastNode().parent.parent.parent.item);
//
//        System.out.println("\n===== REMOVE 18 and 20 =====");
//        list.remove("18");
//        list.remove("20");
//        System.out.println("list = " + list);
//        for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!
//
//        System.out.println("\n===== ADD 21 and ... 32 =====");
//        list.add("21");
//        list.add("22");
//        list.add("23");
//        list.add("24");
//        list.add("25");
//        list.add("26");
//        list.add("27");
//        list.add("28");
//        list.add("29");
//        list.add("30");
//        list.add("31");
//        list.add("32");
//        //list.add(null);
//        System.out.println("list = " + list);
//        for (String s : list) System.out.print(s+ " ");//нужно реализовать итератор !!!!!!!!!!!!!!
//        System.out.println("\n---------------------------------------");
//
//        System.out.println("\n---------------------------------------");
//        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
//        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
//        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
//        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent("11"));
//        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
//        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
//        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
//        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
//        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
//        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
//        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
//        System.out.println("--->> By task and add more item:");
//        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
//        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
//        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
//        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
//        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
//        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
//        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
//        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
//        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
//        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
//        System.out.println("---------------------------------------");
//        System.out.println("Size array = " + list.size() + " expected = 22");
//        System.out.println();
//
//        System.out.println("=============== contains(Object o) test ==================");
//        System.out.println("10 is = "+list.contains("10"));
//        System.out.println("9 is = "+list.contains("9"));
//        System.out.println("0 is = "+list.contains("0"));
//        System.out.println("32 is = "+list.contains("32"));
//        System.out.println("23 is = "+list.contains("23"));
//
//        System.out.println("=============== containsAll(Object o) test ==================");
//        Solution solConAll=new Solution();
//        solConAll.add("1");
//        solConAll.add("16");
//        solConAll.add("32");
//        System.out.println("list.containsAll(solConAll) = "+list.containsAll(solConAll));
//        solConAll.add("56");
//        System.out.println("list.containsAll(solConAll) = "+list.containsAll(solConAll));
//
//        System.out.println("=============== iterator test for ==================");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println();
//
//        System.out.println("=============== Clone test ==================");
//        System.out.println("Object: " + list + " --> Size = " + list.size());
//        Solution sol = (Solution) list.clone();
//        //list.remove("7"); //Select for test
//        //System.out.println("Object: " + list + " --> Size = " + list.size());//Select for test
//        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
//        System.out.println("Result: " + list.containsAll(sol));
//
//        System.out.println("\nTest addAll: ");
//        Solution add = new Solution();
//        add.addAll(sol);
//        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());
//
//        System.out.println("=============== Iterator test ===============");
//        Iterator<String> itr = list.iterator();
//        while (itr.hasNext()) {
//            String a = itr.next();
//            System.out.print(a + " ");
//        }
//        System.out.println("\nExpected size 22 = " + list.size());
//
//        System.out.println("\nIter remove");
//        Iterator<String> itr2 = list.iterator();
//        while (itr2.hasNext()) {
//            if (itr2.next().contains("31")) {
//                itr2.remove();
//            }
//        }
//        System.out.println("For test " + list + " --> Size = " + list.size());
//        System.out.println("Collect size " + list.size() + " Expected 21");
//
//        System.out.println("=============== hashCode test ===============");
//        System.out.println("list.hashCode() = "+list.hashCode());
//        System.out.println("sol.hashCode() = "+sol.hashCode());
//
//        System.out.println("=============== equals test ===============");
//        System.out.println(list);
//        System.out.println(sol);
//        System.out.println("list.equals(sol) = "+list.equals(sol));
//        Solution s1=new Solution();
//        s1.add("1");
//        s1.add("2");
//        s1.add("3");
//        Solution s2=new Solution();
//        s2.add("1");
//        s2.add("2");
//        s2.add("3");
//        System.out.println("s1.equals(s2) = "+s1.equals(s2));
//
//        System.out.println("=============== removeAll test ===============");
//        Solution s3=new Solution();
//        s3.add("1");
//        s3.add("2");
//        s3.add("3");
//        s3.add("4");
//        s3.add("5");
//        s3.add("6");
//        s3.add("7");
//        s3.add("8");
//        Solution s4=new Solution();
//        s4.add("3");
//        s4.add("6");
//        s4.add("7");
//        s4.add("8");
//        System.out.println("s3 = "+s3);
//        System.out.println("s4 = "+s4);
//        s3.removeAll(s4);
//        System.out.println("s3 = "+s3);
//        System.out.println("s4 = "+s4);
//
//        System.out.println("=============== retainAll test ===============");
//        Solution sRet=new Solution();
//        sRet.add("3");
//        sRet.add("6");
//        System.out.println("s4 = "+s4);
//        s4.retainAll(sRet);
//        System.out.println("s4 = "+s4);
//
//        System.out.println("=============== toArray test ===============");
//        System.out.println("s3 = "+s3);
//        String[] array=s3.toArray();
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//
//        System.out.println("=============== toArray([]) test ===============");
//        String[] array2=sRet.toArray();
//        for (int i = 0; i < array2.length; i++) {
//            System.out.print(array2[i] + " ");
//        }
//        String[] arrayFin=s3.toArray(array2);
//        for (int i = 0; i < arrayFin.length; i++) {
//            System.out.print(arrayFin[i] + " ");
//        }
//
//        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
//        System.out.println("Collect before serializable " + list);
//        System.out.print("Save list");
//        File file=new File("D://TEMP//111.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(list);
//        oos.close();
//        fos.close();
//        System.out.println(" Serializable done");
//        System.out.print("Load list");
//        FileInputStream fis = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Solution list2 = (Solution) ois.readObject();
//        ois.close();
//        fis.close();
//        System.out.println(" Deserializable done");
//        System.out.println("Collect after deserializable " + list2);
//
//        System.out.println("\n================ Clear test =================");
//        System.out.println("Before: " + listTree);
//        listTree.clear();
//        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));

        List<String> listTree = new Solution();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);

        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new Solution();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new Solution();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
        listTree.clear();
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }

        //For additional check correct work clone method
        Solution list = ((Solution)listTree).clone();

        System.out.println("Start value with using clone: " + listTree);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 21 and 22 =====");
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
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
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

        System.out.println("=============== Clone test ==================");

        System.out.println("Object: " + list + " --> Size = " + list.size());
        Solution sol = list.clone();
        //list.remove("7"); //Select for test
        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
        System.out.println("Result: " + list.containsAll(sol));

        System.out.println("\nTest addAll: ");
        Solution add = new Solution();
        add.addAll(sol);
        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());

        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list);
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2);

        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree);
        listTree.clear();
        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));
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

    //наследум наш итератор/////////////////////////////////////////////////////////////////////////////////////////////
    //и перегружаем абстрактные методы и один не астрактный метод (remove)
    //сдираем все и перервбатываем из LinkedList.java или AbstractList.java
    public class IteratorSolution implements Iterator{
        //текущий индекс в списке
        private int nextIndex;
        //присваиваем мнимую голову возвращаемому узлу
        private Node<String> lastReturned=root.next;
        //присваиваем мнимую голову следующему узлу
        private Node<String> next=root.next;

        //-----------------------------------------------------------------------------------------------------
        //есть ли следующий элемент в списке
        @Override
        public boolean hasNext() {
            //если текущий индекс меньше размера то возвращаем истину, иначе ложь
            return nextIndex < size();
        }//----------------------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------------
        //возвращаем текущий элемент в списке
        @Override
        public Object next() {
            //проверка есть ли дальше узлы
            if (!hasNext()) throw new NoSuchElementException();
            //присваиваем присваиваем текущий узел возвращаемому
            lastReturned = next;
            //итерируемся на следующий узел
            next = next.next;
            //итерирую индекс нода
            nextIndex++;
            //возвращаю текущий узел
            return lastReturned.item;
        }//----------------------------------------------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------------
        //удаляем текущий элемент из списка
        @Override
        public void remove() {
            Solution.this.remove(lastReturned.item);
        }//----------------------------------------------------------------------------------------------------
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //перегружаем итератор и возвращаем наш итератор////////////////////////////////////////////////////////////////////
    //нужто чтобы работала конструкция for (String s : list)
    //т.к. в цикле for итератор неявно вызывается по умолчанию
    @Override
    public Iterator<String> iterator() {
        return new IteratorSolution();
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //получение родителя у узла/////////////////////////////////////////////////////////////////////////////////////////
    public String getParent(String value) {
        //если value is null
        if (null==value) return "null";
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
    //незабываем пометить что узел записывать ненадо ! т.к. там хранятся адреса !
    //а ссылки и адреса мы сериализовать не можем !!!
    private transient Node<String> root=new Node<String>("0");
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
    protected Solution clone() throws CloneNotSupportedException {
        //тырим из LinkedList.java и немного редактируем
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

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //добавляем все элементы сразу//////////////////////////////////////////////////////////////////////////////////////
    //метод можно и не перегружать, т.к. все строки подходят и ничего менять не надо
    //вот этот метод из AbstractCollection
    /*
    boolean modified = false;
    for (E e : c)
            if (add(e))
    modified = true;
    return modified;
    */
    @Override
    public boolean addAll(Collection<? extends String> c) {
        return super.addAll(c);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
        //return super.indexOf(o);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //есть ли узел в списке или нет/////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean contains(Object o) {
        //берем мнимую голову
        Node<String> head=root.next;
        //ищем искомый узел в дереве
        while (head!=null){
            //узел в списке есть
            if (o.equals(head.item)) return true;
            //итерируемся
            head=head.next;
        }
        //узла в списке нет
        return false;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //есть ли узлы в списке/////////////////////////////////////////////////////////////////////////////////////////////
    //внаглую сдираем из AbstractCollection.java
    //чтобы работало надо перегрузить итератор на свой
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
        //return super.remove(index);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
        //return super.lastIndexOf(o);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException//////////////////////////////////
    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
        //return super.listIterator(index);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //конструктор - наследуем от AbstractList.java//////////////////////////////////////////////////////////////////////
    //конструкторы не наследуются - поэтому вызываем суперкласс
    //а при вызове суперкласса вызывается его конструктор
    protected Solution() {
        super();
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //метод finalize вызываем у Object.java/////////////////////////////////////////////////////////////////////////////
    //он пуст и только пробрасывает исключение Throwable
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //в listIterator присутствуют методы доступа и взятия по индексу////////////////////////////////////////////////////
    //а доступ по индексу запрещен, пользуемся исключением UnsupportedOperationException
    @Override
    public ListIterator<String> listIterator() {
        throw new UnsupportedOperationException();
        //return new IteratorSolution();
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //наследуем от AbstractList, ничего не меняем все устраивает////////////////////////////////////////////////////////
    //вот код из AbstractList
    /*
    int hashCode = 1;
    for (E e : this)
    hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
    return hashCode;
    */
    @Override
    public int hashCode() {
        return super.hashCode();
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //сравниваем два дерева/////////////////////////////////////////////////////////////////////////////////////////////
    //наследуем от AbstractList и чуточку редактируем
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Solution))
            return false;

        Iterator<?> e1 = iterator();
        Iterator<?> e2 = ((Solution) o).iterator();
        while (e1.hasNext() && e2.hasNext()) {
            Object o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }
        //если списки разные по размеру то вернем ложь инате истину
        return !(e1.hasNext() || e2.hasNext());
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //удалить все элементы или несколько////////////////////////////////////////////////////////////////////////////////
    //внаглую наследуемся от AbstractCollection.java.java и ничего не меняем - все идеально подходит
    //вот код
    /*
    Objects.requireNonNull(c);
    boolean modified = false;
    Iterator<?> it = iterator();
    while (it.hasNext()) {
        if (c.contains(it.next())) {
            it.remove();
            modified = true;
        }
    }
    return modified;
    */
    @Override
    public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //оставить все или несколько узлов указанные коллекцией/////////////////////////////////////////////////////////////
    //внаглую наследуемся от AbstractCollection.java.java и немного редактируем
    //вот код оригинал
    /*
    Objects.requireNonNull(c);
    boolean modified = false;
    Iterator<E> it = iterator();
    while (it.hasNext()) {
        if (!c.contains(it.next())) {
            it.remove();
            modified = true;
        }
    }
    return modified;
    */
    //но так как мы удаляем ветками то алгоритм этот совлюдатся небудет
    //логично былоб пустить исключение сюдаб - но да ладно ...
    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                //задаем итератору начальную мнимую голову
                it = iterator();
                modified = true;
            }
        }
        return modified;
        //return super.retainAll(c);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //преобразование дерева в массив////////////////////////////////////////////////////////////////////////////////////
    //внаглую наследуемся от AbstractCollection.java.java и немного редактируем
    @Override
    public String[] toArray() {
        // Estimate size of array; be prepared to see more or fewer elements
        String[] r = new String[size()];
        Iterator it = iterator();
        for (int i = 0; i < r.length; i++) {
            r[i] = (String) it.next();
        }
        return r;
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //преобразуем в массив дерево и дополнительный массив в общий массив////////////////////////////////////////////////
    //внаглую наследуемся от AbstractCollection.java.java и ничего не меняем - все идеально подходит
    //вот код
    /*
    // Estimate size of array; be prepared to see more or fewer elements
    int size = size();
    T[] r = a.length >= size ? a :
            (T[])java.lang.reflect.Array
                    .newInstance(a.getClass().getComponentType(), size);
    Iterator<E> it = iterator();

    for (int i = 0; i < r.length; i++) {
        if (! it.hasNext()) { // fewer elements than expected
            if (a == r) {
                r[i] = null; // null-terminate
            } else if (a.length < i) {
                return Arrays.copyOf(r, i);
            } else {
                System.arraycopy(r, 0, a, 0, i);
                if (a.length > i) {
                    a[i] = null;
                }
            }
            return a;
        }
        r[i] = (T)it.next();
    }
    // more elements than expected
    return it.hasNext() ? finishToArray(r, it) : r;
    */
    @Override
    public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //записать объект из потока/////////////////////////////////////////////////////////////////////////////////////////
    //тырим из LinkedList.java и немного редактируем
    //вот оригинальный код
    /*
    // Write out any hidden serialization magic
    s.defaultWriteObject();
    // Write out size
    s.writeInt(size);
    // Write out all elements in the proper order.
    for (Node<E> x = first; x != null; x = x.next)
            s.writeObject(x.item);
    */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        // Write out any hidden serialization magic
        stream.defaultWriteObject();
        // Write out size
        stream.writeInt(size());
        // Write out all elements in the proper order.
        for (Node<String> x = root.next; x != null; x = x.next)
            stream.writeObject(x.item);
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //загрузить объект из потока////////////////////////////////////////////////////////////////////////////////////////
    //тырим из LinkedList.java и немного редактируем
    //вот оригинальный код
    /*
    // Read in any hidden serialization magic
    s.defaultReadObject();
    // Read in size
    int size = s.readInt();
    // Read in all elements in the proper order.
    for (int i = 0; i < size; i++)
    linkLast((E)s.readObject());
    */
    //тут порядок останется , но меняется структура дерева !!!
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        stream.defaultReadObject();
        // Read in size
        int size = stream.readInt();
        //создадим новое дерево (вызываем конструктор у узла)
        //этим самым мы создаем спрятанный узел от заказчика
        root=new Node<String>("0");
        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++)
            add((String)stream.readObject());
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}