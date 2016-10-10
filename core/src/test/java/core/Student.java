package core;

public class Student {
	String name;
    int age;
    boolean flag;
    
    static {
    	System.out.print("tt");
    }

	public Student() {
		System.out.print(this.name);
		System.out.print(this.age);
		System.out.print(this.flag);
	}
}
