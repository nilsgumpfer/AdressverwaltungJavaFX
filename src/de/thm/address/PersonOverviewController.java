package de.thm.address;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import de.thm.address.model.PersonModel;

import java.awt.event.MouseAdapter;

/**
 * Created by Nils on 26.04.2016.
 */
public class PersonOverviewController {
    private MainApp mainApp;

    @FXML
    private TableView<PersonModel> personTable;
    @FXML
    private TableColumn<PersonModel, String> firstNameColumn;
    @FXML
    private TableColumn<PersonModel, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetNameLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityNameLabel;

    @FXML
    private void initialize(){

        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonModel>() {
            @Override
            public void changed(ObservableValue<? extends PersonModel> observable, PersonModel oldValue, PersonModel newValue) {
                firstNameLabel.setText(newValue.getFirstName());
                lastNameLabel.setText(newValue.getLastName());
                streetNameLabel.setText(newValue.getStreetName());
                postalCodeLabel.setText(newValue.getPostalCode());
                cityNameLabel.setText(newValue.getCityName());
            }
        });
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        /* Add observable list data to the table*/
        mainApp.createPersonData();
        personTable.setItems(mainApp.getPersonData());
    }
}

//DAS IST NEU
