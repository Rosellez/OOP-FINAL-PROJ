import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DepositHandler {
    private static final DecimalFormat df = new DecimalFormat("P0.00");

    public static void depositMoney(SavingManagementSystem system, Scanner scanner) {
        System.out.print("\nEnter the amount to deposit: ");
        double amount = InputHandler.getDoubleInput(scanner);
        if (amount > 0) {
            system.setDepositedAmount(system.getDepositedAmount() + amount);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            system.getTransactionHistory().add("Deposited " + df.format(amount) + " on " + date);
            System.out.println("You've deposited " + df.format(amount) + ".");
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }
}
