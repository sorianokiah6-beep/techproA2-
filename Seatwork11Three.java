import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int number;
        boolean isHeads;

        // Random number from 1 to 6
        number = random.nextInt(6) + 1;  // nextInt(6) = 0-5, +1 → 1-6

        // Random boolean (true = HEADS, false = TAILS)
        isHeads = random.nextBoolean();

        System.out.println("Dice roll: " + number);

        if (isHeads) {
            System.out.println("Coin: HEADS");
        } else {
            System.out.println("Coin: TAILS");
        }
    }
}
