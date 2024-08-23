//package com.example.travelmate;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import android.app.DatePickerDialog;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.google.firebase.firestore.FirebaseFirestore;
//import java.util.Calendar;
//
//
//public class RequestForm extends AppCompatActivity {
//
//    private EditText requesterNameEditText, fromDateEditText, toDateEditText;
//    private Button sendRequestButton;
//    private String providerEmail;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_request_form);
//
//        requesterNameEditText = findViewById(R.id.requester_name);
//        fromDateEditText = findViewById(R.id.from_date);
//        toDateEditText = findViewById(R.id.to_date);
//        sendRequestButton = findViewById(R.id.send_request_button);
//
//        providerEmail = getIntent().getStringExtra("providerEmail");
//
//        fromDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
//                fromDateEditText.setText(day + "/" + (month + 1) + "/" + year)));
//
//        toDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
//                toDateEditText.setText(day + "/" + (month + 1) + "/" + year)));
//
//        sendRequestButton.setOnClickListener(v -> saveBookingDetails());
//
//    }
//
//    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener dateSetListener) {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        new DatePickerDialog(RequestForm.this, dateSetListener, year, month, day).show();
//    }
//
//    private void saveBookingDetails() {
//        String requesterName = requesterNameEditText.getText().toString();
//        String fromDate = fromDateEditText.getText().toString();
//        String toDate = toDateEditText.getText().toString();
//
//        if (requesterName.isEmpty() || fromDate.isEmpty() || toDate.isEmpty()) {
//            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        BookingDetails bookingDetails = new BookingDetails(requesterName, fromDate, toDate, providerEmail);
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("bookingDetails")
//                .add(bookingDetails)
//                .addOnSuccessListener(documentReference -> {
//                    Toast.makeText(RequestForm.this, "Request sent successfully", Toast.LENGTH_SHORT).show();
//                    finish();
//                })
//                .addOnFailureListener(e -> Toast.makeText(RequestForm.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
//    }
//}
//package com.example.travelmate;
//
//import android.app.DatePickerDialog;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.google.firebase.firestore.FirebaseFirestore;
//import java.util.Calendar;
//
//public class RequestForm extends AppCompatActivity {
//
//    private EditText requesterNameEditText, fromDateEditText, toDateEditText, providerEmailEditText, providerContactEditText;
//    private Button sendRequestButton;
//    private String providerEmail;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_request_form);
//
//        requesterNameEditText = findViewById(R.id.requester_name);
//        fromDateEditText = findViewById(R.id.from_date);
//        toDateEditText = findViewById(R.id.to_date);
//        providerEmailEditText = findViewById(R.id.provider_email);
//        providerContactEditText = findViewById(R.id.provider_contact);
//        sendRequestButton = findViewById(R.id.send_request_button);
//
//        // Get provider details from intent
//        providerEmail = getIntent().getStringExtra("providerEmail");
//        String providerContact = getIntent().getStringExtra("providerContact");
//
//        // Set provider details in the EditText fields
//        providerEmailEditText.setText(providerEmail);
//        providerContactEditText.setText(providerContact);
//
//        fromDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
//                fromDateEditText.setText(day + "/" + (month + 1) + "/" + year)));
//
//        toDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
//                toDateEditText.setText(day + "/" + (month + 1) + "/" + year)));
//
//        sendRequestButton.setOnClickListener(v -> saveBookingDetails());
//    }
//
//    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener dateSetListener) {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        new DatePickerDialog(RequestForm.this, dateSetListener, year, month, day).show();
//    }
//
//    private void saveBookingDetails() {
//        String requesterName = requesterNameEditText.getText().toString();
//        String fromDate = fromDateEditText.getText().toString();
//        String toDate = toDateEditText.getText().toString();
//
//        if (requesterName.isEmpty() || fromDate.isEmpty() || toDate.isEmpty()) {
//            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        BookingDetails bookingDetails = new BookingDetails(requesterName, fromDate, toDate, providerEmail);
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("bookingDetails")
//                .add(bookingDetails)
//                .addOnSuccessListener(documentReference -> {
//                    Toast.makeText(RequestForm.this, "Request sent successfully", Toast.LENGTH_SHORT).show();
//                    finish();
//                })
//                .addOnFailureListener(e -> Toast.makeText(RequestForm.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
//    }
//}
//package com.example.travelmate;
//
//import android.app.DatePickerDialog;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.google.firebase.firestore.FirebaseFirestore;
//import java.util.Calendar;
//
//public class RequestForm extends AppCompatActivity {
//
//    private EditText requesterNameEditText, fromDateEditText, toDateEditText, providerEmailEditText, providerContactEditText;
//    private Button sendRequestButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_request_form);
//
//        // Initialize the EditText and Button
//        requesterNameEditText = findViewById(R.id.requester_name);
//        fromDateEditText = findViewById(R.id.from_date);
//        toDateEditText = findViewById(R.id.to_date);
//        providerEmailEditText = findViewById(R.id.provider_email);
//        providerContactEditText = findViewById(R.id.provider_contact);
//        sendRequestButton = findViewById(R.id.send_request_button);
//
//        // Assuming providerEmail is passed via Intent
//        String providerEmail = getIntent().getStringExtra("providerEmail");
//        String providerContact = getIntent().getStringExtra("providerContact");
//
//        // Set the email and contact EditText fields with the received values
//        providerEmailEditText.setText(providerEmail);
//        providerContactEditText.setText(providerContact);
//
//        // DatePicker for From Date
//        fromDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
//                fromDateEditText.setText(day + "/" + (month + 1) + "/" + year)));
//
//        // DatePicker for To Date
//        toDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
//                toDateEditText.setText(day + "/" + (month + 1) + "/" + year)));
//
//        // Set the button click listener
//        sendRequestButton.setOnClickListener(v -> saveBookingDetails());
//    }
//
//    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener dateSetListener) {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        new DatePickerDialog(RequestForm.this, dateSetListener, year, month, day).show();
//    }
//
//    private void saveBookingDetails() {
//        String requesterName = requesterNameEditText.getText().toString();
//        String fromDate = fromDateEditText.getText().toString();
//        String toDate = toDateEditText.getText().toString();
//        String providerEmail = providerEmailEditText.getText().toString(); // Fetch provider email from the field
//        String providerContact = providerContactEditText.getText().toString(); // Fetch provider contact from the field
//
//        if (requesterName.isEmpty() || fromDate.isEmpty() || toDate.isEmpty() || providerEmail.isEmpty() || providerContact.isEmpty()) {
//            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        BookingDetails bookingDetails = new BookingDetails(requesterName, fromDate, toDate, providerEmail);
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("bookingDetails")
//                .add(bookingDetails)
//                .addOnSuccessListener(documentReference -> {
//                    Toast.makeText(RequestForm.this, "Request sent successfully", Toast.LENGTH_SHORT).show();
//                    finish();
//                })
//                .addOnFailureListener(e -> Toast.makeText(RequestForm.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
//    }
//}

package com.example.travelmate;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Calendar;

public class RequestForm extends AppCompatActivity {

    private EditText requesterNameEditText, fromDateEditText, toDateEditText, providerEmailEditText, providerContactEditText;
    private Button sendRequestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        // Initialize the EditText and Button
        requesterNameEditText = findViewById(R.id.requester_name);
        fromDateEditText = findViewById(R.id.from_date);
        toDateEditText = findViewById(R.id.to_date);
        providerEmailEditText = findViewById(R.id.provider_email);
        providerContactEditText = findViewById(R.id.requester_contact);
        sendRequestButton = findViewById(R.id.send_request_button);

        // Set up the DatePicker for From Date
        fromDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
                fromDateEditText.setText(day + "/" + (month + 1) + "/" + year)));

        // Set up the DatePicker for To Date
        toDateEditText.setOnClickListener(v -> showDatePickerDialog((datePicker, year, month, day) ->
                toDateEditText.setText(day + "/" + (month + 1) + "/" + year)));

        // Set the button click listener to save booking details
        sendRequestButton.setOnClickListener(v -> saveBookingDetails());
    }

    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener dateSetListener) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(RequestForm.this, dateSetListener, year, month, day).show();
    }

    private void saveBookingDetails() {
        String requesterName = requesterNameEditText.getText().toString();
        String fromDate = fromDateEditText.getText().toString();
        String toDate = toDateEditText.getText().toString();
        String providerEmail = providerEmailEditText.getText().toString(); // Get the provider's email from the input field
        String providerContact = providerContactEditText.getText().toString(); // Get the provider's contact from the input field

        // Validate that all fields are filled
        if (requesterName.isEmpty() || fromDate.isEmpty() || toDate.isEmpty() || providerEmail.isEmpty() || providerContact.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a BookingDetails object with the user input
        BookingDetails bookingDetails = new BookingDetails(requesterName, fromDate, toDate, providerEmail, providerContact);

        // Save the booking details to Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("bookingDetails")
                .add(bookingDetails)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(RequestForm.this, "Request sent successfully", Toast.LENGTH_SHORT).show();
                    finish(); // Close the activity after a successful request
                })
                .addOnFailureListener(e -> Toast.makeText(RequestForm.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}