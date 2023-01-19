/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Student extends Person{
    // TODO: Modify and complete this class
    private int grade;

    public Student(String fn, String ln, String pn, int gr)
    {
        super(fn, ln, pn);
        grade = gr;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Grade: " + grade;
    }
}
