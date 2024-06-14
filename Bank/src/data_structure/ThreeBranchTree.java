package data_structure;

import bank_classes.UserRequest;

public class ThreeBranchTree {
    private static TreeNode loanRoot;
    private static TreeNode depositRoot ;

    public static void insertNode(UserRequest data) {
        switch (data.getType()) {
            case CLOSE_LOAN:
                loanRoot = insert(loanRoot, data);
                break;
            case CLOSE_DEPOSIT:
                depositRoot = insert(depositRoot, data);
                break;
            default:
                System.err.println("Error when creating a new Tree Branch");
        }
    }

    private static TreeNode insert(TreeNode node, UserRequest data) {
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

        return node;
    }

    public static void printTransactionHistory(TreeNode root){
        if (root == null) return;
        printTransactionHistory(root.right);
        printTransactionHistory(root.middle);
        printTransactionHistory(root.left);
        System.out.println("User ID: " + root.data.getUserId() + "\nMessage: " + root.data.getMessage() + "\nAmount: " + root.data.getAmount() + "\n");
    }

    public static TreeNode getLoanRoot() {
        return loanRoot;
    }

    public static TreeNode getDepositRoot() {
        return depositRoot;
    }
    
}
