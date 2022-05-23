import java.util.Stack;

public class BinarySearchTree {
    private TreeNode root;
    private int size;
    int[] list = new int[5];

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    private TreeNode createNewNode(int e){
        return new TreeNode(e);
    }

    public int getSize(){
        return size;
    }
    public TreeNode getRoot(){
        return root;
    }
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    TreeNode insert_Recursive(TreeNode root, int key) {
        //tree is empty
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        //traverse the tree
        if (key < root.getElement())     //insert in the left subtree
            root.setLeft(insert_Recursive(root.getLeft(), key)) ;
        else if (key > root.getElement())    //insert in the right subtree
            root.setRight(insert_Recursive(root.getRight(), key));
        // return pointer
        return root;
    }

    public int[] getList(){
        return list;
    }
    public void inorder(){
        Stack nodes = new Stack<>();
        int count = 0;
        TreeNode current = root;
        while((!nodes.isEmpty() ||current != null) && count < 5){
            if(current != null){
                nodes.push(current);
                current = current.getLeft();
            }
            else{
                TreeNode node = (TreeNode) nodes.pop();
                list[count] = node.getElement();
                System.out.println(node.getElement());
                current = node.getRight();
                count++;
            }
        }
    }

}
