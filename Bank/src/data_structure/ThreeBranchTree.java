package data_structure;

import bank_classes.UserRequest;

public class ThreeBranchTree {
    private static TreeNode loanRoot;
    private static TreeNode depositRoot ;

    // Inserts a node with the user request into the three-branch tree.
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

    //  Inserts a node into the tree, based on the amount of money requested.
    private static TreeNode insert(TreeNode node, UserRequest data) {
        if (node == null){
            node = new TreeNode(data);
        } else if (data.getOriginalAmount() < node.data.getOriginalAmount()) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                insert(node.left, data);
            }
        } else if (data.getOriginalAmount() > node.data.getOriginalAmount()) {
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

    // Prints the history of all the loans that were closed from the tree.
    public static void printLoanHistory(TreeNode root){
        if (root == null){
            System.out.println("\nThere are no closed loans");
            return;
        }
        printLoanHistory(root.right);
        printLoanHistory(root.middle);
        System.out.println("User ID: " + root.data.getUserId() + "\nMessage: " + root.data.getMessage() + "\nAmount Loaned: " + root.data.getOriginalAmount() + "\nAmount Paid: "+root.data.getAmount()+"\n");
        printLoanHistory(root.left);
    }

    // Prints the history of all the long-deposits that were closed from the tree
    public static void printDepositHistory(TreeNode root){
        if (root == null){
            System.out.println("\nThere are no closed deposits");
            return;
        }
        printDepositHistory(root.right);
        printDepositHistory(root.middle);
        System.out.println("User ID: " + root.data.getUserId() + "\nMessage: " + root.data.getMessage() + "\nAmount Deposited: " + root.data.getOriginalAmount() + "\nAmount Withdrawn: "+root.data.getAmount()+"\n");
        printDepositHistory(root.left);
    }

    // Returns the root of the loans tree
    public static TreeNode getLoanRoot() {
        return loanRoot;
    }

    // Returns the root of the deposits tree
    public static TreeNode getDepositRoot() {
        return depositRoot;
    }
    
}
