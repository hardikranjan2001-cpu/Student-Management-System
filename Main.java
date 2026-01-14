import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Roll No: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String dept = sc.nextLine();

                System.out.print("Year: ");
                int year = sc.nextInt();
                sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                dao.addStudent(new Student(roll, name, dept, year, email));
            }
            else if (choice == 2) {
                dao.viewStudents();
            }
            else if (choice == 3) {
                System.out.print("Enter Roll No to Update: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("New Name: ");
                String name = sc.nextLine();

                System.out.print("New Department: ");
                String dept = sc.nextLine();

                System.out.print("New Year: ");
                int year = sc.nextInt();
                sc.nextLine();

                System.out.print("New Email: ");
                String email = sc.nextLine();

                dao.updateStudent(roll, name, dept, year, email);
            }
            else if (choice == 4) {
                System.out.print("Enter Roll No to Delete: ");
                int roll = sc.nextInt();
                dao.deleteStudent(roll);
            }
            else if (choice == 5) {
                System.out.print("Enter Roll No to Search: ");
                int roll = sc.nextInt();
                dao.searchStudent(roll);
            }
            else if (choice == 6) {
                System.out.println("Exiting system...");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
