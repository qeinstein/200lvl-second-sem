import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(String.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();


        scanner.close();

        System.out.println("\nStudent Information");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
    }
}