package com.example.app3a.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app3a.R;
import com.example.app3a.controler.activity.MainController;
import com.example.app3a.model.personnage.Personnage;

public class MainActivity extends AppCompatActivity {
    private MainController mainController;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the main Controller
        mainController = new MainController(this);
    }
    public void otherActivity(Personnage personnage){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Character",personnage);
        startActivity(intent);
    }
}
