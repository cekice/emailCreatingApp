package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternativeEmail;

    //Konstruktor za ime i prezime
    public Email() {

        System.out.println("Input your Name: ");
        Scanner fName = new Scanner(System.in);
        String firstName = fName.nextLine();

        System.out.println("Input your lastname: ");
        Scanner lName = new Scanner(System.in);
        String lastName = lName.nextLine();

        this.firstName = firstName;
        this.lastName = lastName;

        //metoda za department
        this.department = setDepartment();

        //metoda za password
        this.password = randomPassword(8);
        System.out.println("Your password is: " + this.password);
        
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + ".student";
    }

    //koji je department
    private String setDepartment() {

        System.out.print("Departments:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter number of chosen depatrment:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else if (depChoice == 0) {
            return "none";
        } else {
            return "";
        }
    }

    //postaviti nasumičan password
    private String randomPassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //postaviti kapacitet za mailbox
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //postaviti alternativni mail
    public void setAlternativeEmail(String altEmail){
        this.alternativeEmail = altEmail;
    }
    //promjena passworda
    public void changePassword (String password){
        this.password = password;
    }
    
    public int getMailboxCapacity(){ return mailboxCapacity; }
    
    public String getAlternativeEmail() { return alternativeEmail;}
    
    public String getChangedPassword() { return password; }
    
    public String showInfo() {
        return "\nDISPLAY NAME: " + firstName + " " + lastName +
               "\nSTUDENT EMAIL: " + email + 
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
