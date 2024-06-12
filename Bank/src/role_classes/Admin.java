package role_classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.UUID;


import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import connection.RoleAns;
import enums.RequestType;
import enums.RoleType;

public class Admin extends Roles {

  public static Queue<UserRequest> bankReq = BankRequest.getBankRequests();
  public static Queue<BankRequest> allBankLoans = new LinkedList<BankRequest>();
  public static Queue<BankRequest> allBankDeposite = new LinkedList<BankRequest>();

  public Admin(String name, String lastName, int id, String password, RoleType role) {
    super(name, lastName, id, password, role);
  }

  // public BankRequest getTransactionHistory() {

  // returns the tree;
  // }


  public void DeleteUser(int user_id) {
    UsersList.removeUser(user_id, this.id);
  }

  // private GetAnalytics(){
  // implementation of Binary tree
  // }

  public void approveRequest() {
    if (BankRequest.approveRequest() == false) {
      System.out.println("No requests available");
      return;
    }
    System.out.println("Request approved");
  }

  public void denyRequest() {
    if (BankRequest.denyRequest() == false) {
      System.out.println("No requests available");
      return;
    }
    System.out.println("Request denied");
  }

  public boolean handleApprovedRequest(Scanner input) throws Exception {
    if (BankRequest.getRequestsSize() == 0) {
      return false;
    }
    UserRequest curr_req = BankRequest.getFirstRequest();
    int id = curr_req.getUserId();
    User curr_user = UsersList.findUsertById(id);
    switch (curr_req.getType()) {

      case RequestType.LOAN:
        curr_user.SetCash(curr_user.GetCash() + curr_req.getAmount());
        curr_user.setTotalLoans(curr_user.GetTotalLoans() + curr_req.getAmount());
        curr_user.addLoan(curr_req.getId());
        break;

      case RequestType.DEPOSIT:
        if (curr_req.getAmount() > curr_user.GetCash() + curr_user.GetFrame()) {
          System.out.println("error deposite bigger then your cash in the bank");
          break;
        }
        curr_user.SetCash(curr_user.GetCash() - curr_req.getAmount());
        curr_user.setTotalDeposits(curr_user.GetTotalDeposit() + curr_req.getAmount());
        curr_user.addDeposit(curr_req.getId());
        break;

      case RequestType.CLOSE_LOAN:
        if(curr_req.getAmount() > curr_user.GetCash() + curr_user.GetFrame()){
        System.out.println("error remain of loan is bigger then your cash in the bank");
        break;
        }
        curr_user.SetCash(curr_user.GetCash() - curr_req.getAmount());
        BankRequest.deleteApprovedRequest(curr_req);      //deletes approved request of the loan
        BankRequest.deleteCloseRequest(curr_req.getId()); //deletes close request of the loan
        curr_user.setTotalLoans(curr_user.GetTotalLoans() - curr_req.getAmount());
        curr_user.deleteLoan(curr_req.getId());
        break;

      case RequestType.CLOSE_DEPOSIT:
        curr_user.SetCash(curr_user.GetCash() + curr_req.getAmount());
        BankRequest.deleteApprovedRequest(curr_req);      //deletes approved request of the deposit
        BankRequest.deleteCloseRequest(curr_req.getId()); //deletes close request of the deposit
        curr_user.setTotalDeposits(curr_user.GetTotalDeposit() - curr_req.getAmount());
        curr_user.deleteDeposit(curr_req.getId());
        break;
    }

    return true;
  }
}