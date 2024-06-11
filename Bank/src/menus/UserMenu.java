package menus;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import connection.RoleAns;
import enums.RequestType;

import java.util.Queue;
import java.util.Scanner;
import java.util.UUID;

import role_classes.User;

public class UserMenu {
    public static void ShowUserMenu(User currUser) {

        float changeCash = 0;
        float currCash = 0;
        String message;
        System.out.println("Welcome, " + currUser.getName());

        System.out.println("1.Withdrawal");
        System.out.println("2.Deposit Cash");
        System.out.println("3.Loan");
        System.out.println("4.Long deposit");
        System.out.println("5.Close loan");
        System.out.println("6.Close long deposit");
        int choice = RoleAns.intInput("What you want to do?", 1, 4);
        switch (choice) {

            case 1:
                currCash = currUser.GetCash();
                changeCash = RoleAns.floatInput("How much money you want to withdrawal?", 1, currCash);
                currCash -= changeCash;
                currUser.SetCash(currCash);
                break;

            case 2:
                changeCash = RoleAns.floatInput("How much money you want to deposit?", 1, 50000);
                currCash = currUser.GetCash();
                currCash += changeCash;
                currUser.SetCash(currCash);
                break;

            case 3:
                changeCash = RoleAns.floatInput("How much money you want to loan?", 1, 50000);
                message = RoleAns.stringInput("Why you want to take a loan?", 1, 100, true);
                UserRequest loan = new UserRequest();
                loan.setAmount(changeCash);
                loan.setMessage(message);
                loan.setUserId(currUser.getId());
                loan.setType(RequestType.LOAN);
                currUser.NewLoanR(loan);
                break;

            case 4:
                currCash = currUser.GetCash();
                changeCash = RoleAns.floatInput("How much money you want to put on long deposit?", 1, currCash);
                message = RoleAns.stringInput("Why you want to put money on deposit?", 1, 100, true);
                UserRequest deposit = new UserRequest();
                deposit.setAmount(changeCash);
                deposit.setMessage(message);
                deposit.setUserId(currUser.getId());
                deposit.setType(RequestType.DEPOSIT);
                currUser.NewDepositR(deposit);
                break;
            case 5:
                int num = 1;
                int loanChoice;
                System.out.println("Your current balance is " + currUser.GetCash());
                for (UUID elem : currUser.getLoans()) {
                    UserRequest curr_request = BankRequest.findRequestById(elem);
                    System.out.printf("%d. %d", num, curr_request.getAmount());
                    num++;
                    loanChoice = RoleAns.intInput("Do you want to close this loan?\n1.Yes\n2.No\n3.Exit", 1, 3);
                    switch (loanChoice) {
                        case 1:
                            if (currUser.GetCash() > curr_request.getAmount()) {
                                currUser.PayoutLoanR(curr_request);
                            } else {
                                System.out.println("You dont have enough money!");
                                return;
                            }
                            break;
                        case 2:
                            continue;
                        case 3:
                            return; // CHECK IF LEGIT
                    }
                }
                break;
            case 6:
                num = 1;
                int depositChoice;
                System.out.println("Your current balance is " + currUser.GetCash());
                for (UUID elem : currUser.getDeposits()) {
                    UserRequest curr_request = BankRequest.findRequestById(elem);
                    System.out.printf("%d. %d", num, curr_request.getAmount());
                    num++;
                    depositChoice = RoleAns.intInput("Do you want to close this deposit?\n1.Yes\n2.No\n3.Exit", 1, 3);
                    switch (depositChoice) {
                        case 1:
                            currUser.WithdrawDepositR(curr_request);
                            break;
                        case 2:
                            continue;
                        case 3:
                            return; // CHECK IF LEGIT
                    }
                }
        }
    }
}
