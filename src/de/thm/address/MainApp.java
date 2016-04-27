package de.thm.address;/**
 * Created by Nils on 26.04.2016.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;
import de.thm.address.model.PersonModel;

import java.io.IOException;

public class MainApp extends Application {

    private BorderPane rootLayout;
    private Stage primaryStage;
    private ObservableList<PersonModel> personData = FXCollections.observableArrayList();
    private PersonOverviewController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initRootLayout();
        showPersonOverview();
    }

    public void initRootLayout() {
        /* Load root layout from fxml file. */
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
        try {
            rootLayout = (BorderPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Show the scene containing the root layout */
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showPersonOverview(){
        /* Load person overview. */
        AnchorPane personOverview = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));

        try {
            personOverview = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Set the person overview into the root layout */
        rootLayout.setCenter(personOverview);
        controller = loader.getController();
        controller.setMainApp(this);
    }

    public void createPersonData()
    {
        PersonModel person1 = new PersonModel("Hans","Wurst","Steingasse 17","37247","Großalmerode");
        PersonModel person2 = new PersonModel("Hans1","Wurst1","Steingasse 117","22247","Hamburg");
        PersonModel person3 = new PersonModel("Ben","Schmark","Steinstraße 18","12345","Wurstheim");
        PersonModel person4 = new PersonModel("Ben1","Schmark1","Steinstraße 118","356653","Weinheim");

        personData.add(person1);
        personData.add(person2);
        personData.add(person3);
        personData.add(person4);
    }

    public ObservableList<PersonModel> getPersonData() {
        return personData;
    }
}
