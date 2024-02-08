package com.android.thefirms.registered_user;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.thefirms.Notifications.NotificationActivity;
import com.android.thefirms.R;
import com.android.thefirms.databinding.ActivityRegisteredUserBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisteredUserActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityRegisteredUserBinding binding;

    private Retrofit retrofit;
    private CompanyApiService companyApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisteredUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        setSupportActionBar(binding.appBarRegisteredUser.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_registered_user);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Set OnClickListener for the notification icon in the TopAppBar
        binding.appBarRegisteredUser.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the NotificationActivity
                Intent intent = new Intent(RegisteredUserActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        // Add text change listener to the search bar
        binding.appBarRegisteredUser.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchCompanies(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchCompanies(newText);
                return false;
            }
        });
    }

    // Method to fetch companies from the API based on the user's input
    private void fetchCompanies(String query) {
        // Create a call object for the API method
        Call<List<Company>> call = companyApiService.getCompanies(query);

        // Execute the call asynchronously
        call.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                if (response.isSuccessful()) {
                    // Handle successful response
                    List<Company> companies = response.body();
                    // Update UI with the fetched companies
                    updateUI(companies);
                } else {
                    // Handle error response
                    // Display appropriate error message to the user
                }
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable t) {
                // Handle failure (e.g., network error)
                // Display appropriate error message to the user
            }
        });
    }

    // Method to update the UI with fetched companies
    private void updateUI(List<Company> companies) {
        // Update UI logic here
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_registered_user);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}