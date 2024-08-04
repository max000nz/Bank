package data_structure;

import bank_classes.UserRequest;

public class TreeNode {
    UserRequest data;
    TreeNode left;
    TreeNode middle;
    TreeNode right;

    // Constructor
    public TreeNode(UserRequest data) {
        this.data = data;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}




