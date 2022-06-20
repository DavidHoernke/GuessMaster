package com.example.myguessmaster;

public abstract class Entity {

    private double difficulty;
    private String name;
    private Date born;
    private String quit = "quit"; // string to compare a quit command to

    public Entity() {
        name = "NULL";
        born = new Date();
        difficulty = 0;
    }

    public Entity(Entity entity) {
        name = entity.getName();
        born = entity.getDate();
        difficulty = entity.getDiff();
    }

    public Entity(String nameIN, Date dateIn, double difficultyIN) {
        name = nameIN;
        born = new Date(dateIn);
        difficulty = difficultyIN;
    }

    public int CompareDate(String date) {

        if (date.equals(quit))
            return 5;

        Date otherDate = new Date(date); // This function compares the date and returns a number depending on if it is
        boolean equal = born.equals(otherDate); // early, late or the correct date, also handles the quit command
        if (equal == true)
            return 1;
        boolean precedes = born.precedes(otherDate);
        if (precedes == true)
            return 2;
        else
            return 3;
    }

    public String toString() {
        return "Name: " + name + "\nBorn at: " + born;
    }

    public String getName() {
        String Copy = new String(name);
        return Copy;
    }

    public Date getDate() {
        Date Copy = new Date(born);
        return Copy;
    }

    public double getDiff() {
        return difficulty;
    }

    public int getAwardedTicketNumber() {
        int tickets = (int) (difficulty * 100);
        return tickets;
    }

    public abstract Entity clone();

    public abstract String entityType();

    public String welcomeMessage() {
        return "Welcome! Let’s start the game! " + entityType();
    }

    public String closingMessage() {
        return "Congratulations! The detailed information of the entity you guessed is:\n" + toString();
    }


}
