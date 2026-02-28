class JJKCharacter {
    String name;
    String role;
    String cursedTechnique;

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Cursed Technique: " + cursedTechnique);
    }
}

public class Main {
    public static void main(String[] args) {

        JJKCharacter character1 = null;

        try {
            character1.displayInfo();
        } catch (NullPointerException e) {
            System.out.println("JJK character object is not created.");
        }

        character1 = new JJKCharacter();

        character1.name = "Satoru Gojo";
        character1.role = "Special Grade Jujutsu Sorcerer";
        character1.cursedTechnique = "Limitless (Infinity, Blue, Red, Hollow Purple)";

        character1.displayInfo();
    }
}
