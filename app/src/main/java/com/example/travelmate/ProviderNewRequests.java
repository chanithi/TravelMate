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
//public class ProviderNewRequests extends AppCompatActivity {
//
//    private ListView newRequestsListView;
//    private ArrayAdapter<String> adapter;
//    private ArrayList<String> requestDetailsList = new ArrayList<>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_provider_new_requests);
//        newRequestsListView = findViewById(R.id.newRequestsListView);
//
//        // Initialize adapter and attach it to the ListView
//        adapter = new ArrayAdapter<>(this, R.layout.item_provider_new_requests, R.id.requesterNameTextView, requestDetailsList);
//        newRequestsListView.setAdapter(adapter);
//
//        // Fetch and display new requests
//        fetchNewRequests();
//    }
//
//    private void fetchNewRequests() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String requesterName = document.getString("requesterName");
//                            String fromDate = document.getString("fromDate");
//                            String toDate = document.getString("toDate");
//                            String requesterEmail = document.getString("requesterEmail");
//                            requestDetailsList.add(requesterName + " | " + fromDate + " - " + toDate + " | " + requesterEmail);
//                        }
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
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
//public class ProviderNewRequests extends AppCompatActivity {
//
//    private ListView newRequestsListView;
//    private ArrayAdapter<String> adapter;
//    private ArrayList<String> requestDetailsList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_new_requests);
//
//        newRequestsListView = findViewById(R.id.newRequestsListView);
//
//        // Initialize adapter and attach it to the ListView
//        adapter = new ArrayAdapter<>(this, R.layout.item_provider_new_requests, R.id.requesterNameTextView, requestDetailsList);
//        newRequestsListView.setAdapter(adapter);
//
//        // Fetch and display new requests
//        fetchNewRequests();
//    }
//
//    private void fetchNewRequests() {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String requesterName = document.getString("requesterName");
//                            String fromDate = document.getString("fromDate");
//                            String toDate = document.getString("toDate");
//                            String contact = document.getString("providerContact");
//
//                            String requestDetails = "Requester Name: " + requesterName +
//                                    "\nFrom Date: " + fromDate +
//                                    "\nTo Date: " + toDate +
//                                    "\nRequester Contact: " + contact;
//
//                            requestDetailsList.add(requestDetails);
//                        }
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//}
//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
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
//public class ProviderNewRequests extends AppCompatActivity {
//
//    private ListView newRequestsListView;
//    private ArrayAdapter<String> adapter;
//    private ArrayList<String> requestDetailsList = new ArrayList<>();
//    private FirebaseFirestore db;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_new_requests);
//
//        newRequestsListView = findViewById(R.id.newRequestsListView);
//
//        // Initialize Firestore and get the provider's email
//        db = FirebaseFirestore.getInstance();
//        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        // Initialize adapter and attach it to the ListView
//        adapter = new ArrayAdapter<>(this, R.layout.item_provider_new_requests, R.id.requesterNameTextView, requestDetailsList);
//        newRequestsListView.setAdapter(adapter);
//
//        // Fetch and display new requests
//        fetchNewRequests();
//    }
//
//    private void fetchNewRequests() {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String requesterName = document.getString("requesterName");
//                            String fromDate = document.getString("fromDate");
//                            String toDate = document.getString("toDate");
//                            String contact = document.getString("providerContact");
//                            String docId = document.getId(); // Get the document ID
//
//                            String requestDetails = "Requester Name: " + requesterName +
//                                    "\nFrom Date: " + fromDate +
//                                    "\nTo Date: " + toDate +
//                                    "\nRequester Contact: " + contact;
//
//                            requestDetailsList.add(requestDetails);
//
//                            // Setup buttons for accept/reject
//                            Button acceptButton = findViewById(R.id.acceptButton);
//                            Button rejectButton = findViewById(R.id.rejectButton);
//
//                            acceptButton.setOnClickListener(v -> updateRequestStatus(docId, "accepted"));
//                            rejectButton.setOnClickListener(v -> updateRequestStatus(docId, "rejected"));
//                        }
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void updateRequestStatus(String docId, String status) {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .document(docId)
//                .update("status", status)
//                .addOnSuccessListener(aVoid -> {
//                    Toast.makeText(ProviderNewRequests.this, "Request " + status, Toast.LENGTH_SHORT).show();
//                    // Here, you can refresh the list or update the UI as needed
//                })
//                .addOnFailureListener(e -> Toast.makeText(ProviderNewRequests.this, "Error updating request", Toast.LENGTH_SHORT).show());
//    }
//}
//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
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
//public class ProviderNewRequests extends AppCompatActivity {
//
//    private ListView newRequestsListView;
//    private ArrayList<Request> requestList = new ArrayList<>();
//    private FirebaseFirestore db;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_new_requests);
//
//        newRequestsListView = findViewById(R.id.newRequestsListView);
//
//        // Initialize Firestore and get the provider's email
//        db = FirebaseFirestore.getInstance();
//        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        // Fetch and display new requests
//        fetchNewRequests();
//    }
//
//    private void fetchNewRequests() {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String requesterName = document.getString("requesterName");
//                            String fromDate = document.getString("fromDate");
//                            String toDate = document.getString("toDate");
//                            String contact = document.getString("providerContact");
//                            String docId = document.getId(); // Get the document ID
//
//                            Request request = new Request(requesterName, fromDate, toDate, contact, docId);
//                            requestList.add(request);
//                        }
//
//                        // Set the adapter
//                        RequestAdapter adapter = new RequestAdapter(requestList);
//                        newRequestsListView.setAdapter(adapter);
//
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private class RequestAdapter extends ArrayAdapter<Request> {
//        RequestAdapter(ArrayList<Request> requests) {
//            super(ProviderNewRequests.this, 0, requests);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_provider_new_requests, parent, false);
//            }
//
//            Request request = getItem(position);
//
//            TextView requesterNameTextView = convertView.findViewById(R.id.requesterNameTextView);
//            Button acceptButton = convertView.findViewById(R.id.acceptButton);
//            Button rejectButton = convertView.findViewById(R.id.rejectButton);
//
//            requesterNameTextView.setText(request.toString());
//
//            acceptButton.setOnClickListener(v -> updateRequestStatus(request.getDocId(), "accepted"));
//            rejectButton.setOnClickListener(v -> updateRequestStatus(request.getDocId(), "rejected"));
//
//            return convertView;
//        }
//    }
//
//    private void updateRequestStatus(String docId, String status) {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .document(docId)
//                .update("status", status)
//                .addOnSuccessListener(aVoid -> {
//                    Toast.makeText(ProviderNewRequests.this, "Request " + status, Toast.LENGTH_SHORT).show();
//                    // Here, you can refresh the list or update the UI as needed
//                })
//                .addOnFailureListener(e -> Toast.makeText(ProviderNewRequests.this, "Error updating request", Toast.LENGTH_SHORT).show());
//    }
//
//    // Create a Request class to hold request details
//    private static class Request {
//        private String requesterName;
//        private String fromDate;
//        private String toDate;
//        private String contact;
//        private String docId;
//
//        Request(String requesterName, String fromDate, String toDate, String contact, String docId) {
//            this.requesterName = requesterName;
//            this.fromDate = fromDate;
//            this.toDate = toDate;
//            this.contact = contact;
//            this.docId = docId;
//        }
//
//        public String getDocId() {
//            return docId;
//        }
//
//        @Override
//        public String toString() {
//            return "Requester Name: " + requesterName +
//                    "\nFrom Date: " + fromDate +
//                    "\nTo Date: " + toDate +
//                    "\nRequester Contact: " + contact;
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
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
//public class ProviderNewRequests extends AppCompatActivity {
//
//    private ListView newRequestsListView;
//    private ArrayList<Request> requestList = new ArrayList<>();
//    private FirebaseFirestore db;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_new_requests);
//
//        newRequestsListView = findViewById(R.id.newRequestsListView);
//
//        // Initialize Firestore and get the provider's email
//        db = FirebaseFirestore.getInstance();
//        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        // Fetch and display new requests
//        fetchNewRequests();
//    }
//
//    public void fetchNewRequests() {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        requestList.clear(); // Clear the list before adding new requests
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String requesterName = document.getString("requesterName");
//                            String fromDate = document.getString("fromDate");
//                            String toDate = document.getString("toDate");
//                            String contact = document.getString("providerContact");
//                            String docId = document.getId(); // Get the document ID
//
//                            Request request = new Request(requesterName, fromDate, toDate, contact, docId);
//                            requestList.add(request);
//                        }
//
//                        // Set the adapter
//                        RequestAdapter adapter = new RequestAdapter(requestList);
//                        newRequestsListView.setAdapter(adapter);
//
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void updateRequestStatus(String docId, String status) {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .document(docId)
//                .update("status", status)
//                .addOnSuccessListener(aVoid -> {
//                    Toast.makeText(ProviderNewRequests.this, "Request " + status, Toast.LENGTH_SHORT).show();
//                    fetchNewRequests(); // Refresh the list
//                    notifyUserOfStatusChange(docId, status); // Notify user of status change
//                })
//                .addOnFailureListener(e -> Toast.makeText(ProviderNewRequests.this, "Error updating request", Toast.LENGTH_SHORT).show());
//    }
//
//    public void notifyUserOfStatusChange(String requesterEmail, String status) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        // Access the user's bookings collection
//        db.collection("users")
//                .document(requesterEmail)
//                .collection("MyBookings")
//                .whereEqualTo("providerEmail", providerEmail)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String bookingId = document.getId();
//
//                            // Update the status of the booking
//                            db.collection("users")
//                                    .document(requesterEmail)
//                                    .collection("MyBookings")
//                                    .document(bookingId)
//                                    .update("status", status)
//                                    .addOnSuccessListener(aVoid -> {
//                                        Toast.makeText(ProviderNewRequests.this, "User notified of status change", Toast.LENGTH_SHORT).show();
//                                    })
//                                    .addOnFailureListener(e -> {
//                                        Toast.makeText(ProviderNewRequests.this, "Error notifying user", Toast.LENGTH_SHORT).show();
//                                    });
//                        }
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error fetching bookings: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private class RequestAdapter extends ArrayAdapter<Request> {
//        private final Context context;
//        private final ArrayList<Request> requests;
//
//        public RequestAdapter(Context context, ArrayList<Request> requests) {
//            super(context, 0, requests);
//            this.context = context;
//            this.requests = requests;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(context).inflate(R.layout.item_provider_new_requests, parent, false);
//            }
//
//            Request request = getItem(position);
//
//            TextView requesterNameTextView = convertView.findViewById(R.id.requesterNameTextView);
//            Button acceptButton = convertView.findViewById(R.id.acceptButton);
//            Button rejectButton = convertView.findViewById(R.id.rejectButton);
//
//            requesterNameTextView.setText(request.toString());
//
//            acceptButton.setOnClickListener(v -> {
//                // Update request status to accepted
//                updateRequestStatus(request.getDocId(), "accepted", request.getRequesterEmail());
//            });
//
//            rejectButton.setOnClickListener(v -> {
//                // Update request status to rejected
//                updateRequestStatus(request.getDocId(), "rejected", request.getRequesterEmail());
//            });
//
//            return convertView;
//        }
//
//        private void updateRequestStatus(String docId, String status, String requesterEmail) {
//            FirebaseFirestore db = FirebaseFirestore.getInstance();
//            String providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//            db.collection("users")
//                    .document(providerEmail)
//                    .collection("NewRequests")
//                    .document(docId)
//                    .update("status", status)
//                    .addOnSuccessListener(aVoid -> {
//                        // Notify the user of the status update
//                        ((ProviderNewRequests) context).fetchNewRequests();
//                        ((ProviderNewRequests) context).notifyUserOfStatusChange(requesterEmail, status);
//                    })
//                    .addOnFailureListener(e -> {
//                        Toast.makeText(context, "Error updating request", Toast.LENGTH_SHORT).show();
//                    });
//        }
//    }
//    }
//
//    public class Request {
//        private String requesterName;
//        private String fromDate;
//        private String toDate;
//        private String contact;
//        private String docId;
//        private String requesterEmail;
//
//        Request(String requesterName, String fromDate, String toDate, String contact, String docId,String requesterEmail) {
//            this.requesterName = requesterName;
//            this.fromDate = fromDate;
//            this.toDate = toDate;
//            this.contact = contact;
//            this.docId = docId;
//            this.requesterEmail = requesterEmail; // Initialize this field
//        }
//
//        public String getDocId() {
//            return docId;
//        }
//
//        public String getRequesterEmail() {
//            return requesterEmail; // Add getter for this field
//        }
//
//        @Override
//        public String toString() {
//            return "Requester Name: " + requesterName +
//                    "\nFrom Date: " + fromDate +
//                    "\nTo Date: " + toDate +
//                    "\nRequester Contact: " + contact;
//        }
//    }
//package com.example.travelmate;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
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
//public class ProviderNewRequests extends AppCompatActivity {
//
//    private ListView newRequestsListView;
//    private ArrayList<Request> requestList = new ArrayList<>();
//    private FirebaseFirestore db;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_new_requests);
//
//        newRequestsListView = findViewById(R.id.newRequestsListView);
//
//        // Initialize Firestore and get the provider's email
//        db = FirebaseFirestore.getInstance();
//        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        // Fetch and display new requests
//        fetchNewRequests();
//    }
//
//    public void fetchNewRequests() {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        requestList.clear(); // Clear the list before adding new requests
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String requesterName = document.getString("requesterName");
//                            String fromDate = document.getString("fromDate");
//                            String toDate = document.getString("toDate");
//                            String contact = document.getString("providerContact");
//                            String docId = document.getId(); // Get the document ID
//                            String requesterEmail = document.getString("requesterEmail"); // Get requester email
//
//                            Request request = new Request(requesterName, fromDate, toDate, contact, docId, requesterEmail);
//                            requestList.add(request);
//                        }
//
//                        // Set the adapter
//                        RequestAdapter adapter = new RequestAdapter(this, requestList);
//                        newRequestsListView.setAdapter(adapter);
//
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void updateRequestStatus(String docId, String status) {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .document(docId)
//                .update("status", status)
//                .addOnSuccessListener(aVoid -> {
//                    Toast.makeText(ProviderNewRequests.this, "Request " + status, Toast.LENGTH_SHORT).show();
//                    fetchNewRequests(); // Refresh the list
//                })
//                .addOnFailureListener(e -> Toast.makeText(ProviderNewRequests.this, "Error updating request", Toast.LENGTH_SHORT).show());
//    }
//
//    public void notifyUserOfStatusChange(String requesterEmail, String status) {
//        if (requesterEmail == null) {
//            Log.e("ProviderNewRequests", "Requester email is null. Cannot notify user of status change.");
//            Toast.makeText(this, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        db.collection("users")
//                .document(requesterEmail)
//                .collection("MyBookings")
//                .whereEqualTo("providerEmail", providerEmail)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String bookingId = document.getId();
//
//                            // Update the status of the booking
//                            db.collection("users")
//                                    .document(requesterEmail)
//                                    .collection("MyBookings")
//                                    .document(bookingId)
//                                    .update("status", status)
//                                    .addOnSuccessListener(aVoid -> {
//                                        Toast.makeText(ProviderNewRequests.this, "User notified of status change", Toast.LENGTH_SHORT).show();
//                                    })
//                                    .addOnFailureListener(e -> {
//                                        Toast.makeText(ProviderNewRequests.this, "Error notifying user", Toast.LENGTH_SHORT).show();
//                                    });
//                        }
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error fetching bookings: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private class RequestAdapter extends ArrayAdapter<Request> {
//        private final Context context;
//        private final ArrayList<Request> requests;
//
//        public RequestAdapter(Context context, ArrayList<Request> requests) {
//            super(context, 0, requests);
//            this.context = context;
//            this.requests = requests;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(context).inflate(R.layout.item_provider_new_requests, parent, false);
//            }
//
//            Request request = getItem(position);
//
//            TextView requesterNameTextView = convertView.findViewById(R.id.requesterNameTextView);
//            Button acceptButton = convertView.findViewById(R.id.acceptButton);
//            Button rejectButton = convertView.findViewById(R.id.rejectButton);
//
//            if (request != null) {
//                requesterNameTextView.setText(request.toString());
//
//                acceptButton.setOnClickListener(v -> {
//                    if (request.getRequesterEmail() == null) {
//                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    // Update request status to accepted
//                    updateRequestStatus(request.getDocId(), "accepted");
//                    notifyUserOfStatusChange(request.getRequesterEmail(), "accepted");
//                });
//
//                rejectButton.setOnClickListener(v -> {
//                    if (request.getRequesterEmail() == null) {
//                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    // Update request status to rejected
//                    updateRequestStatus(request.getDocId(), "rejected");
//                    notifyUserOfStatusChange(request.getRequesterEmail(), "rejected");
//                });
//            }
//
//            return convertView;
//        }
//    }
//    public class Request {
//        private String requesterName;
//        private String fromDate;
//        private String toDate;
//        private String contact;
//        private String docId;
//        private String requesterEmail;
//
//        Request(String requesterName, String fromDate, String toDate, String contact, String docId, String requesterEmail) {
//            this.requesterName = requesterName;
//            this.fromDate = fromDate;
//            this.toDate = toDate;
//            this.contact = contact;
//            this.docId = docId;
//            this.requesterEmail = requesterEmail; // Initialize this field
//        }
//
//        public String getDocId() {
//            return docId;
//        }
//
//        public String getRequesterEmail() {
//            return requesterEmail; // Add getter for this field
//        }
//
//        @Override
//        public String toString() {
//            return "Requester Name: " + requesterName +
//                    "\nFrom Date: " + fromDate +
//                    "\nTo Date: " + toDate +
//                    "\nRequester Contact: " + contact;
//        }
//    }
//}
//package com.example.travelmate;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
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
//public class ProviderNewRequests extends AppCompatActivity {
//
//    private ListView newRequestsListView;
//    private ArrayList<BookingDetails> requestList = new ArrayList<>();
//    private FirebaseFirestore db;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider_new_requests);
//
//        newRequestsListView = findViewById(R.id.newRequestsListView);
//
//        // Initialize Firestore and get the provider's email
//        db = FirebaseFirestore.getInstance();
//        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//
//        // Fetch and display new requests
//        fetchNewRequests();
//    }
//
//    private void fetchNewRequests() {
//        db.collection("users")
//                .document(providerEmail)
//                .collection("NewRequests")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        requestList.clear(); // Clear the list before adding new requests
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            BookingDetails booking = document.toObject(BookingDetails.class);
//                            requestList.add(booking);
//                        }
//
//                        // Set the adapter
//                        RequestAdapter adapter = new RequestAdapter(this, requestList);
//                        newRequestsListView.setAdapter(adapter);
//
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void updateRequestStatus(String requesterEmail, String providerEmail, String status) {
//        if (providerEmail == null || requesterEmail == null) {
//            Toast.makeText(ProviderNewRequests.this, "Error: Missing email information", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        db.collection("bookingDetails")
//                .whereEqualTo("requesterEmail", requesterEmail)
//                .whereEqualTo("providerEmail", providerEmail)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        if (task.getResult().isEmpty()) {
//                            Toast.makeText(ProviderNewRequests.this, "No matching bookings found", Toast.LENGTH_SHORT).show();
//                        } else {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                String bookingId = document.getId();
//
//                                // Update the status of the booking
//                                db.collection("bookingDetails")
//                                        .document(bookingId)
//                                        .update("status", status)
//                                        .addOnSuccessListener(aVoid -> {
//                                            Toast.makeText(ProviderNewRequests.this, "Request " + status, Toast.LENGTH_SHORT).show();
//                                            fetchNewRequests(); // Refresh the list
//                                        })
//                                        .addOnFailureListener(e -> {
//                                            Log.e("UpdateRequestStatus", "Error updating request status", e);
//                                            Toast.makeText(ProviderNewRequests.this, "Error updating request", Toast.LENGTH_SHORT).show();
//                                        });
//                            }
//                        }
//                    } else {
//                        Log.e("UpdateRequestStatus", "Error fetching bookings", task.getException());
//                        Toast.makeText(ProviderNewRequests.this, "Error fetching bookings: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void notifyUserOfStatusChange(String requesterEmail, String status) {
//        if (requesterEmail == null) {
//            Log.e("ProviderNewRequests", "Requester email is null. Cannot notify user of status change.");
//            Toast.makeText(this, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        db.collection("bookingDetails")
//                .whereEqualTo("requesterEmail", requesterEmail)
//                .whereEqualTo("providerEmail", providerEmail)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            String bookingId = document.getId();
//
//                            // Update the status of the booking
//                            db.collection("bookingDetails")
//                                    .document(bookingId)
//                                    .update("status", status)
//                                    .addOnSuccessListener(aVoid -> {
//                                        Toast.makeText(ProviderNewRequests.this, "User notified of status change", Toast.LENGTH_SHORT).show();
//                                    })
//                                    .addOnFailureListener(e -> {
//                                        Toast.makeText(ProviderNewRequests.this, "Error notifying user", Toast.LENGTH_SHORT).show();
//                                    });
//                        }
//                    } else {
//                        Toast.makeText(ProviderNewRequests.this, "Error fetching bookings: " + task.getException(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private class RequestAdapter extends ArrayAdapter<BookingDetails> {
//        private final Context context;
//        private final ArrayList<BookingDetails> requests;
//
//        public RequestAdapter(Context context, ArrayList<BookingDetails> requests) {
//            super(context, 0, requests);
//            this.context = context;
//            this.requests = requests;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(context).inflate(R.layout.item_provider_new_requests, parent, false);
//            }
//
//            BookingDetails booking = getItem(position);
//
//            TextView requesterNameTextView = convertView.findViewById(R.id.requesterNameTextView);
//            TextView fromDateTextView = convertView.findViewById(R.id.fromDateTextView);
//            TextView toDateTextView = convertView.findViewById(R.id.toDateTextView);
//            TextView requesterContactTextView = convertView.findViewById(R.id.requesterContactTextView);
//            Button acceptButton = convertView.findViewById(R.id.acceptButton);
//            Button rejectButton = convertView.findViewById(R.id.rejectButton);
//
//            if (booking != null) {
//                requesterNameTextView.setText("Name: " + booking.getRequesterName());
//                fromDateTextView.setText("From: " + booking.getFromDate());
//                toDateTextView.setText("To: " + booking.getToDate());
//                requesterContactTextView.setText("Contact: " + booking.getRequesterContact());
//
//                acceptButton.setOnClickListener(v -> {
//                    if (booking.getRequesterEmail() == null) {
//                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    // Update request status to accepted
//                    booking.setStatus("Accepted");
//                    updateRequestStatus(booking.getRequesterEmail(), booking.getStatus());
//                    notifyUserOfStatusChange(booking.getRequesterEmail(), booking.getStatus());
//                });
//
//                rejectButton.setOnClickListener(v -> {
//                    if (booking.getRequesterEmail() == null) {
//                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    // Update request status to rejected
//                    booking.setStatus("Rejected");
//                    updateRequestStatus(booking.getRequesterEmail(), booking.getStatus());
//                    notifyUserOfStatusChange(booking.getRequesterEmail(), booking.getStatus());
//                });
//
//
//            }
//
//            return convertView;
//        }
//    }

//    private class RequestAdapter extends ArrayAdapter<BookingDetails> {
//        private final Context context;
//        private final ArrayList<BookingDetails> requests;
//        private final String providerEmail; // Make sure this is passed and used
//
//        public RequestAdapter(Context context, ArrayList<BookingDetails> requests, String providerEmail) {
//            super(context, 0, requests);
//            this.context = context;
//            this.requests = requests;
//            this.providerEmail = providerEmail; // Initialize providerEmail
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(context).inflate(R.layout.item_provider_new_requests, parent, false);
//            }
//
//            BookingDetails booking = getItem(position);
//
//            TextView requesterNameTextView = convertView.findViewById(R.id.requesterNameTextView);
//            TextView fromDateTextView = convertView.findViewById(R.id.fromDateTextView);
//            TextView toDateTextView = convertView.findViewById(R.id.toDateTextView);
//            TextView requesterContactTextView = convertView.findViewById(R.id.requesterContactTextView);
//            Button acceptButton = convertView.findViewById(R.id.acceptButton);
//            Button rejectButton = convertView.findViewById(R.id.rejectButton);
//
//            if (booking != null) {
//                requesterNameTextView.setText("Name: " + booking.getRequesterName());
//                fromDateTextView.setText("From: " + booking.getFromDate());
//                toDateTextView.setText("To: " + booking.getToDate());
//                requesterContactTextView.setText("Contact: " + booking.getRequesterContact());
//
//                acceptButton.setOnClickListener(v -> {
//                    if (booking.getRequesterEmail() == null) {
//                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    // Update request status to accepted
//                    updateRequestStatus(booking.getRequesterEmail(), providerEmail, "Accepted");
//                });
//
//                rejectButton.setOnClickListener(v -> {
//                    if (booking.getRequesterEmail() == null) {
//                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    // Update request status to rejected
//                    updateRequestStatus(booking.getRequesterEmail(), providerEmail, "Rejected");
//                });
//            }
//
//            return convertView;
//        }
//
//        private void updateRequestStatus(String requesterEmail, String providerEmail, String status) {
//            FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//            db.collection("bookingDetails")
//                    .whereEqualTo("requesterEmail", requesterEmail)
//                    .whereEqualTo("providerEmail", providerEmail)
//                    .get()
//                    .addOnCompleteListener(task -> {
//                        if (task.isSuccessful()) {
//                            if (task.getResult().isEmpty()) {
//                                Toast.makeText(context, "No matching bookings found", Toast.LENGTH_SHORT).show();
//                            } else {
//                                for (QueryDocumentSnapshot document : task.getResult()) {
//                                    String bookingId = document.getId();
//
//                                    // Update the status of the booking
//                                    db.collection("bookingDetails")
//                                            .document(bookingId)
//                                            .update("status", status)
//                                            .addOnSuccessListener(aVoid -> {
//                                                Toast.makeText(context, "Request " + status, Toast.LENGTH_SHORT).show();
//                                                fetchNewRequests(); // Refresh the list
//                                            })
//                                            .addOnFailureListener(e -> {
//                                                Log.e("UpdateRequestStatus", "Error updating request status", e);
//                                                Toast.makeText(context, "Error updating request", Toast.LENGTH_SHORT).show();
//                                            });
//                                }
//                            }
//                        } else {
//                            Log.e("UpdateRequestStatus", "Error fetching bookings", task.getException());
//                            Toast.makeText(context, "Error fetching bookings: " + task.getException(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        }
//
//        // Method to fetch new requests - needs implementation
//        private void fetchNewRequests() {
//            // Fetch and refresh the list of new requests
//        }
//    }

//}

package com.example.travelmate;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class ProviderNewRequests extends AppCompatActivity {

    private ListView newRequestsListView;
    private ArrayList<BookingDetails> requestList = new ArrayList<>();
    private FirebaseFirestore db;
    private String providerEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_new_requests);

        newRequestsListView = findViewById(R.id.newRequestsListView);

        // Initialize Firestore and get the provider's email
        db = FirebaseFirestore.getInstance();
        providerEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        // Fetch and display new requests
        fetchNewRequests();
    }

    private void fetchNewRequests() {
        db.collection("users")
                .document(providerEmail)
                .collection("NewRequests")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        requestList.clear(); // Clear the list before adding new requests
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            BookingDetails booking = document.toObject(BookingDetails.class);
                            requestList.add(booking);
                        }

                        // Set the adapter
                        RequestAdapter adapter = new RequestAdapter(this, requestList, providerEmail);
                        newRequestsListView.setAdapter(adapter);

                    } else {
                        Toast.makeText(ProviderNewRequests.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateRequestStatus(String requesterEmail, String status) {
        if (providerEmail == null || requesterEmail == null) {
            Toast.makeText(ProviderNewRequests.this, "Error: Missing email information", Toast.LENGTH_SHORT).show();
            return;
        }

        db.collection("bookingDetails")
                .whereEqualTo("requesterEmail", requesterEmail)
                .whereEqualTo("providerEmail", providerEmail)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        if (task.getResult().isEmpty()) {
                            Toast.makeText(ProviderNewRequests.this, "No matching bookings found", Toast.LENGTH_SHORT).show();
                        } else {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String bookingId = document.getId();

                                // Update the status of the booking
                                db.collection("bookingDetails")
                                        .document(bookingId)
                                        .update("status", status)
                                        .addOnSuccessListener(aVoid -> {
                                            Toast.makeText(ProviderNewRequests.this, "Request " + status, Toast.LENGTH_SHORT).show();
                                            fetchNewRequests(); // Refresh the list
                                        })
                                        .addOnFailureListener(e -> {
                                            Log.e("UpdateRequestStatus", "Error updating request status", e);
                                            Toast.makeText(ProviderNewRequests.this, "Error updating request", Toast.LENGTH_SHORT).show();
                                        });
                            }
                        }
                    } else {
                        Log.e("UpdateRequestStatus", "Error fetching bookings", task.getException());
                        Toast.makeText(ProviderNewRequests.this, "Error fetching bookings: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private class RequestAdapter extends ArrayAdapter<BookingDetails> {
        private final Context context;
        private final ArrayList<BookingDetails> requests;
        private final String providerEmail;

        public RequestAdapter(Context context, ArrayList<BookingDetails> requests, String providerEmail) {
            super(context, 0, requests);
            this.context = context;
            this.requests = requests;
            this.providerEmail = providerEmail;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_provider_new_requests, parent, false);
            }

            BookingDetails booking = getItem(position);

            TextView requesterNameTextView = convertView.findViewById(R.id.requesterNameTextView);
            TextView fromDateTextView = convertView.findViewById(R.id.fromDateTextView);
            TextView toDateTextView = convertView.findViewById(R.id.toDateTextView);
            TextView requesterContactTextView = convertView.findViewById(R.id.requesterContactTextView);
            Button acceptButton = convertView.findViewById(R.id.acceptButton);
            Button rejectButton = convertView.findViewById(R.id.rejectButton);

            if (booking != null) {
                requesterNameTextView.setText("Name: " + booking.getRequesterName());
                fromDateTextView.setText("From: " + booking.getFromDate());
                toDateTextView.setText("To: " + booking.getToDate());
                requesterContactTextView.setText("Contact: " + booking.getRequesterContact());

                acceptButton.setOnClickListener(v -> {
                    if (booking.getRequesterEmail() == null) {
                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // Update request status to accepted
                    updateRequestStatus(booking.getRequesterEmail(), "Accepted");
                });

                rejectButton.setOnClickListener(v -> {
                    if (booking.getRequesterEmail() == null) {
                        Toast.makeText(context, "Error: Requester email is missing", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // Update request status to rejected
                    updateRequestStatus(booking.getRequesterEmail(), "Rejected");
                });
            }

            return convertView;
        }
    }
}