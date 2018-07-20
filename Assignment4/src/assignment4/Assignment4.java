package assignment4;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Assignment4 {

    
    

    public static void main(String[] args) {
        
     
        ArrayList persons = new ArrayList();
        
       String text = "John.Davidson/05051988/Belgrade Michael.Barton/01011968/Krakov Ivan.Perkinson/23051986/Moscow";   
          
        
        String[] persones = text.split("[ ./]", 12);
        
        for(int i=0; i<persones.length; i +=4)
        {
            persons.add(new Person(persones[i], persones[i+1], LocalDate.parse(persones[i+2], 
                    DateTimeFormatter.ofPattern("ddMMyyyy")), persones[i+3]));
        }
        
        
        for(int i=0; i<persons.size(); i +=1)
          System.out.println(persons.get(i).toString());       
        
    }
 }               

        
    

