package observer;

/**
 * @author Grigory Shaulov
 * 
 **/

//Observable
public interface Sender {
	String getSimNumber();
	void sendMSG(Receiver r, Message msg);
}
