

import java.util.ArrayList;

public class Student extends Person {
  

    String studentId;
    boolean isFeePaid;
    String firstName;
    String lastName;
    int coursesEnrolled;
    ArrayList<Course> courses;


    public Student(String studentId, boolean isFeePaid, String firstName, String lastName,int coursesEnrolled) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.isFeePaid = isFeePaid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.coursesEnrolled = coursesEnrolled;
        courses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean isIsFeePaid() {
        return isFeePaid;
    }

    public void setIsFeePaid(boolean isFeePaid) {
        this.isFeePaid = isFeePaid;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addCourse(Course course) {

        this.courses.add(course);

    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(int coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    

}
