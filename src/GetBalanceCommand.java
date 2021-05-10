import command.Balance;
import command.Command;

public class GetBalanceCommand implements Command {
	Balance balance;
	
	
	public GetBalanceCommand(Balance balance) {
		this.balance = balance;
	}

	@Override
	public double getBalance() {
		return balance.get();
	}

	@Override
	public void setBalance(double value) {
		//do nothing
	}

}
