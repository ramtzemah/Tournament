package command;
public class BalanceCommand {
	//private double balance;
	
	//public class PointCommand {
		Command setBalance;
		Command getBalance;
		
		
		public BalanceCommand(Command setBalance, Command getBalance) {
			this.setBalance = setBalance;
			this.getBalance = getBalance;
		}
	
	public double getBalance() {
		return getBalance.getBalance();
	}

	public void setBalance(double value) {
		setBalance.setBalance(value);
	}
//
//	public double getBalanceCommand() {
//		return getBalance();
//	}
//
//	public void setBalanceCommand(double simBalance) {
//		setBalance(simBalance);
//	}

}
