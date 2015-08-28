package com.javarush.test.level20.lesson10.bonus04;

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


import java.io.*;
import java.util.*;


public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    private static final long serialVersionUID = -2069918990882805962L;
    int size = 0;

    Node<String> root = new Node<>(null, null);
    Node<String> parent = root;



    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException
    {
        List<String> list = new Solution();
        for (int i = 1; i < 15; i++)
        {
            list.add(String.valueOf(i));
        }
        ((Solution) list).print();

        System.out.println("list.remove(\"2\") " + list.remove("2"));
        System.out.println("list.remove(\"9\") " + list.remove("9"));
        System.out.println("list.remove(\"51\") " + list.remove("51"));
        ((Solution) list).print();
        System.out.println("list.add(\"16\") " + list.add("16"));
        System.out.println("list.add(\"17\") " + list.add("17"));
        System.out.println("list.add(\"18\") " + list.add("18"));
        System.out.println("list.add(\"19\") " + list.add("19"));
        System.out.println("list.add(\"20\") " + list.add("20"));
        ((Solution) list).print();
        System.out.println("list.remove(\"18\") " + list.remove("18"));
        System.out.println("list.remove(\"20\") " + list.remove("20"));
        ((Solution) list).print();
        System.out.println("list.add(\"21\") " + list.add("21"));
        System.out.println("list.add(\"22\") " + list.add("22"));
        ((Solution) list).print();
        System.out.println("list.clear()");
        list.clear();
        ((Solution) list).print();
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("list.add(null) " + list.add(null));
        ((Solution) list).print();
        System.out.println("list.remove(null) " + list.remove(null));
        System.out.println("list.remove(null) " + list.remove(null));
        ((Solution) list).print();
        System.out.println("list.add(\"a\") " + list.add("a"));
        System.out.println("list.add(\"b\") " + list.add("b"));
        System.out.println("list.add(\"c\") " + list.add("c"));
        System.out.println("list.add(\"d\") " + list.add("d"));
        System.out.println("list.add(\"e\") " + list.add("e"));
        ((Solution) list).print();
        System.out.println("list.remove(\"a\") " + list.remove("a"));
        System.out.println("list.remove(\"b\") " + list.remove("b"));
        ((Solution) list).print();
        for (int i = 1; i < 16; i++)
        {
            System.out.println("list.add(\"" + i + "\") " + list.add(String.valueOf(i)));
        }
        ((Solution) list).print();
        System.out.println("Parent 3 <- 1 = " + ((Solution) list).getParent("3"));
        System.out.println("Parent 5 <- 2 = " + ((Solution) list).getParent("5"));
        System.out.println("Parent 7 <- 3 = " + ((Solution) list).getParent("7"));
        System.out.println("Parent 10 <- 4 = " + ((Solution) list).getParent("10"));
        System.out.println("list.remove(\"2\") " + list.remove("2"));
        ((Solution) list).print();
        System.out.println("Parent null <- 11 = " + ((Solution) list).getParent("11"));
        System.out.println("Parent null <- null = " + ((Solution) list).getParent(null));
        System.out.println("list.add(null) " + list.add(null));
        System.out.println("Parent 7 <- null = " + ((Solution) list).getParent(null));
        ((Solution) list).print();
        System.out.println("Size = 9 = " + list.size());
        System.out.print("\nSave list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" done\n");
        ((Solution) list2).print();

        System.out.println("Clone list2");
        List<String> listClone =((Solution)list2).clone();
        ((Solution) listClone).print();

        System.out.println("list.iterator()");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        iterator = list.iterator();
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.remove() ");
        iterator.remove();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        ((Solution) list).print();
        iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println("\nlist.listIterator() while .hasNext() .next()");
       /* ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) System.out.print(listIterator.next() + " ");
        System.out.println("\nwhile .hasPrevious() .previous()");
        while (listIterator.hasPrevious()) System.out.print(listIterator.previous() + " ");
        System.out.println("\nlistIterator.set(\"0\")");
        listIterator.set("0");
        ((Solution) list).print();
        System.out.println("listIterator.add(\"16\")");
        listIterator.add("16");
        ((Solution) list).print();
        System.out.println("listIterator.next() " + listIterator.next());
        System.out.println("listIterator.remove()");
        listIterator.remove();
        System.out.println("listIterator.nextIndex() " + listIterator.nextIndex());
        System.out.println("listIterator.previousIndex() " + listIterator.previousIndex());
        System.out.println("listIterator.previous() " + listIterator.previous());
        System.out.println("listIterator.previousIndex() " + listIterator.previousIndex());
        ((Solution) list).print();
        listIterator = list.listIterator(1);
        System.out.println("listIterator.nextIndex() " + listIterator.nextIndex());
        System.out.println("listIterator.next() " + listIterator.next());*/
    }

    public void print()
    {
        StringBuilder text = new StringBuilder();
        if (root.left != null)
            text.append(nodeText(root.left, 0));
        if (root.right != null)
            text.append(nodeText(root.right, 0));
        System.out.print(text.toString());
    }

    private String nodeText(Node<String> node, final int level)
    {
        StringBuilder text = new StringBuilder(String.format("%-5s", node.value));
        text.append(node.left != null ? nodeText(node.left, level + 1) : "\n");
        if (node.right != null) {
            for (int i = 0; i <= level; i++)
                text.append("     ");
            text.append(nodeText(node.right, level + 1));
        }
        return text.toString();
    }

    public Queue<Node<String>> getSubTree(Node<String> top)
    {
        Queue<Node<String>> queue = new LinkedList<>();
        Queue<Node<String>> subTree = new LinkedList<>();
        if (top != root)
            subTree.add(top);

        if(top == null)
            return subTree;
        do
        {
            if (top.left != null)
                queue.add(top.left);
            if (top.right != null)
                queue.add(top.right);



            if (!queue.isEmpty())
                top = queue.poll();
            if(!subTree.contains(top))
                subTree.add(top);



        }
        while (top.left!=null||top.right!=null||!queue.isEmpty());
        return subTree;
    }

    @Override
    public boolean remove(Object value)
    {

        Node<String> currentNode =  findNode((String) value);
        if(currentNode==null) return false;
        Queue<Node<String>> queueForRemove = getSubTree(currentNode);
        //queueForRemove.add(currentNode);

        parent = currentNode.parent;
        for (Node<String> node : queueForRemove)
        {
            if (node.parent != null && node.parent.left != null && node.equals(node.parent.left))
                node.parent.left = null;
            else if (node.parent != null && node.parent.right != null && node.equals(node.parent.right))
                node.parent.right = null;
            node = null;
            size--;
        }
        return true;
    }


    private boolean remove(Node<String> value)
    {

        Node<String> currentNode =  value;
        if(currentNode==null) return false;
        Queue<Node<String>> queueForRemove = getSubTree(currentNode);
        //queueForRemove.add(currentNode);

        parent = currentNode.parent;
        for (Node<String> node : queueForRemove)
        {
            if (node.parent != null && node.parent.left != null && node.equals(node.parent.left))
                node.parent.left = null;
            else if (node.parent != null && node.parent.right != null && node.equals(node.parent.right))
                node.parent.right = null;
            node = null;
            size--;
        }
        return true;
    }

    public String getParent(String value)
    {

        Node<String> searchingNode = findNode(value);
        if (searchingNode == null)
            return null;
        return (searchingNode.parent == null) ? null : searchingNode.parent.value;
    }


    Node<String> findNode(String value)
    {
        Queue<Node<String>> wholeTree = getSubTree(root);
        for (Node<String> node : wholeTree)
        {
            if (node==null) continue;
            if (node.value == null )
            {if (value==null) return node;}
            else if (node.value.equals(value))
                return node;
        }
        return null;
    }

    @Override
    public boolean add(String value)
    {
        Node<String> newNode = new Node<>(value, parent);
        Queue<Node<String>> allQueue = getSubTree(root);
        boolean itsRoot = parent==root;


        if (parent.left == null&&!(itsRoot&&allQueue.size()>1))
        {
            newNode.parent = parent;
            parent.left = newNode;
            size++;
        }

        else if (parent.right == null&&!(itsRoot&&allQueue.size()>2))
        {
            newNode.parent = parent;
            parent.right = newNode;
            size++;
        }

        else
        {

            Queue<Node<String>> wholeTree = getSubTree(root);
            for (Node<String> node : wholeTree)
            {
                if (node.left == null || node.right == null)
                {
                    parent = node;
                    break;
                }
            }
            add(value);
        }

        return true;
    }



    @Override
    public String get(int index)
    {

        throw new UnsupportedOperationException();


    }

    @Override
    public void clear()
    {
        if(root.right!=null)
            remove(root.right.value);
        if(root.left!=null)
            remove(root.left.value);

    }

    @Override
    public int size()
    {
        return size;
    }


    @Override
    public Solution  clone() throws CloneNotSupportedException
    {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Solution) ois.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    //возвращаем (точнее подменяем итератор)////////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private class Itr implements Iterator<String> {
        /**
         * Index of element to be returned by subsequent call to next.
         */
        int cursor = 0;

        /**
         * Index of element returned by most recent call to next or
         * previous.  Reset to -1 if this element is deleted by a call
         * to remove.
         */
        int lastRet = -1;
        Queue<Node<String>> wholeTree = getSubTree(root);
        /**
         * The modCount value that the iterator believes that the backing
         * List should have.  If this expectation is violated, the iterator
         * has detected concurrent modification.
         */
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public String next() {
            checkForComodification();
            try {

                int i = cursor;
                String next = get(i).value;
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        private Node<String> get(int index)
        {

            int i=0;
            for (Node<String> node : wholeTree)
            {
                if (i==index)
                    return node;
                i++;
            }
            throw  new NullPointerException();

        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                Solution.this.remove(get(lastRet));
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
            wholeTree = getSubTree(root);
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private class Node<String> implements Serializable
    {
        String value;
        Node<String> parent;
        Node<String> left;
        Node<String> right;

        public Node(String value, Node<String> parent)
        {
            this.value = value;
            this.parent = parent;
        }
    }
}
