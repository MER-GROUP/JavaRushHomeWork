package test;

/**
 * Created by maxim on 28.07.2015.
 */
public class Tree004 {
    public static class Node{
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    public static class Tree{
        private Node root;

        //при создании объекта все поля автоматом заполняются null значениями
        public Tree() {
            this.root=null;
        }

        //приватная перегруженная вставка
        private Node insert(Node current,int data,Node parent){
            if (current==null){
                current=new Node();
                current.setData(data);
                current.setLeft(null);
                current.setRight(null);
                current.setParent(parent);
            }else if (data<current.data){
                current.setLeft(insert(current.getLeft(),data,current));
            }else {
                current.setRight(insert(current.getRight(),data,current));
            }
            return current;
        }

        //перегруженная вставка
        public void insert(int data){
            root=insert(root,data,null);
        }

        //перегруженный обход
        public void traverseTree(TraverseType traverseType){
            traverseTree(root,traverseType);
        }

        //перегруженный обход
        private void traverseTree(Node current,TraverseType traverseType){
            if (current==null){
                return;
            }else {
                switch (traverseType){
                    case INORDER:
                        traverseTree(current.getLeft(),traverseType);
                        System.out.print(" " + current.getData());
                        traverseTree(current.getRight(), traverseType);
                        break;
                    case PREORDER:
                        System.out.print(" " + current.getData());
                        traverseTree(current.getLeft(),traverseType);
                        traverseTree(current.getRight(), traverseType);
                        break;
                    case POSTORDER:
                        traverseTree(current.getLeft(),traverseType);
                        traverseTree(current.getRight(),traverseType);
                        System.out.print(" " + current.getData());
                        break;
                }
            }
        }

        //перегруженный поиск узла в бинарном дереве
        public Node find(int data){
            return find(root,data);
        }

        //перегруженный поиск узла в бинарном дереве
        private Node find(Node currenr,int data){
            if (currenr==null){
                //System.out.println("no");
                return null;
            }else if (currenr.getData()==data){
                //System.out.println("yes");
                return currenr;
            }else
            return find((data<currenr.getData() ? currenr.getLeft() : currenr.getRight()),data);
        }

        //перегруженный поиск минимального узла
        public Node findMin(){
            Node min=root;
            if (min==null){
                return null;
            }
            while (min.getLeft()!=null){
                min=min.getLeft();
            }
            //System.out.println(min.getData());
            return min;
        }

        //перегруженный поиск минимального узла
        public Node findMin(Node current){
            Node min=current;
            if (min==null){
                return null;
            }
            while (min.getLeft()!=null){
                min=min.getLeft();
            }
            //System.out.println(min.getData());
            return min;
        }

        //перегруженная функция удаления
        public void delete(int data){
            root=delete(root,data);
        }

        //перегруженная функция удаления
        public Node delete(Node startNode,int data){
            //ищем узел который хотим удалить
            Node element=find(startNode,data);
            //если элемента нет то выходим из функции
            if (element==null) return startNode;
            //задаем значение для проверки есть ли у удаляемого узла родитель
            boolean hasParent=element.getParent()!=null;
            //задаем значение которое проверяет левое это поддерево
            boolean isLeft=hasParent && element.getData()<element.getParent().getData();
            //если у удаляемого элемента нет поддеревьев
            if (element.getLeft()==null && element.getRight()==null) {
                //если у удаляемого элемента есть родитель
                if (hasParent)
                {
                    //и он левое поддерево
                    if (isLeft)
                    {
                        //то у родителя обнуляем левое поддерево
                        element.getParent().setLeft(null);
                    }
                    //инначе он правое поддерево
                    else
                    {
                        //то у родителя обнуляем правое поддерево
                        element.getParent().setRight(null);
                    }
                }
                //если у удаляемого элемента нет родителя
                else {
                    //то обнуляю дерево
                    startNode=null;
                }
            }
            //если у удаляемого элемента есть левое поддерево и нет правого поддерева
            else if (element.getLeft()!=null && element.getRight()==null){
                //если у удаляемого элемента есть родитель
                if (hasParent){
                    //и он левое поддерево
                    if (isLeft){
                        //то родителю в левое поддерево присваиваем левое поддерево элемента
                        element.getParent().setLeft(element.getLeft());
                    }
                    //инначе он правое поддерево
                    else{
                        //то родителю в правое поддерево присваиваем левое поддерево элемента
                        element.getParent().setRight(element.getLeft());
                    }
                }
                //иначе если у удаляемого элемента нет родителя
                else {
                    //то на место удаляемого элемента вставляем его левое поддерево
                    startNode=element.getLeft();
                }
            }
            //если у удаляемого элемента есть правое поддерево и нет левого поддерева
            else if (element.getLeft()==null && element.getRight()!=null){
                //если у удаляемого элемента есть родитель
                if (hasParent){
                    //и он левое поддерево
                    if (isLeft){
                        //то родителю в левое поддерево присваиваем правое поддерево элемента
                        element.getParent().setLeft(element.getRight());
                    }
                    //инначе он правое поддерево
                    else {
                        //то родителю в правое поддерево присваиваем правое поддерево элемента
                        element.getParent().setRight(element.getRight());
                    }
                }
                //иначе если у удаляемого элемента нет родителя
                else {
                    //то на место удаляемого элемента вставляем его правое поддерево
                    startNode=element.getRight();
                }
            }
            //если у удаляемого элемента есть правое поддерево и левое поддерева
            else {
                //задаем значение переменной - ищем у правого поддерева удаляемого элемента минимальный узел
                Node rightMin=findMin(element.getRight());
                //заменяем значение удаляемого узла на минимальное значение правого поддерева удаляемого узла
                element.setData(rightMin.getData());
                //родителю минимального узла присваиваем правое поддерево минимального узла (рекурсивно)
                delete(rightMin,rightMin.getData());
            }
            //возвращаем дерево
            return startNode;
        }
    }

    //перечисление методов обхода бинарного дерева
    public enum TraverseType{
        INORDER,
        PREORDER,
        POSTORDER;
    }

    public static void main(String[] args) {
        //test
        /*Tree tree=new Tree();
        tree.insert(10);
        tree.insert(6);
        tree.insert(7);
        tree.insert(19);
        tree.insert(20);
        tree.traverseTree(TraverseType.INORDER);
        System.out.println();
        tree.traverseTree(TraverseType.PREORDER);
        System.out.println();
        tree.delete(10);
        tree.traverseTree(TraverseType.INORDER);
        System.out.println();
        tree.traverseTree(TraverseType.PREORDER);*/
        Tree tree=new Tree();
        tree.insert(10);
        tree.traverseTree(TraverseType.INORDER);
        System.out.println();
        tree.traverseTree(TraverseType.PREORDER);
        System.out.println();
        tree.delete(10);
        tree.traverseTree(TraverseType.INORDER);
        System.out.println();
        tree.traverseTree(TraverseType.PREORDER);
        System.out.println();
    }
}
