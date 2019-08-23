package com.example.rockpapperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock,b_scissors,b_paper,b_singlePlayer;
    TextView tv_your_choice,tv_computer_choice,score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        b_singlePlayer = (Button) findViewById(R.id.b_singlePlayer);
        b_singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singlePlayerMode();
            }
        });

    }
    protected void singlePlayerMode(){
        setContentView(R.layout.single_player_mode);

        b_paper = (Button) findViewById(R.id.b_paper);
        b_rock = (Button) findViewById(R.id.b_rock);
        b_scissors = (Button) findViewById(R.id.b_scissor);
        tv_computer_choice = (TextView) findViewById(R.id.tv_computer_choice);
        tv_your_choice = (TextView) findViewById(R.id.tv_your_choice);
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_your_choice.setText("Paper");
                computerChoice();
                Toast.makeText(MainActivity.this,result(),Toast.LENGTH_SHORT).show();
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_your_choice.setText("Scissors");
                computerChoice();
                Toast.makeText(MainActivity.this,result(),Toast.LENGTH_SHORT).show();

            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_your_choice.setText("Rock");
                computerChoice();
                Toast.makeText(MainActivity.this,result(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    protected String result(){
        String computerChoice = (String)tv_computer_choice.getText();
        String playerChoice = (String)tv_your_choice.getText();
        if(computerChoice == playerChoice){
            return "You think like the computer";
        }
        else if(computerChoice == "Rock" && playerChoice == "Paper"){
            return "You Won";
        }
        else if(computerChoice == "Rock" && playerChoice == "Scissors"){
            return "You Lose";
        }
        else if(computerChoice == "Scissors" && playerChoice == "Paper"){
            return "You Lose";
        }
        else if(computerChoice == "Scissors" && playerChoice == "Rock"){
            return "You Won";
        }
        else if(computerChoice == "Paper" && playerChoice == "Scissors"){
            return "You Won";
        }
        else if(computerChoice == "Paper" && playerChoice == "Rock"){
            return "You Lose";
        }
        else
            return "Don't know what happened to me";
    }
    protected void computerChoice(){
        Random rand = new Random();
        int number = rand.nextInt(3);
        number+=1;
        if(number == 1){
            tv_computer_choice.setText("Rock");
        }
        else if(number == 1){
            tv_computer_choice.setText("Paper");
        }
        else
            tv_computer_choice.setText("Scissors");
        result();
    }
}
