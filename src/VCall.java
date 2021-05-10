/**
 * @author Grigory Shaulov
 * 
 **/


import java.time.LocalTime;

import command.Balance;
import command.BalanceCommand;

public class VCall extends Thread {

	private String simNumber;
	private String callNumber;
	private BalanceCommand balanceCommand;
	private double pricePerMin;
	private boolean stop;
	
	public VCall(String callNumber, double pricePerMin) {
		this.stop=false;
		this.callNumber = callNumber;
		this.pricePerMin = pricePerMin;
		Balance balance = new Balance();
		this.balanceCommand= new BalanceCommand(new SetBalanceCommand(balance),new GetBalanceCommand(balance));
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public double getSimBalance() {
		return balanceCommand.getBalance();
	}

	public void setSimBalance(double simBalance) {
		this.balanceCommand.setBalance(simBalance);
	}

	public double getPricePerMin() {
		return pricePerMin;
	}

	public void setPricePerMin(double pricePerMin) {
		this.pricePerMin = pricePerMin;
	}

	@Override
	public void run() {
		System.out.printf("Voice Call Started [From: %s To: %s Balance: %.2f]\n", getSimNumber(), callNumber,getSimBalance());
		LocalTime duration = LocalTime.of(0, 0, 0);
		//duration=LocalTime.now();
		//add code here
		while (getSimBalance()-(getPricePerMin()/60)>0) {
			try {

				Thread.sleep(1000);
				if(stop) {
					break;
				}
				duration=duration.plusSeconds(1);
				
				setSimBalance(getSimBalance()-(getPricePerMin()/60));
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
		}if(!stop) {
		System.out.printf("Voice Call Finished(No Enough Balance) [From: %s To: %s Balance: %.2f Durtion: "+duration+"]\n", getSimNumber(), callNumber,getSimBalance());
		}
		else { System.out.printf("Voice Call Stopped [From: %s To: %s Balance: %.2f Duration: " + duration+"]", getSimNumber(), callNumber,getSimBalance());
		System.out.println();
		}
	}

	public void setBalanceCommand(BalanceCommand balanceCommand) {
		this.balanceCommand = balanceCommand;
		
	}

	public void setstop(boolean b) {
		stop=b;
	}

}
