import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String filePath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim().toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        if (words.isEmpty()) {
            System.out.println("Word list is empty!");
            return;
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("**********************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("**********************");

        while (wrongGuesses < 6) {

            System.out.println(getHangmanArt(wrongGuesses));

            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean correct = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    wordState.set(i, guess);
                    correct = true;
                }
            }

            if (correct) {
                System.out.println("Correct guess!");
                if (!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("YOU WIN!");
                    System.out.println("The word was: " + word);
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess!");
            }
        }

        if (wrongGuesses >= 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was: " + word);
        }

        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        switch (wrongGuesses) {
            case 1:
                return "  O";
            case 2:
                return "  O\n  |";
            case 3:
                return "  O\n /|";
            case 4:
                return "  O\n /|\\";
            case 5:
                return "  O\n /|\\\n /";
            case 6:
                return "  O\n /|\\\n / \\";
            default:
                return "";
        }
    }
}
