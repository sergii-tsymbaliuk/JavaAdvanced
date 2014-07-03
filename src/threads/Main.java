package threads;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HairDressHall.setHairdresser(new Hairdresser());
		
		Thread t = new Thread(HairDressHall.getHairdresser());
		t.setDaemon(true);
		t.start();
		
		for ( int i=0; i< 100; i++){
			new Thread(new Customer("Customer "+i)).start();
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
