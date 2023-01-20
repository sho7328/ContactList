// Sophie Ho
// 1/19/23
// Composer Class for Contact List is a subclass of the Person class.
// Each Composer has a musical era they are from.

public class Composer extends Person
{
    // Instance variable musicalEra represents the composer's musical style and era.
    private String musicalEra;

    // Constructor that sets the name, phone number, and musical era of a composer contact.
    public Composer(String fn, String ln, String pn, String me)
    {
        super(fn, ln, pn);
        musicalEra = me;
    }

    // Getter for the composer's musical era.
    public String getMusicalEra() {
        return musicalEra;
    }

    // Returns the contact info for a composer.
    @Override
    public String toString()
    {
        return super.toString() + " " + musicalEra + " Composer";
    }
}
