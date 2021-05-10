import command.Balance;
import command.Command;

public class SetBalanceCommand implements Command {
	Balance balance;
	
	
	public SetBalanceCommand(Balance balance) {
		this.balance = balance;
	}

	@Override
	public void setBalance(double value) {
		balance.set(value);
	}

	@Override
	public double getBalance() {
		return -1;
	}


}
