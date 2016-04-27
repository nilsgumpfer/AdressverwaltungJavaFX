package de.thm.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.SimpleStyleableStringProperty;

/**
 * Created by Nils on 26.04.2016.
 */
public class PersonModel {
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty streetName = new SimpleStringProperty();
    private StringProperty postalCode = new SimpleStringProperty();
    private StringProperty cityName = new SimpleStringProperty();

    public PersonModel() {
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.streetName = new SimpleStringProperty();
        this.postalCode = new SimpleStringProperty();
        this.cityName = new SimpleStringProperty();
    }

    public PersonModel(String firstName, String lastName, String streetName, String postalCode, String cityName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.streetName = new SimpleStringProperty(streetName);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.cityName = new SimpleStringProperty(cityName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreetName() {
        return streetName.get();
    }

    public StringProperty streetNameProperty() {
        return streetName;
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCityName() {
        return cityName.get();
    }

    public StringProperty cityNameProperty() {
        return cityName;
    }

}
