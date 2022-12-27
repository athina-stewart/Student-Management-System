/**
 * Available commands: add, delete, update, find, exit
 * **/

import java.util.LinkedList;

public class StudentManagementSystem {
    LinkedList<StudentRecord> studentList;

    public StudentManagementSystem(){
        studentList = new LinkedList<>();
    }

    public boolean find(int studentID){
        for (StudentRecord studentRecord : studentList) {
            if (studentID == studentRecord.getSchoolID()) {
                return true;
            }
        }
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

    }

}
