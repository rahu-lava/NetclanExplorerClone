package com.example.netclanexplorer;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);
        imageView = findViewById(R.id.refineImage);


        Menu menu = bottomNavigationView.getMenu();

        MenuItem explore = menu.findItem(R.id.explore);
        MenuItem contacts = menu.findItem(R.id.contact);
        MenuItem chat = menu.findItem(R.id.chat);
        MenuItem connection = menu.findItem(R.id.connection);

        MenuItem current = menu.findItem(R.id.explore);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ExploreFragment()).commit();



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RefineActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.explore) {
                    explore.setIcon(R.drawable.eye_solid);
                    connection.setIcon(R.drawable.connection_regular);
                    contacts.setIcon(R.drawable.contact_regular);
                    chat.setIcon(R.drawable.chat_regular);

                    setFrag(new ExploreFragment());
                    return true;
                } else if (itemId == R.id.connection) {
                    explore.setIcon(R.drawable.eye_regular);
                    connection.setIcon(R.drawable.connection_solid);
                    contacts.setIcon(R.drawable.contact_regular);
                    chat.setIcon(R.drawable.chat_regular);
                    setFrag(new ConnectionFragment());
                    return true;
                } else if (itemId == R.id.chat) {
                    explore.setIcon(R.drawable.eye_regular);
                    connection.setIcon(R.drawable.connection_regular);
                    contacts.setIcon(R.drawable.contact_regular);
                    chat.setIcon(R.drawable.chat_solid);
                    setFrag(new ChatFragment());
                    return true;
                } else if (itemId == R.id.contact){
                    explore.setIcon(R.drawable.eye_regular);
                    connection.setIcon(R.drawable.connection_regular);
                    contacts.setIcon(R.drawable.contact_solid);
                    chat.setIcon(R.drawable.chat_regular);
                    setFrag(new ContactsFragment());
                    return true;
                } else if (itemId == R.id.group){
                    current.setIcon(R.drawable.eye_regular);
                    setFrag(new GroupFragment());
                    return true;
                }

                return false;
            }
        });

    }

    public void setFrag(Fragment fragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }

}