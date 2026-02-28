import java.util.Scanner;

public class Main {

    // Returns a letter grade based on the average
    static char gradeFunction(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many grades (1 to 5)? ");
        int count = scanner.nextInt();

        double sum = 0;

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = scanner.nextDouble();
            sum += grade;
        }

        double average = sum / count;
        char letterGrade = gradeFunction(average);

        System.out.println("Average: " + average);
        System.out.println("Letter Grade: " + letterGrade);
    }
          }
