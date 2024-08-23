package com.example.travelmate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class EditProfile extends AppCompatActivity {

    private EditText nameEditText, districtEditText, contactEditText, passwordEditText;
    private FirebaseFirestore db;
    private String email;
    Button saveButton;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);

        nameEditText = findViewById(R.id.edit_name);
        districtEditText = findViewById(R.id.edit_district);
        contactEditText = findViewById(R.id.edit_contact);
        passwordEditText = findViewById(R.id.edit_password);
        saveButton = findViewById(R.id.btn_save);
        deleteButton = findViewById(R.id.btn_delete_profile);

        db = FirebaseFirestore.getInstance();
        email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        loadUserData();

        saveButton.setOnClickListener(view -> saveProfileChanges());
        deleteButton.setOnClickListener(view -> confirmDeleteProfile());
    }

    private void loadUserData() {
        if (email != null) {
            db.collection("users")
                    .whereEqualTo("email", email)
                    .get()
                    .addOnSuccessListener(queryDocumentSnapshots -> {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                // Load existing data into EditTexts
                                nameEditText.setText(documentSnapshot.getString("name"));
                                districtEditText.setText(documentSnapshot.getString("district"));
                                contactEditText.setText(documentSnapshot.getString("contact"));
                                passwordEditText.setText(documentSnapshot.getString("password"));
                            }
                        } else {
                            showToast("User data not found.");
                        }
                    })
                    .addOnFailureListener(e -> showToast("Failed to load user data."));
        }
    }

    private void saveProfileChanges() {
        String newName = nameEditText.getText().toString();
        String newDistrict = districtEditText.getText().toString();
        String newContact = contactEditText.getText().toString();
        String newPassword = passwordEditText.getText().toString();

        db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        db.collection("users").document(documentSnapshot.getId())
                                .update("name", newName, "district", newDistrict, "contact", newContact, "password", newPassword)
                                .addOnSuccessListener(aVoid -> showToast("Profile updated successfully."))
                                .addOnFailureListener(e -> showToast("Failed to update profile."));
                    }
                });
    }

    private void confirmDeleteProfile() {
        new AlertDialog.Builder(this)
                .setTitle("Delete Profile")
                .setMessage("Are you sure you want to delete your profile?")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> deleteProfile())
                .setNegativeButton(android.R.string.no, null)
                .show();
    }

    private void deleteProfile() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            db.collection("users")
                    .whereEqualTo("email", email)
                    .get()
                    .addOnSuccessListener(queryDocumentSnapshots -> {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            db.collection("users").document(documentSnapshot.getId())
                                    .delete()
                                    .addOnSuccessListener(aVoid -> {
                                        showToast("Profile deleted successfully.");
                                        user.delete();
                                        startActivity(new Intent(EditProfile.this, SignIn.class));
                                        finish();
                                    })
                                    .addOnFailureListener(e -> showToast("Failed to delete profile."));
                        }
                    });
        }
    }

    private void showToast(String message) {
        Toast.makeText(EditProfile.this, message, Toast.LENGTH_SHORT).show();
    }
}


