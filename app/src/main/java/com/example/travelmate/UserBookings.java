//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//
//import java.util.ArrayList;
//
//public class UserBookings extends AppCompatActivity {
//
//    private ListView myBookingsListView;
//    private ArrayAdapter<String> adapter;
//    private ArrayList<String> bookingStatusList = new ArrayList<>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_user_bookings);
//
//        myBookingsListView = findViewById(R.id.myBookingsListView);
//
//        // Initialize adapter and attach it to the ListView
//        adapter = new ArrayAdapter<>(this, R.layout.item_user_bookings, R.id.bookingStatusTextView, bookingStatusList);
//        myBookingsListView.setAdapter(adapter);
//
//        // Fetch and display bookings
//        fetchMyBookings();
//    }
//
//    private void fetchMyBookings() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String currentUserEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        db.collection("users")
//                .document(currentUserEmail)
//                .collection("MyBookings")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String status = document.getString("status"); // "pending", "accepted", "rejected"
//                            String providerEmail = document.getString("providerEmail");
//                            bookingStatusList.add("Your request to " + providerEmail + " is " + status);
//                        }
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(UserBookings.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//}
//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//
//import java.util.ArrayList;
//
//public class UserBookings extends AppCompatActivity {
//
//    private ListView myBookingsListView;
//    private ArrayAdapter<String> adapter;
//    private ArrayList<String> bookingStatusList = new ArrayList<>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_user_bookings);
//
//        myBookingsListView = findViewById(R.id.myBookingsListView);
//
//        // Initialize adapter and attach it to the ListView
//        adapter = new ArrayAdapter<>(this, R.layout.item_user_bookings, R.id.bookingStatusTextView, bookingStatusList);
//        myBookingsListView.setAdapter(adapter);
//
//        // Fetch and display bookings
//        fetchMyBookings();
//    }
//
//    private void fetchMyBookings() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String currentUserEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        db.collection("users")
//                .document(currentUserEmail)
//                .collection("MyBookings")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String status = document.getString("status"); // "pending", "accepted", "rejected"
//                            String providerEmail = document.getString("providerEmail");
//                            bookingStatusList.add("Your request to " + providerEmail + " is " + status);
//                        }
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(UserBookings.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//}
//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//
//import java.util.ArrayList;
//
//public class UserBookings extends AppCompatActivity {
//
//    private ListView myBookingsListView;
//    private ArrayAdapter<String> adapter;
//    private ArrayList<String> bookingStatusList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_bookings);
//
//        myBookingsListView = findViewById(R.id.myBookingsListView);
//
//        // Initialize adapter and attach it to the ListView
//        adapter = new ArrayAdapter<>(this, R.layout.item_user_bookings, R.id.bookingStatusTextView, bookingStatusList);
//        myBookingsListView.setAdapter(adapter);
//
//        // Fetch and display bookings
//        fetchMyBookings();
//    }
//
//    private void fetchMyBookings() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String currentUserEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        db.collection("users")
//                .document(currentUserEmail)
//                .collection("MyBookings")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        bookingStatusList.clear(); // Clear the list before adding new bookings
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String status = document.getString("status"); // "pending", "accepted", "rejected"
//                            String providerEmail = document.getString("providerEmail");
//                            bookingStatusList.add("Your request to " + providerEmail + " is " + status);
//                        }
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(UserBookings.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//}

package com.example.travelmate;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class UserBookings extends AppCompatActivity {

    private ListView myBookingsListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> bookingStatusList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bookings);

        myBookingsListView = findViewById(R.id.myBookingsListView);

        // Initialize adapter and attach it to the ListView
        adapter = new ArrayAdapter<>(this, R.layout.item_user_bookings, R.id.bookingStatusTextView, bookingStatusList);
        myBookingsListView.setAdapter(adapter);

        // Fetch and display bookings
        fetchMyBookings();
    }

    private void fetchMyBookings() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String currentUserEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        // Query the bookingDetails collection where requesterEmail matches the current user's email
        db.collection("bookingDetails")
                .whereEqualTo("requesterEmail", currentUserEmail)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        bookingStatusList.clear(); // Clear the list before adding new bookings
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String status = document.getString("status"); // "pending", "accepted", "rejected"
                            String providerEmail = document.getString("providerEmail");
                            bookingStatusList.add("Your request to " + providerEmail + " is " + status);
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(UserBookings.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}