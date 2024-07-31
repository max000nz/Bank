package user_interface;

import bank_classes.UserRequest;

public interface UserInterface {
    public void NewLoanR(UserRequest loan);
    public void NewDepositR(UserRequest deposit);
    public void PayoutLoanR(UserRequest closeLoan);
    public void WithdrawDepositR(UserRequest closeDeposit);
}
