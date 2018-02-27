/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author thepu
 */
public class Person {
    
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    
    
    public Person(String firstName, String lastName){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }
    
    public String getFirstName(){return this.firstName.get();}
    public void setFirstName(String firstName){this.firstName.set(firstName);}
    public StringProperty firstNameProperty(){return this.firstName;}
    
    public String getLastName(){return this.lastName.get();}
    public void setLastName(String lastName){this.lastName.set(lastName);}
    public StringProperty lastNameProperty(){return this.lastName;}
    
}
