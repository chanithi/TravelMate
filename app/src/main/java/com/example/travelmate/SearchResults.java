//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.ImageView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class SearchResults extends AppCompatActivity {
//
//    private ImageView userTypeImage;
//    private AutoCompleteTextView districtFilter;
//    private RecyclerView searchResultsRecyclerView;
//    private UserAdapter userAdapter;
//    private List<User> userList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_search_results);
//
//        userTypeImage = findViewById(R.id.user_type_image);
//        districtFilter = findViewById(R.id.district_filter);
//        searchResultsRecyclerView = findViewById(R.id.search_results_recycler_view);
//
//        String searchTerm = getIntent().getStringExtra("searchTerm");
//
//        if (searchTerm != null) {
//            setUserTypeImage(searchTerm);
//            // Load data based on the searchTerm, and populate the RecyclerView
//            loadSearchResults(searchTerm);
//        } else {
//            // Handle the case where searchTerm is null
//            userTypeImage.setImageResource(R.drawable.driver); // Set a default image
//        }
//
//
////        // Set up RecyclerView
////        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
////        userAdapter = new UserAdapter(userList, this);
////        searchResultsRecyclerView.setAdapter(userAdapter);
//
//        // Get the user type from the intent and set the appropriate image
//        String userType = getIntent().getStringExtra("userType");
//        setUserTypeImage(userType);
//
//        // Set up district filter (You can populate this with a list of districts)
//        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getDistricts());
//        districtFilter.setAdapter(districtAdapter);
//        districtFilter.setOnItemClickListener((parent, view, position, id) -> filterByDistrict(districtAdapter.getItem(position)));
//
//        // Load the data based on user type
//        loadData(userType);
//    }
//
//    private void setUserTypeImage(String searchTerm) {
//        switch (searchTerm.toLowerCase()) {
//            case "drivers":
//                userTypeImage.setImageResource(R.drawable.driver);
//                break;
//            case "guides":
//                userTypeImage.setImageResource(R.drawable.guide);
//                break;
//            case "hotels":
//                userTypeImage.setImageResource(R.drawable.hotel);
//                break;
//            default:
//                userTypeImage.setImageResource(R.drawable.driver);
//                break;
//        }
//    }
//
//    private void loadSearchResults(String searchTerm) {
//        // This method should query Firestore for the users matching the searchTerm
//        // For now, it's a placeholder method. You'd need to implement this to actually fetch data.
//        List<User> userList = fetchUsersByType(searchTerm);
//        UserAdapter userAdapter = new UserAdapter(userList, this);
//        searchResultsRecyclerView.setAdapter(userAdapter);
//    }
//
//    private void fetchUsersByType(String userType) {
//        List<User> userList = new ArrayList<>();
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        db.collection("users")
//                .whereEqualTo("userType", userType.toLowerCase())
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (DocumentSnapshot document : task.getResult()) {
//                            User user = document.toObject(User.class);
//                            userList.add(user);
//                        }
//                        // Update the RecyclerView with the fetched data
//                        UserAdapter userAdapter = new UserAdapter(userList, this);
//                        searchResultsRecyclerView.setAdapter(userAdapter);
//                    } else {
//                        // Handle the error
//                        Log.e("SearchResults", "Error fetching users: ", task.getException());
//                    }
//                });
//    }
//
//
//    private void filterByDistrict(String district) {
//        List<User> filteredList = new ArrayList<>();
//
//        for (User user : userList) {
//            if (user.getDistrict().equalsIgnoreCase(district)) {
//                filteredList.add(user);
//            }
//        }
//
//        // Update the RecyclerView with the filtered data
//        UserAdapter userAdapter = new UserAdapter(filteredList, this);
//        searchResultsRecyclerView.setAdapter(userAdapter);
//    }
//
//    private void loadData(String userType) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        userList = new ArrayList<>();
//
//        db.collection("users")
//                .whereEqualTo("userType", userType.toLowerCase())
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (DocumentSnapshot document : task.getResult()) {
//                            User user = document.toObject(User.class);
//                            userList.add(user);
//                        }
//                        // Update the RecyclerView with the fetched data
//                        UserAdapter userAdapter = new UserAdapter(userList, this);
//                        searchResultsRecyclerView.setAdapter(userAdapter);
//                    } else {
//                        // Handle the error
//                        Log.e("SearchResults", "Error loading data: ", task.getException());
//                    }
//                });
//    }
//
//    private List<String> getDistricts() {
//        // Replace these with actual district names relevant to your application
//        return Arrays.asList("Colombo", "Gampaha", "Kandy", "Galle", "Matara", "Jaffna", "Anuradhapura");
//    }
//}
//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.ImageView;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class SearchResults extends AppCompatActivity {
//
//    private ImageView userTypeImage;
//    private AutoCompleteTextView districtFilter;
//    private RecyclerView searchResultsRecyclerView;
//    private UserAdapter userAdapter;
//    private List<User> userList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_results);
//
//        userTypeImage = findViewById(R.id.user_type_image);
//        districtFilter = findViewById(R.id.district_filter);
//        searchResultsRecyclerView = findViewById(R.id.search_results_recycler_view);
//
//        String searchTerm = getIntent().getStringExtra("searchTerm");
//
//        if (searchTerm != null) {
//            setUserTypeImage(searchTerm);
//            // Load data based on the searchTerm, and populate the RecyclerView
//            loadSearchResults(searchTerm);
//        } else {
//            // Handle the case where searchTerm is null
//            userTypeImage.setImageResource(R.drawable.driver); // Set a default image
//        }
//
//        // Set up RecyclerView
//        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        userAdapter = new UserAdapter(userList, this);
//        searchResultsRecyclerView.setAdapter(userAdapter);
//
//        // Set up district filter
//        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getDistricts());
//        districtFilter.setAdapter(districtAdapter);
//        districtFilter.setOnItemClickListener((parent, view, position, id) -> filterByDistrict(districtAdapter.getItem(position)));
//    }
//
//    private void setUserTypeImage(String searchTerm) {
//        switch (searchTerm.toLowerCase()) {
//            case "drivers":
//                userTypeImage.setImageResource(R.drawable.driver); // Replace with actual drawable
//                break;
//            case "guides":
//                userTypeImage.setImageResource(R.drawable.guide); // Replace with actual drawable
//                break;
//            case "hotels":
//                userTypeImage.setImageResource(R.drawable.hotel); // Replace with actual drawable
//                break;
//            default:
//                userTypeImage.setImageResource(R.drawable.acc); // Default fallback image
//                break;
//        }
//    }
//
//
////    private void loadData(String userType) {
////        FirebaseFirestore db = FirebaseFirestore.getInstance();
////        db.collection("users")
////                .whereEqualTo("userType", userType.toLowerCase())
////                .get()
////                .addOnCompleteListener(task -> {
////                    if (task.isSuccessful()) {
////                        userList.clear(); // Clear existing data
////                        for (DocumentSnapshot document : task.getResult()) {
////                            User user = document.toObject(User.class);
////                            userList.add(user);
////                        }
////                        // Update the RecyclerView with the fetched data
////                        userAdapter.notifyDataSetChanged();
////                    } else {
////                        // Handle the error
////                        Log.e("SearchResults", "Error loading data: ", task.getException());
////                    }
////                });
////    }
//
//
//    private void loadSearchResults(String searchTerm) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("users")
//                .whereEqualTo("userType", searchTerm.toLowerCase())
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        List<User> users = new ArrayList<>();
//                        for (DocumentSnapshot document : task.getResult()) {
//                            User user = document.toObject(User.class);
//                            if (user != null) {
//                                users.add(user);
//                            }
//                        }
//                        // Update the RecyclerView with the fetched data
//                        UserAdapter userAdapter = new UserAdapter(users, this);
//                        searchResultsRecyclerView.setAdapter(userAdapter);
//                    } else {
//                        Log.e("SearchResults", "Error fetching users: ", task.getException());
//                    }
//                });
//    }
//
//    private void filterByDistrict(String district) {
//        List<User> filteredList = new ArrayList<>();
//        for (User user : userList) {
//            if (user.getDistrict().equalsIgnoreCase(district)) {
//                filteredList.add(user);
//            }
//        }
//        // Update the RecyclerView with the filtered data
//        userAdapter.updateData(filteredList);
//    }
//
//    private List<String> getDistricts() {
//        // Replace these with actual district names relevant to your application
//        return Arrays.asList("Colombo", "Gampaha", "Kandy", "Galle", "Matara", "Jaffna", "Anuradhapura");
//    }
//}
//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.ImageView;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class SearchResults extends AppCompatActivity {
//
//    private ImageView userTypeImage;
//    private AutoCompleteTextView districtFilter;
//    private RecyclerView searchResultsRecyclerView;
//    private UserAdapter userAdapter;
//    private List<User> userList = new ArrayList<>();
//    private List<User> allUsers = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_results);
//
//        userTypeImage = findViewById(R.id.user_type_image);
//        districtFilter = findViewById(R.id.district_filter);
//        searchResultsRecyclerView = findViewById(R.id.search_results_recycler_view);
//
//        String searchTerm = getIntent().getStringExtra("searchTerm");
//
//        if (searchTerm != null) {
//            setUserTypeImage(searchTerm);
//            // Load data based on the searchTerm, and populate the RecyclerView
//            loadSearchResults(searchTerm);
//        } else {
//            // Handle the case where searchTerm is null
//            userTypeImage.setImageResource(R.drawable.acc); // Set a default image
//        }
//
//        // Set up RecyclerView
//        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        userAdapter = new UserAdapter(userList, this);
//        searchResultsRecyclerView.setAdapter(userAdapter);
//
//        // Set up district filter
//        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getDistricts());
//        districtFilter.setAdapter(districtAdapter);
//        districtFilter.setOnItemClickListener((parent, view, position, id) -> filterByDistrict(districtAdapter.getItem(position)));
//    }
//
//    private void setUserTypeImage(String searchTerm) {
//        switch (searchTerm.toLowerCase()) {
//            case "drivers":
//                userTypeImage.setImageResource(R.drawable.driver); // Replace with actual drawable
//                break;
//            case "guides":
//                userTypeImage.setImageResource(R.drawable.guide); // Replace with actual drawable
//                break;
//            case "hotels":
//                userTypeImage.setImageResource(R.drawable.hotel); // Replace with actual drawable
//                break;
//            default:
//                userTypeImage.setImageResource(R.drawable.acc); // Default fallback image
//                break;
//        }
//    }
//
//    private void loadSearchResults(String searchTerm) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String formattedSearchTerm = capitalizeFirstLetter(searchTerm);
//
//        db.collection("users")
//                .whereEqualTo("userType", formattedSearchTerm)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        List<User> users = new ArrayList<>();
//                        for (DocumentSnapshot document : task.getResult()) {
//                            User user = document.toObject(User.class);
//                            if (user != null) {
//                                users.add(user);
//                            }
//                        }
//                        allUsers = users; // Store all users for filtering
//                        userList.clear();
//                        userList.addAll(users);
//                        userAdapter.notifyDataSetChanged();
//                    } else {
//                        Log.e("SearchResults", "Error fetching users: ", task.getException());
//                    }
//                });
//    }
//
//    // Utility method to capitalize the first letter of the searchTerm
//    private String capitalizeFirstLetter(String term) {
//        if (term == null || term.isEmpty()) {
//            return term;
//        }
//        return term.substring(0, 1).toUpperCase() + term.substring(1).toLowerCase();
//    }
//
//    private void filterByDistrict(String district) {
//        List<User> filteredList = new ArrayList<>();
//        for (User user : allUsers) {
//            if (user.getDistrict().equalsIgnoreCase(district)) {
//                filteredList.add(user);
//            }
//        }
//        // Update the RecyclerView with the filtered data
//        userAdapter.updateData(filteredList);
//    }
//
//    private List<String> getDistricts() {
//        // Replace these with actual district names relevant to your application
//        return Arrays.asList("Colombo", "Gampaha", "Kandy", "Galle", "Matara", "Jaffna", "Anuradhapura");
//    }
//}
//package com.example.travelmate;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.ImageView;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class SearchResults extends AppCompatActivity {
//
//    private ImageView userTypeImage;
//    private AutoCompleteTextView districtFilter;
//    private ListView searchResultsListView;
//    private UserAdapter userAdapter;
//    private List<User> userList = new ArrayList<>();
//    private List<User> allUsers = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_results);
//
//        userTypeImage = findViewById(R.id.user_type_image);
//        districtFilter = findViewById(R.id.district_filter);
//        searchResultsListView = findViewById(R.id.search_results_list_view);
//
//        String searchTerm = getIntent().getStringExtra("searchTerm");
//
//        if (searchTerm != null) {
//            setUserTypeImage(searchTerm);
//            // Load data based on the searchTerm, and populate the ListView
//            loadSearchResults(searchTerm);
//        } else {
//            // Handle the case where searchTerm is null
//            userTypeImage.setImageResource(R.drawable.acc); // Set a default image
//        }
//
//        // Set up ListView
//        userAdapter = new UserAdapter(userList, this);
//        searchResultsListView.setAdapter(userAdapter);
//
//        // Set up district filter
//        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getDistricts());
//        districtFilter.setAdapter(districtAdapter);
//        districtFilter.setOnItemClickListener((parent, view, position, id) -> filterByDistrict(districtAdapter.getItem(position)));
//    }
//
//    private void setUserTypeImage(String searchTerm) {
//        switch (searchTerm.toLowerCase()) {
//            case "driver":
//                userTypeImage.setImageResource(R.drawable.driver); // Replace with actual drawable
//                break;
//            case "guide":
//                userTypeImage.setImageResource(R.drawable.guide); // Replace with actual drawable
//                break;
//            case "hotel":
//                userTypeImage.setImageResource(R.drawable.hotel); // Replace with actual drawable
//                break;
//            default:
//                userTypeImage.setImageResource(R.drawable.acc); // Default fallback image
//                break;
//        }
//    }
//
//    private void loadSearchResults(String searchTerm) {
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        String formattedSearchTerm = capitalizeFirstLetter(searchTerm);
//
//        db.collection("users")
//                .whereEqualTo("userType", formattedSearchTerm)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        List<User> users = new ArrayList<>();
//                        for (DocumentSnapshot document : task.getResult()) {
//                            User user = document.toObject(User.class);
//                            if (user != null) {
//                                users.add(user);
//                            }
//                        }
//                        allUsers = users; // Store all users for filtering
//                        userList.clear();
//                        userList.addAll(users);
//                        userAdapter.notifyDataSetChanged();
//                    } else {
//                        Log.e("SearchResults", "Error fetching users: ", task.getException());
//                    }
//                });
//    }
//
//    // Utility method to capitalize the first letter of the searchTerm
//    private String capitalizeFirstLetter(String term) {
//        if (term == null || term.isEmpty()) {
//            return term;
//        }
//        return term.substring(0, 1).toUpperCase() + term.substring(1).toLowerCase();
//    }
//
////    private void filterByDistrict(String district) {
////        List<User> filteredList = new ArrayList<>();
////        for (User user : allUsers) {
////            if (user.getDistrict().equalsIgnoreCase(district)) {
////                filteredList.add(user);
////            }
////        }
////        // Update the ListView with the filtered data
////        userAdapter.updateData(filteredList);
////    }
//
//    private void filterByDistrict(String district) {
//        // Ensure the input district is not null or empty
//        if (district == null || district.trim().isEmpty()) return;
//
//        // Normalize the input district by trimming spaces and converting to title case
//        String normalizedInputDistrict = capitalizeFirstLetter(district.trim().toLowerCase());
//
//        List<User> filteredList = new ArrayList<>();
//        for (User user : allUsers) {
//            // Ensure the user district is not null
//            String userDistrict = user.getDistrict() != null ? user.getDistrict().trim() : "";
//
//            // Normalize user district to match input district format
//            String normalizedUserDistrict = capitalizeFirstLetter(userDistrict.toLowerCase());
//
//            // Compare normalized input district with normalized user district
//            if (normalizedUserDistrict.equals(normalizedInputDistrict)) {
//                filteredList.add(user);
//            }
//        }
//
//        // Update the RecyclerView with the filtered data
//        userAdapter.updateData(filteredList);
//    }
//
//    // Utility method to capitalize the first letter of a string
////    private String capitalizeFirstLetter(String term) {
////        if (term == null || term.isEmpty()) return term;
////        return term.substring(0, 1).toUpperCase() + term.substring(1).toLowerCase();
////    }
//
//    private List<String> getDistricts() {
//        // Replace these with actual district names relevant to your application
//        return Arrays.asList("Colombo", "Gampaha", "Kandy", "Galle", "Matara", "Jaffna", "Anuradhapura");
//    }
//}
package com.example.travelmate;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResults extends AppCompatActivity {

    private ImageView userTypeImage;
    private AutoCompleteTextView districtFilter;
    private ListView searchResultsListView;
    private UserAdapter userAdapter;
    private List<User> userList = new ArrayList<>();
    private List<User> allUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        userTypeImage = findViewById(R.id.user_type_image);
        districtFilter = findViewById(R.id.district_filter);
        searchResultsListView = findViewById(R.id.search_results_list_view);

        String searchTerm = getIntent().getStringExtra("searchTerm");

        if (searchTerm != null) {
            setUserTypeImage(searchTerm);
            // Load data based on the searchTerm, and populate the ListView
            loadSearchResults(searchTerm);
        } else {
            // Handle the case where searchTerm is null
            userTypeImage.setImageResource(R.drawable.acc); // Set a default image
        }

        // Set up ListView
        userAdapter = new UserAdapter(userList, this);
        searchResultsListView.setAdapter(userAdapter);

        // Set up district filter
        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getDistricts());
        districtFilter.setAdapter(districtAdapter);
        districtFilter.setOnItemClickListener((parent, view, position, id) -> filterByDistrict(districtAdapter.getItem(position)));
    }

    private void setUserTypeImage(String searchTerm) {
        switch (searchTerm.toLowerCase()) {
            case "driver":
                userTypeImage.setImageResource(R.drawable.driver); // Replace with actual drawable
                break;
            case "guide":
                userTypeImage.setImageResource(R.drawable.guide); // Replace with actual drawable
                break;
            case "hotel":
                userTypeImage.setImageResource(R.drawable.hotel); // Replace with actual drawable
                break;
            default:
                userTypeImage.setImageResource(R.drawable.acc); // Default fallback image
                break;
        }
    }

    private void loadSearchResults(String searchTerm) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String formattedSearchTerm = capitalizeFirstLetter(searchTerm);

        db.collection("users")
                .whereEqualTo("userType", formattedSearchTerm)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<User> users = new ArrayList<>();
                        for (DocumentSnapshot document : task.getResult()) {
                            User user = document.toObject(User.class);
                            if (user != null) {
                                users.add(user);
                            }
                        }
                        allUsers = users; // Store all users for filtering
                        userList.clear();
                        userList.addAll(users);
                        userAdapter.notifyDataSetChanged();
                    } else {
                        Log.e("SearchResults", "Error fetching users: ", task.getException());
                    }
                });
    }

    private String capitalizeFirstLetter(String term) {
        if (term == null || term.isEmpty()) {
            return term;
        }
        return term.substring(0, 1).toUpperCase() + term.substring(1).toLowerCase();
    }

    private void filterByDistrict(String district) {
        // Ensure the input district is not null or empty
        if (district == null || district.trim().isEmpty()) return;

        // Normalize the input district by trimming spaces and converting to title case
        String normalizedInputDistrict = capitalizeFirstLetter(district.trim().toLowerCase());

        List<User> filteredList = new ArrayList<>();
        for (User user : allUsers) {
            // Ensure the user district is not null
            String userDistrict = user.getDistrict() != null ? user.getDistrict().trim() : "";

            // Normalize user district to match input district format
            String normalizedUserDistrict = capitalizeFirstLetter(userDistrict.toLowerCase());

            // Compare normalized input district with normalized user district
            if (normalizedUserDistrict.equals(normalizedInputDistrict)) {
                filteredList.add(user);
            }
        }

        // Update the ListView with the filtered data
        userAdapter.updateData(filteredList);
    }

    private List<String> getDistricts() {
        // Replace these with actual district names relevant to your application
        return Arrays.asList("Colombo", "Gampaha", "Kandy", "Galle", "Matara", "Jaffna", "Anuradhapura");
    }
}