package com.example.uts_mcs_2540120345;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uts_mcs_2540120345.Database.DatabaseHelper;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PurchasePage extends AppCompatActivity {

    private DatabaseHelper db;

    private EditText edtQuantity, edtEmail;
    private Button buyButton, ViewHistory;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_page);
        edtEmail = findViewById(R.id.Email);
        edtQuantity = findViewById(R.id.EditQuantity);
        buyButton = findViewById(R.id.buttonBuy);
        ViewHistory = findViewById(R.id.buttonHistory);
        db = new DatabaseHelper(this);


        ViewHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(PurchasePage.this, HistoryList.class));
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailTXT = edtEmail.getText().toString();
                String quantityTXT = edtQuantity.getText().toString();

                Boolean checkinsertdata = db.insertuserdata(emailTXT, quantityTXT);
                if(checkinsertdata==true){
                    Toast.makeText(PurchasePage.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(PurchasePage.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.logoutMenuItem:
                if (id == R.id.logoutMenuItem) {
                    showLogoutConfirmationDialog();
                    return true;
                }

            case R.id.purchase:
                toPurchasePage();
                return true;

            case R.id.history:
                toHistoryPage();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();

    }
    public void toHistoryPage(){
        Intent intent = new Intent(this, HistoryList.class);
        startActivity(intent);
    }

    public void toPurchasePage(){
        Intent intent = new Intent(this, PurchasePage.class);
        startActivity(intent);
    }

}