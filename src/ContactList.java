import java.util.ArrayList;
import java.util.Scanner;


/**
 * SOPHIE HO
 * January 19, 2023.
 * Contact List Code, methods coded by Sophie.
 *
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    // Create an ArrayList to store all contacts.
    private ArrayList<Person> contacts;
    // Create a scanner to take in user input.
    Scanner input = new Scanner(System.in);

    // TODO: Write a Constructor
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        // Ask user for what contact to make
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Composer");
        String choice = input.nextLine();
        // Make sure the user enters in expected input
        while(!(choice.equals("1") || choice.equals("2")))
        {
            System.out.println("Please enter the number 1 or 2.\n");
            System.out.println("Select a type of contact to add:");
            System.out.println("1. Student");
            System.out.println("2. Composer");
            choice = input.nextLine();
        }
        System.out.println("Please fill in the following information.");
        System.out.println("First Name: ");
        String fn = input.nextLine();
        System.out.println("Last Name: ");
        String ln = input.nextLine();
        System.out.println("Phone Number: ");
        String pn = input.nextLine();
        // Make a student and add to contacts
        if (choice.equals("1"))
        {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            input.nextLine();
            Person p = new Student(fn, ln, pn, grade);
            contacts.add(p);
        }
        // Make a composer and add to contacts
        else if(choice.equals("2"))
        {
            System.out.println("Musical Era (Baroque, Classical, Early Romantic, Late Romantic, Contemporary): ");
            String era = input.nextLine();
            Person c = new Composer(fn, ln, pn, era);
            contacts.add(c);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for(int i = 0; i < contacts.size(); i++)
        {
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method

        int n = contacts.size();
        // Sort contacts by first name
        if(sortBy == 0)
        {
            for(int pass = 1; pass < n; pass++)
            {
                for(int comp = 0; comp < n - pass; comp++)
                {
                    if (contacts.get(comp).getFirstName().compareToIgnoreCase(contacts.get(comp + 1).getFirstName()) > 0)
                    {
                        //swap the bigger element with the smaller element
                        Person bigger = contacts.get(comp);
                        Person smaller = contacts.get(comp + 1);
                        contacts.set(comp, smaller);
                        contacts.set(comp + 1, bigger);
                    }
                }
            }
        }
        // Sort contacts by last name
        else if(sortBy == 1)
        {
            for(int pass = 1; pass < n; pass++)
            {
                for(int comp = 0; comp < n - pass; comp++)
                {
                    if (contacts.get(comp).getLastName().compareToIgnoreCase(contacts.get(comp + 1).getLastName()) > 0)
                    {
                        //swap the bigger element with the smaller element
                        Person bigger = contacts.get(comp);
                        Person smaller = contacts.get(comp + 1);
                        contacts.set(comp, smaller);
                        contacts.set(comp + 1, bigger);
                    }
                }
            }
        }
        // Sort contacts by phone number
        else if(sortBy == 2)
        {
            for(int pass = 1; pass < n; pass++)
            {
                for(int comp = 0; comp < n - pass; comp++)
                {
                    if (contacts.get(comp).getPhoneNumber().compareToIgnoreCase(contacts.get(comp + 1).getPhoneNumber()) > 0)
                    {
                        //swap the bigger element with the smaller element
                        Person bigger = contacts.get(comp);
                        Person smaller = contacts.get(comp + 1);
                        contacts.set(comp, smaller);
                        contacts.set(comp + 1, bigger);
                    }
                }
            }
        }
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName)
    {
        // Traverse contacts to find the match for the first name
        for (int i = 0; i < contacts.size(); i++)
        {
            // If there is an identical first name, return that person.
            if(contacts.get(i).getFirstName().equals(firstName))
            {
                return contacts.get(i);
            }
        }
        // If there's no match, return null.
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName)
    {
        // Traverse contacts to find the match for the last name
        for (int i = 0; i < contacts.size(); i++)
        {
            // If there is an identical last name, return that person.
            if(contacts.get(i).getLastName().equals(lastName))
            {
                return contacts.get(i);
            }
        }
        // If there's no match, return null.
        return null;
    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber)
    {
        // Traverse contacts to find the match for the phone number
        for (int i = 0; i < contacts.size(); i++)
        {
            // If there is an identical phone number, return that person.
            if(contacts.get(i).getPhoneNumber().equals(phoneNumber))
            {
                return contacts.get(i);
            }
        }
        // If there's no match, return null.
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents()
    {
        // TODO: Complete the listStudents method
        for(int i = 0 ; i < contacts.size(); i++)
        {
            // If the contact is a student, print them out.
            if(contacts.get(i) instanceof Student)
            {
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        // TODO: Complete the run method

        String num = input.nextLine();
        while(!num.equals("0"))
        {
            // If the user enters 1, run addContact
            if(num.equals("1"))
            {
                addContact();
            }
            // If user enters 2, list contacts by first name
            else if(num.equals("2"))
            {
                sort(0);
                printContacts();
            }
            // If user enters 3, list contacts by last name
            else if(num.equals("3"))
            {
                sort(1);
                printContacts();
            }
            // If user enters 4, list contacts by phone number
            else if(num.equals("4"))
            {
                sort(2);
                printContacts();
            }
            // If user enters 5, list all students
            else if(num.equals("5"))
            {
                listStudents();
            }
            // If user enters 6, search the contacts by first name using the user's input.
            else if(num.equals("6"))
            {
                // Ask for the contact's first name
                System.out.println("Enter the contact's first name:");
                String fn = input.nextLine();
                // If there's no matching first name, tell the user.
                if(searchByFirstName(fn) == null)
                {
                    System.out.println(fn + " is not in the list.");
                }
                // Otherwise, return the matching contact.
                else
                {
                    System.out.println(searchByFirstName(fn));
                }
            }
            // If user enters 7, search the contacts by last name using the user's input.
            else if(num.equals("7"))
            {
                // Ask for last name
                System.out.println("Enter the contact's last name:");
                String ln = input.nextLine();
                // If there's no matching last name, tell the user
                if(searchByLastName(ln) == null)
                {
                    System.out.println(ln + " is not in the list.");
                }
                // Otherwise, return the matching contact
                else
                {
                    System.out.println(searchByLastName(ln));
                }
            }
            // If user enters 8, search the contacts by phone number using the user's input.
            else if(num.equals("8"))
            {
                // Ask for the phone number
                System.out.println("Enter the contact's phone number:");
                String pn = input.nextLine();
                // If the number isn't in the list, tell the user.
                if(searchByPhoneNumber(pn) == null)
                {
                    System.out.println(pn + " is not in the list.");
                }
                // Otherwise, return the matching contact.
                else
                {
                    System.out.println(searchByPhoneNumber(pn));
                }
            }
            printMenuOptions();
            num = input.nextLine();
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
