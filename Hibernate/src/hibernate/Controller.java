package hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Controller { 
    
 public void addEmployee(String employee_name, String employee_age, String employee_address, int employee_salary) throws ClassNotFoundException{
      Session session = HibernateUtil.createSessionFactory().openSession();
      Transaction tx = null;
      Integer employee_id = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = new Employee();
         employee.setEmployee_name(employee_name);
         employee.setEmployee_age(employee_age);
         employee.setEmployee_address(employee_address);
         employee.setEmployee_salary(employee_salary);
         employee_id = (Integer) session.save(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         System.out.println(e);
      }
      finally {
         session.close(); 
      }
   }   
   
   
   public void listEmployees( ) throws ClassNotFoundException{
      Session session = HibernateUtil.createSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
            Employee employee = (Employee) iterator.next(); 
            System.out.print("Employee Name: " + employee.getEmployee_name()); 
            System.out.print("Employee Age: " + employee.getEmployee_age());
            System.out.print("Employee Address: " + employee.getEmployee_address());
            System.out.println("Employee Salary: " + employee.getEmployee_salary()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         System.out.println(e);
      } finally {
         session.close(); 
      }
   }
   
   public void updateEmployee(Integer Employee_id, int employee_salary ) throws ClassNotFoundException{
      Session session = HibernateUtil.createSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, Employee_id); 
         employee.setEmployee_salary( employee_salary );
		 session.update(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         System.out.println(e); 
      } finally {
         session.close(); 
      }
   }
   
   public void deleteEmployee(Integer Employee_id) throws ClassNotFoundException{
      Session session = HibernateUtil.createSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, Employee_id); 
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         System.out.println(e);
      } finally {
         session.close(); 
      }
   }  

  
}


