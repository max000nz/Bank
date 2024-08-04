package role_classes;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import enums.RoleType;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Admin extends Roles {
  LocalTime time = LocalTime.now();
  public static Queue<UserRequest> bankReq = BankRequest.getBankRequests();
  public static Queue<BankRequest> allBankLoans = new LinkedList<>();
  public static Queue<BankRequest> allBankDeposite = new LinkedList<>();
  
  // Constructor
  public Admin(String name, String lastName, int id, String password, RoleType role) {
    super(name, lastName, id, password, role);
  }

  // Deletes a specific user based on an id number.
  public void DeleteUser(int user_id) {
    try {
      UsersList.removeUser(user_id, this.id);
      if(user_id != 222222222) System.out.println("\nUser " + user_id + " was deleted successfully");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  // Denies a request.
  public void denyRequest() {
    if (BankRequest.denyRequest() == false) {
      System.out.println("No requests available");
      return;
    }
    System.out.println("Request denied");
  }

  // Determines what happens when the admin approves a request based on its type.
  public boolean handleApprovedRequest(Scanner input) throws Exception {
    if (BankRequest.getRequestsSize() == 0) {
      throw new Exception("requests size is 0");
    }
    UserRequest curr_req = BankRequest.getFirstRequest();
    int id = curr_req.getUserId();
    User curr_user = UsersList.findUsertById(id);
    switch (curr_req.getType()) {

      case LOAN:
        curr_user.setCash(curr_user.GetCash() + curr_req.getAmount());
        curr_user.setTotalLoans(curr_user.GetTotalLoans() + curr_req.getAmount());
        curr_req.setStartTime(time.toSecondOfDay()/60);
        curr_user.addLoan(curr_req.getId());
        BankRequest.increaseLoanNum();
        BankRequest.increaseLoanSum(curr_req.getAmount());
        break;

      case DEPOSIT:
        if (curr_req.getAmount() > curr_user.GetCash() + curr_user.GetFrame()) {
          System.out.println("error deposite bigger then your cash in the bank");
          break;
        }
        curr_user.setCash(curr_user.GetCash() - curr_req.getAmount());
        curr_user.setTotalDeposits(curr_user.GetTotalDeposit() + curr_req.getAmount());
        curr_req.setStartTime(time.toSecondOfDay()/60);
        curr_user.addDeposit(curr_req.getId());
        BankRequest.increaseDepositNum();
        BankRequest.increaseDepositSum(curr_req.getAmount());
        break;


      case CLOSE_LOAN:
        if(curr_req.getAmount() > curr_user.GetCash() + curr_user.GetFrame()){
        System.out.println("error remain of loan is bigger then your cash in the bank");
        break;
        }
        BankRequest.increaseProfit(curr_req.getAmount() - curr_req.getOriginalAmount());
        curr_user.setCash(curr_user.GetCash() - curr_req.getAmount());
        BankRequest.deleteApprovedRequest(curr_req);      //deletes approved request of the loan
        BankRequest.deleteCloseRequest(curr_req); //deletes close request of the loan
        curr_user.setTotalLoans(curr_user.GetTotalLoans() - curr_req.getAmount() + 0);
        curr_user.deleteLoan(curr_req.getId());
        BankRequest.decreaseLoanNum();
        BankRequest.decreaseLoanSum(curr_req.getOriginalAmount());
        break;

      case CLOSE_DEPOSIT:
        BankRequest.decreaseProfit(curr_req.getAmount() - curr_req.getOriginalAmount());
        curr_user.setCash(curr_user.GetCash() + curr_req.getAmount());
        BankRequest.deleteApprovedRequest(curr_req);      //deletes approved request of the deposit
        BankRequest.deleteCloseRequest(curr_req); //deletes close request of the deposit
        curr_user.setTotalDeposits(curr_user.GetTotalDeposit() - curr_req.getAmount());
        curr_user.deleteDeposit(curr_req.getId());
        BankRequest.decreaseDepositNum();
        BankRequest.decreaseDepositSum(curr_req.getOriginalAmount());
        break;
    }

    return true;
  }
}