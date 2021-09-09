

import java.io.*;

public class Course {

    private String courseName;  
 
    private String courseNo;    
  
    private int courseCredits;  
    
    private String grade;
  

    public Course() {
   
        courseName = "";
        courseCredits = 0;
        courseNo = "";
    }

    public Course(String cName, String cNo, int credits,String grade) {
      
        this.courseCredits = credits;
        this.courseName = cName;
        this.courseNo = cNo;
        this.grade = grade;
    }

  
    public void setCourseInfo(String cName, String cNo, int credits) {
   
        this.courseName = cName;
        this.courseNo = cNo;
        this.courseCredits = credits;
    }

    public void setCourseName(String cName) {
       
        this.courseName = cName;
    }

   
    public void setCourseNumber(String cNo) {
     
        this.courseNo = cNo;
    }

 
    public void setCourseCredits(int credits) {
      
        this.courseCredits = credits;
    }


    public void print() {
       
        System.out.println(this.courseNo + " " + this.courseName + " " + this.courseCredits);
    }


    public void print(PrintWriter outp) {
       
        outp.write(this.courseNo + " " + this.courseName + " " + this.courseCredits);
        outp.flush();
        outp.close();
    }


    public String getCourseName() {
        return courseName;
    }

   
    public String getCourseNumber() {
        
        return this.courseNo;
    }

 
    public int getCredits() {
 
        return this.courseCredits;
    }

  
    public void copyCourseInfo(Course otherCourse) {
   
        this.courseName = otherCourse.courseName;
        this.courseNo = otherCourse.courseNo;
        this.courseCredits = otherCourse.courseCredits;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    

}
