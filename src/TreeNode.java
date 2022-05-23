public class TreeNode {
    private int element;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int newElement){
        element = newElement;
        left = null;
        right = null;
    }
    public int getElement(){
        return element;
    }
    public void setElement(int newElement){
        element = newElement;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
