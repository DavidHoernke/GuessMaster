package com.example.myguessmaster;


public class Politician extends Person {
    private String party;

    public String getParty() {					// getter and setter
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Politician() {						//Constructors
        super();
        party = "NULL";
    }

    public Politician(Politician Politician) {
        super(Politician);
        party = Politician.getParty();

    }

    public Politician(String nameIN, Date dateIn, String genderIN, String partyIN, double difficultyIN) {

        super(nameIN, dateIn, genderIN, difficultyIN);
        party = partyIN;
    }

    public String entityType() {			// defining entityType()

        return "This entity is a Politician!";
    }

    public Politician clone() {					//cloning method
        return new Politician(this);
    }

    public String toString() {							// to string method
        return super.toString() + "\nParty: " + this.getParty();
    }
}

