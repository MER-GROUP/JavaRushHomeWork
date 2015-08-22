//Всем привет. Действительно были ошибки. Ошибки я исправил и //сдал. Данный вариант еще с ошибками. Удачи)
package test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.List;


/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать HeapSolution.
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

public class HeapSolution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{

    public static final long serialVersionUID = 1241231;


    public static void main (String[]args)throws IOException, ClassNotFoundException, CloneNotSupportedException
    {

        List<String> list = new HeapSolution();
        List<String> list1 = new HeapSolution();
        list1.add("1231331");
        list1.add(":-) 1");
        System.out.println(list.size());
        for (int i = 1; i <= 1022; i++)
        {
            list.add(":-) " + i);
        }
        if (list.size() == 1022)
            System.out.println("ok 1");
        list.remove(":-) 512");

        if (list.size() == 1021)
            System.out.println("ok 2");
        list.remove(":-) 6");

        if (766 == list.size())
            System.out.println("ok 3");
        else
            System.out.println(list.size() + " error 3");
        list.remove(":-) 2");


        if (510 == list.size())
            System.out.println("ok 4");
        else
            System.out.println(list.size() + " error 4");
        for (int i = 15; i <= 22; i++)
        {
            list.remove(":-) " + i);
        }

        if (7 == list.size())
            System.out.println("ok 5");
        else
            System.out.println("error 5 list size is " + list.size());
        //int[] ii = new int[] {1, 3, 4, 7, 8, 9, 10};

        System.out.println(("должно быть :-) 3, а по факту " + ((HeapSolution) list).getParent(":-) 7")));
        System.out.println(("должно быть :-) 3, а по факту " + ((HeapSolution) list).getParent(":-) 8")));
        System.out.println(("должно быть :-) 4, а по факту " + ((HeapSolution) list).getParent(":-) 9")));
        System.out.println(("должно быть :-) 4, а по факту " + ((HeapSolution) list).getParent(":-) 10")));
        System.out.println(("должно быть :-) 1, а по факту " + ((HeapSolution) list).getParent(":-) 3")));
        System.out.println(("должно быть :-) 1, а по факту " + ((HeapSolution) list).getParent(":-) 4")));
        System.out.println(("должно быть null, а по факту " + ((HeapSolution) list).getParent(":-) 1")));
        for (Object o:list1){
            System.out.println(o + "parent - " + ((HeapSolution) list).getParent((String) o));
        }
        System.out.println("_____________________________");
        //list1.retainAll(list);
        list1.removeAll(list);
        for (Object o:list){
            System.out.println(o + "parent - " + ((HeapSolution) list).getParent((String) o));
        }
    }

    @Override
    protected HeapSolution clone() throws CloneNotSupportedException
    {
        super.clone();
        HeapSolution res = new HeapSolution();
        res.clear();
        Iterator<String> it = iterator();
        res.tree = new Node(null, null);
        res.tree.thisid = -1;
        while (it.hasNext())
        {
            String str = it.next();
            res.addToRightNode(str, findNode(tree, str).thisid);
        }
        return res;
    }




    public HeapSolution()
    {
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (tree != null ? tree.hashCode() : 0);
        return result;
    }

    @Override
    protected void finalize() throws Throwable
    {
        tree = null;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        Node top = tree;
        boolean result = false;
        Queue<Node> queue = new LinkedList<> ();
        queue.add(top);
        HeapSolution res = new HeapSolution();
        do{
            if (!queue.isEmpty()) top=queue.poll();
            if (top.item !=null)
            {
                if (c.contains(top.item))
                {
                    if (!res.contains(top.item))
                    {
                        res.add(top.item);
                        modCount++;
                    }

                }
            }
            if (top.left!=null) queue.add(top.left);
            if (top.right!=null) queue.add(top.right);

        }while (!queue.isEmpty());

        this.tree = res.tree;
        return result;
    }


    @Override
    public boolean removeAll(Collection<?> c)
    {
        for (Object o : this)
        {
            remove(o);
        }
        return true;
    }
    @Override
    public boolean containsAll(Collection<?> c)
    {
        boolean res = true;
        for (Object ad : c)
        {
            if (!contains(ad))
                return false;
        }
        return res;
    }

    @Override
    public boolean addAll(Collection<? extends String> c)
    {
        boolean res = true;
        for (Object ad : c)
        {
            if (!add(ad.toString()))
                res = false;
        }
        return res;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeapSolution strings = (HeapSolution) o;

        return !(tree != null ? !tree.equals(strings.tree) : strings.tree != null);

    }

    @Override
    public String[] toArray()
    {
        String[] res = new String[size()];
        IteratorHeapSolution it = new IteratorHeapSolution();
        int i = 0;
        while (it.hasNext())
        {
            res[i] = it.next();
            i++;
        }
        return res;
    }

    private transient Node tree = new Node(null, null);

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public String set(int index, String element)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public void add(int index, String element)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public String remove(int index)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public void clear()
    {
        tree = null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }
    @Override
    public ListIterator<String> listIterator() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Access from index denied");
    }
    @Override
    public ListIterator<String> listIterator(int index)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new IteratorHeapSolution();
    }

    @Override
    public int size()
    {
        int size = 0;
        Iterator<String> iterator = this.iterator();
        while (iterator.hasNext())
        {
            iterator.next();
            size++;
        }
        return size;
    }


    private static class Node
    {
        static int id = 0;
        String item;
        Node parent;
        Node left;
        Node right;
        int thisid;
        int level=0;

        Node(Node parent, String item)
        {
            this.item = item;
            this.parent = parent;
            this.left = null;
            this.right = null;
            this.thisid = id++;
            if (parent!=null)
            {
                this.level = parent.level+1;
            }
        }

        void clear()
        {
            this.thisid = 0;
            this.item = null;
            this.parent = null;
            this.left = null;
            this.right = null;
            this.level=0;
        }

    }

    private boolean addToRightNode(String s, int ind)
    {
        if (tree == null)                           //если дерева еще нет создадим
        {
            tree = new Node(null, s);               //создаем первый эл.
            return true;
        }
        Node res = tree;
        //Если у верхнего уровня есть два элемента
        if ((res.left!=null && res.right!=null) || (findLastNode(res).level>1))
        {

            res=findLastNode(res);
            Node resparent = res.parent==null ?tree:res.parent;
            //Проверка есть ли место на том же родителе
            if (resparent.left==null || resparent.right==null){
                //Слева
                if (resparent.left==null){
                    resparent.left = new Node(resparent, s);
                    resparent.left.thisid=ind;
                }
                //Справа
                else{
                    resparent.right = new Node(resparent, s);
                    resparent.right.thisid=ind;
                }
            }
            //Если нет
            else
            {
                //находим следующего родителя
                Node resTemp = findNodeNextParent(resparent, tree);
                // и если он есть добавляем к нему
                if (resTemp != null)
                {
                    resTemp.left = new Node(resTemp, s);

                }
                //Если следующего родителя на том же уровне нет
                else
                {
                    //Ищем первый элемент последнего уровня
                    res = findFirstNodeLastLevel(tree, findLastNode(tree).level);
                    res.left = new Node(res, s);
                    res.left.thisid=ind;

                }
            }

        }
        //Если не два
        else{
            //Если пустой левый, добавляем к нему
            if (res.left==null){
                res.left=new Node (null,s);
                res.left.thisid=ind;

            }
            else{
                res.right=new Node (null,s);
                res.right.thisid=ind;

            }
        }

        return true;
    }

    private boolean addToRightNode(String s)
    {
        if (tree == null)                           //если дерева еще нет создадим
        {
            tree = new Node(null, s);               //создаем первый эл.
            return true;
        }
        Node res = tree;
        //Если у верхнего уровня есть два элемента
        if ((res.left!=null && res.right!=null) || (findLastNode(res).level>1))
        {

            res=findLastNode(res);
            Node resparent = res.parent==null ?tree:res.parent;
            //Проверка есть ли место на том же родителе
            if (resparent.left==null || resparent.right==null){
                //Слева
                if (resparent.left==null){
                    resparent.left = new Node(resparent, s);
                }
                //Справа
                else{
                    resparent.right = new Node(resparent, s);
                }
            }
            //Если нет
            else
            {
                //находим следующего родителя
                Node resTemp = findNodeNextParent(resparent, tree);
                // и если он есть добавляем к нему
                if (resTemp != null)
                {
                    resTemp.left = new Node(resTemp, s);

                }
                //Если следующего родителя на том же уровне нет
                else
                {
                    //Ищем первый элемент последнего уровня
                    res = findFirstNodeLastLevel(tree, findLastNode(tree).level);
                    res.left = new Node(res, s);

                }
            }

        }
        //Если не два
        else{
            //Если пустой левый, добавляем к нему
            if (res.left==null){
                res.left=new Node (null,s);

            }
            else{
                res.right=new Node (null,s);

            }
        }

        return true;
    }

    private int getNodeLevel(Node node)
    {
        int lvl = 0;
        int lvlL = 0;
        int lvlR = 0;
        if (node == null)
            return 0;
        //Если есть оба элемента ил хотя бы один
        if (node.left!=null || node.right!=null){
            //Если есть левый
            if (node.left!=null)
            {
                //Если у левого есть дети
                if (node.left.left != null || node.left.right != null)
                {
                    lvlL = getNodeLevel(node.left);
                } else
                {
                    lvlL = 0;
                }
                lvlL++;
            }
            //Если есть правый
            if (node.right!=null)
            {
                //Если у правого есть дети
                if (node.right.left != null || node.right.right != null)
                {
                    lvlR = getNodeLevel(node.right);
                } else
                {
                    lvlR = 0;
                }
                lvlR++;
            }
            lvl=lvlL>lvlR?lvlL:lvlR;
        }
        return lvl;
    }

    private Node findNode(Node n, Object o)
    {
        if (n == null || o==null)
            return null;
        if (o.equals(n.item))
        {
            return n;
        }
        Node res = findNode(n.left, o);
        if (res == null)
            return findNode(n.right, o);
        return res;
    }
    //Ищем первый элемент на последнем уровне
    private Node findFirstNodeLastLevel(Node n,int level)
    {
        if (n == null)
            return n;
        Node resL=null;
        Node resR=null;
        if (n.level==level){
            return n;
        }
        else{
            resL=findFirstNodeLastLevel(n.left,level);
            resR=findFirstNodeLastLevel(n.right,level);
        }
        if (resL!=null && resR!=null){
            if (resL.thisid<resR.thisid)
            {
                return resL;
            }
            else{
                return resR;
            }
        }
        else{
            if (resL!=null && resR==null){
                return resL;
            }
            else{
                if (resR!=null && resL==null){
                    return resR;
                }
            }
        }
        return n;
    }
    //Ищем следующего родителя на том же уровне родителей
    private Node findNodeNextParent(Node n,Node nFound)
    {
        if (nFound == null)
            return nFound;
        if (nFound.level==n.level && nFound.thisid>n.thisid)
        {
            return nFound;
        }
        Node res = findNodeNextParent(n, nFound.left);
        if (res == null)
            return findNodeNextParent(n, nFound.right);
        return res;
    }
    //Ищем последний добавленных элемент
    private Node findLastNode(Node n)
    {
        Node resL=null;
        Node resR=null;
        if (n == null)
            return n;
        if (n.left!=null)
        {
            resL = findLastNode(n.left);
        }
        if (n.right!=null)
        {
            resR = findLastNode(n.right);
        }
        if (resR!=null && resL!=null){
            if (resL.thisid>resR.thisid)
            {
                return resL;
            }
            else
            {
                return resR;
            }
        }
        else{
            if (resL!=null && resR==null){
                return resL;
            }
            else
            {
                if (resR!=null && resL==null){
                    return resR;
                }
            }
        }
        return n;
    }

    private Node findNodeID(Node n, int id)
    {
        if (n == null)
            return n;
        if (n.thisid == id)
        {
            return n;
        }
        Node res = findNodeID(n.left, id);
        if (res == null)
            return findNodeID(n.right, id);
        return res;
    }

    @Override
    public boolean remove(Object o)
    {
        if (o==null)
        {
            return  false;
        }
        Node node = findNode(tree, o);

        if (node == null)
            return false;
        Node nodeParent=node.parent!=null?node.parent:tree;
        if (node.equals(nodeParent.left))
        {
            node = nodeParent;
            node.left.clear();
            node.left = null;
        } else
        {
            node = nodeParent;
            node.right.clear();
            node.right = null;
        }


        return true;
    }

    @Override
    public boolean add(String s)
    {
        return addToRightNode(s);
    }


    private class IteratorHeapSolution implements Iterator<String>
    {
        private int pos = 0;

        @Override
        public boolean hasNext()
        {
            if (findNodeID(tree, pos + 1) != null)
                return true;
            else
            {
                while (findNodeID(tree, pos + 1) == null)
                {
                    pos++;
                    if (pos + 1 > Node.id)
                        return false;
                }
                return true;
            }
        }

        @Override
        public String next()
        {
            pos++;
            Node ss = findNodeID(tree,pos);
            return ss.item;

        }

        @Override
        public void remove()
        {
            Node node = findNodeID(tree, pos);
            if (node!=null)
            {
                if (node.parent == null)
                {
                    tree = null;
                } else if (node.parent.left != null && node.parent.left.equals(node))
                {
                    node = node.parent;
                    node.left.clear();
                    node.left = null;
                } else
                {
                    node = node.parent;
                    node.right.clear();
                    node.right = null;
                }
            }
        }
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public boolean contains(Object o)
    {
        return findNode(tree, o) != null;
    }


    String getParent(String value)
    {
        //have to be implemented
        Node node = findNode(tree, value);
        if (node == null)
            return null;
        return node.parent!=null?node.parent.item:null;
    }

    private void writeObject(ObjectOutputStream o) throws IOException
    {
        o.defaultWriteObject();
        o.writeInt(size());
        Iterator<String> it = iterator();
        while (it.hasNext())
        {
            o.writeObject(it.next());
        }
    }

    private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException
    {
        o.defaultReadObject();
        int len = o.readInt();
        tree = null;
        for (int i = 0; i < len; i++)
        {
            add((String) o.readObject());
        }
    }

}


