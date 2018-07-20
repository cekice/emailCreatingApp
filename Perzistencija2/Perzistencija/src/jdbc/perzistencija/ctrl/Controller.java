package jdbc.perzistencija.ctrl;

import java.sql.SQLException;
import java.util.List;
import jdbc.perzistencija.db.DB;
import jdbc.perzistencija.db.Employee;
import jdbc.perzistencija.ui.UI;

public class Controller {
    public DB db;
    public UI ui;
    
    public void showEmployee() throws SQLException{
    List allEmployee = db.getAllEmployee();
        System.out.println("Id\tName\tAge\tAddress\tSalary");
        for(Object o : allEmployee){
        Employee employee = (Employee)o;
        System.out.println(employee);
        }
    }
    public void addEmployee() throws SQLException{
        Employee toAdd = ui.getEmployee();
        db.insertEmployee(toAdd);
    
    }
    public void updateEmployee() throws SQLException{
        String name = ui.getEmployeeName();
        Employee toUpdate = db.getEmployee(name);
            if(toUpdate==null){
                System.out.println("Employe name do not exist in database");
                return;
            }
            else{
                    ui.updateEmployee(toUpdate);
                    db.updateEmployee(toUpdate);
            }
    
    }
    public void deleteEmployee() throws SQLException{
        int id = ui.getEmployeeId();
        db.deleteEmployee(id);
    }
}
