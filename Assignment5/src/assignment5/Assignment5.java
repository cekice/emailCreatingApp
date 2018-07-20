package assignment5;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment5 {

    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        
        int a;
        String putanja = ""; 
        String novo = "";
        
        System.out.println("Za pregled foldera upišite broj 1\n"
                + "Za prikaz informacija fajlova/foldera upišite broj 2\n"
                + "Za kreiranje foldera upišite broj 3\n"
                + "Za promjenu imena fajla/foldera upišite broj 4\n"
                + "Za kopiranje fajlova/kompletnih foldera upišite broj 5\n"
                + "Za premeštanje fajlova/kompletnih foldera upišite 6\n"
                + "Za brisanje fajlova/foldera upišite broj 7");
        a =  input.nextInt();
        
        if(a==1){ 
               try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.println("Upišite putanju foldera: ");
            putanja = bufferRead.readLine();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
                 File list = new File(putanja);
                 if(list.exists() && list.isDirectory())
                 {String[] strings = list.list();
                    for(int i=0; i<strings.length; i++)
                        System.out.println(strings[i]);}
                 else
                     System.out.println("Putanja nije tačna.\nProvjerite putanju i pokušajte ponovo!!"); 
                 
                }      
                   
               
        if(a==2) {
                    try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))){
                      
                    System.out.println("Upišite ime određenjog fajla/foldera: ");
                    putanja = bufferRead.readLine();
                    }
                    catch(IOException e)
                    {
                    System.out.println(e);
                    }
                    
                    File info = new File(putanja);
 
                    if (info.exists() || info.isFile()) {
                    System.out.println("Ime fajla/foldera: " + info.getName());
                    System.out.println("Putanja fajla/foldera: " + info.getAbsolutePath());
                    System.out.println("Veličina fajla/foldera:" + info.length() + "B");
                    System.out.println(Files.readAttributes(info.toPath(), BasicFileAttributes.class).creationTime());
 
                    Instant instant = Instant.ofEpochMilli(info.lastModified());
                                 LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                                 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy. HH:mm:ss");
                    System.out.println("Datum posljednje izmjene: " + dateTime.format(dateTimeFormatter));            
                                info.setReadOnly();
                                }
                    else
                    System.out.println("Putanja nije tačna./nProvjerite putanju i pokušajte ponovo!!");
                               
                     }
        if(a==3){
                 try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))){
                      
                    System.out.println("Upišite putanju gdje želite kreirati folder: ");

                    putanja = bufferRead.readLine();
                    }
                    catch(IOException e)
                    {
                    System.out.println(e);
                    }
                 
                                
                File create = new File(putanja);
                try{
                if(!create.exists()){
                    create.mkdir();
                    System.out.println("Uspješno napravljen folder zvan :" + create.getName());
                }
                else
                    System.out.println("Folder pod imenom " + create.getName() + " već postoji!!");
                }
                
                catch(Exception e){
                        System.out.println("Nije moguće kreirati folder" + create.getName());}
                
                }
            
                
        
        if(a==4){
                try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in)))
                {
                System.out.println("Upišite putanju fjla/foldera kojem želite promijenite ime: ");
                putanja = bufferRead.readLine();
             
                System.out.println("Upišite putanju sa novim imenom fajla/foldera: ");
                novo = bufferRead.readLine();
                }
                catch(IOException e)
                {
                System.out.println(e);
                }
                  
                  File oldfile = new File(putanja);
                  File newfile = new File(novo);
                  if(!oldfile.exists()){
                      System.out.println("Fajl/folder ne postoji");
                      return;
                  }
                  if(newfile.exists()){
                      System.out.println("Ime fajla/foldera već postoji");
                      return;
                  }
                  if(oldfile.renameTo(newfile))
                      System.out.println("Uspješno ste promijenili ime fajla/foldera");
                  
                  else
                      System.out.println("Promjena imena nije uspjela ");
                  
                  return;
        
        }
        
        if(a==5){
                try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in)))
                {
                System.out.println("Upišite putanju fajla/foldera koji želite kopirati: ");
                putanja = bufferRead.readLine();
             
                System.out.println("Upišite putanju gdje želite fajl/folder kopirati: ");
                novo = bufferRead.readLine();
                }
                catch(IOException e)
                {
                System.out.println(e);
                }    
                 
                 File filea = new File(putanja);
                 File fileb = new File(novo);
                 try(FileInputStream inStream = new FileInputStream(filea);
                     FileOutputStream outStream = new FileOutputStream(fileb);)
                 {
                     byte[] buffer = new byte[1024];
                     int length;
                     while ((length = inStream.read(buffer))>0){
                       outStream.write(buffer, 0, length);
                 }
                 System.out.println("Uspješno kopiranje");
                 }
                 catch (IOException exc) {
                     System.out.println(exc);
                 }
        }
        if(a==6){
                try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in)))
                {
                System.out.println("Upišite putanju fajla/foldera koji želite premjestiti: ");
                putanja = bufferRead.readLine();
             
                System.out.println("Upišite putanju gdje želite fajl/folder premjestiti: ");
                novo = bufferRead.readLine();
                }
                catch(IOException e)
                {
                System.out.println(e);
                }
                 File filea = new File(putanja);
                 File fileb = new File(novo + "\\" + filea.getName());
                 try(FileInputStream inStream = new FileInputStream(filea);
                     FileOutputStream outStream = new FileOutputStream(fileb);)
                 {
                     byte[] buffer = new byte[1024];
                     int length;
                     while ((length = inStream.read(buffer))>0){
                       outStream.write(buffer, 0, length);
                 }
                 System.out.println("Uspješno premještanje");
                 
                  inStream.close();
                  outStream.close();
                 
                  filea.delete();
                 }
                 
                 catch (IOException exc) {
                     System.out.println(exc);
                 }
                 
                
        }
        if(a==7){
                 try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))){
                      
                 System.out.println("Upišite putanju /fajla/foldera koji želite izbrisati: ");

                 putanja = bufferRead.readLine();
                 }
                 catch(IOException e)
                 {
                 System.out.println(e);
                 }
                 
                 File file = new File(putanja);
                 if(file.exists()){
                     file.delete();
                     System.out.println("Fajl/Folder uspješno izbrisan! ");
                 }
                 else
                     System.out.println("Brisanje nije uspješno! ");
                     
        }
        
        if(a > 7 || a < 1){
                        System.out.println("Upišite tačan broj za određenu operaciju!");
        }
    
    
            
    
    }    
        

    

}
