package com.example.myguessmaster;

public class Person extends Entity {
    private String gender;

    public Person() {
        super();
        gender = "NULL";
    }

    public Person(Person Person) {					// constructors
        super(Person);
        gender = Person.getGender();
    }

    public Person(String nameIN, Date dateIn, String genderIN, double difficultyIN) {
        super(nameIN, dateIn, difficultyIN);
        gender = genderIN;
    }

    public String toString() {															// to string
        return super.toString() + "\nGender: " + this.getGender();
    }

    public Person clone() {
        return new Person(this);
    }

    public String getGender() {			//getters and setters
        return new String(gender);
    }

    public String entityType() {

        return "This entity is a Person!";
    }

}
