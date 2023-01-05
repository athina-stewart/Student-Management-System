/**
 * Available commands: add, delete, update, find, exit
 * **/

import java.util.LinkedList;
import java.util.Scanner;

public class ManagementSystem {
    LinkedList<StudentRecord> studentList;

    public ManagementSystem(){
        studentList = new LinkedList<>();
    }

    Scanner in = new Scanner(System.in);

    public boolean find(int studentID){
        for (StudentRecord studentRecord : studentList) {
            if (studentID == studentRecord.getSchoolID()) {
                System.out.println("Student found");
                return true;
            }
        }
        System.out.println("Student not found");
        return false;
//        for (int index = 0; index < studentList.size(); index ++){
//            if (studentID == studentList.get(index).getSchoolID()){
//                return true;
//            }
//        }
//        return false;
    }

    public void add(StudentRecord record){
        if (find(record.getSchoolID())){
            System.out.println("Student is already recorded");
        } else {
            studentList.add(record);
            System.out.println("Student has been added to management system");
        }
    }

    public void delete(int studentID){
        if (!find(studentID)){
            System.out.println("No deletion. Student not found in management system.");
        } else {
            studentList.removeIf(record -> studentID == record.getSchoolID());
            System.out.println("Student deleted.");
//            for (StudentRecord record: studentList){
//                if (studentID == record.getSchoolID()){
//                    studentList.remove(record);
//                }
//            }
        }
    }

    private StudentRecord findRecord(int studentID){
        for (StudentRecord studentRecord : studentList) {
            if (studentID == studentRecord.getSchoolID()) {
                return studentRecord;
            }
        }
        return null;
    }

    public void update(int studentID){
        if (!find(studentID)){
            System.out.println("Student is not found in management system.");
        } else {
            System.out.println("New ID number: ");
            findRecord(studentID).setSchoolID(in.nextInt());

            System.out.println("New grade: ");
            findRecord(studentID).setGrade(in.nextInt());

            System.out.println("New allergies: ");
            findRecord(studentID).setAllergies(new String[]{in.nextLine()});

            System.out.println("New Emergency Contact Name: ");
            findRecord(studentID).setEmergencyContactName(in.nextLine());

            System.out.println("New Emergency Contact Number: ");
            findRecord(studentID).setEmergencyContactNumber(in.nextInt());
        }
    }

    public void show(){
        if(!studentList.isEmpty()){
            for (StudentRecord record: studentList){
                System.out.println(record);
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void showStudent(int ID){
        System.out.println(findRecord(ID));
    }

}
