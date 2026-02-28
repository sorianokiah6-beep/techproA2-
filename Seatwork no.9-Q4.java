import java.util.ArrayList;

class Student {
    private int id;
    private String name;

    
    Student(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Student Created: " + name);
    }

    void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

  
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Garbage Collector destroying Student object: " + name);
        } finally {
            super.finalize();
        }
    }
}

public class GarbageCollectorDemo {

    public static void main(String[] args) {
        System.out.println("=== Student Record System Started ===");
        ArrayList<Student> students = new ArrayList<>();

        
        students.add(new Student(1, "Juan"));
        students.add(new Student(2, "Maria"));
        students.add(new Student(3, "Pedro"));

        System.out.println("\n--- Displaying Student Records ---");
        for (Student s : students) {
            s.displayInfo();
        }

        // Removing references
        System.out.println("\n--- Removing Student Records ---");
        students.remove(0); // Juan removed
        students.remove(0); // Maria removed (shifts to index 0 after Juan is removed)

        // Suggest Garbage Collection
        System.out.println("\nRequesting Garbage Collection...");
        System.gc(); 

        // Creating more objects to increase memory usage
        System.out.println("\n--- Creating Temporary Student Objects ---");
        for (int i = 4; i <= 20; i++) {
            Student temp = new Student(i, "TempStudent" + i);
            // 'temp' goes out of scope each loop, making it eligible for GC
        }

        // Nullifying remaining references
        System.out.println("\n--- Clearing Remaining References ---");
        students = null;

        // Request GC again
        System.out.println("\nRequesting Garbage Collection Again...");
        System.gc();

        // Pause to allow GC to run
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\n=== Program Ended ===");
    }
}
