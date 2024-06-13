package data_structure;

import bank_classes.UserRequest;

public class ThreeBranchTree {
    private static TreeNode loanRoot;
    private static TreeNode depositRoot ;

    public ThreeBranchTree(UserRequest data) {

        switch (data.getType()) {
            case LOAN:
                loanRoot = new TreeNode(data);
                break;
            case DEPOSIT:
                depositRoot = new TreeNode(data);
                break;
            default:
                System.err.println("Error when creating a new Tree Branch");
        }
    }

    public static void insertNode(UserRequest data) {
        switch (data.getType()) {
            case CLOSE_LOAN:
                insert(loanRoot, data);
                break;
            case CLOSE_DEPOSIT:
                insert(depositRoot, data);
                break;
            default:
                System.err.println("Error when creating a new Tree Branch");
        }
    }

    private static void insert(TreeNode node, UserRequest data) {
        if (node == null){
            node = new TreeNode(data);
        } else if (data.getAmount() < node.data.getAmount()) {
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
