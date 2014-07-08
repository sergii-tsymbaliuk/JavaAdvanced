package serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DoSerialize {
	final static String FILE_NAME = "store.db";
	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File (FILE_NAME);
		ObjectOutputStream os = null;
		ObjectInputStream is = null;
		Student std1,std2;
		
		f.setWritable(true);
		try {
			os = new ObjectOutputStream(new FileOutputStream(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		std1 = new Student("Student1",1980,"AB82");
		std2 = new Student("Student2",1985,"AM87");
		
		System.out.println(std1.toString());
		System.out.println(std2.toString());
		
		// Write object
		try {
			os.writeObject(std1);
			os.writeObject(std2);
			os.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//readobjects
		Student.tag = "Teacher";
		
		try {
			is = new ObjectInputStream(new FileInputStream(f));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			std1 = (Student)is.readObject();
			std2 = (Student)is.readObject();
			is.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println(std1.toString());
		System.out.println(std2.toString());
		
	}

}
