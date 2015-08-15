package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by maxim on 27.07.2015.
 */
public class Tree003 {
    public static class Node{
        Node left;
        Node right;
        Node parrent;
        int value;

        //contructor
        public Node(Node parrent, int value) {
            this.parrent = parrent;
            this.value = value;
        }

        //contructor
        public Node(int value) {
            this.value = value;
        }

        //добавление значения в бинарное дерево
        //сравнить новое значение со старым
        //если новое значчение меньше старого, то рекурсивно добавить новое дерево в левое поддерево
        //если новое значение больше или равно старому значению, то рекурсивно добавить новое ддерево в правое поддерево
        //если поддерева нет, то вставить на это место новое дерево
        public void add(Node node){
            if (node.value<value){
                if (left!=null) left.add(node);
                else left=node;
            }else {
                if (right!=null) right.add(node);
                else right=node;
            }
        }

        //обход бинарного дерева в глубину в прямом порядке (рекурсивно)
        //примениить функцию печати к корневому узлу
        //рекурсивно обойти левое дерево
        //рекурсивно обойти правое дерево
        public void recPreOrder(){
            System.out.print(" " + this.value);
            if (left!=null) left.recPreOrder();
            if (right!=null) right.recPreOrder();
        }

        //обход бинарного дерева в глубину в симетричном порядке (рекурсивно)
        //рекурсивно обойти левое дерево
        //примениить функцию печати к корневому узлу
        //рекурсивно обойти правое дерево
        public void recInOrder(){
            if (left!=null) left.recInOrder();
            System.out.print(" " + this.value);
            if (right!=null) right.recInOrder();
        }

        //обход бинарного дерева в глубину в обратном порядке (рекурсивно)
        //рекурсивно обойти левое дерево
        //рекурсивно обойти правое дерево
        //примениить функцию печати к корневому узлу
        public void recPostOrder(){
            if (left!=null) left.recPostOrder();
            if (right!=null) right.recPostOrder();
            System.out.print(" " + this.value);
        }

        //обход бинарного дерева в ширину (итерационно)
        //обрабатываем первый в очереди узел, при наличии дочерних узлов
        //заносим их в конец очереди. переходим к следующей итерации
        public void contLevelOrder(Node top){
            Queue<Node> queue=new LinkedList<>();
            do{
                System.out.print(" "+top.value);
                if (top.left!=null) queue.add(top.left);
                if (top.right!=null) queue.add(top.right);
                if (!queue.isEmpty()) top=queue.poll();
            }while (!queue.isEmpty());
            System.out.print(" "+top.value);
        }

        //обход бинарного дерева в глубину в прямом порядке (итеративно)
        //обрабатываем текущий узел, при наличии правого поддерева добавляем его в стек
        //для последующей обработки. переходим к узлу левого поддерева.
        //если левого узла нет, переходим к верхнему узлу из стека
        public void contPreOrder(Node top){
            Stack<Node> stack=new Stack<>();
            while(top!=null || !stack.empty()){
                if (!stack.empty()){
                    top=stack.pop();
                }
                while (top!=null){
                    System.out.print(" "+top.value);
                    if (top.right!=null) stack.push(top.right);
                    top=top.left;
                }
            }
        }

        //обход бинарного дерева в глубину в симетричном порядке (итеративно)
        //из текущего узла спускаемся до самого нижнего левого узла,
        //добавляя в стек все посещенные узлы.
        //обрабатываем верхнийузел из стека. если в текущем узле имеется правое поддерево,
        //начинаем следующую итерацию с правого узла. если правого узла нет,
        //пропускаем шаг со спуском и переходим к обработке следующего узла из стека
        public void contInOrder(Node top){
            Stack<Node> stack=new Stack<>();
            while (top!=null || !stack.empty()){
                if (!stack.empty()){
                    top=stack.pop();
                    System.out.print(" "+top.value);
                    if (top.right!=null){
                        top=top.right;
                    }else {
                        top=null;
                    }
                }
                while (top!=null){
                    stack.push(top);
                    top=top.left;
                }
            }
        }

        //обход бинарного дерева в глубину в обратном порядке (итеративно)
        //делаем кодирование непосредственно в очередности стека - при спуске,
        //если у очередного узла позже нужно будет обработать еще правое поддерево,
        //в стек вносится последовательность - родитель, правый узел, родитель.
        //таким образом, при обработке узлов из стека мы сможем определить,
        //нужно ли нам обрабатывать правое поддерево.
        public void contPostOrder(Node top){
            Stack<Node> stack=new Stack<>();
            while (top!=null || !stack.empty()){
                if (!stack.empty()){
                    top=stack.pop();
                    if (!stack.empty() && top.right==stack.peek()){
                        top=stack.pop();
                    }else {
                        System.out.print(" " + top.value);
                        top=null;
                    }
                }
                while (top!=null){
                    stack.push(top);
                    if (top.right!=null){
                        stack.push(top.right);
                        stack.push(top);
                    }
                    top=top.left;
                }
            }
        }

        //обход бинарного дерева в глубину в обратном порядке (итеративно) с помощью указателя на родителя
        //нужно следить при подъеме на верхний уровень - пришли ли от правого потомка или от левого
        //для реализации метода - надо и метод add сделать с parent
        public void parentPostOrder(Node top){
            boolean fromRight=false;
            Node shuttle=top, holder;
            while (true){
                while (fromRight){
                    System.out.print(" "+shuttle.value);
                    if (shuttle==top){
                        return;
                    }
                    holder=shuttle;
                    shuttle=shuttle.parrent;
                    fromRight=(shuttle.right==holder);
                    if (!fromRight && shuttle.right!=null){
                        shuttle=shuttle.right;
                    }else {
                        fromRight=true;
                    }
                }
                while (shuttle.left!=null){
                    shuttle=shuttle.left;
                }
                if (shuttle.right!=null){
                    shuttle=shuttle.right;
                }else {
                    fromRight=true;
                }
            }
        }

        //перемещение на steps узлов от текущего узла start при симетричном обходе дерева
        //для реализации метода - надо и метод add сделать с parent
        public Node walkTheTree(Node start,int steps){
            boolean fromRight=true;
            Node shuttle=start,holder;
            if (shuttle.right!=null){
                shuttle=shuttle.right;
                while (shuttle.left!=null){
                    shuttle=shuttle.left;
                    fromRight=false;
                }
            }
            int counter=0;
            do{
                while (true){
                    if (!fromRight && ++counter==steps){
                        return shuttle;
                    }
                    if (!fromRight && shuttle.right!=null){
                        shuttle=shuttle.right;
                        break;
                    }
                    holder=shuttle;
                    shuttle=shuttle.parrent;
                    fromRight=(holder==shuttle.right);
                }
                while (shuttle.left!=null){
                    shuttle=shuttle.left;
                }
            }while (true);
        }
    }

    public static void main(String[] args) {
        Node node=new Node(6);
        node.add(new Node(4));
        node.add(new Node(9));
        node.add(new Node(7));
        node.add(new Node(10));
        node.add(new Node(5));
        node.add(new Node(3));
        System.out.println("---------node.recInOrder()---------------");
        node.recInOrder();
        System.out.println("\n---------node.contLevelOrder(node)---------------");
        node.contLevelOrder(node);
        System.out.println("\n---------node.recPostOrder()---------------");
        node.recPostOrder();
        System.out.println("\n---------node.recPreOrder()---------------");
        node.recPreOrder();
        System.out.println("\n---------node.contPreOrder(node)---------------");
        node.contPreOrder(node);
        System.out.println("\n---------node.contInOrder(node)---------------");
        node.contInOrder(node);
        System.out.println("\n---------node.contPostOrder(node)---------------");
        node.contPostOrder(node);
        //System.out.println("\n---------node.parentPostOrder(node)---------------");
        //node.parentPostOrder(node);
    }
}
