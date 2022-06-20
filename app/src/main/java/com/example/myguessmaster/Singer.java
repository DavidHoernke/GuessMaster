package com.example.myguessmaster;


public class Singer extends Person {
    private String debutAlbum;
    private Date debutAlbumReleaseDate;

    public Singer() { 						//Defining Constructors
        super();
        debutAlbum = "NULL";
        debutAlbumReleaseDate = new Date();
    }

    public Singer(Singer Singer) {
        super(Singer);
        debutAlbum = Singer.getDebutAlbum();
        debutAlbumReleaseDate = new Date(Singer.getDate());

    }

    public Singer(String nameIN, Date dateIn, String genderIN, String debutAlbumIN, Date debutAlbumReleaseDateIN,
                  double difficultyIN) {

        super(nameIN, dateIn, genderIN, difficultyIN);
        debutAlbum = debutAlbumIN;
        debutAlbumReleaseDate = debutAlbumReleaseDateIN;
    }

    public Date getDebutAlbumReleaseDate() {				// getters and setters
        return debutAlbumReleaseDate;
    }

    public void setDebutAlbumReleaseDate(Date debutAlbumReleaseDate) {
        this.debutAlbumReleaseDate = debutAlbumReleaseDate;
    }

    public String getDebutAlbum() {
        return debutAlbum;
    }

    public void setDebutAlbum(String debutAlbum) {
        this.debutAlbum = debutAlbum;
    }

    public String entityType() {					//overwriting entityType()

        return "This entity is a Singer!";
    }

    public Singer clone() {
        return new Singer(this);
    }

    public String toString() {												// to string method
        return super.toString() + "\nDebut Album: " + this.getDebutAlbum() + "\nRelease Date: "
                + this.getDebutAlbumReleaseDate();
    }
}


