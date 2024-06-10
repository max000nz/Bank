package menus;


import bank_classes.BankRequest;
import bank_classes.UserRequest;
import connection.RoleAns;
import enums.RequestType;
import java.util.Scanner;
import role_classes.User;

public class UserMenu {
    public static void ShowUserMenu(User currUser){

        float changeCash = 0;
        float currCash = 0;
        String message;
        System.out.println("Welcome, " + currUser.getName());

        System.out.println("Withdrawal");
        System.out.println("Deposit Cash");
        System.out.println("Loan");
        System.out.println("Long deposit");
        System.out.println("Close loan");
        System.out.println("Close long deposit");
        int choice = RoleAns.intInput("What you want to do?", 1, 4);
        switch(choice){

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
            message = RoleAns.stringInput("Why you want to take a loan?", 1,100,true);
            UserRequest loan = new UserRequest();
            loan.setAmount(changeCash);
            loan.setMessage(message);
            loan.setUserId(currUser.GetId());
            loan.setType(RequestType.LOAN);
            currUser.NewLoanR(loan);
        break;
        
        case 4:
            currCash = currUser.GetCash();    
            changeCash = RoleAns.floatInput("How much money you want to put on long deposit?", 1, currCash);
            message = RoleAns.stringInput("Why you want to put money on deposit?", 1,100,true);
            UserRequest deposit = new UserRequest();
            deposit.setAmount(changeCash);
            deposit.setMessage(message);
            deposit.setUserId(currUser.GetId());
            deposit.setType(RequestType.DEPOSIT);
            currUser.NewDepositR(deposit);
        break;
        case 5:
            //Request Close Loan


        currUser.PayoutLoanR(loan);
        break;
        case 6:
            //Request Close Deposit

            
        currUser.WithdrawDepositR(deposit);
        break;
        }
    }
}
