class Person {
 	String name;
 	int age;

     void displayInfo() {
 	System.out.println("Name: " + name);
     System.out.println("Age: " + age);  
     }
   } 

public class Main {
	public static void main(String[] args) {
	
	Person p = new Person();
	
    p.name = "Nia";
    p.age = 16;
    
    p.displayInfo();	
	}
}
