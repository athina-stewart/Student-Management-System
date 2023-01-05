import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {

        ManagementSystem college = new ManagementSystem();
        Scanner in = new Scanner(System.in);

        int option = 0;
        while (option !=7) {

            System.out.println("\nStudent Management System");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Update student");
            System.out.println("4. Show all students");
            System.out.println("5. Find student");
            System.out.println("6. Show student");
            System.out.println("7. Exit management system");
            System.out.print("Enter option: ");
            option = in.nextInt();

            if(option == 1){
                System.out.println("Student Name: ");
                String name = in.nextLine();
                System.out.println("Student ID: ");
                int ID = in.nextInt();
                System.out.println("Student grade: ");
                int grade = in.nextInt();

                StudentRecord record = new StudentRecord(name, grade, ID);
                System.out.println(record);
                college.add(record);
            }
            if(option == 2){
                System.out.println("Student ID: ");
                int ID = in.nextInt();
                college.delete(ID);
            }
            if(option == 3){
                System.out.println("Student ID: ");
                int ID = in.nextInt();
                college.update(ID);
            }
            if(option == 4){
                college.show();
            }
            if(option == 5){
                System.out.println("Student ID: ");
                int ID = in.nextInt();
                college.find(ID);
            }
            if(option == 5){
                System.out.println("Student ID: ");
                int ID = in.nextInt();
                college.showStudent(ID);
            }
        }
    }
}
