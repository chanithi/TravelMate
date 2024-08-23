package com.example.travelmate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class DriverAcc extends AppCompatActivity {

    private TextView nameTextView, districtTextView, contactTextView, emailTextView, passwordTextView;
    private ImageView profileImageView;
    private FirebaseFirestore db;
    private String userId;
    Button editProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_driver_acc);

        nameTextView = findViewById(R.id.provider_acc_name);
        districtTextView = findViewById(R.id.provider_acc_district);
        contactTextView = findViewById(R.id.provider_acc_contact);
        emailTextView = findViewById(R.id.provider_acc_email);
        passwordTextView = findViewById(R.id.provider_acc_password);
        profileImageView = findViewById(R.id.provider_acc_icon);
        editProfileButton = findViewById(R.id.btn_edit_provider_profile);

        db = FirebaseFirestore.getInstance();
        userId = getIntent().getStringExtra("userId");


        editProfileButton.setOnClickListener(view -> {
            Intent intent = new Intent(DriverAcc.this, EditProfile.class);
            startActivity(intent);
        });

        loadData();

    }

//    private void loadData() {
//    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//    if (email != null) {
//        db.collection("users")
//                .whereEqualTo("email", email)
//                .get()
//                .addOnSuccessListener(queryDocumentSnapshots -> {
//                    if (!queryDocumentSnapshots.isEmpty()) {
//                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
//                            // Extract data from the document
//                            String name = documentSnapshot.getString("name");
//                            String district = documentSnapshot.getString("district");
//                            String contact = documentSnapshot.getString("contact");
//                            String emailAddress = documentSnapshot.getString("email");
//                            // Password is generally not recommended to be displayed or stored directly
//                            String password = documentSnapshot.getString("password");
//
//                            // Set data to UI components
//                            nameTextView.setText(name);
//                            districtTextView.setText(district);
//                            contactTextView.setText(contact);
//                            emailTextView.setText(emailAddress);
//                            passwordTextView.setText(password); // Typically not shown
//
//                            // Set a default image
//                            profileImageView.setImageResource(R.drawable.acc);
//                        }
//                    } else {
//                        showToast("No user data found.");
//                    }
//                })
//                .addOnFailureListener(e -> showToast("Failed to load user data."));
//    } else {
//        showToast("User email is null.");
//    }
//}

    private void loadData() {
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().toLowerCase();

        if (email != null) {
            Log.d("DriverAcc", "Querying Firestore for email: " + email); // Log the email being queried

            db.collection("users")
                    .whereEqualTo("email", email)
                    .get()
                    .addOnSuccessListener(queryDocumentSnapshots -> {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                // Extract data from the document
                                String name = documentSnapshot.getString("name");
                                String district = documentSnapshot.getString("district");
                                String contact = documentSnapshot.getString("contact");
                                String emailAddress = documentSnapshot.getString("email");
                                String password = documentSnapshot.getString("password");

                                // Set data to UI components
                                nameTextView.setText(name);
                                districtTextView.setText(district);
                                contactTextView.setText(contact);
                                emailTextView.setText(emailAddress);
                                passwordTextView.setText(password);

                                // Set a default image
                                profileImageView.setImageResource(R.drawable.acc);
                            }
                        } else {
                            Log.d("DriverAcc", "No documents found for email: " + email);
                            showToast("No user data found.");
                        }
                    })
                    .addOnFailureListener(e -> {
                        Log.e("DriverAcc", "Error querying Firestore", e);
                        showToast("Failed to load user data.");
                    });
        } else {
            showToast("User email is null.");
        }
    }


    private void showToast(String message) {
        Toast.makeText(DriverAcc.this, message, Toast.LENGTH_SHORT).show();
    }
}