import java.util.*;

class FinancialTracker{
    static Map<String, Double> expenses = new HashMap<>();
    static double savingsGoal = 0;
    static double totalExpenses = 0;
    static double totalSavings = 0;

    public static void main(String[] args){
        boolean isRunning = true;
        while (isRunning){
            showMenu();  
            int userChoice = getUserChoice(); 
            switch (userChoice){
                case 1:
                    setSavingsGoal();  
                    break;
                case 2:
                    trackExpense();  
                    break;
                case 3:
                    showReport();  
                    break;
                case 4:
                    clearExpenses();  
                    break;
                case 5:
                    viewSpecificExpense(); 
                    break;
                case 6:
                    isRunning = exitConfirmation();  
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");  
            }
        }
    }
    private static void showMenu(){
        System.out.println("\n---------- Financial Tracker ----------");
        System.out.println("_______________________________________");
        System.out.println("\n 1. Set Savings Goal");
        System.out.println(" 2. Track Expense");
        System.out.println(" 3. Show Report");
        System.out.println(" 4. Clear All Expenses");
        System.out.println(" 5. View Specific Expense");
        System.out.println(" 6. Exit");
        System.out.println("_______________________________________");
        System.out.print("Enter your choice: ");
    }
    private static int getUserChoice(){
        try{
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } 
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid number.");
            return -1;  
        }
    }
    private static void setSavingsGoal(){
        System.out.println("_______________________________________");
        System.out.print("\nEnter your savings goal: ");
        try{
            savingsGoal = Double.parseDouble(new Scanner(System.in).nextLine());
            if(savingsGoal < 0){
                System.out.println("_______________________________________");
                System.out.println("\nSavings goal cannot be negative.");
            } 
            else{
                System.out.println("_______________________________________");
                System.out.println("\nSavings goal set to: " + savingsGoal);
            }
        } 
        catch(NumberFormatException e){
            System.out.println("_______________________________________");
            System.out.println("\nInvalid amount, please enter a valid number.");
        }
    }
    private static void trackExpense(){
        System.out.print("\nEnter expense description: ");
        String description = new Scanner(System.in).nextLine();
        System.out.print("Enter expense amount: ");
        try{
            double amount = Double.parseDouble(new Scanner(System.in).nextLine());
            if(amount < 0){
                System.out.println("_______________________________________");
                System.out.println("/nExpense cannot be negative.");
            } 
            else{
                expenses.put(description, amount); 
                totalExpenses += amount;  
                System.out.println("Expense recorded: " + description + " - " + amount);
            }
        } 
        catch(NumberFormatException e){
            System.out.println("_______________________________________");
            System.out.println("\nInvalid amount. Please enter a valid number.");
        }
    }
    private static void showReport(){
        System.out.println("\n----- Monthly Report -----");
        System.out.println("_______________________________________");
        System.out.println("\nTotal Expenses: " + totalExpenses);
        System.out.println("Savings Goal: " + savingsGoal);
        double remainingGoal = savingsGoal - totalExpenses;
        System.out.println("_______________________________________");
        System.out.println("/nRemaining to reach savings goal: " + (remainingGoal > 0 ? remainingGoal : 0));
        totalSavings = savingsGoal - totalExpenses; 
        System.out.println("Total Savings: " + totalSavings);
        if (totalSavings > 0){
            System.out.println("\n_______________________________________");
            System.out.println("You need " + totalSavings + " more to meet your goal.");
        } 
        else{
            System.out.println("Congrats! You've met or exceeded your savings goal.");
        }
        System.out.println("\nExpenses Breakdown:");
        if (expenses.isEmpty()){
            System.out.println("_______________________________________");
            System.out.println("\nNo expenses recorded yet.");
        } 
        else{
            for (Map.Entry<String, Double> entry : expenses.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    private static void clearExpenses(){
        if(expenses.isEmpty()){
            System.out.println("No expenses to clear.");
        }
        else{
            expenses.clear();  
            totalExpenses = 0;  
            System.out.println("All expenses have been cleared.");
        }
    }
    private static void viewSpecificExpense(){
        System.out.print("Enter the description of the expense you want to view: ");
        String description = new Scanner(System.in).nextLine();
        if(expenses.containsKey(description)){
            System.out.println(description + ": " + expenses.get(description));
        } 
        else{
            System.out.println("Expense not found.");
        }
    }
    private static boolean exitConfirmation(){
        System.out.print("Are you sure you want to exit? (Y/N): ");
        String input=new Scanner(System.in).nextLine().toUpperCase();
        if(input.equals("Y")){
            System.out.println("_______________________________________");
            System.out.println("\nThank you for using the Financial Tracker!");
            return false;  
        } 
        else{
            return true; 
        }
    }
}
