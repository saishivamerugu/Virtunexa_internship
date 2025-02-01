import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FlashcardApp {
    static class Flashcard{
        private String question;
        private String answer;

        Flashcard(String question, String answer){
            this.question = question;
            this.answer = answer;
        }
        public String getQuestion(){
            return question;
        }
        String getAnswer(){
            return answer;
        }
    }
    static class FlashcardManager{
        private List<Flashcard> flashcards = new ArrayList<>();

        void addFlashcard(Flashcard flashcard){
            flashcards.add(flashcard);
        }
        public void viewFlashcards(){
            if (flashcards.isEmpty()){
                System.out.println("--------------------------------");
                System.out.println("No flashcards available.");
                return;
            }
            for (int i = 0; i < flashcards.size(); i++){
                Flashcard fc = flashcards.get(i);
                System.out.println((i + 1) + ". Q: " + fc.getQuestion() + " | A: " + fc.getAnswer());
            }
        }
        public void startQuiz(){
            if (flashcards.isEmpty()){
                System.out.println("--------------------------------");
                System.out.println("No flashcards available for the quiz.");
                return;
            }
            int score=0;
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < flashcards.size(); i++) {
                Flashcard fc = flashcards.get(i);
                System.out.println("Question: " + fc.getQuestion());
                System.out.print("Your Answer: ");
                String userAnswer = scanner.nextLine();
                if (userAnswer.equalsIgnoreCase(fc.getAnswer())) {
                    score++;
                 }
            }

            System.out.println("---------------------------------------------------");
            System.out.println("");
            System.out.println("Quiz completed! Your score: " + score + "/" + flashcards.size());
        }
    }
    public static void main(String[] args){
        FlashcardManager manager = new FlashcardManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\nFlashcard Application Menu:");
            System.out.println("--------------------------------");
            System.out.println("1. Create a new flashcard");
            System.out.println("2. View all flashcards");
            System.out.println("3. Start quiz");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter the question: ");
                    String question = scanner.nextLine();
                    System.out.println("--------------------------------");
                    System.out.print("Enter the answer: ");
                    String answer = scanner.nextLine();
                    System.out.println("--------------------------------");
                    manager.addFlashcard(new Flashcard(question, answer));
                    System.out.println("Flashcard added successfully!!!!");
                    break;
                case "2":
                    manager.viewFlashcards();
                    break;
                case "3":
                    manager.startQuiz();
                    break;
                case "4":
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
