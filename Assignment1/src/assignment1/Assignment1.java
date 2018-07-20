package assignment1;

import javax.swing.JOptionPane;

public class Assignment1 extends JFrame{

    public static void main(String[] args) {
        
         
        JFrame frame = new JFrame();
        JOptionPane jop = new JOptionPane();
        
        int timer = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Settings", "Close"}, null);
 
        switch(timer)
        {
        case JOptionPane.YES_OPTION:
                frame.setVisible(true);
        break;
        case JOptionPane.NO_OPTION:
            JOptionPane.showMessageDialog(null, "Close");
        break;               
    
}

    }

}
