import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        while (alarmTime == null) {
            try {
                System.out.print("Enter an alarm time (HH:mm:ss): ");
                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter);

                // If time already passed → set for next day
                if (alarmTime.isBefore(LocalTime.now())) {
                    alarmTime = alarmTime.plusHours(24);
                }

                System.out.println("Alarm set for " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use HH:mm:ss");
            }
        }

        Thread alarmThread = new Thread(new AlarmClock(alarmTime));
        alarmThread.start();
    }

    // 🔔 AlarmClock class inside the same file
    static class AlarmClock implements Runnable {

        private final LocalTime alarmTime;
        private final String filePath = "A Caring Friend.wav";

        public AlarmClock(LocalTime alarmTime) {
            this.alarmTime = alarmTime;
        }

        @Override
        public void run() {

            while (LocalTime.now().isBefore(alarmTime)) {
                try {
                    Thread.sleep(1000);
                    LocalTime now = LocalTime.now();
                    System.out.printf("\rCurrent time: %02d:%02d:%02d",
                            now.getHour(), now.getMinute(), now.getSecond());
                } catch (InterruptedException e) {
                    return;
                }
            }

            System.out.println("\n⏰ ALARM!");
            playSound();
        }

        private void playSound() {

            File audioFile = new File(filePath);

            if (!audioFile.exists()) {
                System.out.println("Audio file not found: " + filePath);
                return;
            }

            try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

                System.out.println("Press ENTER to stop alarm...");
                System.in.read();

                clip.stop();
                clip.close();

            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                System.out.println("Error playing sound.");
            }
        }
    }
}
Sent
