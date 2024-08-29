//package com.example.travelmate;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
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
//public class ProviderConfirmedBookings extends AppCompatActivity {
//
//    private ListView confirmedBookingsListView;
//    private ArrayList<BookingDetails> confirmedList = new ArrayList<>();
//    private FirebaseFirestore db;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_confirmed_bookings);
//
//        confirmedBookingsListView = findViewById(R.id.confirmedBookingsListView);
//
//        // Initialize Firestore and get the provider's email
//        db = FirebaseFirestore.getInstance();
//        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        // Fetch and display confirmed bookings
//        fetchConfirmedBookings();
//    }
//
//    private void fetchConfirmedBookings() {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("ConfirmedBookings")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        confirmedList.clear(); // Clear the list before adding new confirmed bookings
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            BookingDetails booking = document.toObject(BookingDetails.class);
//                            confirmedList.add(booking);
//                        }
//
//                        // Set the adapter
//                        ConfirmedAdapter adapter = new ConfirmedAdapter(this, confirmedList);
//                        confirmedBookingsListView.setAdapter(adapter);
//
//                    } else {
//                        Toast.makeText(ProviderConfirmedBookings.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private class ConfirmedAdapter extends ArrayAdapter<BookingDetails> {
//        private final Context context;
//        private final ArrayList<BookingDetails> confirmedBookings;
//
//        public ConfirmedAdapter(Context context, ArrayList<BookingDetails> confirmedBookings) {
//            super(context, 0, confirmedBookings);
//            this.context = context;
//            this.confirmedBookings = confirmedBookings;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(context).inflate(R.layout.item_provider_confirmed_bookings, parent, false);
//            }
//
//            BookingDetails booking = getItem(position);
//
//            TextView requesterNameTextView = convertView.findViewById(R.id.confirmedRequesterNameTextView);
//            TextView fromDateTextView = convertView.findViewById(R.id.confirmedFromDateTextView);
//            TextView toDateTextView = convertView.findViewById(R.id.confirmedToDateTextView);
//            TextView requesterContactTextView = convertView.findViewById(R.id.confirmedRequesterContactTextView);
//
//            if (booking != null) {
//                requesterNameTextView.setText("Name: " + booking.getRequesterName());
//                fromDateTextView.setText("From: " + booking.getFromDate());
//                toDateTextView.setText("To: " + booking.getToDate());
//                requesterContactTextView.setText("Contact: " + booking.getRequesterContact());
//            }
//
//            return convertView;
//        }
//    }
//}
package com.example.travelmate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

//public class ProviderConfirmedBookings extends AppCompatActivity {
//
//    private ListView confirmedBookingsListView;
//    private ArrayList<BookingDetails> confirmedBookingsList = new ArrayList<>();
//    private FirebaseFirestore db;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_new_requests); // Reuse the same layout
//
//        confirmedBookingsListView = findViewById(R.id.newRequestsListView); // Reuse the same ListView ID
//
//        // Initialize Firestore and get the provider's email
//        db = FirebaseFirestore.getInstance();
//        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        // Fetch and display confirmed bookings
//        fetchConfirmedBookings();
//    }
//
//    private void fetchConfirmedBookings() {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests") // Fetch from NewRequests for demonstration
//                .whereEqualTo("status", "Accepted") // Filter only accepted bookings
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        confirmedBookingsList.clear(); // Clear the list before adding new bookings
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            BookingDetails booking = document.toObject(BookingDetails.class);
//                            confirmedBookingsList.add(booking);
//                        }
//
//                        // Set the adapter
//                        RequestAdapter adapter = new RequestAdapter(this, confirmedBookingsList, providerEmail);
//                        confirmedBookingsListView.setAdapter(adapter);
//
//                    } else {
//                        Toast.makeText(ProviderConfirmedBookings.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//}
public class ProviderConfirmedBookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_confirmed_bookings); // Use correct layout file

        ListView confirmedBookingsListView = findViewById(R.id.confirmedBookingsListView);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        ArrayList<BookingDetails> confirmedBookingsList = new ArrayList<>();
        ArrayAdapter<BookingDetails> adapter = new ArrayAdapter<BookingDetails>(this, R.layout.item_provider_confirmed_bookings, confirmedBookingsList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_provider_confirmed_bookings, parent, false);
                }
                TextView requesterNameTextView = convertView.findViewById(R.id.confirmedRequesterNameTextView);
                TextView fromDateTextView = convertView.findViewById(R.id.confirmedFromDateTextView);
                TextView toDateTextView = convertView.findViewById(R.id.confirmedToDateTextView);
                TextView contactTextView = convertView.findViewById(R.id.confirmedRequesterContactTextView);

                BookingDetails booking = getItem(position);

//                if (booking != null) {
//                    requesterNameTextView.setText(booking.getRequesterName());
//                    fromDateTextView.setText(booking.getFromDate());
//                    toDateTextView.setText(booking.getToDate());
//                    contactTextView.setText(booking.getRequesterContact());
//                }
                if (booking != null) {
                    // Set the text with the desired format
                    requesterNameTextView.setText("Requester Name: " + booking.getRequesterName());
                    fromDateTextView.setText("From: " + booking.getFromDate());
                    toDateTextView.setText("To: " + booking.getToDate());
                    contactTextView.setText("Contact No: " + booking.getRequesterContact());
                }
                return convertView;
            }
        };

        confirmedBookingsListView.setAdapter(adapter);

        // Fetch confirmed bookings for this provider
        db.collection("bookingDetails")
                .whereEqualTo("providerEmail", providerEmail)
                .whereEqualTo("status", "Accepted") // Filter for accepted bookings
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    confirmedBookingsList.clear();
                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        BookingDetails booking = document.toObject(BookingDetails.class);
                        confirmedBookingsList.add(booking);
                    }
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Failed to load confirmed bookings.", Toast.LENGTH_SHORT).show();
                });
    }
}