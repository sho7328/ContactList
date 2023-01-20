/**
 * SOPHIE HO
 * 1/19/23
 * The Person superclass.
 * This class has subclasses Student and Composer.
 *
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Person {

    // Instance variables firstName, lastName, an phoneNumber are created for each person.
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Person constructor sets the person's name and phone number.
    public Person(String fn, String ln, String pn)
    {
        firstName = fn;
        lastName = ln;
        phoneNumber = pn;
    }

    // Getter for the person's first name.
    public String getFirstName() {
        return firstName;
    }

    // Getter for the person's last name.
    public String getLastName() {
        return lastName;
    }

    // Getter for the person's number.
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Returns the person's contact info.
    public String toString()
    {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
