package data_structure;

public class ThreeBranchTree {
    private static TreeNode root;

    public ThreeBranchTree(int data) {
        this.root = new TreeNode(data);
    }

    public void insertNode(int data) {
        insert(root, data);
    }

    private void insert(TreeNode node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                insert(node.left, data);
            }
        } else if (data > node.data) {
            if (node.right == null) {
                node.right = new TreeNode(data);
            } else {
                insert(node.right, data);
            }
        } else {
            if (node.middle == null) {
                node.middle = new TreeNode(data);
            } else {
                insert(node.middle, data);
            }
        }
    }
}
