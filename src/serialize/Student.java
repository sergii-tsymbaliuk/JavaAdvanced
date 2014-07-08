package serialize;

import java.io.Serializable;

public class Student extends Person implements Serializable {
	//private static final long serialVersionUID = -3377190700533541293L;
	public static String tag = "Student";
	public String code;
	private static final long serialVersionUID = 1L;	
	
	public Student() {
		super();		
		System.out.println("Default Strudent constructor executed for "+this.getClass()+" toString="+this.toString());
	}

	public Student(String name, Number burthdate, String code) {
		super(name, burthdate);
		this.code = code;
		System.out.println("Custom Strudent constructor executed for "+this.getClass()+" toString="+this.toString());
	}
	
	@Override
	public String toString() {
		return "Student [code=" + code + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", tag=" + tag + ", code=" + code				
				+ "]";
	}
}
