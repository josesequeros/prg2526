/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.tableviewdemo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author jabue
 */
public class Country {

    private final SimpleStringProperty country;
    private final SimpleStringProperty capital;
    private final SimpleDoubleProperty population;
    private final SimpleBooleanProperty democratic;

    Country(String country, String capital, double population, boolean democratic) {
        this.country = new SimpleStringProperty(country);
        this.capital = new SimpleStringProperty(capital);
        this.population = new SimpleDoubleProperty(population);
        this.democratic = new SimpleBooleanProperty(democratic);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getCapital() {
        return capital.get();
    }

    public void setCapital(String capital) {
        this.capital.set(capital);
    }

    public double getPopulation() {
        return population.get();
    }

    public void setPopulation(double population) {
        this.population.set(population);
    }

    public boolean isDemocratic() {
        return democratic.get();
    }

    public void setDemocratic(boolean democratic) {
        this.democratic.set(democratic);
    }
}
