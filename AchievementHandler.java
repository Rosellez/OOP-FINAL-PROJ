public class AchievementHandler {
    public static void viewAchievements(SavingManagementSystem system) {
        System.out.println("\n\n-----------YOUR ACHIEVEMENTS----------------------------------------------");
        if (system.getAchievements().isEmpty()) {
            System.out.println("\t    No achievements yet.");
        } else {
            for (String achievement : system.getAchievements()) {
                System.out.println(achievement);
            }
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}
