package assignment;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
   
    static TextField firstNum;
    static TextField secondNum;
    
    public static void main(String[] args) throws IOException {
        
        Frame f = new Frame();
        LayoutManager prozor = new FlowLayout();   
      
        f.setLayout(prozor);
        f.setSize(300,300);
        
        
        firstNum = new TextField(20);
        secondNum = new TextField(20);
        Label l = new Label();
        Button bu = new Button("Saberi");
        bu.addActionListener(new ActionListener()  {
            
                    Socket socket = new Socket("localhost", 1000);
                    InputStream input = socket.getInputStream();
                    OutputStream output = socket.getOutputStream();
                    
            
            @Override
            public void actionPerformed(ActionEvent e) {
                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                            String a = (firstNum.getText());
                            String b = (secondNum.getText());
                            String brojevi = (a.trim()+","+b.trim())+"\r\n";
                            output.write(brojevi.getBytes());
                            l.setText(reader.readLine());    
                            
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                }
        });
           
            f.add(firstNum);
            f.add(secondNum);
            f.add(bu);
            f.add(l);
            f.setVisible(true);
    }

}
