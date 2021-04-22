package udemymasterclass.arraylist;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("079 335 1364");

    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 to show all )");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("\nShutting down ..");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                 case 6:
                    printActions();
                    break;
            }

        }
    }

    private static void queryContact() {
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("query missing!");
            return;
        }
        System.out.println("number: "+ existingContactRecord.getPhoneNumber());

    }

    private static void removeContact() {
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact missing!");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println(name+",now deleted!");
        }else{
            System.out.println("Error... can't delete"+ name);
        }
    }

    private static void updateContact() {
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("enter name: ");
        String newName = scanner.nextLine();
        System.out.println("enter new number: ");
        String newNumber = scanner.nextLine();
        Contact newContact= Contact.createContact(newName, newNumber);

        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println(name+ ", now updated");
        }else{
            System.out.println("Error can't updated"+ name  );
        }


    }


    private static void addNewContact() {
        System.out.println("enter new contact :");
        String name = scanner.nextLine();

        System.out.println("enter number");
        String phone = scanner.nextLine();

        Contact newContact = Contact.createContact(name, phone);

        if(mobilePhone.addNewContact(newContact)){
            System.out.println(name+", added!");
        }else{
            System.out.println("could not add"+ name);
        }
    }

    private static void printActions() {
            System.out.println("\n Available actions:\n");
            System.out.println("0 - to shutdown\n"+
                    "1 - to print contacts\n"+
                    "2 - to add new contact\n"+
                    "3 - to update contact\n"+
                    "4 - to remove contact\n"+
                    "5 - to query contact\n" +
                    "6 - to print list of actions");
            System.out.println("\n Choose your action: ");
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

}
