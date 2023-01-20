/**
 * SOPHIE HO
 * 1/19/23
 *
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Student extends Person{

    // Instance variable grade represents the grade the student is in.
    private int grade;

    // Constructor for a student that sets their name, phone number, and grade.
    public Student(String fn, String ln, String pn, int gr)
    {
        super(fn, ln, pn);
        grade = gr;
    }

    // Getter for a student's grade.
    public int getGrade() {
        return grade;
    }

    // Returns the contact info for a student.
    @Override
    public String toString()
    {
        return super.toString() + " Grade: " + grade;
    }
}
