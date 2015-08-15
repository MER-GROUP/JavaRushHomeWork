package test;

/**
 * Created by maxim on 27.07.2015.
 */
public class Tree002 {
    public static class Tree{
        //правое и левое поддеревья и ключ
        public Tree big;
        public Tree small;
        public int key;
        //конструктор и инициализацией ключа
        public Tree(int key) {
            this.key = key;
        }
        //add -  добавление нового поддерева (ключа)
        //сравнить ключ добавляемого поддерева (К) с ключем корневого узла (Х).
        //если к>=х рекурсивно добавить новое новое дерево в правое поддерево
        //к<х рекурсивно добавить новое дерево в левое поддерево.
        //если поддерева нет то вставить на это место новое дерево
        public void add(Tree aTree){
            //если ключ-значение больше узла
            if (aTree.key>key){
                //если правая ветка не null
                if (big!=null){
                    //то рекурсивно идем вглубь правой ветки
                    big.add(aTree);
                }
                //если правая ветка null
                else {
                    //то правой ветке присваиваем созданное дерево
                    big=aTree;
                }
            }
            //если ключ значение меньше узла
            else {
                //если левая ветка не null
                if (small!=null){
                    //то рекурсивно идем вглубь левой ветки
                    small.add(aTree);
                }
                //если левая ветка null
                else {
                    //то левой ветке присваиваем созданный узел
                    small=aTree;
                }
            }
        }
        //traverse - обход
        //рекурсивно обойти левое левое поддерево
        //применить функцию f (печать) к корневому узлу
        //рекурсивно обойти правое поддерево
        public void infix_traverse(){
            if (small!=null){
                small.infix_traverse();
            }
            System.out.print(" " + key);
            if (big!=null){
                big.infix_traverse();
            }
        }
        //вершина, левое поддерево, правое поддерево
        public void prefix_traverse(){
            System.out.print(" " + key);
            if (small!=null){
                small.prefix_traverse();
            }
            if (big!=null){
                big.prefix_traverse();
            }
        }
        //левое, правое, вершина
        public void postfix_traverse(){
            if (small!=null){
                small.postfix_traverse();
            }
            if (big!=null){
                big.postfix_traverse();
            }
            System.out.print(" " + key);
        }
    }

    public static void main(String[] args) {
        Tree myTree;
        myTree=new Tree(7);//создать дерево с ключом
        myTree.add(new Tree(5));//присоединять поддеревья
        myTree.add(new Tree(9));
        myTree.add(new Tree(6));
        myTree.add(new Tree(1));
        myTree.add(new Tree(3));
        myTree.add(new Tree(2));
        myTree.add(new Tree(10));
        myTree.infix_traverse();
        System.out.println("\n----------------");
        myTree.prefix_traverse();
        System.out.println("\n----------------");
        myTree.postfix_traverse();
        System.out.println("\n----------------");
    }
}
