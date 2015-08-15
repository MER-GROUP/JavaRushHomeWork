package test;

/**
 * Created by maxim on 27.07.2015.
 */
public class Tree001 {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        /*
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node2=new TreeNode(2,null,node5);
        TreeNode node0=new TreeNode(0,null,null);
        TreeNode node4=new TreeNode(4,null,null);
        TreeNode node1=new TreeNode(1,node0,node4);
        TreeNode node3=new TreeNode(3,node2,node1);
        TreeNode ref=node3;
        */
        TreeNode ref=new TreeNode(3,
                                    new TreeNode(2,
                                                    null,
                                                    new TreeNode(5,null,null)),
                                    new TreeNode(1,
                                                    new TreeNode(0,null,null),
                                                    new TreeNode(4,null,null)));
    }
}
