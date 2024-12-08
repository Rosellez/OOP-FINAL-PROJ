import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler {
    private static final String DATA_FILE = "savings_data.txt";

    @SuppressWarnings("unchecked")
    public static void loadData(SavingManagementSystem system) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            Map<String, Object> data = (Map<String, Object>) ois.readObject();
            system.setUserName((String) data.get("userName"));
            system.setDepositedAmount((Double) data.get("depositedAmount"));
            system.getSavingGoals().putAll((Map<String, ListHandler>) data.get("savingGoals"));
            system.getTransactionHistory().addAll((List<String>) data.get("transactionHistory"));
            system.getAchievements().addAll((List<String>) data.get("achievements"));
        } catch (IOException | ClassNotFoundException e) {
            // No saved data found or error occurred
        }
    }

    public static void saveData(SavingManagementSystem system) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            Map<String, Object> data = new HashMap<>();
            data.put("userName", system.getUserName());
            data.put("depositedAmount", system.getDepositedAmount());
            data.put("savingGoals", system.getSavingGoals());
            data.put("transactionHistory", system.getTransactionHistory());
            data.put("achievements", system.getAchievements());
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Failed to save data.");
        }
    }
}
