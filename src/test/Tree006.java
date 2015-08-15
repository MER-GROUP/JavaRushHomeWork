package test;

/**
 * Created by maxim on 03.08.2015.
 */
public class Tree006 {
    //унаследованный класс RuntimeException
    public static class DuplicateItemException extends RuntimeException{
        //construct
        public DuplicateItemException() {
            super();
        }
        //construct
        public DuplicateItemException(String message) {
            super(message);
        }
    }

    //унаследованный класс RuntimeException
    public static class ItemNotFoundException extends RuntimeException{
        //construct
        public ItemNotFoundException() {
            super();
        }
        //construct
        public ItemNotFoundException(String message) {
            super(message);
        }
    }

    //класс узел бинарного дерева
    static class BinaryNode{
        Comparable element;
        BinaryNode left;
        BinaryNode right;
        //construct
        public BinaryNode(Comparable element) {
            this.element = element;
            left=right=null;
        }
    }

    //класс бинарного дерева
    public static class BinarySearchTree{
        //корень дерева
        protected BinaryNode root;

        //construct
        public BinarySearchTree() {
            root=null;
        }

        //insert
        public void insert(Comparable x){
            root=insert(x,root);
        }
        protected BinaryNode insert(Comparable x,BinaryNode t){
            //если корень равен bull
            if (t==null){
                t=new BinaryNode(x);
            }
            //если вставляемое значение нового узла меньше значения текущего узла
            //то переходим в левое поддерево
            else if (x.compareTo(t.element)<0){
                //
                t.left=insert(x,t.left);
            }
            //если вставляемое значение нового узла больше значения текущего узла
            //то переходим в правое поддерево
            else if (x.compareTo(t.element)>0){
                t.right=insert(x,t.right);
            }
            //иначе если значение значение нового узла равно значению текущего узла то выбрасываем исключение
            //(хотя это неправильно так делать)
            else {
                throw new DuplicateItemException(x.toString());
            }
            return t;
        }

        //infix
        public void infix(){
            infix(root);
            System.out.println();
        }
        protected void infix(BinaryNode node){
            if (node==null) return;
            else {
                if (node.left!=null) infix(node.left);
                System.out.print(" " + node.element);
                if (node.right!=null) infix(node.right);
            }
        }

        //remove
        public void remove(Comparable x){
            remove(x,root);
        }
        protected BinaryNode remove(Comparable x,BinaryNode t){
            //если дерево пусто
            if (t==null) throw new ItemNotFoundException(x.toString());
            else {
                //если удаляемый элемент меньше то идем в левое поддерево
                if (x.compareTo(t.element)<0) t.left=remove(x,t.left);
                //если удаляемый элемент больше то идем в правое поддерево
                else if (x.compareTo(t.element)>0) t.right=remove(x,t.right);
                //если элемент равен и у удаляемого узла есть двое детей
                else if (t.left!=null && t.right!=null){
                    //значение минимального элемента правого поддерева присваиваю удаляемому узлу
                    t.element=findMin(t.right).element;
                    //минимальный узел правого поддерева удаляю
                    t.right=removeMin(t.right);
                }
                //иначе если элемент равен и у удаляемого узла есть хотябы один родитель
                else {
                    t=(t.left!=null)?t.left:t.right;
                }
                //вернуть новый узел
                return t;
            }
        }

        //elementAt - взятие элемента из узла
        private Comparable elementAt(BinaryNode t){
            return (t==null)?null:t.element;
        }

        //findMin()
        public Comparable findMin(){
            return elementAt(findMin(root));
        }
        protected BinaryNode findMin(BinaryNode t){
            if (t!=null){
                while (t.left!=null){
                    t=t.left;
                }
            }
            return t;
        }

        //removeMin()
        public void removeMin(){
            root=removeMin(root);
        }
        protected BinaryNode removeMin(BinaryNode t){
            if (t==null) throw new ItemNotFoundException();
            else if (t.left!=null){
                t.left=removeMin(t.left);
                return t;
            }else {
                return t.right;
            }
        }

        //findMax
        public Comparable findMax(){
            return elementAt(findMax(root));
        }
        protected BinaryNode findMax(BinaryNode t){
            if(t!=null)
                while(t.right!=null) t=t.right;
            return t;
        }

        //find
        public Comparable find(Comparable x){
            return elementAt(find(x,root));
        }
        protected BinaryNode find(Comparable x,BinaryNode t){
            while (t!=null){
                if (x.compareTo(t.element)<0) t=t.left;
                else if (x.compareTo(t.element)>0) t=t.right;
                else return t;
            }
            return null;
        }

    }

    //main
    public static void main(String[] args) {
        /*
        //test insert
        BinarySearchTree tree=new BinarySearchTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(10);
        tree.insert(7);
        tree.insert(15);
        tree.insert(18);
        //test infix
        tree.infix();
        //test remove
        tree.remove(5);
        tree.infix();
        //test findMax
        System.out.println(tree.findMax());
        //test find
        System.out.println(tree.find(15));
        System.out.println(tree.find(155));
        */

        /*
        BinarySearchTree t=new BinarySearchTree();
        final int NUMS=4000;
        final int GAP=37;

        System.out.println("Cheking... (no more output means success)");
        for (int i = GAP; i !=0 ; i=(i+GAP)%NUMS) {
            t.insert(new Integer(i));
        }
        t.infix();

        for (int i = 1; i < NUMS; i+=2) {
            t.remove(new Integer(i));
        }
        t.infix();

        if (((Integer)(t.findMin())).intValue()!=2 || ((Integer)(t.findMax())).intValue()!=NUMS-2){
            System.out.println("FindMin or FindMax error!");
        }

        for (int i = 2; i < NUMS; i+=2) {
            if (((Integer)(t.find(new Integer(i)))).intValue()!=i){
                System.out.println("Find error!");
            }
        }

        for (int i = 1; i < NUMS; i+=2) {
            if (t.find(new Integer(i))!=null){
                System.out.println("Find error2!");
            }
        }
        */
        BinarySearchTree t2=new BinarySearchTree();
        t2.insert("MAX");
        t2.insert("POL");
        t2.insert("ZUM");
        t2.insert("AAA");
        t2.infix();
    }
}
