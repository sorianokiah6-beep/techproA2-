package com.tutorialspoint;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SeatWorkFive {
   public static void main(String[] args) {

      String s = "Hello World! 3 + 3.0 = 6";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // check if the scanner's next token matches "rld" following 2 chars
      System.out.println("" + scanner.hasNext(Pattern.compile("..rld")));

      // check if the scanner's next token matches "llo" following 2 chars
      System.out.println("" + scanner.hasNext(Pattern.compile("..llo")));

      // print the rest of the string
      System.out.println("" + scanner.nextLine());

      // close the scanner
      scanner.close();
   }
}
