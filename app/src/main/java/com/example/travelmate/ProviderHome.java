//package com.example.travelmate;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//public class ProviderHome extends AppCompatActivity {
//
//    private ImageView accountIcon;
//    private FirebaseFirestore db;
//    private FirebaseAuth auth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_provider_home);
//
//        accountIcon = findViewById(R.id.provider_home_acc_icon);
//        db = FirebaseFirestore.getInstance();
//        auth = FirebaseAuth.getInstance();
//
//        accountIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navigateToAccount();
//            }
//        });
//
//    }
//
//    private void navigateToAccount() {
//        String userId = auth.getCurrentUser().getUid();
//        Intent intent = new Intent(ProviderHome.this, DriverAcc.class);
//        intent.putExtra("userId", userId);
//        startActivity(intent);
//    }
//}
package com.example.travelmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProviderHome extends AppCompatActivity {

    private ImageView accountIcon;
    private FirebaseFirestore db;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home);

        accountIcon = findViewById(R.id.provider_home_acc_icon);
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        // Set up the account icon to show a popup menu
        accountIcon.setOnClickListener(view -> showPopupMenu(view));
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.account_menu, popupMenu.getMenu());
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
        Intent intent = new Intent(ProviderHome.this, DriverAcc.class);
        intent.putExtra("userId", userId);
        startActivity(intent);
    }
}

