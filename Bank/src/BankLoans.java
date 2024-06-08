import java.util.LinkedList;

public class BankLoans {
  private int numOfLoans;
  private LinkedList<UserRequest> loans = null;
  
  
  public BankLoans() {
	  this.numOfLoans = 0;
	  this.loans = new LinkedList<UserRequest>();
  }
  
  
  public UserRequest findLoanByname(String name){
	  if (this.numOfLoans == 0) return null;
	  
	  for (int i=0; i< this.numOfLoans; i++) {
		  // if(this.loans.get(i).getName().equals(name)) return this.loans.get(i);		// No method getName
	  }
	  
	  System.out.println("name was not found");
	  return null;
  }
  
  
  public UserRequest deleteLoan(int id){
	  if (this.numOfLoans == 0 || loans.size() == 0) return null;
	  
	  for (int i=0; i< this.numOfLoans; i++) {
		  // if(this.loans.get(i).id.equals(id)) return this.loans.get(i);				// No method getName
	  }
	  
	  System.out.println("name was not found");
	  return null;
  }
  
}
