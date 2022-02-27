package com.isanuric.xml.country;

public class Country {
    private String name;
    private String capital;
    private int citizens;

    public Country() {
    }

    public Country(String name, String capital, int citizens) {
        this.name = name;
        this.capital = capital;
        this.citizens = citizens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }
}
