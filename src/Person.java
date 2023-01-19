/**
 * A class that represents a Person
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Person {
    // TODO: Complete the Person class
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String fn, String ln, String pn)
    {
        firstName = fn;
        lastName = ln;
        phoneNumber = pn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString()
    {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
