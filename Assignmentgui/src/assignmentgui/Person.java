package assignmentgui;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person
{
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty adress = new SimpleStringProperty(this, "adress", "");
    private final ObjectProperty<ConTime> conTime = new SimpleObjectProperty(this, "conTime", ConTime.ONE);
    private final StringProperty netFlow = new SimpleStringProperty(this, "netFlow", "");
    private final StringProperty speed = new SimpleStringProperty(this, "speed", "");

    public Person()
    {

    }

    public Person(String firstName, String lastName, String adress, ConTime conTime, String netFlow, String speed)
    {
	this.firstName.set(firstName);
	this.lastName.set(lastName);
	this.adress.set(adress);
	this.conTime.set(conTime);
        this.netFlow.set(netFlow);
        this.speed.set(speed);
    }

    public Person(String firstName)
    {
	this.firstName.set(firstName);
    }

    public Person(String firstName, String lastName)
    {
	this.firstName.set(firstName);
	this.lastName.set(lastName);
    }

    public String getFirstName()
    {
	return firstName.get();
    }

    public void setFirstName(String firstName)
    {
	this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty()
    {
	return firstName;
    }

    public String getLastName()
    {
	return lastName.get();
    }

    public void setLastName(String lastName)
    {
	this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty()
    {
	return lastName;
    }

    public String getAdress()
    {
	return adress.get();
    }

    public void setAdress(String adress)
    {
	this.adress.set(adress);
    }

    public StringProperty adressProperty()
    {
	return adress;
    }
    
    public ConTime getConTime() {
        return conTime.get();
    }

    public void setConTime(ConTime conTime) {
        this.conTime.set(conTime);
    }

    public ObjectProperty<ConTime> conTimeProperty() {
        return conTime;
    }

    public String getNetFlow() {
        return netFlow.get();
    }

    public void setNetFlow(String netFlow) {
        this.netFlow.set(netFlow);
    }

    public StringProperty netFlowProperty() {
        return netFlow;
    } 
    
    public String getSpeed() {
        return speed.get();
    }

    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

    public StringProperty speedProperty() {
        return speed;
    }



    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty()
    {
	return errorList;
    }

    public boolean isValid()
    {
	boolean isValid = true;
	if(firstName.get() != null && firstName.get().equals(""))
	{
	    errorList.getValue().add("First name can't be empty!");
	    isValid = false;
	}
	if(lastName.get().equals(""))
	{
	    errorList.getValue().add("Last name can't be empty!");
	    isValid = false;
	}
	if(adress.get().equals(""))
	{
	    errorList.getValue().add("Adress can't be empty!");
	    isValid = false;
	}
	return isValid;
    }
    
     public boolean save() {
 
        if (isValid()) {
            System.out.println("Person with details: \n" + this + "\nsaved!");
            return true;
        }
 
        return false;
 
    }
 
    @Override
    public String toString() {
        return "Ime: " + firstName.get() + "\n" + "Prezime: " + lastName.get() + "\n" + "Adresa: " + adress.get() + "Protok: "+ (String)netFlow.getValue()+ "Brzina: "+(String)speed.getValue()+ "";
    }


}
