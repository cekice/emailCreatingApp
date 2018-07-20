package jdbc.perzistencija.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {
    
    public Connection connect() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employees", "root", "");
        
        return con;
    }
    public void insertEmployee(Employee employee) throws SQLException{
        Connection con = connect();
        Statement st = con.createStatement();
        String query = "insert into employee values (null,'"+employee.employee_name+"','"+employee.employee_age+"',"
                 + "'"+employee.employee_address+"','"+employee.employee_salary+"')";
         
         st.execute(query);
         con.close();
    }
    public void deleteEmployee(int employee_id) throws SQLException{
        Connection con = connect();
        Statement st = con.createStatement();
        String query = "delete from employee where employee_id = " + employee_id;
        
        st.execute(query);
        con.close();
    }
    public void updateEmployee(Employee employee) throws SQLException{
        Connection con = connect();
        PreparedStatement st = con.prepareStatement("update employee set employee_name = ?, employee_age = ?, employee_address = ?, employee_salary = ? where employee_id = ?");
            st.setString(1, employee.employee_name);
            st.setString(2, employee.employee_age);
            st.setString(3, employee.employee_address);
            st.setDouble(4, employee.employee_salary);
            st.setInt(5,    employee.employee_id);
        st.execute();
       con.close();
    }
    public List getAllEmployee() throws SQLException{
        List res = new ArrayList();
        Connection con = connect();
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from employee");
          while(rs.next()){
              Employee employee = new Employee();
              
              employee.employee_id      = rs.getInt("employee_id");
              employee.employee_name    = rs.getString("employee_name");
              employee.employee_age     = rs.getString("employee_age");
              employee.employee_address = rs.getString("employee_address");
              employee.employee_salary  = rs.getDouble("employee_salary");
              res.add(employee);
          }
        return res;
    }
    public Employee getEmployee(String employee_name) throws SQLException{
        Employee employee = null;
        Connection con = connect();
        PreparedStatement st = con.prepareStatement("select * from employee where employee_name = ?");
        st.setString(1, employee_name);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            employee = new Employee();
            
            employee.employee_id      = rs.getInt("employee_id");
            employee.employee_name    = rs.getString("employee_name");
            employee.employee_age     = rs.getString("employee_age");
            employee.employee_address = rs.getString("employee_address");
            employee.employee_salary  = rs.getDouble("employee_salary");
        }
        st.close();
        con.close();
        return employee;
    
    }
}
