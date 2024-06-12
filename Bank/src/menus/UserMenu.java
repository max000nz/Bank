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
        while(true){
            System.out.println("Welcome, " + currUser.getName());

            System.out.println("1.Withdrawal");
            System.out.println("2.Deposit Cash");
            System.out.println("3.Loan");
            System.out.println("4.Long deposit");
            System.out.println("5.Close loan");
            System.out.println("6.Close long deposit");
            System.out.println("0.Exit");
            
            choice = RoleAns.choiceInput("What do you want to do?", 0, 7, input);
            switch (choice) {
    
                case 0:
                    return;
    
                case 1:
                    currCash = currUser.GetCash();

                    if(currUser.GetCash()==0) {System.out.println("Current Balance = 0"); break;}
                    changeCash = RoleAns.cashInput("How much money you want to withdrawal?", 1, currCash, input);
                    if(currUser.GetCash()-changeCash<0) {System.out.println("You dont have enongh money in your balance"); break;}
                    currCash -= changeCash;
                    currUser.setCash(currCash);
                    System.out.println("Your current balance is: "+currUser.GetCash());
                    break;
    
    
                case 2:
                    changeCash = RoleAns.cashInput("How much money you want to deposit?", 1, 50000, input);
                    currCash = currUser.GetCash();
                    currCash += changeCash;
                    currUser.setCash(currCash);
                    System.out.println("Your current balance is: "+currUser.GetCash());
                    break;
    
    
                case 3:
                    changeCash = RoleAns.cashInput("How much money you want to loan?", 1, 50000, input);
                    message = RoleAns.messageInput("Why you want to take a loan?", 1, 100, input);
                    UserRequest loan = new UserRequest();
                    loan.setAmount(changeCash);
                    loan.setMessage(message);
                    loan.setUserId(currUser.getId());
                    loan.setType(RequestType.LOAN);
                    currUser.NewLoanR(loan);
                    break;
    
                case 4:
                    currCash = currUser.GetCash();
                    changeCash = RoleAns.cashInput("How much money you want to put on long deposit?", 1, currCash, input);
                    message = RoleAns.messageInput("Why you want to put money on deposit?", 1, 100, input);
                    UserRequest deposit = new UserRequest();
                    deposit.setAmount(changeCash);
                    deposit.setMessage(message);
                    deposit.setUserId(currUser.getId());
                    deposit.setType(RequestType.DEPOSIT);
                    currUser.NewDepositR(deposit);
                    break;
                case 5:
                    int num = 1;
                    int loanChoice = 0;
                    System.out.println("Your current balance is " + currUser.GetCash());
                    for (UUID elem : currUser.getLoans()) {
                        UserRequest curr_request = BankRequest.findRequestById(elem);
                        System.out.printf("%d. %d", num, curr_request.getAmount());
                        num++;
                        // need to handle queue issue ( head moving backward whan choise is no)
                        loanChoice = RoleAns.choiceInput("Do you want to close this loan?\n1.Yes\n2.No\n3.Exit", 1, 3, input);
                        switch (loanChoice) {
                            case 1:
                                currUser.PayoutLoanR(curr_request);
                                continue;
                                // if (currUser.GetCash() >= curr_request.getAmount()) {
                                //     currUser.PayoutLoanR(curr_request);
                                // } else {
                                //     System.out.println("You dont have enough money!");
                                //     break;
                                // }
                            case 2:
                                continue;
                            case 3:
                                return; // CHANGE MAIN SWITCH TO WHILE AND THIS WILL WORK
                        }
                    }
                    break;
                case 6:
                    num = 1;
                    int depositChoice = 0;
                    System.out.println("Your current balance is " + currUser.GetCash());
                    for (UUID elem : currUser.getDeposits()) {
                        UserRequest curr_request = BankRequest.findRequestById(elem);
                        System.out.printf("%d. %d", num, curr_request.getAmount());
                        num++;
                        depositChoice = RoleAns.choiceInput("Do you want to close this deposit?\n1.Yes\n2.No\n3.Exit", 1, 3, input);
                        switch (depositChoice) {
                            case 1:
                                currUser.WithdrawDepositR(curr_request);
                                continue;
                            case 2:
                                continue;
                            case 3:
                                return; // CHANGE MAIN SWITCH TO WHILE AND THIS WILL WORK
                            }
                        }
                } 
            }
        }
    }




