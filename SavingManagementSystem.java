import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SavingManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("P0.00");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static DecimalFormat getDf() {
        return df;
    }
    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
    public static SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }

    private String userName;
    private double depositedAmount = 0.00;
    private HashMap<String, ListHandler> savingGoals = new HashMap<>();
    private List<String> transactionHistory = new ArrayList<>();
    private List<String> achievements = new ArrayList<>();

    public void run() {
        DataHandler.loadData(this);
        System.out.print("\nEnter your name: ");
        userName = scanner.nextLine().trim();

        if (savingGoals.isEmpty() && depositedAmount == 0) {
            System.out.println("Welcome, " + userName + "! Let's start managing your savings!");
        } else {
            System.out.println("Welcome back, " + userName + "!");
        }

        while (true) {
            Menu.displayMenu();
            int choice = (int) InputHandler.getDoubleInput(scanner);
            switch (choice) {
                case 1 -> CreateGoalHandler.createSavingGoal(this, scanner);
                case 2 -> ListHandler.listSavingGoals(this);
                case 3 -> DepositHandler.depositMoney(this, scanner);
                case 4 -> SaveGoalHandler.saveForGoal(this, scanner);
                case 5 -> WithdrawHandler.withdrawFromGoal(this, scanner);
                case 6 -> TransactionHandler.viewTransactionHistory(this);
                case 7 -> AchievementHandler.viewAchievements(this);
                case 8 -> {
                    System.out.println("Goodbye, " + userName + "!");
                    DataHandler.saveData(this);
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Getters and setters for accessing private fields in other classes
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public double getDepositedAmount() { return depositedAmount; }
    public void setDepositedAmount(double depositedAmount) { this.depositedAmount = depositedAmount; }
    public Map<String, ListHandler> getSavingGoals() { return savingGoals; }
    public List<String> getTransactionHistory() { return transactionHistory; }
    public List<String> getAchievements() { return achievements; }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void setSavingGoals(HashMap<String, ListHandler> savingGoals) {
        this.savingGoals = savingGoals;
    }
}
