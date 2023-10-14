import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userchoice;
        Scanner sc = new Scanner(System.in);
        Dashboard dashboard = new Dashboard();
        Student studentmanager = new Student(null, null, 0, 0, 0, null, null, null, null,null);
        boolean done = false;
        while (!done) {
            try {
                dashboard.showMainDashboard();
                userchoice = sc.nextInt();
                sc.nextLine();
                switch (userchoice) {
                    case 1:
                        handleStudentDashboard(sc, dashboard, studentmanager);
                        break;
                    case 2:
                        handleTeacherDashboard(sc, dashboard);
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid choice, try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is wrong, try again");
                sc.nextLine();
            }
        }
    }

    private static void handleStudentDashboard(Scanner sc, Dashboard dashboard, Student studentManager) {
        boolean done = false;
        while (!done) {
            try {
                dashboard.showStudentDashboard();
                int userChoice = sc.nextInt();
                sc.nextLine();
                switch (userChoice) {
                    case 1:
                        studentManager.addStudentInformation();
                        break;
                    case 2:
                        studentManager.editStudentInformation();
                        break;
                    case 5:
                        studentManager.showStudentInformation();
                        break;
                    case 6:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid choice try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is wrong, try again");
                sc.nextLine();
            }
        }
    }

    private static void handleTeacherDashboard(Scanner sc, Dashboard dashboard) {
        boolean done = false;
        while (!done) {
            try {
                dashboard.showTeacherDashboard();
                int userChoice = sc.nextInt();
                sc.nextLine();
                switch (userChoice) {
                    case 6:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid choice, try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is wrong, try again");
                sc.nextLine();
            }
        }
    }
}