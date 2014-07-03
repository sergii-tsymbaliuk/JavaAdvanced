package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HairDressHall {
	private static final int DRESSHALL_QUEUE_CAPACITY = 4; //Вместимость зала ожидания 
	private static Customer customer = null;
	private static BlockingQueue<Customer> clientqueue = new LinkedBlockingQueue<Customer>(DRESSHALL_QUEUE_CAPACITY);
	private static Hairdresser hairdresser; 
	
	synchronized public static boolean isOccupied(){
		return !(customer==null);
	}
	
	synchronized public static Customer getCustomer() {
		return customer;
	}

	synchronized public static void setCustomer(Customer customer) {
		HairDressHall.customer = customer;
	}
	
	public static void doCutCustomer(){
		getCustomer().doCut();
		setCustomer(clientqueue.poll());
	}

	public static boolean isQueueFree (){
		return  ( clientqueue.size() < DRESSHALL_QUEUE_CAPACITY );
	}

	public static void addToQueue(Customer customer2) {
		try {
			clientqueue.put(customer2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Hairdresser getHairdresser() {
		return hairdresser;
	}

	public static void setHairdresser(Hairdresser hairdresser) {
		HairDressHall.hairdresser = hairdresser;
	}
}
