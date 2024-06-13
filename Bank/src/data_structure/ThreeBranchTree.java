package data_structure;

import bank_classes.UserRequest;

public class ThreeBranchTree {
    private static TreeNode root;

    public ThreeBranchTree(UserRequest data) {
        this.root = new TreeNode(data);
    }

    public static void insertNode(UserRequest data) {
        insert(root, data);
    }

    private static void insert(TreeNode node, UserRequest data) {
        if (data.getAmount() < node.data.getAmount()) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                insert(node.left, data);
            }
        } else if (data.getAmount() > node.data.getAmount()) {
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
