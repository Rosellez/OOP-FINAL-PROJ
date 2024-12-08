import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CreateGoalHandler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void createSavingGoal(SavingManagementSystem system, Scanner scanner) {
        System.out.print("\nEnter the GOAL NAME (in CAPITAL LETTERS): ");
        scanner.nextLine();
        String goalName = scanner.nextLine().trim();

        if (!goalName.equals(goalName.toUpperCase())) {
            System.out.println("Goal name must be in CAPITAL LETTERS. Please retry.");
            return;
        }
        if (system.getSavingGoals().containsKey(goalName)) {
            System.out.println("This goal already exists!");
            return;
        }

        System.out.print("Enter the TARGET AMOUNT (in pesos): ");
        double targetAmount = InputHandler.getDoubleInput(scanner);
        scanner.nextLine();
        System.out.print("Enter the DEADLINE (YYYY-MM-DD): ");
        String deadline = scanner.nextLine().trim();

        try {
            dateFormat.parse(deadline);
            system.getSavingGoals().put(goalName, new ListHandler(goalName, targetAmount, deadline));
            System.out.println("Saving goal created successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }
    }
}
