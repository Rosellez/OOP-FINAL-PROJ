import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WithdrawHandler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private static final DecimalFormat df = new DecimalFormat("P0.00");

     public static void withdrawFromGoal(SavingManagementSystem system, Scanner scanner) {
        System.out.print("\nEnter the GOAL NAME: ");
        scanner.nextLine();
        String goalName = scanner.nextLine().trim();
        ListHandler goal = (ListHandler) system.getSavingGoals().get(goalName);

        if (goal == null || goal.savedAmount < goal.targetAmount) {
            System.out.println("You cannot withdraw this goal as it is not yet accomplished.");
            return;
        }

        System.out.print("Enter the amount to withdraw: ");
        double amount = InputHandler.getDoubleInput(scanner);

        if (amount > goal.savedAmount) {
            System.out.println("You cannot withdraw more than the saved amount.");
        } else {
            goal.savedAmount -= amount;

            if (goal.savedAmount == 0) {
                system.getSavingGoals().remove(goalName);
                String date = dateFormat.format(new Date());
                system.getAchievements().add("CONGRATULATIONS | Goal ('" + goalName + "') accomplished on " + date);
            }

            String dateTime = dateFormat.format(new Date()) + " | " + timeFormat.format(new Date());
            system.getTransactionHistory().add("Withdraw " + df.format(amount) + " for Goal: " + goalName + " on " + dateTime);
            System.out.println("YOU DID IT! YOU'VE ACHIEVED YOUR " + goalName + " <3");
        }
    }

}
