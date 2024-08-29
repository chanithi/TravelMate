//package com.example.travelmate;
//
//import android.app.appsearch.SearchResult;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.ImageView;
//import android.text.TextWatcher;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
//
////import com.google.firebase.auth.FirebaseAuth;
////import com.google.firebase.auth.FirebaseUser;
//
//public class UserHome extends AppCompatActivity {
//
//    private AutoCompleteTextView searchBar;
//    FirebaseAuth auth;
//    FirebaseUser user;
//    FirebaseFirestore db;
//    Button button;
//    ImageView accountIcon;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_user_home);
//
//        auth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance();
//        button = findViewById(R.id.signOut_btn);
//        accountIcon = findViewById(R.id.user_home_acc_icon);
//        user = auth.getCurrentUser();
//
//        accountIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navigateToAccount();
//            }
//        });
//
//        if(user == null){
//            Intent intent = new Intent(getApplicationContext(), SignIn.class);
//            startActivity(intent);
//            finish();
//        }
//
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getApplicationContext(), SignIn.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        // Find the account icon by its ID
//        ImageView accountIcon = findViewById(R.id.user_home_acc_icon);
//
//        // Set an OnClickListener to navigate to the UserAccount page
//        accountIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(UserHome.this, UserAcc.class);
//                startActivity(intent);
//            }
//        });
//
//        // Set up the search bar with limited options
//        searchBar = findViewById(R.id.search_bar);
//        String[] searchOptions = new String[]{"Drivers", "Guides", "Hotels"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, searchOptions);
//        searchBar.setAdapter(adapter);
//
//        // Listen for changes in the search bar input
//        searchBar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // No action needed
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // No action needed
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // Handle search input and navigate to the relevant page
//                handleSearch(s.toString());
//            }
//        });
//    }
//
//    private void navigateToAccount() {
//        String userId = auth.getCurrentUser().getUid();
//        Intent intent = new Intent(UserHome.this, UserAcc.class);
//        intent.putExtra("userId", userId);
//        startActivity(intent);
//    }
//
//    private void handleSearch(String searchTerm) {
//        Intent intent = new Intent(UserHome.this, SearchResults.class);
//        intent.putExtra("searchTerm", searchTerm);
//        startActivity(intent);
//    }

//    private void navigateToDriversPage() {
//        Intent intent = new Intent(UserHome.this, DriversPage.class);
//        startActivity(intent);
//    }
//
//    private void navigateToGuidesPage() {
//        Intent intent = new Intent(UserHome.this, GuidesPage.class);
//        startActivity(intent);
//    }
//
//    private void navigateToHotelsPage() {
//        Intent intent = new Intent(UserHome.this, HotelsPage.class);
//        startActivity(intent);
//    }
//}
//package com.example.travelmate;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.KeyEvent;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.PopupMenu;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//public class UserHome extends AppCompatActivity {
//
//    private AutoCompleteTextView searchBar;
//    private FirebaseAuth auth;
//    private FirebaseUser user;
//    private FirebaseFirestore db;
////    private Button button;
//    private ImageView accountIcon;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_home);
//
//        auth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance();
////        button = findViewById(R.id.signOut_btn);
//        accountIcon = findViewById(R.id.user_home_acc_icon);
//        user = auth.getCurrentUser();
//
//        if (user == null) {
//            Intent intent = new Intent(getApplicationContext(), SignIn.class);
//            startActivity(intent);
//            finish();
//        }
//
//        accountIcon.setOnClickListener(view -> showAccountMenu(view));
//
////        button.setOnClickListener(view -> {
////            FirebaseAuth.getInstance().signOut();
////            Intent intent = new Intent(getApplicationContext(), SignIn.class);
////            startActivity(intent);
////            finish();
////        });
//
////        // Find the account icon by its ID
////        accountIcon.setOnClickListener(view -> {
////            Intent intent = new Intent(UserHome.this, UserAcc.class);
////            startActivity(intent);
////        });
//
//        // Set up the search bar with limited options
//        searchBar = findViewById(R.id.search_bar);
//        String[] searchOptions = new String[]{"Driver", "Guide", "Hotel"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, searchOptions);
//        searchBar.setAdapter(adapter);
//
//        // Set up listener for search input and handle Enter key press
//        searchBar.setOnKeyListener((v, keyCode, event) -> {
//            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
//                String searchTerm = searchBar.getText().toString().trim();
//                if (!searchTerm.isEmpty()) {
//                    handleSearch(searchTerm);
//                }
//                return true;
//            }
//            return false;
//        });
//    }
//
////    private void navigateToAccount() {
////        String userId = auth.getCurrentUser().getUid();
////        Intent intent = new Intent(UserHome.this, UserAcc.class);
////        intent.putExtra("userId", userId);
////        startActivity(intent);
////    }
//    private void showAccountMenu(View view) {
//        PopupMenu popupMenu = new PopupMenu(UserHome.this, view);
//        popupMenu.getMenuInflater().inflate(R.menu.account_menu, popupMenu.getMenu());
//
//        popupMenu.setOnMenuItemClickListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.menu_my_profile:
//                    navigateToAccount();
//                    return true;
//                    case R.id.menu_sign_out:
//                        signOut();
//                        return true;
//                    default:
//                        return false;
//                }
//            });
//
//        popupMenu.show();
//    }
//
//    private void navigateToAccount() {
//        String userId = auth.getCurrentUser().getUid();
//        Intent intent = new Intent(UserHome.this, UserAcc.class);
//        intent.putExtra("userId", userId);
//        startActivity(intent);
//    }
//
//    private void signOut() {
//        FirebaseAuth.getInstance().signOut();
//        Intent intent = new Intent(getApplicationContext(), SignIn.class);
//        startActivity(intent);
//        finish();
//    }
//
//
//    private void handleSearch(String searchTerm) {
//        Intent intent = new Intent(UserHome.this, SearchResults.class);
//        intent.putExtra("searchTerm", searchTerm);
//        startActivity(intent);
//    }
//}
package com.example.travelmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserHome extends AppCompatActivity {

    private AutoCompleteTextView searchBar;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore db;
    private ImageView accountIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        accountIcon = findViewById(R.id.user_home_acc_icon);
        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), SignIn.class);
            startActivity(intent);
            finish();
        }

        // Set up the account icon to show a popup menu
        accountIcon.setOnClickListener(view -> showPopupMenu(view));

        // Set up the search bar with limited options
        searchBar = findViewById(R.id.search_bar);
        String[] searchOptions = new String[]{"Driver", "Guide", "Hotel"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, searchOptions);
        searchBar.setAdapter(adapter);

        // Set up listener for search input and handle Enter key press
        searchBar.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                String searchTerm = searchBar.getText().toString().trim();
                if (!searchTerm.isEmpty()) {
                    handleSearch(searchTerm);
                }
                return true;
            }
            return false;
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.account_menu, popupMenu.getMenu()); // Ensure this matches your menu file
        popupMenu.setOnMenuItemClickListener(item -> handleMenuItemClick(item));
        popupMenu.show();
    }

    private boolean handleMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_my_profile) {
            navigateToAccount();
            return true;
        } else if (id == R.id.menu_sign_out) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), SignIn.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }


    private void navigateToAccount() {
        String userId = auth.getCurrentUser().getUid();
        Intent intent = new Intent(UserHome.this, UserAcc.class);
        intent.putExtra("userId", userId);
        startActivity(intent);
    }

    private void handleSearch(String searchTerm) {
        Intent intent = new Intent(UserHome.this, SearchResults.class);
        intent.putExtra("searchTerm", searchTerm);
        startActivity(intent);
    }
}