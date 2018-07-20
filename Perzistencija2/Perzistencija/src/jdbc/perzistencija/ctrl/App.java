package jdbc.perzistencija.ctrl;

import java.sql.SQLException;
import jdbc.perzistencija.db.DB;
import jdbc.perzistencija.ui.UI;

public class App {
    public static void launch() throws SQLException {
        
        System.out.println("Is running-....");
        
        Controller ctrl = new Controller();
        ctrl.db = new DB();
        ctrl.ui = new UI();
        
        whileLoop:
        while(true){
            switch(ctrl.ui.menu()){
                case UI.ShowEmployee:
                    ctrl.showEmployee();
                    break;
                case UI.AddEmployee:
                    ctrl.addEmployee();
                    break;
                case UI.UpdateEmployee:
                    ctrl.updateEmployee();
                    break;
                case UI.DeleteEmployee:
                    ctrl.deleteEmployee();
                    break;
                case UI.ExitApp:
                    System.out.println("See ya");
                    break whileLoop;
            }
        }
    }
    
    
}
