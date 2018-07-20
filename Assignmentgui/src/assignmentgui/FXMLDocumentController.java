package assignmentgui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;

public class FXMLDocumentController
{
    ObservableList<String> valueSpeed = FXCollections.observableArrayList("2 Mbit", "5 Mbit", "10 Mbit","20 Mbit","50 Mbit","100 Mbit");
    ObservableList<String> valueNetFlow = FXCollections.observableArrayList("1 GB", "5 GB", "10 GB", "100 GB", "Flat");
    ObservableList<Person> persons = FXCollections.<Person>observableArrayList();
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField adress;
    @FXML
    private ToggleGroup conTime;
    @FXML
    private ChoiceBox<String> netFlow;
    @FXML
    private ChoiceBox<String> speed;

    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    
    Person person;

    @FXML//
    TableView<Person> tabela = new TableView<>();//

    public FXMLDocumentController()
    {
    }

    @FXML
    private void initialize()
    {
	person = new Person();
        
        netFlow.setItems(valueNetFlow);
        speed.setItems(valueSpeed);

	firstName.textProperty().bindBidirectional(person.firstNameProperty());
	lastName.textProperty().bindBidirectional(person.lastNameProperty());
	adress.textProperty().bindBidirectional(person.adressProperty());
        
	conTime.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
	{
	    @Override
	    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
	    {
                if(newValue != null)
		{
		
		    ToggleButton selected = (ToggleButton) newValue;
		    switch(selected.getId())
		    {
			case "One":
			    person.conTimeProperty().set(ConTime.ONE);
			    break;
			case "Two":
			    person.conTimeProperty().set(ConTime.TWO);
			    break;
		    }
                }
	    }
	});
        /*
        netFlow.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
	{
	    @Override
	    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
	    {
		
		    ToggleButton selected = (ToggleButton) newValue;
		    switch(selected.getId())
		    {
			case "1":
			    person.netFlowProperty().set(NetFlow.One);
			    break;
			case "2":
			    person.netFlowProperty().set(NetFlow.Five);
			    break;
                        case "3":
			    person.netFlowProperty().set(NetFlow.Ten);
			    break;
                        case "4":
			    person.netFlowProperty().set(NetFlow.Onehundret);
			    break;
                        case "5":
			    person.netFlowProperty().set(NetFlow.Flat);
			    break;    
		    }
		
	    }
	});
        
        
       
       ChoiceBox cb1 = new ChoiceBox(FXCollections.observableArrayList("2", "5", "10", "20", "50", "100"));
        
        cb1.valueProperty().bindBidirectional(person.speedProperty());
       
       speed.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Number>()
	{
	    @Override
	    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
	    {
		
		    Integer selected2 = (Integer) newValue;
		    switch(selected2.getId())
		    {
			case "6":
			    person.speedProperty().set("2");
			    break;
			case "7":
			    person.speedProperty().set("5");
			    break;
                        case "8":
			    person.speedProperty().set("10");
			    break;
                        case "9":
			    person.speedProperty().set("20");
			    break; 
                        case "10":
			    person.speedProperty().set("50");
			    break;
                        case "11":
			    person.speedProperty().set("100");
			    break;    
		    }
		
	    }
	});*/
    }
    
    

    @FXML
    private void savePerson()
    {
	if(person.isValid())
	{
	    /* SAVE + LIST */
	    persons = tabela.getItems();
	    ToggleButton selected = (ToggleButton) conTime.getSelectedToggle();
          
	    switch(selected.getId())
	    {
		case "One":
		    persons.add(new Person(firstName.getText(), lastName.getText(), adress.getText(), ConTime.ONE, (String)netFlow.getValue(), (String)speed.getValue()));
		    break;
		case "Two":
		    persons.add(new Person(firstName.getText(), lastName.getText(), adress.getText(), ConTime.TWO, (String)netFlow.getValue(), (String)speed.getValue())); 
		    break;
	    }
	    tabela.setItems(persons);
	    /* SAVE + LIST */
	}
	else
	{
	    StringBuilder errMsg = new StringBuilder();

	    ArrayList<String> errList = person.errorsProperty().get();
	    for(String errList1 : errList)
		errMsg.append(errList1);

	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Person can be saved!");
	    alert.setHeaderText(null);
	    alert.setContentText(errMsg.toString());
	    alert.showAndWait();
	    errList.clear();
	}
    }

    @FXML
    private void closeForm()
    {
	Platform.exit();
    }

    @FXML
    private void clearPerson()
    {
	person.firstNameProperty().set("");
	person.lastNameProperty().set("");
	person.adressProperty().set("");
	person.conTimeProperty().set(null);
        person.speedProperty().set("");
        person.netFlowProperty().set(null);
	if(conTime.getSelectedToggle() != null)
	    conTime.getSelectedToggle().setSelected(false);
    }

    /* DELETE */
    @FXML
    private void deletePerson()
    {
	persons = tabela.getItems();
	int index = tabela.selectionModelProperty().getValue().getSelectedIndex();
	persons.remove(index);
	tabela.setItems(persons);
    }
    /* DELETE */
}
