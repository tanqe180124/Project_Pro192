import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Person {
    private ArrayList<Student> studentList;
    private ArrayList<String> sEMajorList;
    private ArrayList<String> econMajorList;
    private String sEStudentMajor;

    private String econStudentMajor;
    private boolean isSEStudent = false;
    private boolean isEconStudent = false;
    public Student(String fullName, String gender, int birthDay, int birthMonth, int birthYear, String email, String phoneNumber, String address, String sEStudentMajor, String econStudentMajor) {
        super(fullName, gender, birthDay, birthMonth, birthYear, email, phoneNumber, address);
        this.studentList = new ArrayList<>();
        this.sEMajorList = new ArrayList<>();
        this.econMajorList = new ArrayList<>();
        this.sEStudentMajor = sEStudentMajor;
        this.econStudentMajor = econStudentMajor;
        sEMajorList.add("1. Software engineering");
        sEMajorList.add("2. Information security");
        sEMajorList.add("3. AI");
        sEMajorList.add("4. Graphic design");
        econMajorList.add("1. Digital marketing");
        econMajorList.add("2. International business");
        econMajorList.add("3. Hotel management");
        econMajorList.add("4. Multimedia Communication Management");
    }

    public void addStudentInformation() {
        String fullName, gender, email, phoneNumber;
        int birthDay = 0, birthMonth = 0, birthYear = 0;
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            try {
                do {
                    System.out.println("Enter student full name: ");
                    fullName = sc.nextLine();
                    if (!isValidFullName(fullName)) {
                        System.out.println("Your full name is not valid, try again");
                    }
                } while (!isValidFullName(fullName));
                do {
                    System.out.println("Enter student gender: ");
                    gender = sc.nextLine();
                    if (!isValidGender(gender)) {
                        System.out.println("Your gender is not valid, try again");
                    }
                } while (!isValidGender(gender));
                do {
                    try {
                        System.out.println("Enter student birth day: ");
                        birthDay = sc.nextInt();
                        sc.nextLine();
                        if (!isValidBirthDay(birthDay)) {
                            System.out.println("Your birth day is not valid, try again");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Your input is wrong, try again");
                        sc.nextLine();
                    }
                } while (!isValidBirthDay(birthDay));
                do {
                    try {
                        System.out.println("Enter student birth month: ");
                        birthMonth = sc.nextInt();
                        sc.nextLine();
                        if (!isValidBirthMonth(birthMonth)) {
                            System.out.println("Your birth month is not valid, try again");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Your input is wrong, try again");
                        sc.nextLine();
                    }
                } while (!isValidBirthMonth(birthMonth));
                do {
                    try {
                        System.out.println("Enter student birth year: ");
                        birthYear = sc.nextInt();
                        sc.nextLine();
                        if (!isValidBirthYear(birthYear)) {
                            System.out.println("Your birth year is not valid, try again");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Your input is wrong, try again"); // loop not work when user input letter
                        sc.nextLine();
                    }
                } while (!isValidBirthYear(birthYear));
                do {
                    System.out.println("Enter student email: ");
                    email = sc.nextLine();
                    if (!isValidEmail(email)) {
                        System.out.println("Your email is not valid, try again");
                    }
                } while (!isValidEmail(email));
                do {
                    System.out.println("Enter student phone number: ");
                    phoneNumber = sc.nextLine();
                    if (!isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Your phone number is not valid");
                    }
                } while (!isValidPhoneNumber(phoneNumber));
                System.out.println("Enter student address: ");
                String address = sc.nextLine();
                Dashboard dashboard = new Dashboard();
                dashboard.showMajorDashboard();
                boolean isSEStudent = false;
                boolean isEconStudent = false;
                int userChoice = sc.nextInt();
                sc.nextLine();
                switch (userChoice) {
                    case 1:
                        System.out.println("------------------------");
                        for (String showSEMajor : sEMajorList) {
                            System.out.println(showSEMajor);
                        }
                        System.out.println("Enter your choice: ");
                        userChoice = sc.nextInt();
                        sc.nextLine();
                        switch (userChoice) {
                            case 1:
                                sEStudentMajor = sEMajorList.get(0);
                                break;
                            case 2:
                                sEStudentMajor = sEMajorList.get(1);
                                break;
                            case 3:
                                sEStudentMajor = sEMajorList.get(2);
                                break;
                            case 4:
                                sEStudentMajor = sEMajorList.get(3);
                                break;
                        }
                        isSEStudent = true;
                        break;
                    case 2:
                        System.out.println("------------------------");
                        for (String showEconMajor : econMajorList) {
                            System.out.println(showEconMajor);
                        }
                        System.out.println("Enter your choice: ");
                        userChoice = sc.nextInt();
                        sc.nextLine();
                        switch (userChoice) {
                            case 1:
                                econStudentMajor = econMajorList.get(0);
                                break;
                            case 2:
                                econStudentMajor = econMajorList.get(1);
                                break;
                            case 3:
                                econStudentMajor = econMajorList.get(2);
                                break;
                            case 4:
                                econStudentMajor = econMajorList.get(3);
                                break;
                        }
                        isEconStudent = true;
                        break;
                    default:
                        System.out.println("Invalid choice, try again");
                }
                if (isSEStudent) {
                    Student student = new Student(fullName, gender, birthDay, birthMonth, birthYear, email, phoneNumber, address, sEStudentMajor, null);
                    studentList.add(student);
                }
                if (isEconStudent) {
                    Student student = new Student(fullName, gender, birthDay, birthMonth, birthYear, email, phoneNumber, address, null, econStudentMajor);
                    studentList.add(student);
                }
                System.out.println("Do you want to add more student (yes/no) ?");
                String userResponse = sc.nextLine();
                if (userResponse.equalsIgnoreCase("no")) {
                    System.out.println("Add success");
                    done = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Your input is wrong");
                sc.nextLine();
            }
        }
    }

    public void editStudentInformation () {
        int userchoice;
        Scanner sc = new Scanner(System.in);
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty, please add student");
        }
        else {
            for (int i = 0; i < studentList.size(); i++) {
                int j = i + 1;
                System.out.printf("%d. ", j);
                System.out.println(studentList.get(i).getFullName());
            }
            System.out.println("Enter student to edit information: ");
            userchoice = sc.nextInt();
            sc.nextLine(); // continue
        }
    }

    @Override
    public String toString() {
        if (isSEStudent) {
            return getFullName() + super.toString() + ", Major: " + sEStudentMajor +"}";
        }
        else {
            return getFullName() + super.toString() + ", Major: " + econStudentMajor +"}";
        }
    }

    public void showStudentInformation() {
        for (Student showStudentInformation : studentList) {
            System.out.println(showStudentInformation);
        }
    }
}
