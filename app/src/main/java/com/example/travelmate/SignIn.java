//package com.example.travelmate;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.activity.result.ActivityResult;
//import androidx.activity.result.ActivityResultCallback;
//import androidx.activity.result.ActivityResultLauncher;
//import androidx.activity.result.contract.ActivityResultContracts;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;


//public class SignIn extends AppCompatActivity {
//
//    TextInputEditText editTextEmail, editTextPassword;
//    Button buttonSignIn;
//    FirebaseAuth mAuth;
//    ProgressBar progressBar;
//    TextView textView;
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(getApplicationContext(), UserHome.class);
//            startActivity(intent);
//            finish();
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_sign_in);
//
//        mAuth = FirebaseAuth.getInstance();
//        editTextEmail = findViewById(R.id.signIn_email);
//        editTextPassword = findViewById(R.id.signIn_password);
//        buttonSignIn = findViewById(R.id.signIn_pg_btn);
//        progressBar = findViewById(R.id.signIn_prog_bar);
//        textView = findViewById(R.id.askToSignUp);
//
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), SignUp.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        buttonSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressBar.setVisibility(View.VISIBLE);
//                String email, password;
//                email = String.valueOf(editTextEmail.getText());
//                password = String.valueOf(editTextPassword.getText());
//
//                if(TextUtils.isEmpty(email)){
//                    Toast.makeText(SignIn.this,"Enter Email",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if(TextUtils.isEmpty(password)){
//                    Toast.makeText(SignIn.this,"Enter Password",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                mAuth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                progressBar.setVisibility(View.GONE);
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(SignIn.this, "Login Successful.",
//                                            Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(getApplicationContext(), UserHome.class);
//                                    startActivity(intent);
//                                    finish();
//
//                                } else {
//
//                                    Toast.makeText(SignIn.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//
//                                }
//                            }
//                        });
//            }
//        });
//
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//public class SignIn extends AppCompatActivity {
//
//    TextInputEditText editTextEmail, editTextPassword;
//    Button buttonSignIn;
//    FirebaseAuth mAuth;
//    ProgressBar progressBar;
//    TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_in);
//
//        mAuth = FirebaseAuth.getInstance();
//        editTextEmail = findViewById(R.id.signIn_email);
//        editTextPassword = findViewById(R.id.signIn_password);
//        buttonSignIn = findViewById(R.id.signIn_pg_btn);
//        progressBar = findViewById(R.id.signIn_prog_bar);
//        textView = findViewById(R.id.askToSignUp);
//
//        textView.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), SignUp.class);
//            startActivity(intent);
//            finish();
//        });
//
//        buttonSignIn.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String email, password;
//            email = String.valueOf(editTextEmail.getText());
//            password = String.valueOf(editTextPassword.getText());
//
//            if (TextUtils.isEmpty(email)) {
//                Toast.makeText(SignIn.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                Toast.makeText(SignIn.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            mAuth.signInWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            if (user != null) {
//                                String userType = getUserType(user);
//                                if ("Customer".equals(userType)) {
//                                    Intent intent = new Intent(SignIn.this, UserHome.class);
//                                    startActivity(intent);
//                                    finish();
//                                } else {
//                                    Intent intent = new Intent(SignIn.this, ProviderHome.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }
//                        } else {
//                            Toast.makeText(SignIn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        });
//    }
//
//    private String getUserType(FirebaseUser user) {
//        // Fetch user type from your database or Firebase Firestore/Realtime Database
//        // This is just a placeholder, replace with actual implementation
//        return "Customer"; // Replace this with actual user type
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
////import com.google.firebase.firestore.DocumentSnapshot;
////import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//public class SignIn extends AppCompatActivity {
//
//    TextInputEditText editTextEmail, editTextPassword;
//    Button buttonSignIn;
//    FirebaseAuth mAuth;
//    ProgressBar progressBar;
//    TextView textView;
//    FirebaseFirestore db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_in);
//
//        mAuth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance(); // Initialize Firestore
//
//        editTextEmail = findViewById(R.id.signIn_email);
//        editTextPassword = findViewById(R.id.signIn_password);
//        buttonSignIn = findViewById(R.id.signIn_pg_btn);
//        progressBar = findViewById(R.id.signIn_prog_bar);
//        textView = findViewById(R.id.askToSignUp);
//
//        textView.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), SignUp.class);
//            startActivity(intent);
//            finish();
//        });
//
//        buttonSignIn.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String email = String.valueOf(editTextEmail.getText());
//            String password = String.valueOf(editTextPassword.getText());
//
//            if (TextUtils.isEmpty(email)) {
//                Toast.makeText(SignIn.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                Toast.makeText(SignIn.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                return;
//            }
//
//            mAuth.signInWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            if (user != null) {
//                                getUserType(user.getUid(), userType -> {
//                                    if ("Customer".equals(userType)) {
//                                        Intent intent = new Intent(SignIn.this, UserHome.class);
//                                        startActivity(intent);
//                                    } else if ("Driver".equals(userType) || "Guide".equals(userType) || "Hotel".equals(userType)) {
//                                        Intent intent = new Intent(SignIn.this, ProviderHome.class);
//                                        startActivity(intent);
//                                    }
//                                    finish();
//                                });
//                            }
//                        } else {
//                            Toast.makeText(SignIn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        });
//    }
//
//    private void getUserType(String uid, UserTypeCallback callback) {
//        // Fetch user type from Firestore
//        db.collection("users").document(uid).get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        DocumentSnapshot document = task.getResult();
//                        if (document != null && document.exists()) {
//                            String userType = document.getString("userType"); // Replace with your actual field name
//                            callback.onCallback(userType);
//                        } else {
//                            callback.onCallback("Customer"); // Default to Customer if not found
//                        }
//                    } else {
//                        callback.onCallback("Customer"); // Default to Customer in case of error
//                    }
//                });
//    }
//
//    // Callback interface for user type
//    private interface UserTypeCallback {
//        void onCallback(String userType);
//    }
//}
package com.example.travelmate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignIn extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextPassword;
    Button buttonSignIn;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance(); // Initialize Firestore

        editTextEmail = findViewById(R.id.signIn_email);
        editTextPassword = findViewById(R.id.signIn_password);
        buttonSignIn = findViewById(R.id.signIn_pg_btn);
        progressBar = findViewById(R.id.signIn_prog_bar);
        textView = findViewById(R.id.askToSignUp);

        textView.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);
            startActivity(intent);
            finish();
        });

        buttonSignIn.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            String email = String.valueOf(editTextEmail.getText());
            String password = String.valueOf(editTextPassword.getText());

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(SignIn.this, "Enter Email", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(SignIn.this, "Enter Password", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                getUserType(user.getUid(), userType -> {
                                    if ("Customer".equals(userType)) {
                                        Intent intent = new Intent(SignIn.this, UserHome.class);
                                        startActivity(intent);
                                    } else if ("Driver".equals(userType) || "Guide".equals(userType) || "Hotel".equals(userType)) {
                                        Intent intent = new Intent(SignIn.this, ProviderHome.class);
                                        startActivity(intent);
                                    }
                                    finish();
                                });
                            }
                        } else {
                            Toast.makeText(SignIn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    private void getUserType(String uid, UserTypeCallback callback) {
        // Fetch user type from Firestore
        db.collection("users").document(uid).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null && document.exists()) {
                            String userType = document.getString("userType"); // Replace with your actual field name
                            callback.onCallback(userType);
                        } else {
                            callback.onCallback("Customer"); // Default to Customer if not found
                        }
                    } else {
                        callback.onCallback("Customer"); // Default to Customer in case of error
                    }
                });
    }

    // Callback interface for user type
    private interface UserTypeCallback {
        void onCallback(String userType);
    }
}
