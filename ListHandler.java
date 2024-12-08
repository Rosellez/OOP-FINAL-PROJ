import java.io.Serializable;

public class ListHandler implements Serializable {
    String goalName;
    double targetAmount;
    double savedAmount;
    String deadline;
    
    public ListHandler(String goalName, double targetAmount, String deadline) {
        this.goalName = goalName;
        this.targetAmount = targetAmount;
        this.savedAmount = 0.00;
        this.deadline = deadline;
    }

    public static void listSavingGoals(SavingManagementSystem system) {
        System.out.println("\n\n**************YOUR SAVING GOALS**************");
        if (system.getSavingGoals().isEmpty()) {
            System.out.println("\t    No saving goals found.");
        } else {
            for (ListHandler goal : system.getSavingGoals().values()) {
                System.out.println("- " + goal.goalName + " - " + goal.savedAmount + " / " +
                        goal.targetAmount + " (Deadline: " + goal.deadline + ")");
            }
        }
        System.out.println("*********************************************");
    }
}
