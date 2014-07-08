package serialize;

public class Person {
	public String name;
	public Number burthdate;
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", burthdate=" + burthdate + "]";
	}


	public Person() {
		super();
		name = "DefaultName";
		System.out.println("Default Person constructor executed for "+this.getClass()+" toString="+this.toString());
	}


	public Person(String name, Number burthdate) {
		super();
		this.name = name;
		this.burthdate = burthdate;
		System.out.println("Custom Person constructor executed for "+this.getClass()+" toString="+this.toString());
	} 
}
