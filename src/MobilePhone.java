import javax.swing.plaf.synth.ColorType;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;


public class MobilePhone {
    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private Scanner scanner = new Scanner(System.in);

    public MobilePhone(){
        this.contacts = contacts;
    }

    public void start() {
        System.out.println("Press 1 to quit.");
        System.out.println("Press 2 to print the list of Contacts.");
        System.out.println("Press 3 to add a contact.");
        System.out.println("Press 4 to search for a contact.");
        System.out.println("Press 5 to update the contact.");
        System.out.println("Press 6 to remove a contact.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.exit(0);
                break;
            case 2:
                printContacts();
                break;
            case 3:
                addContact();
                break;
            case 4:
                searchContact();
                break;
            case 5:
                updateContact();
                break;
            case 6:
                removeContact();
                break;
            default:
                start();
                break;
        }
    }

    private void printContacts(){
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println("Name: " + contacts.get(i).getName() + " phonenumber: " + contacts.get(i).getPhoneNumber());
        } start();
    }

    private void addContact() {
        String phoneNumber;
        System.out.println("Enter the name of the contact: ");
        String name = scanner.nextLine();
        if(name != null){
            System.out.println("Enter phonenumber: ");
            phoneNumber = scanner.nextLine();
            contacts.add(Contact.createContact(name, phoneNumber));
        } else {
            System.out.println("Name was not there.");
        } start();
    }

    private void updateContact(){
        System.out.println("Which contact would you like to update?");
        String name = scanner.nextLine();
        System.out.println("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new phonenumber: ");
        String newPhoneNumber = scanner.nextLine();
        if (searchIndex(name) != -1) {
            int i = searchIndex(name);
                contacts.get(i).setName(newName);
                contacts.get(i).setPhoneNumber(newPhoneNumber);
            } else {
                System.out.println("No contact with this name could be found.");
            }
            start();
    }

    private void removeContact(){
        System.out.println("Enter the contact you would like to erase: ");
        String name = scanner.nextLine();
            if (searchIndex(name) != -1) {
                int i = searchIndex(name);
                contacts.remove(i);
            } else {
                System.out.println("We could not find contact with name " + name);
            } start();
    }

    private void searchContact() {
        System.out.println("Enter the contact you would like to search: ");
        String name = scanner.nextLine();
            if(searchIndex(name) != -1){
                int i = searchIndex(name);
                System.out.println("The contact name is " + contacts.get(i).getName() + " and the telephonenumber is " + contacts.get(i).getPhoneNumber());
            } else {
                System.out.println("We could not find contact with name " + name);
            }
         start();
    }

    private int searchIndex(String name) {
        for(int i = 0; i < contacts.size(); i++){
            if(name.equals(contacts.get(i).getName())){
                return i;
            }
        } return -1;
    }
}
