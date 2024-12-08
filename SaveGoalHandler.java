import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SaveGoalHandler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private static final DecimalFormat df = new DecimalFormat("P0.00");

    public static void saveForGoal(SavingManagementSystem system, Scanner scanner) {
        System.out.print("\nEnter the GOAL NAME: ");
        scanner.nextLine();
        String goalName = scanner.nextLine().trim();
        ListHandler goal = (ListHandler) system.getSavingGoals().get(goalName);

        if (goal == null) {
            System.out.println("There's no such Goal in the system or you probably didn't use capital letters.");
            return;
        }

        System.out.print("Enter the SAVINGS AMOUNT: ");
        double savingsAmount = InputHandler.getDoubleInput(scanner);

        if (savingsAmount > system.getDepositedAmount()) {
            System.out.println("Savings amount cannot exceed your deposited balance.");
        } else {
            goal.savedAmount += savingsAmount;
            system.setDepositedAmount(system.getDepositedAmount() - savingsAmount);

            String dateTime = dateFormat.format(new Date()) + " | " + timeFormat.format(new Date());
            system.getTransactionHistory().add("Saved " + df.format(savingsAmount) + " to Goal: " + goalName + " on " + dateTime);
            System.out.println("Added " + df.format(savingsAmount) + " for your " + goalName + " :)");
        }
    }
}
