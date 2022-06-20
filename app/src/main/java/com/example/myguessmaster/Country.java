package com.example.myguessmaster;

public class Country extends Entity {
    private String Capital;


    public Country() {
        super();
        Capital="Null";
    }

    public Country(String nameIN, Date dateIn,String CapitalIN, double difficultyIN) {			// constructors
        super(nameIN, dateIn, difficultyIN);
        Capital= CapitalIN;
    }

    public Country(Country entity) {
        super(entity);
        Capital=entity.getCapital();
    }

    public String getCapital(){				// getters and setters
        return new String(Capital);
    }

    public String toString() {
        return super.toString() + "\nCapital: " + this.getCapital();
    }

    public Country clone() {
        return new Country(this);
    }
    public String entityType() {
        return "This entity is a country!";
    }
}

