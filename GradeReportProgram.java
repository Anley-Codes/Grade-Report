
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GradeReportProgram {

    public static double getGPA(String grade) {

        double gradeValue = 0.0;
        switch (grade) {
            case "A":
                gradeValue = 4.00;
                break;
            case "A-":
                gradeValue = 3.67;
                break;
            case "B+":
                gradeValue = 3.33;
                break;
            case "B":
                gradeValue = 3.00;
                break;
            case "B-":
                gradeValue = 2.67;
                break;
            case "C+":
                gradeValue = 2.33;
                break;
            case "C":
                gradeValue = 2.00;
                break;
            case "D+":
                gradeValue = 1.33;
                break;
            case "D":
                gradeValue = 1.00;
                break;
            case "F":
                gradeValue = 0;
                break;
            case "FX":
                gradeValue = 0;
                break;
            default:
                break;
        }

        return gradeValue;
    }

    public static ArrayList<Student> readFile() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            File text = new File("stData.txt");

            Scanner scnr = new Scanner(text);

            int lineNumber = 1;
            String line = scnr.nextLine();
            System.out.println(line);
            while (scnr.hasNextLine()) {
                String std_line = scnr.nextLine();
                if (std_line.trim().isEmpty()) {
                    continue;
                }

                String[] details = std_line.split(" ");
                String std_fname = details[0];
                String std_lname = details[1];
                String std_id = details[2];
                String std_paid = details[3];
                boolean paid = false;
                if (std_paid.equals("Y")) {
                    paid = true;
                }
                int std_couse = Integer.parseInt(details[4]);

                Student std = new Student(std_id, paid, std_fname, std_lname, std_couse);
                for (int x = 0; x < std_couse; x++) {
                    String[] courseDetails = scnr.nextLine().split(" ");
                    Course course = new Course(courseDetails[0], courseDetails[1], Integer.parseInt(courseDetails[2]), courseDetails[3]);
                    std.addCourse(course);
                }

                students.add(std);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(" " + ex);
        }

        return students;
    }

    public static String generateReport(Student std) {

        String report = String.format("%-10s\n", "Student Name:" + std.getFirstName() + " " + std.getLastName());
        report += String.format("%-10s\n", "Student ID:" + std.getStudentId());
        report += String.format("%-10s\n", "Number of Courses Enrolled:" + std.getCoursesEnrolled());
        report += String.format("%-10s %-20s %-20s %-20s\n", "Course No.", "Course Name", "Credits", "Grade");
        ArrayList<Course> courses = std.getCourses();
        int total = 0;
        double gradeValue = 0.0;
        String message = "";

        for (int x = 0; x < std.getCourses().size(); x++) {

            Course cs = courses.get(x);

            total += cs.getCredits();
            gradeValue += getGPA(cs.getGrade());

            if (std.isFeePaid) {
                report += String.format("%-10s %-20s %-20s %-20s\n", cs.getCourseNumber(), cs.getCourseName(), cs.getCredits(), cs.getGrade());
            } else {

                report += String.format("%-10s %-20s %-20s %-20s\n", cs.getCourseNumber(), cs.getCourseName(), cs.getCredits(), "**");

            }

        }

        if (std.isFeePaid) {

            double val = gradeValue / std.coursesEnrolled;
            message = "** Midsemister GPA:" + val + " ***\n";

        } else {
            message = "** Grade are being held for not paying the tution ***\n";
            message += "** Amount due $5865.00 ***\n";
        }

        report += String.format("%s\n", "Total Number of credit Hours:" + total);

        report += message;

        report += "-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n";

        return report;
    }

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
        
            ArrayList<Student> students = readFile();
            fileWriter = new FileWriter("output.txt");
            for (int x = 0; x < students.size(); x++) {

                String std = generateReport(students.get(x));
                fileWriter.write(std);

            }
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
