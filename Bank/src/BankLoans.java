
import java.util.*;

//gay

public class BankLoans {
  private int numOfLoans;
  private LinkedList<Loan> loans = null;
  
  
  public BankLoans() {
	  this.numOfLoans = 0;
	  this.loans = new LinkedList<Loan>();
  }
  
  
  public Loan findLoanByname(String name){
	  if (this.numOfLoans == 0) return null;
	  
	  
	  for (int i=0; i< this.numOfLoans; i++) {
		  if(this.loans.get(i).getName().equals(name)) return this.loans.get(i);
	  }
	  
	  System.out.println("name was not found");
	  return null;
  }
  
  
  public Loan deleteLoan(int id){
	  if (this.numOfLoans == 0 || loans.size() == 0) return null;
	  
	  for (int i=0; i< this.numOfLoans; i++) {
		  if(this.loans.get(i).id.equals(id)) return this.loans.get(i);
	  }
	  
	  System.out.println("name was not found");
	  return null;
  }
  
}
