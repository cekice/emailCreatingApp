package assignment4;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Person {
    
    String name;
    String lastName;
    LocalDate dateOfBirth;
    String placeOfBirth;
    
    public Person(String name, String lastName,LocalDate dateOfBirth, String placeOfBirth)
            
    {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.lastName = lastName;
        this.placeOfBirth = placeOfBirth;
    }


    @Override
    public String toString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        
        return "Lični podaci: " + "Ime: " + this.name + ", Prezime: "+ this.lastName + ","
                + " Datum rođenja: " + this.dateOfBirth.format(formatter) + ", Mjesto rođenja: " + this.placeOfBirth ;
        
    }

   
  


}
