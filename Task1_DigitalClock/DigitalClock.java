import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class DigitalClock {
    public static void displayClock12Hour() {
        //logic for the 12 hours implementation h-> hours, m->minutes, s->seconds, a->am/pm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        while (true) {
            LocalTime currentTime = LocalTime.now(); 
            System.out.println("___________________________________________");
            System.out.println("Current Time (12-hour format): ");
            System.out.println("------"+currentTime.format(formatter)+"------");
            System.out.println("___________________________________________");
            System.out.println("Press 1 to exit and return to the options");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    break; 
                }
            }
        }
    }
    public static void displayClock24Hour() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true) {
            LocalTime currentTime = LocalTime.now(); 
            System.out.println("___________________________________________");
            System.out.println("Current Time (24-hour format): ");
            System.out.println("------"+currentTime.format(formatter)+"------");
            System.out.println("___________________________________________");
            System.out.println("Press 1 to exit and return to the options");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    break; 
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------Digital Clock-------------");
            System.out.println("__________________________________________");
            System.out.println("Welcome to the Digital Clock Application");
            System.out.println("__________________________________________");
            System.out.println("Choose the time format: ");
            System.out.println("1. 12-hour format (AM/PM) :");
            System.out.println("2. 24-hour format :");
            System.out.println("Press 0 to exit from the program!!");
            int choice = 0;
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1 || choice == 2 || choice == 0) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid choice...Please enter from (1, 2, or 0)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input....Please enter a number (1, 2, or 0)");
                }
            }
            if (choice == 0) {
                System.out.println("Exiting the program...");
                break;
            }
            if (choice == 1) {
                displayClock12Hour(); 
            } else if (choice == 2) {
                displayClock24Hour(); 
            }
        }
    }
}
