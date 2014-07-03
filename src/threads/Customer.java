package threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class Customer implements Runnable {
	private AtomicBoolean isCut = new AtomicBoolean(false);

	public boolean isCut() {
		return isCut.get();
	}

	public void setCut(boolean isCut) {
		this.isCut.set(isCut);
	}
	
	public void doCut() {
		setCut(true);
		System.out.println("Customer "+ this.hashCode() +": haircut completed");
	}

	@Override
	public void run() {
			if (!HairDressHall.isOccupied()) {
				System.out.println("Customer "+ this.hashCode() +": HairDress Hall is empty - go to do hair cut");				
				HairDressHall.setCustomer(this);
				System.out.println("Customer "+ this.hashCode() +": Unsleep hairdresser");				
				HairDressHall.getHairdresser().notify();
			} else {
				//если зал занят - пытаемся стать в очередь
				if (HairDressHall.isQueueFree()){
					HairDressHall.addToQueue(this);
					System.out.println("Customer "+ this.hashCode() +": Hairdress hall accupied - waiting in queue");
				} else {
					System.out.println("Customer "+ this.hashCode() +" left hairdresser - queue is full and hall accupied");
					return;
				}
			}
			while ( !isCut() ){	
				try {
					System.out.println("Customer "+ this.hashCode() +": not yet haircutted - sleeping");					
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
