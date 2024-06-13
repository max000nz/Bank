package data_structure;

import bank_classes.UserRequest;

public class ThreeBranchTree {
    private static TreeNode loanRoot;
    private static TreeNode depositRoot ;

    public ThreeBranchTree(UserRequest data) {
        switch (data.getType()) {
            case LOAN:
                this.loanRoot = new TreeNode(data);
                break;
            case DEPOSIT:
                this.depositRoot = new TreeNode(data);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void insertNode(UserRequest data) {
        switch (data.getType()) {
            case LOAN:
                insert(loanRoot, data);
                break;
            case DEPOSIT:
                insert(depositRoot, data);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void insert(TreeNode node, UserRequest data) {
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
