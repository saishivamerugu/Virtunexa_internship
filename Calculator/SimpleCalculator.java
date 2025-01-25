import java.util.Scanner;

public class SimpleCalculator{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        int choice;

        while (true){
            System.out.println("Select an operation from [1-7]");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulo");
            System.out.println("6. Power");
            System.out.println("7. Exit");
            choice = scanner.nextInt();

            if (choice == 7){
                break;
            }

            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();


            if (choice != 6) {
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
            } else {
                num2 = 0; 
            }

            switch (choice){
                case 1:
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0){
                        System.out.println("Result: " + (num1 / num2));
                    } else {
                        System.out.println("Error: Division by zero");
                    }
                    break;
                case 5:
                    if (num2 != 0){
                        System.out.println("Result: " + (num1 % num2));
                    } else {
                        System.out.println("Error: Modulo by zero");
                    }
                    break;
                case 6:
                    System.out.println("Result: " + Math.pow(num1, num2)); 
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
