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
        while (true) {
            System.out.println("\nWelcome, " + currUser.getName());
            System.out.println("Your current balance is: " + currUser.GetCash() + "\n");
            System.out.println("1.Withdrawal");
            System.out.println("2.Deposit Cash");
            System.out.println("3.Loan");
            System.out.println("4.Long deposit");
            System.out.println("5.Close loan");
            System.out.println("6.Close long deposit");
            System.out.println("7.Show loans History");
            System.out.println("8.Show deposit History");
            System.out.println("0.Exit\n");

            choice = RoleAns.choiceInput("What do you want to do?", 0, 8, input);
            switch (choice) {

                case 0:
                    return;

                case 1:

                    currCash = currUser.GetCash();
                    if (currUser.GetCash() == 0) {
                        System.out.println("Current Balance = 0");
                        break;
                    }
                    changeCash = RoleAns.cashInput("How much money you want to withdrawal?", 1, 1000000, input);
                    if (currUser.GetCash() < changeCash) {
                        System.out.println("You dont have enongh money in your balance");
                        break;
                    }
                    currCash -= changeCash;
                    currUser.setCash(currCash);
                    System.out.println("Money was successfully withdrawn");
                    break;

                case 2:

                    changeCash = RoleAns.cashInput("How much money you want to deposit?", 1, 50000, input);
                    currCash = currUser.GetCash();
                    currCash += changeCash;
                    currUser.setCash(currCash);
                    System.out.println("Money was successfully deposited");
                    break;

                case 3:

                    changeCash = RoleAns.cashInput("How much money you want to loan?", 1, 50000, input);
                    message = RoleAns.messageInput("Why you want to take a loan?", 1, 100, input);
                    UserRequest loan = new UserRequest();
                    loan.setAmount(changeCash);
                    loan.setMessage(message);
                    loan.setUserId(currUser.getId());
                    loan.setType(RequestType.LOAN);
                    loan.calculateInterest(changeCash);
                    currUser.NewLoanR(loan);
                    System.out.println("Your request was successfully sent to the bank");
                    break;

                case 4:

                    currCash = currUser.GetCash();
                    changeCash = RoleAns.cashInput("How much money you want to put on long deposit?", 1, 10000000,
                            input);
                    if (currCash - changeCash < 0) {
                        System.out.println("You dont have enough money in your account balance");
                        break;
                    }
                    message = RoleAns.messageInput("Why you want to put money on deposit?", 1, 100, input);
                    UserRequest deposit = new UserRequest();
                    deposit.setAmount(changeCash);
                    deposit.setMessage(message);
                    deposit.setUserId(currUser.getId());
                    deposit.setType(RequestType.DEPOSIT);
                    deposit.calculateInterest(changeCash);
                    currUser.NewDepositR(deposit);
                    System.out.println("Your request was successfully sent to the bank");
                    break;

                case 5:

                    int num = 1;
                    int loanChoice = -1;
                    System.out.println("Your current balance is " + currUser.GetCash());
                    for (UUID elem : currUser.getLoans()) {
                        UserRequest curr_request = BankRequest.findAprrovedRequestById(elem);
                        if (curr_request.isPendingToClose() == true)
                            continue;
                        System.out.println(num + ". " + curr_request.getAmount());
                        num++;
                        // need to handle queue issue ( head moving backward whan choise is no)
                        loanChoice = RoleAns.choiceInput("Do you want to close this loan?\n1.Yes\n2.No\n0.Exit", 0, 2,
                                input);
                        switch (loanChoice) {
                            case 1:
                                curr_request.setPendingToClose(true);
                                currUser.PayoutLoanR(curr_request);
                                System.out.println("Request to close the loan sent successfully");
                                continue;
                            case 2:
                                continue;
                            case 0:
                                break; // CHANGE MAIN SWITCH TO WHILE AND THIS WILL WORK
                        }
                    }
                    break;

                case 6:

                    num = 1;
                    int depositChoice = 0;
                    System.out.println("Your current balance is " + currUser.GetCash());
                    for (UUID elem : currUser.getDeposits()) {
                        UserRequest curr_request = BankRequest.findAprrovedRequestById(elem);
                        if (curr_request.isPendingToClose() == true)
                            continue;
                        System.out.println(num + ". " + curr_request.getAmount());
                        num++;
                        depositChoice = RoleAns.choiceInput("Do you want to close this deposit?\n1.Yes\n2.No\n0.Exit",
                                0, 2, input);
                        switch (depositChoice) {
                            case 1:
                                curr_request.setPendingToClose(true);
                                currUser.WithdrawDepositR(curr_request);
                                System.out.println("Request to close the deposit sent successfully");
                                continue;
                            case 2:
                                continue;
                            case 0:
                                break; // CHANGE MAIN SWITCH TO WHILE AND THIS WILL WORK
                        }
                    }
                    break;
                case 7:

                    if (currUser.getLoans().isEmpty()) {
                        System.out.println("No more Loans");
                        break;
                    }
                    int loan_counter = 1;
                    for (UUID elem : currUser.getLoans()) {
                        UserRequest req = BankRequest.findAprrovedRequestById(elem);
                        System.out.println("Loan " + loan_counter + ":\nAmount Loaned: " + req.getAmount()
                                + "\nMessage: " + req.getMessage() + "\nInterest: " + req.getInterest());
                        loan_counter++;
                    }
                    System.out.println("No more Loans");
                    break;

                case 8:

                    if (currUser.getDeposits().isEmpty()) {
                        System.out.println("No more Deposits");
                        break;
                    }
                    int deposit_counter = 1;
                    for (UUID elem : currUser.getDeposits()) {
                        UserRequest req = BankRequest.findAprrovedRequestById(elem);
                        System.out.println("Deposit " + deposit_counter + ":\nAmount Deposited: " + req.getAmount()
                                + "\nMessage: " + req.getMessage() + "\nInterest: " + req.getInterest());
                        deposit_counter++;
                    }
                    System.out.println("No more Deposits");
                    break;
            }
        }
    }
}
