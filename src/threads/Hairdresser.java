package threads;

public class Hairdresser implements Runnable {

	@Override
	public void run() {
		while(true){
			//Если в зале есть клиент - стрижем
			if (HairDressHall.isOccupied()){
				System.out.println("Hairdresser docut customer in queue");
				HairDressHall.doCutCustomer();
			} else { //Иначе спим
				System.out.println("Hairdresser: Queue empty - sleeping");				
				synchronized( this ){
					try {
						this.wait(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
	}
}
