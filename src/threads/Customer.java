package threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class Customer implements Runnable {
	private AtomicBoolean isCut = new AtomicBoolean(false);
	private String name;

	public String getName() {
		return name;
	}

	public Customer(String name) {
		this.name = name; 
	}

	public boolean isCut() {
		return isCut.get();
	}

	public void setCut(boolean isCut) {
		this.isCut.set(isCut);
	}
	
	public void doCut() {
		System.out.println(getName() +": begin to haircut");
		try {		
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setCut(true);
		System.out.println(getName() +": haircut completed");
	}

	@Override
	public void run() {
			if (!HairDressHall.isOccupied()) {
				System.out.println(getName() +": HairDress Hall is empty - go to do hair cut");				
				HairDressHall.setCustomer(this);
				System.out.println(getName() +": Unsleep hairdresser");	
				synchronized( HairDressHall.getHairdresser() ){
					HairDressHall.getHairdresser().notifyAll();
				}
			} else {
				//если зал занят - пытаемся стать в очередь
				if (HairDressHall.isQueueFree()){
					HairDressHall.addToQueue(this);
					System.out.println(getName() +": Hairdress hall accupied - waiting in queue");
				} else {
					System.out.println(getName() +" left hairdresser - queue is full and hall accupied");
					return;
				}
			}
			while ( !isCut() ){	
				try {
					System.out.println(getName() +": not yet haircutted - sleeping");					
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
}
