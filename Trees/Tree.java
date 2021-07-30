class treeNode {
    int data;
    treeNode left;
    treeNode right;

    treeNode() {} 
    treeNode(int a_data) {
        data = a_data;
    } 
}

public class Tree {
    public treeNode root;

    public Tree() {
        root = new treeNode();
    }

    public void preOrder(treeNode n) {
        
        if (n != null) {
            System.out.println("current: " + n.data);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public static void inOrder(treeNode n) {
        if (n != null) {
            postOrder(n.left);
            System.out.println("current: " + n.data);
            postOrder(n.right);
        }        
    }

    public static void postOrder(treeNode n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            System.out.println("current: " + n.data);
        }
    }
    
    public static void main(String[] args) throws Exception {
        // System.out.println("current");

        Tree TreeObj = new Tree();
        TreeObj.root.data = 17;

        TreeObj.root.left = new treeNode(13);
        TreeObj.root.right = new treeNode(27);

        TreeObj.root.left.left = new treeNode(9);
        TreeObj.root.left.right = new treeNode(16);

        TreeObj.root.left.left.right = new treeNode(11);

        TreeObj.root.right.left = new treeNode(20);
        TreeObj.root.right.right = new treeNode(39);

        TreeObj.preOrder(TreeObj.root); // 
        System.out.println("test\n");
        TreeObj.inOrder(TreeObj.root); //
        System.out.println("test\n");
        TreeObj.postOrder(TreeObj.root); //


        System.out.println("test");
    }
}
 