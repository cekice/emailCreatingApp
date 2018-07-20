package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {
        
         ServerSocket sServer = new ServerSocket(1000);
         System.out.println("Listening....");
         while(true){
              Socket socket = sServer.accept();
              InputStream input =  socket.getInputStream();  
              OutputStream output = socket.getOutputStream();
              BufferedReader reader = new BufferedReader(new InputStreamReader(input)); 
    
              String brojevi = reader.readLine();
              System.out.println(brojevi);
          
              int a = Integer.parseInt(brojevi.split(",")[0]);
              int b = Integer.parseInt(brojevi.split(",")[1]);                         
         
              String rezultat;
              rezultat = String.valueOf(a + b);
              output.write((rezultat+"\n\r").getBytes());  
                 
         }
    }

}
