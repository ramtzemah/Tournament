/**
 * @author Grigory Shaulov
 * 
 **/
package command;


public class Balance {
	private double value;

	public Balance() {
		this.value = 0;
	}

	public double get() {
		return value;
	}

	public void set(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Balance [value=" + value + "]";
	}


}
