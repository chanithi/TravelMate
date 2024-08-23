package com.example.travelmate;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserDriverView extends AppCompatActivity {

    private ImageView userDetailImage;
    private TextView userDetailName;
    private TextView userDetailDistrict;
    private TextView userDetailContact;
    private Button userDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_driver_view);

        userDetailImage = findViewById(R.id.user_detail_image);
        userDetailName = findViewById(R.id.user_detail_name);
        userDetailDistrict = findViewById(R.id.user_detail_district);
        userDetailContact = findViewById(R.id.user_detail_contact);
        userDetailButton = findViewById(R.id.user_detail_button);

        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");
        String district = intent.getStringExtra("userDistrict");
        String contact = intent.getStringExtra("userContact");

        userDetailName.setText(name);
        userDetailDistrict.setText(district);
        userDetailContact.setText(contact);

        // Optionally, set the image resource based on user type or other criteria
        userDetailImage.setImageResource(R.drawable.acc); // Set default image

        userDetailButton.setOnClickListener(v -> {
            // Handle button click action here
        });
    }
}

