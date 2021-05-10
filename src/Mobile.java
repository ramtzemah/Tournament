

/**
 * @author Grigory Shaulov
 * 
 **/
import java.time.LocalDateTime;

import command.Balance;
import command.BalanceCommand;
import javafx.scene.shape.CubicCurve;
import observer.Message;
import observer.Receiver;
import observer.Sender;


public class Mobile implements Sender, Receiver, MobileFunc {
	private String name;
	private String simNumber;
	private BalanceCommand balanceCommand;
	private VCall currentVCall;
	private boolean stop = false;
	
	
	public Mobile(String name, String simNumber) {
		stop=false;
	//	super();
		this.name = name;
		this.simNumber = simNumber;
		Balance balance = new Balance();
		this.balanceCommand= new BalanceCommand(new SetBalanceCommand(balance),new GetBalanceCommand(balance));
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public double getSimBalance() {
		return balanceCommand.getBalance();
	}
	@Override
	public void setSimBalance(double simBalance) {
		this.balanceCommand.setBalance(simBalance);
	}
	@Override
	public VCall getCurrentVCall() {
		currentVCall.checkAccess();
		return null;
	}
	@Override
	public void startVCall(VCall vCall) throws InterruptedException {
		vCall.setSimNumber(simNumber);
		vCall.setBalanceCommand(balanceCommand);
		currentVCall=vCall;
		currentVCall.start();
	}
	@Override
	public void stopVCall() {
		currentVCall.setstop(true);
	//	startVCall(currentVCall).interrupt();
//		System.out.println("Voice Call Stopped [From: "+ simNumber +" To: "+currentVCall.getCallNumber() +" Balance: "+balanceCommand.getBalance() +" Duration: " + 
//				"]");
	}
	@Override
	public void receiveMSG(Sender s, Message msg) {
		System.out.println("-------------"+s.getSimNumber()+"-------------");
		System.out.println("New Message Has Arrived\n" + 
				"------------------------------------\n" + 
				"From: "+simNumber+"\n" + 
				"Date: "+msg.getTime()+"\n" + 
				"Message: "+msg.getMsg()+"\n" + 
				"------------------------------------\n");		
	}
	@Override
	public String getSimNumber() {
		return simNumber;
	}
	@Override
	public void sendMSG(Receiver r, Message msg) {
		receiveMSG((Sender) r, msg);
	}

	
	
	



}
