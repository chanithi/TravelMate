//package com.example.travelmate;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
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
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
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
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//import com.google.firebase.auth.FirebaseUser;
//
//
////public class SignUp extends AppCompatActivity {
////
////    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact, editTextNIC;
////    Button buttonReg;
////    FirebaseAuth mAuth;
////    ProgressBar progressBar;
////    TextView textView;
////
////    @Override
////    public void onStart() {
////        super.onStart();
////        FirebaseUser currentUser = mAuth.getCurrentUser();
////        if(currentUser != null){
////            Intent intent = new Intent(getApplicationContext(), SignIn.class);
////            startActivity(intent);
////            finish();
////        }
////    }
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        //EdgeToEdge.enable(this);
////        setContentView(R.layout.activity_sign_up);
////
////        mAuth = FirebaseAuth.getInstance();
////        editTextEmail = findViewById(R.id.signUp_email);
////        editTextPassword = findViewById(R.id.signUp_password);
////        editTextName = findViewById(R.id.signUp_name);
////        editTextContact = findViewById(R.id.signUp_contact);
////        editTextNIC = findViewById(R.id.signUp_nic);
////        buttonReg = findViewById(R.id.signUp_pg_btn);
////        progressBar = findViewById(R.id.signUp_prog_bar);
////        textView = findViewById(R.id.askToSignIn);
////
////        textView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent = new Intent(getApplicationContext(), SignIn.class);
////                startActivity(intent);
////                finish();
////            }
////        });
////
////         buttonReg.setOnClickListener(new View.OnClickListener() {
////             @Override
////             public void onClick(View view) {
////                 progressBar.setVisibility(View.VISIBLE);
////                 String name, nic, contact, email, password;
////                 name = String.valueOf(editTextName.getText());
////                 nic = String.valueOf(editTextNIC.getText());
////                 contact = String.valueOf(editTextContact.getText());
////                 email = String.valueOf(editTextEmail.getText());
////                 password = String.valueOf(editTextPassword.getText());
////
////                 if(TextUtils.isEmpty(email)){
////                     Toast.makeText(SignUp.this,"Enter Email",Toast.LENGTH_SHORT).show();
////                     return;
////                 }
////
////                 if(TextUtils.isEmpty(password)){
////                     Toast.makeText(SignUp.this,"Enter Password",Toast.LENGTH_SHORT).show();
////                     return;
////                 }
////
////                 if(TextUtils.isEmpty(name)){
////                     Toast.makeText(SignUp.this,"Enter Name",Toast.LENGTH_SHORT).show();
////                     return;
////                 }
////
////                 if(TextUtils.isEmpty(nic)){
////                     Toast.makeText(SignUp.this,"Enter NIC",Toast.LENGTH_SHORT).show();
////                     return;
////                 }
////
////                 if(TextUtils.isEmpty(contact)){
////                     Toast.makeText(SignUp.this,"Enter Contact Number",Toast.LENGTH_SHORT).show();
////                     return;
////                 }
////
////                 mAuth.createUserWithEmailAndPassword(email, password)
////                         .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
////                             @Override
////                             public void onComplete(@NonNull Task<AuthResult> task) {
////                                 progressBar.setVisibility(View.GONE);
////                                 if (task.isSuccessful()) {
////                                     Toast.makeText(SignUp.this, "Account Created.",
////                                             Toast.LENGTH_SHORT).show();
////
////
////                                 } else {
////                                     // If sign in fails, display a message to the user.
////                                     Toast.makeText(SignUp.this, "Authentication failed.",
////                                             Toast.LENGTH_SHORT).show();
////
////                                 }
////                             }
////                         });
////             }
////         });
////    }
////}
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
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
//public class SignUp extends AppCompatActivity {
//
//    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact;
//    Spinner userTypeSpinner;
//    Button buttonReg;
//    FirebaseAuth mAuth;
//    ProgressBar progressBar;
//    TextView textView;
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (mAuth.getCurrentUser() != null) {
//            Intent intent = new Intent(getApplicationContext(), SignIn.class);
//            startActivity(intent);
//            finish();
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        mAuth = FirebaseAuth.getInstance();
//        editTextEmail = findViewById(R.id.signUp_email);
//        editTextPassword = findViewById(R.id.signUp_password);
//        editTextName = findViewById(R.id.signUp_name);
//        editTextContact = findViewById(R.id.signUp_contact);
//        userTypeSpinner = findViewById(R.id.user_type_spinner);
//        buttonReg = findViewById(R.id.signUp_pg_btn);
//        progressBar = findViewById(R.id.signUp_prog_bar);
//        textView = findViewById(R.id.askToSignIn);
//
//        // Populate the user type dropdown
//        String[] userTypes = new String[]{"Customer", "Driver", "Guide", "Hotel"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userTypes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        userTypeSpinner.setAdapter(adapter);
//
//        textView.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), SignIn.class);
//            startActivity(intent);
//            finish();
//        });
//
//        buttonReg.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String name, contact, userType, email, password;
//            name = String.valueOf(editTextName.getText());
//            contact = String.valueOf(editTextContact.getText());
//            userType = userTypeSpinner.getSelectedItem().toString();
//            email = String.valueOf(editTextEmail.getText());
//            password = String.valueOf(editTextPassword.getText());
//
//            if (TextUtils.isEmpty(name)) {
//                Toast.makeText(SignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                return;
//            }
//
//            if (TextUtils.isEmpty(contact)) {
//                Toast.makeText(SignUp.this, "Enter Contact Number", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                return;
//            }
//
//            if (TextUtils.isEmpty(userType)) {
//                Toast.makeText(SignUp.this, "Select User Type", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                return;
//            }
//
//            if (TextUtils.isEmpty(email)) {
//                Toast.makeText(SignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                Toast.makeText(SignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                return;
//            }
//
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            Toast.makeText(SignUp.this, "Account Created.", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(SignUp.this, SignIn.class);
//                            startActivity(intent);
//                            finish();
//                        } else {
//                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//                                Toast.makeText(SignUp.this, "This email is already registered.", Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//        });
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//
//public class SignUp extends AppCompatActivity {
//
//    private static final int PICK_IMAGE_REQUEST = 1;
//
//    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact;
//    Spinner userTypeSpinner;
//    Button buttonReg, uploadPhotoButton;
//    ImageView uploadedImageView;
//    FirebaseAuth mAuth;
//    ProgressBar progressBar;
//    TextView textView;
//    Uri imageUri;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        // Initialize views
//        editTextEmail = findViewById(R.id.signUp_email);
//        editTextPassword = findViewById(R.id.signUp_password);
//        editTextName = findViewById(R.id.signUp_name);
//        editTextContact = findViewById(R.id.signUp_contact);
//        userTypeSpinner = findViewById(R.id.user_type_spinner);
//        buttonReg = findViewById(R.id.signUp_pg_btn);
//        uploadPhotoButton = findViewById(R.id.upload_photo_btn);
//        uploadedImageView = findViewById(R.id.uploaded_image_view);
//        progressBar = findViewById(R.id.signUp_prog_bar);
//        textView = findViewById(R.id.askToSignIn);
//
//        // Populate the user type dropdown
//        String[] userTypes = {"Customer", "Driver", "Guide", "Hotel"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userTypes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        userTypeSpinner.setAdapter(adapter);
//
//        textView.setOnClickListener(view -> {
//            startActivity(new Intent(getApplicationContext(), SignIn.class));
//            finish();
//        });
//
//        uploadPhotoButton.setOnClickListener(view -> openFileChooser());
//
//        buttonReg.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String name = editTextName.getText().toString().trim();
//            String contact = editTextContact.getText().toString().trim();
//            String userType = userTypeSpinner.getSelectedItem().toString();
//            String email = editTextEmail.getText().toString().trim();
//            String password = editTextPassword.getText().toString().trim();
//
//            if (TextUtils.isEmpty(name)) {
//                showToast("Enter Name");
//                return;
//            }
//
//            if (TextUtils.isEmpty(contact)) {
//                showToast("Enter Contact Number");
//                return;
//            }
//
//            if (TextUtils.isEmpty(userType)) {
//                showToast("Select User Type");
//                return;
//            }
//
//            if (TextUtils.isEmpty(email)) {
//                showToast("Enter Email");
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                showToast("Enter Password");
//                return;
//            }
//
//            if (imageUri == null) {
//                showToast("Please upload a photo.");
//                return;
//            }
//
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            showToast("Account Created.");
//                            startActivity(new Intent(SignUp.this, SignIn.class));
//                            finish();
//                        } else {
//                            handleSignUpError(task);
//                        }
//                    });
//        });
//    }
//
//    private void openFileChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
//            uploadedImageView.setImageURI(imageUri);
//        }
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(SignUp.this, message, Toast.LENGTH_SHORT).show();
//        progressBar.setVisibility(View.GONE);
//    }
//
//    private void handleSignUpError(Task<AuthResult> task) {
//        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//            showToast("This email is already registered.");
//        } else {
//            showToast("Authentication failed.");
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//public class SignUp extends AppCompatActivity {
//
//    private static final int PICK_IMAGE_REQUEST = 1;
//
//    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact, editTextDistrict;
//    Spinner userTypeSpinner;
//    Button buttonReg, uploadPhotoButton;
//    ImageView uploadedImageView;
//    FirebaseAuth mAuth;
//    FirebaseFirestore db;
//    ProgressBar progressBar;
//    TextView textView;
//    Uri imageUri;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        mAuth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance(); // Initialize Firestore
//
//        // Initialize views
//        editTextEmail = findViewById(R.id.signUp_email);
//        editTextPassword = findViewById(R.id.signUp_password);
//        editTextName = findViewById(R.id.signUp_name);
//        editTextContact = findViewById(R.id.signUp_contact);
//        editTextDistrict = findViewById(R.id.signUp_district);
//        userTypeSpinner = findViewById(R.id.user_type_spinner);
//        buttonReg = findViewById(R.id.signUp_pg_btn);
//        uploadPhotoButton = findViewById(R.id.upload_photo_btn);
//        uploadedImageView = findViewById(R.id.uploaded_image_view);
//        progressBar = findViewById(R.id.signUp_prog_bar);
//        textView = findViewById(R.id.askToSignIn);
//
//        // Populate the user type dropdown
//        String[] userTypes = {"Customer", "Driver", "Guide", "Hotel"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userTypes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        userTypeSpinner.setAdapter(adapter);
//
//        textView.setOnClickListener(view -> {
//            startActivity(new Intent(getApplicationContext(), SignIn.class));
//            finish();
//        });
//
//        uploadPhotoButton.setOnClickListener(view -> openFileChooser());
//
//        buttonReg.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String name = editTextName.getText().toString().trim();
//            String contact = editTextContact.getText().toString().trim();
//            String district = editTextDistrict.getText().toString().trim();
//            String userType = userTypeSpinner.getSelectedItem().toString();
//            String email = editTextEmail.getText().toString().trim();
//            String password = editTextPassword.getText().toString().trim();
//
//            if (TextUtils.isEmpty(name)) {
//                showToast("Enter Name");
//                return;
//            }
//
//            if (TextUtils.isEmpty(contact)) {
//                showToast("Enter Contact Number");
//                return;
//            }
//
//            if (TextUtils.isEmpty(district)) {
//                showToast("Enter Your District");
//                return;
//            }
//
//            if (TextUtils.isEmpty(userType)) {
//                showToast("Select User Type");
//                return;
//            }
//
//            if (TextUtils.isEmpty(email)) {
//                showToast("Enter Email");
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                showToast("Enter Password");
//                return;
//            }
//
//            if (imageUri == null) {
//                showToast("Please upload a photo.");
//                return;
//            }
//
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            if (user != null) {
//                                saveUserDetails(user.getUid(), name, contact, district,userType);
//                            }
//                        } else {
//                            handleSignUpError(task);
//                        }
//                    });
//        });
//    }
//
//    private void saveUserDetails(String uid, String name, String contact, String district, String userType) {
//        User user = new User(name, contact, district,userType);
//        db.collection("users").document(uid).set(user)
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        showToast("Account Created.");
//                        startActivity(new Intent(SignUp.this, SignIn.class));
//                        finish();
//                    } else {
//                        showToast("Failed to save user details.");
//                    }
//                });
//    }
//
//    private void openFileChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
//            uploadedImageView.setImageURI(imageUri);
//        }
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(SignUp.this, message, Toast.LENGTH_SHORT).show();
//        progressBar.setVisibility(View.GONE);
//    }
//
//    private void handleSignUpError(Task<AuthResult> task) {
//        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//            showToast("This email is already registered.");
//        } else {
//            showToast("Authentication failed.");
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SignUp extends AppCompatActivity {
//
//    private static final int PICK_IMAGE_REQUEST = 1;
//
//    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact, editTextDistrict;
//    Spinner userTypeSpinner;
//    Button buttonReg, uploadPhotoButton;
//    ImageView uploadedImageView;
//    FirebaseAuth mAuth;
//    FirebaseFirestore db;
//    FirebaseStorage storage;
//    StorageReference storageReference;
//    ProgressBar progressBar;
//    TextView textView;
//    Uri imageUri;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        mAuth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance(); // Initialize Firestore
//        storage = FirebaseStorage.getInstance(); // Initialize Firebase Storage
//        storageReference = storage.getReference(); // Get a reference to Firebase Storage
//
//        // Initialize views
//        editTextEmail = findViewById(R.id.signUp_email);
//        editTextPassword = findViewById(R.id.signUp_password);
//        editTextName = findViewById(R.id.signUp_name);
//        editTextContact = findViewById(R.id.signUp_contact);
//        editTextDistrict = findViewById(R.id.signUp_district);
//        userTypeSpinner = findViewById(R.id.user_type_spinner);
//        buttonReg = findViewById(R.id.signUp_pg_btn);
//        uploadPhotoButton = findViewById(R.id.upload_photo_btn);
//        uploadedImageView = findViewById(R.id.uploaded_image_view);
//        progressBar = findViewById(R.id.signUp_prog_bar);
//        textView = findViewById(R.id.askToSignIn);
//
//        // Populate the user type dropdown
//        String[] userTypes = {"Customer", "Driver", "Guide", "Hotel"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userTypes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        userTypeSpinner.setAdapter(adapter);
//
//        textView.setOnClickListener(view -> {
//            startActivity(new Intent(getApplicationContext(), SignIn.class));
//            finish();
//        });
//
//        uploadPhotoButton.setOnClickListener(view -> openFileChooser());
//
//        buttonReg.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String name = editTextName.getText().toString().trim();
//            String contact = editTextContact.getText().toString().trim();
//            String district = editTextDistrict.getText().toString().trim();
//            String userType = userTypeSpinner.getSelectedItem().toString();
//            String email = editTextEmail.getText().toString().trim();
//            String password = editTextPassword.getText().toString().trim();
//
//            if (TextUtils.isEmpty(name)) {
//                showToast("Enter Name");
//                return;
//            }
//
//            if (TextUtils.isEmpty(contact)) {
//                showToast("Enter Contact Number");
//                return;
//            }
//
//            if (TextUtils.isEmpty(district)) {
//                showToast("Enter Your District");
//                return;
//            }
//
//            if (TextUtils.isEmpty(userType)) {
//                showToast("Select User Type");
//                return;
//            }
//
//            if (TextUtils.isEmpty(email)) {
//                showToast("Enter Email");
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                showToast("Enter Password");
//                return;
//            }
//
//            if (imageUri == null) {
//                showToast("Please upload a photo.");
//                return;
//            }
//
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            if (user != null) {
//                                uploadImageAndSaveUserDetails(user.getUid(), name, contact, district, userType);
//                            }
//                        } else {
//                            handleSignUpError(task);
//                        }
//                    });
//        });
//    }
//
//    private void uploadImageAndSaveUserDetails(String uid, String name, String contact, String district, String userType) {
//        // Create a storage reference
//        StorageReference fileRef = storageReference.child("profile_images/" + uid + ".jpg");
//
//        // Upload the image
//        UploadTask uploadTask = fileRef.putFile(imageUri);
//
//        uploadTask.addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                fileRef.getDownloadUrl().addOnCompleteListener(urlTask -> {
//                    if (urlTask.isSuccessful()) {
//                        String imageUrl = urlTask.getResult().toString();
//                        saveUserDetails(uid, name, contact, district, userType, imageUrl);
//                    } else {
//                        showToast("Failed to get image URL.");
//                    }
//                });
//            } else {
//                showToast("Failed to upload image.");
//            }
//        });
//    }
//
//    private void saveUserDetails(String uid, String name, String contact, String district, String userType, String imageUrl) {
//        Map<String, Object> user = new HashMap<>();
//        user.put("name", name);
//        user.put("contact", contact);
//        user.put("district", district);
//        user.put("userType", userType);
//        user.put("imageUrl", imageUrl);
//
//        db.collection("users").document(uid).set(user)
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        showToast("Account Created.");
//                        startActivity(new Intent(SignUp.this, SignIn.class));
//                        finish();
//                    } else {
//                        showToast("Failed to save user details.");
//                    }
//                });
//    }
//
//    private void openFileChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
//            uploadedImageView.setImageURI(imageUri);
//        }
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(SignUp.this, message, Toast.LENGTH_SHORT).show();
//        progressBar.setVisibility(View.GONE);
//    }
//
//    private void handleSignUpError(Task<AuthResult> task) {
//        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//            showToast("This email is already registered.");
//        } else {
//            showToast("Authentication failed.");
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SignUp extends AppCompatActivity {
//
//    private static final int PICK_IMAGE_REQUEST = 1;
//
//    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact, editTextDistrict;
//    Spinner userTypeSpinner;
//    Button buttonReg, uploadPhotoButton;
//    ImageView uploadedImageView;
//    FirebaseAuth mAuth;
//    FirebaseFirestore db;
//    FirebaseStorage storage;
//    StorageReference storageReference;
//    ProgressBar progressBar;
//    TextView textView;
//    Uri imageUri;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        mAuth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance(); // Initialize Firestore
//        storage = FirebaseStorage.getInstance(); // Initialize Firebase Storage
//        storageReference = storage.getReference(); // Get a reference to Firebase Storage
//
//        // Initialize views
//        editTextEmail = findViewById(R.id.signUp_email);
//        editTextPassword = findViewById(R.id.signUp_password);
//        editTextName = findViewById(R.id.signUp_name);
//        editTextContact = findViewById(R.id.signUp_contact);
//        editTextDistrict = findViewById(R.id.signUp_district);
//        userTypeSpinner = findViewById(R.id.user_type_spinner);
//        buttonReg = findViewById(R.id.signUp_pg_btn);
//        uploadPhotoButton = findViewById(R.id.upload_photo_btn);
//        uploadedImageView = findViewById(R.id.uploaded_image_view);
//        progressBar = findViewById(R.id.signUp_prog_bar);
//        textView = findViewById(R.id.askToSignIn);
//
//        // Populate the user type dropdown
//        String[] userTypes = {"Customer", "Driver", "Guide", "Hotel"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userTypes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        userTypeSpinner.setAdapter(adapter);
//
//        textView.setOnClickListener(view -> {
//            startActivity(new Intent(getApplicationContext(), SignIn.class));
//            finish();
//        });
//
//        uploadPhotoButton.setOnClickListener(view -> openFileChooser());
//
//        buttonReg.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String name = editTextName.getText().toString().trim();
//            String contact = editTextContact.getText().toString().trim();
//            String district = editTextDistrict.getText().toString().trim();
//            String userType = userTypeSpinner.getSelectedItem().toString();
//            String email = editTextEmail.getText().toString().trim();
//            String password = editTextPassword.getText().toString().trim();
//
//            if (TextUtils.isEmpty(name)) {
//                showToast("Enter Name");
//                return;
//            }
//
//            if (TextUtils.isEmpty(contact)) {
//                showToast("Enter Contact Number");
//                return;
//            }
//
//            if (TextUtils.isEmpty(district)) {
//                showToast("Enter Your District");
//                return;
//            }
//
//            if (TextUtils.isEmpty(userType)) {
//                showToast("Select User Type");
//                return;
//            }
//
//            if (TextUtils.isEmpty(email)) {
//                showToast("Enter Email");
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                showToast("Enter Password");
//                return;
//            }
//
//            if (imageUri == null) {
//                showToast("Please upload a photo.");
//                return;
//            }
//
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            if (user != null) {
//                                uploadImageAndSaveUserDetails(user.getUid(), name, contact, district, userType);
//                            }
//                        } else {
//                            handleSignUpError(task);
//                        }
//                    });
//        });
//    }
//
//    private void uploadImageAndSaveUserDetails(String uid, String name, String contact, String district, String userType) {
//        if (imageUri != null) {
//            // Create a storage reference
//            StorageReference fileRef = storageReference.child("profile_images/" + uid + ".jpg");
//
//            // Upload the image
//            UploadTask uploadTask = fileRef.putFile(imageUri);
//
//            uploadTask.addOnCompleteListener(task -> {
//                if (task.isSuccessful()) {
//                    fileRef.getDownloadUrl().addOnCompleteListener(urlTask -> {
//                        if (urlTask.isSuccessful()) {
//                            String imageUrl = urlTask.getResult().toString();
//                            saveUserDetails(uid, name, contact, district, userType, imageUrl);
//                        } else {
//                            showToast("Failed to get image URL.");
//                        }
//                    });
//                } else {
//                    showToast("Failed to upload image.");
//                }
//            }).addOnFailureListener(e -> showToast("Image upload failed: " + e.getMessage()));
//        } else {
//            showToast("No image selected");
//        }
//    }
//
//    private void saveUserDetails(String uid, String name, String contact, String district, String userType, String imageUrl) {
//        Map<String, Object> user = new HashMap<>();
//        user.put("name", name);
//        user.put("contact", contact);
//        user.put("district", district);
//        user.put("userType", userType);
//        user.put("imageUrl", imageUrl);
//
//        db.collection("users").document(uid).set(user)
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        showToast("Account Created.");
//                        startActivity(new Intent(SignUp.this, SignIn.class));
//                        finish();
//                    } else {
//                        showToast("Failed to save user details.");
//                    }
//                });
//    }
//
//    private void openFileChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
//            uploadedImageView.setImageURI(imageUri);
//        }
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(SignUp.this, message, Toast.LENGTH_SHORT).show();
//        progressBar.setVisibility(View.GONE);
//    }
//
//    private void handleSignUpError(Task<AuthResult> task) {
//        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//            showToast("This email is already registered.");
//        } else {
//            showToast("Authentication failed.");
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//public class SignUp extends AppCompatActivity {
//
//    private static final int PICK_IMAGE_REQUEST = 1;
//
//    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact, editTextDistrict;
//    Spinner userTypeSpinner;
//    Button buttonReg, uploadPhotoButton;
//    ImageView uploadedImageView;
//    FirebaseAuth mAuth;
//    FirebaseFirestore db;
//    ProgressBar progressBar;
//    TextView textView;
//    Uri imageUri;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        mAuth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance(); // Initialize Firestore
//
//        // Initialize views
//        editTextEmail = findViewById(R.id.signUp_email);
//        editTextPassword = findViewById(R.id.signUp_password);
//        editTextName = findViewById(R.id.signUp_name);
//        editTextContact = findViewById(R.id.signUp_contact);
//        editTextDistrict = findViewById(R.id.signUp_district);
//        userTypeSpinner = findViewById(R.id.user_type_spinner);
//        buttonReg = findViewById(R.id.signUp_pg_btn);
//        uploadPhotoButton = findViewById(R.id.upload_photo_btn);
//        uploadedImageView = findViewById(R.id.uploaded_image_view);
//        progressBar = findViewById(R.id.signUp_prog_bar);
//        textView = findViewById(R.id.askToSignIn);
//
//        // Populate the user type dropdown
//        String[] userTypes = {"Customer", "Driver", "Guide", "Hotel"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userTypes);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        userTypeSpinner.setAdapter(adapter);
//
//        textView.setOnClickListener(view -> {
//            startActivity(new Intent(getApplicationContext(), SignIn.class));
//            finish();
//        });
//
//        //uploadPhotoButton.setOnClickListener(view -> openFileChooser());
//
//        buttonReg.setOnClickListener(view -> {
//            progressBar.setVisibility(View.VISIBLE);
//            String name = editTextName.getText().toString().trim();
//            String contact = editTextContact.getText().toString().trim();
//            String district = editTextDistrict.getText().toString().trim();
//            String userType = userTypeSpinner.getSelectedItem().toString();
//            String email = editTextEmail.getText().toString().trim();
//            String password = editTextPassword.getText().toString().trim();
//
//            if (TextUtils.isEmpty(name)) {
//                showToast("Enter Name");
//                return;
//            }
//
//            if (TextUtils.isEmpty(contact)) {
//                showToast("Enter Contact Number");
//                return;
//            }
//
//            if (TextUtils.isEmpty(district)) {
//                showToast("Enter Your District");
//                return;
//            }
//
//            if (TextUtils.isEmpty(userType)) {
//                showToast("Select User Type");
//                return;
//            }
//
//            if (TextUtils.isEmpty(email)) {
//                showToast("Enter Email");
//                return;
//            }
//
//            if (TextUtils.isEmpty(password)) {
//                showToast("Enter Password");
//                return;
//            }
//
//            if (imageUri == null) {
//                showToast("Please upload a photo.");
//                return;
//            }
//
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(task -> {
//                        progressBar.setVisibility(View.GONE);
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            if (user != null) {
//                                // Save user details including email and password
//                                saveUserDetails(user.getUid(), name, contact, district, userType, email, password);
//                            }
//                        } else {
//                            handleSignUpError(task);
//                        }
//                    });
//        });
//    }
//
//    private void saveUserDetails(String uid, String name, String contact, String district, String userType, String email, String password) {
//        // Include email and password in the User object
//        User user = new User(name, contact, district, userType, email, password);
//        db.collection("users").document(uid).set(user)
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        showToast("Account Created.");
//                        startActivity(new Intent(SignUp.this, SignIn.class));
//                        finish();
//                    } else {
//                        showToast("Failed to save user details.");
//                    }
//                });
//    }
//
//    private void openFileChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
//            uploadedImageView.setImageURI(imageUri);
//        }
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(SignUp.this, message, Toast.LENGTH_SHORT).show();
//        progressBar.setVisibility(View.GONE);
//    }
//
//    private void handleSignUpError(Task<AuthResult> task) {
//        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//            showToast("This email is already registered.");
//        } else {
//            showToast("Authentication failed.");
//        }
//    }
//}
package com.example.travelmate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUp extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    TextInputEditText editTextEmail, editTextPassword, editTextName, editTextContact, editTextDistrict;
    Spinner userTypeSpinner;
    Button buttonReg, uploadPhotoButton;
    //ImageView uploadedImageView;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    ProgressBar progressBar;
    TextView textView;
    //Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance(); // Initialize Firestore

        // Initialize views
        editTextEmail = findViewById(R.id.signUp_email);
        editTextPassword = findViewById(R.id.signUp_password);
        editTextName = findViewById(R.id.signUp_name);
        editTextContact = findViewById(R.id.signUp_contact);
        editTextDistrict = findViewById(R.id.signUp_district);
        userTypeSpinner = findViewById(R.id.user_type_spinner);
        buttonReg = findViewById(R.id.signUp_pg_btn);
        //uploadPhotoButton = findViewById(R.id.upload_photo_btn);
        //uploadedImageView = findViewById(R.id.uploaded_image_view);
        progressBar = findViewById(R.id.signUp_prog_bar);
        textView = findViewById(R.id.askToSignIn);

        // Populate the user type dropdown
        String[] userTypes = {"Customer", "Driver", "Guide", "Hotel"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(adapter);

        textView.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), SignIn.class));
            finish();
        });

        //uploadPhotoButton.setOnClickListener(view -> openFileChooser());

        buttonReg.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            String name = editTextName.getText().toString().trim();
            String contact = editTextContact.getText().toString().trim();
            String district = editTextDistrict.getText().toString().trim();
            String userType = userTypeSpinner.getSelectedItem().toString();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (TextUtils.isEmpty(name)) {
                showToast("Enter Name");
                return;
            }

            if (TextUtils.isEmpty(contact)) {
                showToast("Enter Contact Number");
                return;
            }

            if (TextUtils.isEmpty(district)) {
                showToast("Enter Your District");
                return;
            }

            if (TextUtils.isEmpty(userType)) {
                showToast("Select User Type");
                return;
            }

            if (TextUtils.isEmpty(email)) {
                showToast("Enter Email");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                showToast("Enter Password");
                return;
            }

//            if (imageUri == null) {
//                showToast("Please upload a photo.");
//                return;
//            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Save user details including email and password
                                saveUserDetails(user.getUid(), name, contact, district, userType, email, password);
                            }
                        } else {
                            handleSignUpError(task);
                        }
                    });
        });
    }

    private void saveUserDetails(String uid, String name, String contact, String district, String userType, String email, String password) {
        // Include email and password in the User object
        User user = new User(name, contact, district, userType, email, password);
        db.collection("users").document(uid).set(user)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        showToast("Account Created.");
                        startActivity(new Intent(SignUp.this, SignIn.class));
                        finish();
                    } else {
                        showToast("Failed to save user details.");
                    }
                });
    }

//    private void openFileChooser() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
//            uploadedImageView.setImageURI(imageUri);
//        }
//    }

    private void showToast(String message) {
        Toast.makeText(SignUp.this, message, Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    private void handleSignUpError(Task<AuthResult> task) {
        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
            showToast("This email is already registered.");
        } else {
            showToast("Authentication failed.");
        }
    }
}

