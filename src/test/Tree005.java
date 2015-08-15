package test;

/**
 * Created by maxim on 30.07.2015.
 */
public class Tree005 {
    //класс дерева
    public static class BSTree<T1 extends Comparable<T1>, T2>{
        //класс узел дерева
        static class Node<T1, T2>{
            T1 key;
            T2 value;
            Node<T1, T2> left, right;

            //constructor
            public Node(T1 key, T2 value) {
                this.key = key;
                this.value = value;
            }
        }

        //переменная узел - дерева
        private Node<T1, T2> root=null;

        //функция получающая значения по ключу
        public T2 get(T1 k){
            Node<T1, T2> x=root;
            while (x!=null){
                int cmp=k.compareTo(x.key);
                if (0==cmp){
                    return x.value;
                }
                if (0>cmp){
                    x=x.left;
                }else {
                    x=x.right;
                }
            }
            return null;
        }

        //добавление ключа и значение в дерево или замена значения по ключу
        public void add(T1 k, T2 v){
            Node<T1, T2> x=root, y=null;
            while (x!=null){
                int cmp=k.compareTo(x.key);
                if (0==cmp){
                    x.value=v;
                    return;
                }else {
                    y=x;
                    if (0>cmp){
                        x=x.left;
                    }else {
                        x=x.right;
                    }
                }
            }
            Node<T1, T2> newNode=new Node<T1, T2>(k,v);
            if (y==null){
                root=newNode;
            }else {
                if (k.compareTo(y.key)<0){
                    y.left=newNode;
                }else {
                    y.right=newNode;
                }
            }
        }

        //удаление узла из дерева
        public void remove(T1 k){
            Node<T1, T2> x=root,y=null;
            //поиск узла
            while (x!=null){
                int cmp=k.compareTo(x.key);
                if (0==cmp){
                    break;
                }else {
                    y=x;
                    if (0>cmp){
                        x=x.left;
                    }else {
                        x=x.right;
                    }
                }
            }
            if (x==null){
                return;
            }
            //если правое поддерево удаляемого узла null
            if (x.right==null){
                //и родитель удаляемого узла null
                if (y==null){
                    //то левое поддерево удаляемого узла присваиваем корню
                    root=x.left;
                }
                //если есть родитель у удаляемого узла
                else {
                    //если удаляемый узел является левым поддеревом родителя
                    if (x==y.left){
                        //то родительскому левому поддереву присваиваем левое поддерево удаляемого узла
                        y.left=x.left;
                    }
                    //иначе удаляемый узел является правым поддеревом родителя
                    else {
                        //то родительскому правому поддереву присваиваем левое поддерево удаляемого узла
                        y.right=x.left;
                    }
                }
            }
            //если левое поддерево удаляемого узла null или левое и правое не null
            else {
                //создаем переменную которой будет присвоено из правого поддерева удаляемого узла минимальный узел по
                //значению (т.е. самый левый в самом низу)
                Node<T1, T2> leftMost=x.right;
                //обнуляем родителя
                y=null;
                while (leftMost.left!=null){
                    //запоминаем родителя
                    y=leftMost;
                    leftMost=leftMost.left;
                }
                //если родитель не null
                if (y!=null){
                    //присвоить левому поддереву родителя правое поддерево минимального узла
                    y.left=leftMost.right;
                }
                //если родитель null
                else {
                    //присвоить левому поддереву родителя (он же удаляемый узел) правое поддерево минимального узла
                    x.right=leftMost.right;
                }
                //и в удаляемый узел записать ключ и значения минимального узла из правого поддерева удаляемого узла
                x.key=leftMost.key;
                x.value=leftMost.value;
            }
        }
    }

    //main
    public static void main(String[] args) {
        BSTree<Integer,String> tree=new BSTree<Integer, String>();
        tree.add(10,"max10");
        tree.add(6,"max6");
        tree.add(7,"max7");
        tree.add(19,"max19");
        tree.add(20,"max20");
        //test get
        System.out.println(tree.get(6));
        tree.add(6,"MAX");
        System.out.println(tree.get(6));
        //test remove
        tree.remove(10);
    }
}
