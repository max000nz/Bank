package menus;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import connection.RoleAns;
import enums.RequestType;
import java.util.Scanner;
import java.util.UUID;
import role_classes.User;

public class UserMenu {
    public static void ShowUserMenu(User currUser, Scanner input) throws Exception {
        float changeCash = 0;
        float currCash = 0;
        String message = "";
        int choice = -1;
        float newAmount;
        boolean exit = false;
        
        while (true) {
            System.out.println("\nWelcome, " + currUser.getName());
            System.out.println("Your current balance is: " + currUser.GetCash() + "\n");
            System.out.println("1.Withdrawal");
            System.out.println("2.Deposit Cash");
            System.out.println("3.Loan");
            System.out.println("4.Long deposit");
            System.out.println("5.Close loan");
            System.out.println("6.Close long-deposit");
            System.out.println("7.Show loans");
            System.out.println("8.Show deposit");
            System.out.println("0.Exit");

            choice = RoleAns.choiceInput("\nWhat do you want to do?", 0, 8, input);
            switch (choice) {

                case 0:
                    return;

                case 1:

                    currCash = currUser.GetCash();
                    if (currUser.GetCash() == 0) {
                        System.out.println("\nYou have no funds in your account");
                        break;
                    }
                    changeCash = RoleAns.cashInput("\nHow much money you want to withdraw?", 1, 1000000, input);
                    if(changeCash == 0) break;
                    if (currUser.GetCash() < changeCash) {
                        System.out.println("\nInsufficient funds");
                        break;
                    }
                    currCash -= changeCash;
                    currUser.setCash(currCash);
                    System.out.println("\nMoney was successfully withdrawn");
                    break;

                case 2:

                    changeCash = RoleAns.cashInput("\nHow much money you want to deposit?", 1, 50000, input);
                    if(changeCash == 0) break;
                    currCash = currUser.GetCash();
                    currCash += changeCash;
                    currUser.setCash(currCash);
                    System.out.println("\nMoney was successfully deposited");
                    break;

                case 3:

                    changeCash = RoleAns.cashInput("\nHow much money you want to loan?", 1, 50000, input);
                    if(changeCash == 0) break;
                    message = RoleAns.messageInput("\nWhy do you want to take a loan?", 1, 100, input);
                    UserRequest loan = new UserRequest();
                    loan.setAmount(changeCash);
                    loan.setOriginalAmount(changeCash);
                    loan.setMessage(message);
                    loan.setUserId(currUser.getId());
                    loan.setType(RequestType.LOAN);
                    loan.calculateInterest(changeCash);
                    currUser.NewLoanR(loan);
                    System.out.println("\nYour request was sent for review");
                    break;

                case 4:

                    currCash = currUser.GetCash();
                    if (currUser.GetCash() == 0) {
                        System.out.println("\nYou have no funds in your account");
                        break;
                    }
                    currCash = currUser.GetCash();
                    changeCash = RoleAns.cashInput("\nHow much money you want to put on long deposit?", 1, 10000000,input);
                    if(changeCash == 0) break;
                    if (currCash - changeCash < 0) {
                        System.out.println("\nInsufficient funds");
                        break;
                    }
                    message = RoleAns.messageInput("\nWhy do you want to deposit money?", 1, 100, input);
                    UserRequest deposit = new UserRequest();
                    deposit.setAmount(changeCash);
                    deposit.setOriginalAmount(changeCash);
                    deposit.setMessage(message);
                    deposit.setUserId(currUser.getId());
                    deposit.setType(RequestType.DEPOSIT);
                    deposit.calculateInterest(changeCash);
                    currUser.NewDepositR(deposit);
                    System.out.println("\nYour request was sent for review");
                    break;

                case 5:
                    exit = false;
                    int num = 1;
                    int loanChoice = -1;
                    if(currUser.getLoans().isEmpty()){
                        System.out.println("\nThere are no open loans");
                        break;
                    }
                    System.out.println("\nYour current balance is " + currUser.GetCash());
                    for (UUID elem : currUser.getLoans()) {
                        if(exit == true) break;
                        UserRequest curr_request = BankRequest.findAprrovedRequestById(elem);
                        newAmount = BankRequest.getNewAmount(elem);
                        if(newAmount == -1) continue;
                        UserRequest req = BankRequest.findAprrovedRequestById(elem);
                        System.out.println("\nLoan " + num + ":\nAmount Loaned: " + req.getOriginalAmount()
                                + "\nMessage: " + req.getMessage() + "\nInterest: " + req.getInterest() + "\nCurrent debt: " + newAmount);
                        num++;
                        // need to handle queue issue ( head moving backward whan choise is no)
                        loanChoice = RoleAns.choiceInput("\nDo you want to close this loan?\n1.Yes\n2.No\n0.Exit", 0, 2,input);
                        switch (loanChoice) {
                            case 1:
                                curr_request.setAmount(newAmount);
                                curr_request.setPendingToClose(true);
                                currUser.PayoutLoanR(curr_request);
                                System.out.println("\nRequest to close the loan sent successfully");
                                continue;
                            case 2:
                                continue;
                            case 0:
                                exit = true;
                                break;
                        }
                    }
                    break;

                case 6:
                    exit = false;
                    num = 1;
                    int depositChoice = 0;
                    if(currUser.getDeposits().isEmpty()){
                        System.out.println("\nThere are no open long-deposits");
                        break;
                    }
                    System.out.println("\nYour current balance is " + currUser.GetCash());
                    for (UUID elem : currUser.getDeposits()) {
                        if(exit == true) break;
                        UserRequest curr_request = BankRequest.findAprrovedRequestById(elem);
                        newAmount = BankRequest.getNewAmount(elem);
                        if(newAmount == -1) continue;
                        UserRequest req = BankRequest.findAprrovedRequestById(elem);
                        System.out.println("\nDeposit " + num + ":\nAmount Deposited: " + req.getOriginalAmount()
                                + "\nMessage: " + req.getMessage() + "\nInterest: " + req.getInterest() + "\nCurrent funds: " + newAmount);
                        num++;
                        depositChoice = RoleAns.choiceInput("\nDo you want to close this deposit?\n\n1.Yes\n2.No\n0.Exit", 0, 2, input);
                        switch (depositChoice) {
                            case 1:
                                curr_request.setAmount(newAmount);
                                curr_request.setPendingToClose(true);
                                currUser.WithdrawDepositR(curr_request);
                                System.out.println("\nRequest to close the deposit sent successfully");
                                continue;
                            case 2:
                                continue;
                            case 0:
                                exit = true;
                                break;
                        }
                    }
                    break;
                case 7:

                    if (currUser.getLoans().isEmpty()) {
                        System.out.println("\nThere are no open loans");
                        break;
                    }
                    int loan_counter = 1;
                    for (UUID elem : currUser.getLoans()) {
                        newAmount = BankRequest.getNewAmount(elem);
                        if(newAmount == -1) continue;
                        UserRequest req = BankRequest.findAprrovedRequestById(elem);
                        System.out.println("\nLoan " + loan_counter + ":\nAmount Loaned: " + req.getOriginalAmount()
                                + "\nMessage: " + req.getMessage() + "\nInterest: " + req.getInterest() + "\nCurrent debt: " + newAmount);
                        loan_counter++;
                    }
                    break;

                case 8:

                    if (currUser.getDeposits().isEmpty()) {
                        System.out.println("\nThere are no open long-deposits");
                        break;
                    }
                    int deposit_counter = 1;
                    for (UUID elem : currUser.getDeposits()) {
                        newAmount = BankRequest.getNewAmount(elem);
                        if(newAmount == -1) continue;
                        UserRequest req = BankRequest.findAprrovedRequestById(elem);
                        System.out.println("\nDeposit " + deposit_counter + ":\nAmount Deposited: " + req.getOriginalAmount()
                                + "\nMessage: " + req.getMessage() + "\nInterest: " + req.getInterest() + "\nCurrent funds: " + newAmount);
                        deposit_counter++;
                    }
            }
        }
    }
}
