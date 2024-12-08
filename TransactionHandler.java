public class TransactionHandler {
    public static void viewTransactionHistory(SavingManagementSystem system) {
        System.out.println("\n\n---------------TRANSACTION HISTORY---------------");
        if (system.getTransactionHistory().isEmpty()) {
            System.out.println("\t      No transactions found.");
        } else {
            for (String entry : system.getTransactionHistory()) {
                System.out.println(entry);
            }
        }
        System.out.println("-------------------------------------------------");
    }
}
