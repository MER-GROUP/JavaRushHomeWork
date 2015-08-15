package test;

public class RedBlackTree {

    //кдасс-узел красного дерева
    private static class RedBlackNode {
        Comparable   element;    // The data in the node
        RedBlackNode left;       // Left child
        RedBlackNode right;      // Right child
        int          color;      // Color

        // Constructors
        RedBlackNode( Comparable theElement ) {
            this( theElement, null, null );
        }

        RedBlackNode( Comparable theElement, RedBlackNode lt, RedBlackNode rt ) {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = RedBlackTree.BLACK;
        }
    }

    private RedBlackNode header;
    private static RedBlackNode nullNode;
    static         // Static initializer for nullNode
    {
        nullNode = new RedBlackNode( null );
        nullNode.left = nullNode.right = nullNode;
    }

    private static final int BLACK = 1;    // Black must be 1
    private static final int RED   = 0;

    // Used in insert routine and its helpers
    private static RedBlackNode current;
    private static RedBlackNode parent;
    private static RedBlackNode grand;
    private static RedBlackNode great;

    public RedBlackTree( ) {
        header      = new RedBlackNode( null );
        header.left = header.right = nullNode;
    }

    private final int compare( Comparable item, RedBlackNode t ) {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.element );
    }

    public boolean isEmpty( ) {
        return header.right == nullNode;
    }

    public void makeEmpty( ) {
        header.right = nullNode;
    }

    //правый поворот
    private static RedBlackNode rotateWithLeftChild( RedBlackNode k2 ) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    //левый поворот
    private static RedBlackNode rotateWithRightChild( RedBlackNode k1 ) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    //повороты поддерева родителя
    private RedBlackNode rotate( Comparable item, RedBlackNode parent ) {
        if( compare( item, parent ) < 0 )
            return parent.left = compare( item, parent.left ) < 0 ?
                    rotateWithLeftChild( parent.left )  :  // LL
                    rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = compare( item, parent.right ) < 0 ?
                    rotateWithLeftChild( parent.right ) :  // RL
                    rotateWithRightChild( parent.right );  // RR
    }

    //перекраска по красно-черному алгоритму
    private void handleReorient( Comparable item ) {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if( parent.color == RED )   // Have to rotate
        {
            grand.color = RED;
            if( ( compare( item, grand ) < 0 ) !=
                    ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }

    //insert
    public void insert( Comparable item ) {
        current = parent = grand = header;
        nullNode.element = item;

        while( compare( item, current ) != 0 ) {
            great = grand;
            grand = parent;
            parent = current;
            current = compare( item, current ) < 0 ?
                    current.left : current.right;

            // Check if two red children; fix if so
            if( current.left.color == RED && current.right.color == RED )
                handleReorient( item );
        }

        // Insertion fails if already present
        if( current != nullNode )
            throw new DuplicateItemException( item.toString( ) );
        current = new RedBlackNode( item, nullNode, nullNode );

        // Attach to parent
        if( compare( item, parent ) < 0 )
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }

    //printTree
    public void printTree() {
        printTree(header.right);
    }
    private void printTree(RedBlackNode t){
        if (t!=nullNode){
            printTree(t.left);
            System.out.print(" " + t.element);
            printTree(t.right);
        }
    }

    //findMin
    public Comparable findMin(){
        if (isEmpty()){
            return null;
        }
        RedBlackNode itr=header.right;
        while (itr.left!=nullNode){
            itr=itr.left;
        }
        return itr.element;
    }

    //findMax
    public Comparable findMax(){
        if (isEmpty()){
            return null;
        }
        RedBlackNode itr=header.right;
        while (itr.right!=nullNode){
            itr=itr.right;
        }
        return itr.element;
    }

    //find
    public Comparable find(Comparable x){
        nullNode.element=x;
        current=header.right;
        for (;;){
            if (x.compareTo(current.element)<0){
                current=current.left;
            }else if (x.compareTo(current.element)>0){
                current=current.right;
            }else if (current!=nullNode){
                return current.element;
            }else
                return null;
        }
    }

    //remove
    public void remove( Comparable x ) {
        throw new UnsupportedOperationException( );
    }

    // Test program
    public static void main( String [ ] args ) {
        RedBlackTree tree = new RedBlackTree( );
        tree.insert(10);
        tree.insert(6);
        tree.insert(7);
        tree.insert(19);
        tree.insert(20);
        tree.printTree();
        System.out.println("\n"+tree.findMin());
        System.out.println(tree.findMax());
        System.out.println(tree.find(19));
        System.out.println(tree.find(196));
        //tree.remove(19);
    }
}

class DuplicateItemException extends RuntimeException
{
    public DuplicateItemException( )
    {
        super( );
    }

    public DuplicateItemException( String message )
    {
        super( message );
    }
}