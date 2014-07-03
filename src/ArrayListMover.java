import java.util.ArrayList;


public class ArrayListMover {

	public static void main(String[]args){
		
		ArrayList <Number> arraylist = new ArrayList<Number>();
		for (int i = -5 ; i<= 5; i++)
			arraylist.add(i);
		
		System.out.println(arraylist);
		
		for ( int i = 0, j=0; i <= arraylist.size(); i++){
			
			Number n = arraylist.remove(j);
			if (n.doubleValue() >= 0){
				arraylist.add(0 , n);
				j++;
			}
			else 
				arraylist.add(arraylist.size(),n);
		}
		System.out.println(arraylist);
	}
}
