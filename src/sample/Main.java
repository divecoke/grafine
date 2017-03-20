package sample;

import Models.Person;
import Views.PersonsController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();


    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public Main() {
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }



    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Grafine sasaja");
        // Initialize layout
        initRootLayout(primaryStage);
        // Show Persons view
        showPersons();
    }

    public void initRootLayout(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/RootLayout.fxml"));
        rootLayout = (BorderPane) root;
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

    // Persons.fxml view
    private void showPersons() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/Persons.fxml"));
        AnchorPane overviewPage = (AnchorPane) root;
        rootLayout.setCenter(overviewPage);
        // Gets controller
        PersonsController controller = new PersonsController();
        controller.setMainApp(this);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
