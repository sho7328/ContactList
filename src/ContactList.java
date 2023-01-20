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

    // The ContactList constructor defines the ArrayList "contacts".
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    // printMenuOptions prints the options the user has for this program.
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

    // addContact adds either a student's contact or a composer's contact to the contact list
    // by asking for contact info (name, number, musical era / grade)
    public void addContact() {
        // Ask user for which type of contact to make
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
        // Ask for the contact's name and number.
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
            // Ask for the student's grade.
            System.out.println("Grade: ");
            int grade = input.nextInt();
            input.nextLine();
            // Create a new student and add it to the ArrayList contacts.
            Person p = new Student(fn, ln, pn, grade);
            contacts.add(p);
        }
        // Make a composer and add to contacts
        else if(choice.equals("2"))
        {
            // Ask for the musical era of the composer.
            System.out.println("Musical Era (Baroque, Classical, Early Romantic, Late Romantic, Contemporary): ");
            String era = input.nextLine();
            // Create a new composer and add it to the contact list.
            Person c = new Composer(fn, ln, pn, era);
            contacts.add(c);
        }
    }

    // printContacts prints all the contacts and their info in the contact list.
    public void printContacts() {
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
    // The sort method bubble sorts the list of contacts by either first name, last name, or phone number.
    public void sort(int sortBy) {
        int n = contacts.size();
        // Sort contacts by first name
        if(sortBy == 0)
        {
            for(int pass = 1; pass < n; pass++)
            {
                for(int comp = 0; comp < n - pass; comp++)
                {
                    // If the earlier first name is later in the alphabet than the later first name, swap them.
                    if (contacts.get(comp).getFirstName().compareToIgnoreCase(contacts.get(comp + 1).getFirstName()) > 0)
                    {
                        //swap the bigger element with the smaller element to create the correct order.
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
                    // If the earlier last name is later in the alphabet than the later last name, swap them.
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
                    // If the earlier phone number is greater than the later phone number, swap them.
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

    // This method takes in user input to search for a contact by their first name.
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

    // This method takes in user input to search for a contact by their last name.
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

    // This method takes in user input to search for a contact by their number.
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

    // This method lists all the contacts that are students.
    public void listStudents()
    {
        // Traverse the list of contacts.
        for(int i = 0 ; i < contacts.size(); i++)
        {
            // If the contact is a student, print their contact info out.
            if(contacts.get(i) instanceof Student)
            {
                System.out.println(contacts.get(i));
            }
        }
    }

    // This method prints the menu and depending on user input, runs each method.
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        String num = input.nextLine();
        // While the user doesn't choose to exit the code:
        while(!num.equals("0"))
        {
            // If the user enters 1, run addContact, which adds a new contact to the contact list.
            if(num.equals("1"))
            {
                addContact();
            }
            // If user enters 2, list all contacts by first name order.
            else if(num.equals("2"))
            {
                sort(0);
                printContacts();
            }
            // If user enters 3, list all contacts by last name order.
            else if(num.equals("3"))
            {
                sort(1);
                printContacts();
            }
            // If user enters 4, list all contacts by phone number order.
            else if(num.equals("4"))
            {
                sort(2);
                printContacts();
            }
            // If user enters 5, list all students that are in the contact list.
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
            // Reprint the menu so the user doesn't have to scroll up to look at it again.
            printMenuOptions();
            // Update the value of the user's input.
            num = input.nextLine();
        }
    }

    // Run the whole program.
    public static void main(String[] args)
    {
        // Create a ContactList object and run the program.
        ContactList cl = new ContactList();
        cl.run();
    }
}
