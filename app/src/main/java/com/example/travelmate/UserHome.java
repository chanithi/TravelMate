package com.example.travelmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.text.TextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AppCompatActivity;

public class UserHome extends AppCompatActivity {

    private AutoCompleteTextView searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_home);

        // Find the account icon by its ID
        ImageView accountIcon = findViewById(R.id.user_home_acc_icon);

        // Set an OnClickListener to navigate to the UserAccount page
        accountIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserHome.this, UserAcc.class);
                startActivity(intent);
            }
        });

        // Set up the search bar with limited options
        searchBar = findViewById(R.id.search_bar);
        String[] searchOptions = new String[]{"Drivers", "Guides", "Hotels"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, searchOptions);
        searchBar.setAdapter(adapter);

        // Listen for changes in the search bar input
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No action needed
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Handle search input and navigate to the relevant page
                handleSearch(s.toString());
            }
        });
    }

    private void handleSearch(String searchTerm) {
        if (searchTerm.equalsIgnoreCase("Drivers")) {
            navigateToDriversPage();
        } else if (searchTerm.equalsIgnoreCase("Guides")) {
            navigateToGuidesPage();
        } else if (searchTerm.equalsIgnoreCase("Hotels")) {
            navigateToHotelsPage();
        }
    }

    private void navigateToDriversPage() {
        Intent intent = new Intent(UserHome.this, DriversPage.class);
        startActivity(intent);
    }

    private void navigateToGuidesPage() {
        Intent intent = new Intent(UserHome.this, GuidesPage.class);
        startActivity(intent);
    }

    private void navigateToHotelsPage() {
        Intent intent = new Intent(UserHome.this, HotelsPage.class);
        startActivity(intent);
    }
}