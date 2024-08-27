//package com.example.travelmate;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class UserDriverView extends AppCompatActivity {
//
//    private ImageView userDetailImage;
//    private TextView userDetailName;
//    private TextView userDetailDistrict;
//    private TextView userDetailContact;
//    private TextView userDetailEmail;
//    private Button tripReqButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_user_driver_view);
//
//        userDetailImage = findViewById(R.id.user_detail_image);
//        userDetailName = findViewById(R.id.user_detail_name);
//        userDetailDistrict = findViewById(R.id.user_detail_district);
//        userDetailContact = findViewById(R.id.user_detail_contact);
//        userDetailEmail = findViewById(R.id.user_detail_email);
//        tripReqButton = findViewById(R.id.trip_req_btn);
//
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("userName");
//        String district = intent.getStringExtra("userDistrict");
//        String contact = intent.getStringExtra("userContact");
//        String providerEmail = intent.getStringExtra("userEmail");
//
//        userDetailName.setText(name);
//        userDetailDistrict.setText(district);
//        userDetailContact.setText(contact);
//        userDetailEmail.setText(providerEmail);
//
//        // Optionally, set the image resource based on user type or other criteria
//        userDetailImage.setImageResource(R.drawable.acc);
//
//        tripReqButton.setOnClickListener(v -> {
//            Intent requestIntent = new Intent(UserDriverView.this, RequestForm.class);
////            requestIntent.putExtra("providerEmail", providerEmail);
//            startActivity(requestIntent);
//        });
//    }
//}
//
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//public class UserDriverView extends AppCompatActivity {
//
//    private ImageView userDetailImage;
//    private TextView userDetailName;
//    private TextView userDetailDistrict;
//    private TextView userDetailContact;
//    private TextView userDetailEmail;
//    private Button tripReqButton;
//    private FirebaseFirestore db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_driver_view);
//
//        userDetailImage = findViewById(R.id.user_detail_image);
//        userDetailName = findViewById(R.id.user_detail_name);
//        userDetailDistrict = findViewById(R.id.user_detail_district);
//        userDetailContact = findViewById(R.id.user_detail_contact);
//        userDetailEmail = findViewById(R.id.user_detail_email);
//        tripReqButton = findViewById(R.id.trip_req_btn);
//
//        db = FirebaseFirestore.getInstance();
//
//        // Retrieve the email from the intent
//        Intent intent = getIntent();
//        String providerEmail = intent.getStringExtra("userEmail");
//
//        if (providerEmail != null) {
//            // Fetch user details from Firestore using email
//            db.collection("users")
//                    .whereEqualTo("email", providerEmail)
//                    .get()
//                    .addOnCompleteListener(task -> {
//                        if (task.isSuccessful() && !task.getResult().isEmpty()) {
//                            DocumentSnapshot document = task.getResult().getDocuments().get(0);
//                            String name = document.getString("name");
//                            String district = document.getString("district");
//                            String contact = document.getString("contact");
//                            String email = document.getString("email");
//
//                            // Set retrieved data to the TextViews
//                            userDetailName.setText(name);
//                            userDetailDistrict.setText(district);
//                            userDetailContact.setText(contact);
//                            userDetailEmail.setText(email);
//
//                            // Optionally, set the image resource based on user type or other criteria
//                            userDetailImage.setImageResource(R.drawable.acc);
//
//                            // Handle button click
//                            tripReqButton.setOnClickListener(v -> {
//                                Intent requestIntent = new Intent(UserDriverView.this, RequestForm.class);
//                                requestIntent.putExtra("providerEmail", email); // Pass email to RequestForm
//                                startActivity(requestIntent);
//                            });
//
//                        } else {
//                            Log.d("UserDriverView", "No such document or empty result.");
//                        }
//                    })
//                    .addOnFailureListener(e -> {
//                        Log.d("UserDriverView", "Error getting documents: ", e);
//                    });
//        } else {
//            Log.d("UserDriverView", "No email provided");
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class UserDriverView extends AppCompatActivity {
//
//    private ImageView userDetailImage;
//    private TextView userDetailName;
//    private TextView userDetailDistrict;
//    private TextView userDetailContact;
//    private TextView userDetailEmail;
//    private Button tripRequestButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_driver_view);
//
//        userDetailImage = findViewById(R.id.user_detail_image);
//        userDetailName = findViewById(R.id.user_detail_name);
//        userDetailDistrict = findViewById(R.id.user_detail_district);
//        userDetailContact = findViewById(R.id.user_detail_contact);
//        userDetailEmail = findViewById(R.id.user_detail_email);
//        tripRequestButton = findViewById(R.id.trip_req_btn);
//
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("userName");
//        String district = intent.getStringExtra("userDistrict");
//        String contact = intent.getStringExtra("userContact");
//        String email = intent.getStringExtra("userEmail");
//
//        userDetailName.setText(name);
//        userDetailDistrict.setText(district);
//        userDetailContact.setText(contact);
//        userDetailEmail.setText(email);
//
//        // Set default image
//        userDetailImage.setImageResource(R.drawable.acc); // Replace with your default image resource
//
//        tripRequestButton.setOnClickListener(v -> {
//            Intent requestIntent = new Intent(UserDriverView.this, RequestForm.class);
//            requestIntent.putExtra("userName", name);
//            requestIntent.putExtra("userEmail", email);
//            startActivity(requestIntent);
//        });
//    }
//}
package com.example.travelmate;

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
    private TextView userDetailEmail;
    private Button tripRequestButton;
    private Button confirmedBookingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_driver_view);

        userDetailImage = findViewById(R.id.user_detail_image);
        userDetailName = findViewById(R.id.user_detail_name);
        userDetailDistrict = findViewById(R.id.user_detail_district);
        userDetailContact = findViewById(R.id.user_detail_contact);
        userDetailEmail = findViewById(R.id.user_detail_email);
        tripRequestButton = findViewById(R.id.trip_req_btn);
        confirmedBookingsButton = findViewById(R.id.confirmed_bookings_btn);

        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");
        String district = intent.getStringExtra("userDistrict");
        String contact = intent.getStringExtra("userContact");
        String email = intent.getStringExtra("userEmail");

        userDetailName.setText(name);
        userDetailDistrict.setText(district);
        userDetailContact.setText(contact);
        userDetailEmail.setText(email);

        // Set default image
        userDetailImage.setImageResource(R.drawable.acc); // Replace with your default image resource

        tripRequestButton.setOnClickListener(v -> {
            Intent requestIntent = new Intent(UserDriverView.this, RequestForm.class);
            requestIntent.putExtra("userName", name);
            requestIntent.putExtra("userEmail", email);
            startActivity(requestIntent);
        });

        confirmedBookingsButton.setOnClickListener(v -> {
            Intent confirmedBookingsIntent = new Intent(UserDriverView.this, ProviderConfirmedBookings.class);
            startActivity(confirmedBookingsIntent);
        });
    }
}