import java.util.Scanner;

public class ScannerDemo {
   public static void main(String[] args) {

      // create a new scanner with System Input
      Scanner scanner = new Scanner(System.in);
         
      while (scanner.hasNext()) {
         
         // check if the scanner's next token is a Boolean
         if(scanner.hasNextBoolean()){
            // print what is scanned
            System.out.println("Found: " + scanner.nextBoolean());		 
         } else {
            System.out.println("Not Found: " + scanner.next());
         }
      }

      // close the scanner
      scanner.close();
   }
}
