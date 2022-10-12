package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

@Named
@RequestScoped
public class CheckboxView {

    private String[] selectedOptions;
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
    private List<SelectItem> countries;
    private String[] selectedCountries;

    @PostConstruct
    public void init() {
        cities = new ArrayList<>();
        cities.add("Pizza de pepperoni ");
        cities.add("Pizza cuatro quesos");
        cities.add("Pizza cuatro estaciones");
        cities.add("Pizza con champiñones");
        cities.add("Pizza hawaiana");
        cities.add("Pizza marinara");
        cities.add("Pizza margarita");
        cities.add("Pizza napolitana");
        cities.add("Pizza neoyorquina");

        countries = new ArrayList<>();
        SelectItemGroup europeCountries = new SelectItemGroup("Añadidos");
        europeCountries.setSelectItems(new SelectItem[]{
            new SelectItem("Peperoni", "Peperoni"),
            new SelectItem("Mozarella", "Mozarella"),
            new SelectItem("Salsa", "Salsa")
        });

        SelectItemGroup americaCountries = new SelectItemGroup("Complementos");
        americaCountries.setSelectItems(new SelectItem[]{
            new SelectItem("Ensaladas", "Ensaladas"),
            new SelectItem("Panes al Ajo", "Panes al Ajo"),
            new SelectItem("Encurtidos", "Encurtidos")
        });

        countries.add(europeCountries);
        countries.add(americaCountries);
    }

    public String[] getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(String[] selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public String[] getSelectedCities() {
        return selectedCities;
    }

    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }

    public String[] getSelectedCities2() {
        return selectedCities2;
    }

    public void setSelectedCities2(String[] selectedCities2) {
        this.selectedCities2 = selectedCities2;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<SelectItem> getCountries() {
        return countries;
    }

    public void setCountries(List<SelectItem> countries) {
        this.countries = countries;
    }

    public String[] getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(String[] selectedCountries) {
        this.selectedCountries = selectedCountries;
    }


    


}
