public class StudentRecord {

    private String name;
    private int grade;
    private int schoolID;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String[] allergies;

    public StudentRecord(){}

    public StudentRecord(String name, int grade, int schoolID){
        this.name = name;
        this.grade = grade;
        this.schoolID = schoolID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }
}
