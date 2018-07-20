package assignmentgui;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Assignmentgui extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
	URL fxmlUrl = getClass().getClassLoader().getResource("assignmentgui/FXMLDocument.fxml");
	HBox root = FXMLLoader.<HBox>load(fxmlUrl);
//fxml/ui_fxml.fxml
	Scene scene = new Scene(root);
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args)
    {
	Application.launch(args);
    }
}
