package mechanics;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerChecker {    
    private Scanner scanner = new Scanner(System.in);

    public Masages masages = new Masages();

    public int getUserChoice(int maxOptions) {

        int choice = 0;

        while (true) {
            try {
                System.out.println("____________");
                System.out.print("## Ваш выбор: ");
                choice = scanner.nextInt();
                System.out.println("****************");
                if (choice >= 1 && choice <= maxOptions) {
                    break;
                } else {
                    masages.messagePackaging("Ошибка: число должно быть от 1 до " + maxOptions + ". Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                masages.messagePackaging("Ошибка: необходимо ввести число. Попробуйте снова.");
                scanner.next();
            }
        }
        return choice;
    }


    public int getUserChoice(String[] array) {

        int choice = 0;
        int maxOptions = array.length;

        while (true) {
            try {
                System.out.println("____________");
                System.out.print("## Ваш выбор: ");
                choice = scanner.nextInt();
                System.out.println("****************");
                if (choice >= 1 && choice <= maxOptions) {
                    break;
                } else {
                    masages.messagePackaging("Ошибка: число должно быть от 1 до " + maxOptions + ". Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                masages.messagePackaging("Ошибка: необходимо ввести число. Попробуйте снова.");
                scanner.next();
            }
        }
        return choice;
    }


    public void closeScanner() { scanner.close(); }
}
