package com.example.app3a.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.app3a.R;
import com.example.app3a.model.api.Link;
import com.example.app3a.model.personnage.Personnage;
import com.example.app3a.view.fragment.FragmentCapacite;
import com.example.app3a.view.fragment.FragmentDescription;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private FragmentCapacite capacite;
    private FragmentDescription description;
    private BottomNavigationView bottomNavigationView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Personnage personnage = getIntent().getParcelableExtra("Character");
        initializeTitle(personnage);
        initializeFragment(personnage);
        initializeBottomBar();
    }
    private void initializeBottomBar() {
        this.bottomNavigationView = findViewById(R.id.bottom_nav_view_id_detail);
        this.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
                if(id == R.id.capacite_image) {
                    fragment.replace(R.id.fragment_changeable,capacite);
                } else if (id == R.id.description_image) {
                    fragment.replace(R.id.fragment_changeable,description);
                }
                fragment.commit();
                return true;
            }
        });
        this.bottomNavigationView.setSelectedItemId(R.id.capacite_image);
    }
    private void initializeTitle(Personnage personnage) {
        this.imageView = findViewById(R.id.detail_logo);
        this.textView = findViewById(R.id.detail_name);
        Picasso.with(imageView.getContext()).load(Link.image+personnage.get().image).resize(128,128).into(imageView);
        this.textView.setText(personnage.get().firstName + " " + personnage.get().lastName);
    }
    private void initializeFragment(Personnage personnage) {
        this.capacite = new FragmentCapacite(personnage.get().puissance);
        this.description = new FragmentDescription(personnage);
    }
}