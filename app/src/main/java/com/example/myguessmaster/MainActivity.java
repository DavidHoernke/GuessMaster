// David Hoernke
// 2023 2457
package com.example.myguessmaster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView entityName;
    private TextView ticketsum;
    private EditText userIn;
    private String user_input;
    private ImageView entityImage;

    Entity activeEntity;
    private String entName;
    private int tickets;
    private int guess;
    private Entity[] entities;
    private int numberOfCanditateEntities;

    public MainActivity() {
        numberOfCanditateEntities = 0;
        entities = new Entity[4]; // Setting an arbitrarily large array to store all of the objects
        tickets = 0;
    }
    public void addEntity(Entity entity) {
        // This is the method to add entities to an array and store their information
        entities[numberOfCanditateEntities] = entity.clone();
        numberOfCanditateEntities++;
    }
    private void fillEntities(){
        new MainActivity();

        Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
        Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
        Person myCreator = new Person("My Creator", new Date("September", 1, 2000),"Female", 1);
        Country usa = new Country("United States of America", new Date("July", 4, 1776), "Washinton D.C.", 0.1);


        addEntity(dion);
        addEntity(myCreator);
        addEntity(usa);
        addEntity(trudeau);

    }
    public void helperWelcome(){
        AlertDialog.Builder welcomealert = new AlertDialog.Builder(MainActivity.this);
        welcomealert.setTitle("GuessMaster Game v3");
        welcomealert.setMessage(activeEntity.welcomeMessage());
        welcomealert.setCancelable(false);

        welcomealert.setNegativeButton("Start Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialop, int which) {
                Toast.makeText(getBaseContext(),"Game is Starting... Enjoy", Toast.LENGTH_SHORT).show();
            }
        });
        //Show Dialog
        AlertDialog dialog = welcomealert.create();
        dialog.show();
    }
    public void  getRandomEntity(){

        activeEntity=entities[(int)Math.floor(Math.random()*4)];
    }
    public void idFinder(){
        ticketsum=findViewById(R.id.tickets);
        userIn=findViewById(R.id.guessInput);
        entityName=findViewById(R.id.entityName);
        entityImage=findViewById(R.id.entityImage);

    }
    private void setEntityImage(){
        switch (activeEntity.getName()){
            case "Justin Trudeau":
                entityImage.setImageResource(R.drawable.justint);
                break;
            case"Celine Dion":
                entityImage.setImageResource(R.drawable.celidion);
                break;
            case "United States of America":
                entityImage.setImageResource(R.drawable.usaflag);
                break;
            case "My Creator":
                entityImage.setImageResource(R.drawable.download);
                break;
            default:
                entityImage.setImageResource(R.drawable.image_error);
                break;
        }
    }

    public void submitGuess(View view){

            Editable guess = userIn.getText();
            Date guessDate;
            Date input = new Date(guess.toString());


            if (input.equals(activeEntity.getDate())==true) {
                AlertDialog.Builder precedes = new AlertDialog.Builder(MainActivity.this);
                precedes.setTitle("You Won");
                precedes.setMessage("BINGO! "+activeEntity.closingMessage());
                precedes.setCancelable(false);

                precedes.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(),"You won "+activeEntity.getAwardedTicketNumber()+" tickets!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = precedes.create();
                dialog.show();

                tickets+= activeEntity.getAwardedTicketNumber();
                ticketsum.setText("Tickets: "+tickets);
                getRandomEntity();
                setEntityImage();
                entityName.setText(activeEntity.getName());
                userIn.getText().clear();
            }
        else if (input.precedes(activeEntity.getDate())) {
            AlertDialog.Builder precedes = new AlertDialog.Builder(MainActivity.this);
            precedes.setTitle("Incorrect.");
            precedes.setMessage("Try a later date.");
            precedes.setCancelable(false);

            precedes.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = precedes.create();
            dialog.show();
        }
        else  {
            AlertDialog.Builder precedes = new AlertDialog.Builder(MainActivity.this);
            precedes.setTitle("Incorrect.");
            precedes.setMessage("Try an earlier date.");
            precedes.setCancelable(false);

            precedes.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = precedes.create();
            dialog.show();
        }











    }
    private void gameInit(){
        getRandomEntity();
        helperWelcome();
        idFinder();
        setEntityImage();
        ticketsum.setText("Tickets: "+tickets);
        entityName.setText(activeEntity.getName());


    }
    public void changeEntity(View view){
        getRandomEntity();
        setEntityImage();
        entityName.setText(activeEntity.getName());
        userIn.getText().clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillEntities();
        gameInit();
    }
}