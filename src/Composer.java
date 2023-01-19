public class Composer extends Person
{
    private String musicalEra;

    public Composer(String fn, String ln, String pn, String me)
    {
        super(fn, ln, pn);
        musicalEra = me;
    }

    public String getMusicalEra() {
        return musicalEra;
    }

    public String toString()
    {
        return super.toString() + " " + musicalEra + " Composer";
    }
}
