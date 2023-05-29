package com.example.uts_mcs_2540120345;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.uts_mcs_2540120345.Database.DatabaseHelper;

import java.util.ArrayList;

public class HistoryList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> email, quantity;
    DatabaseHelper db;
    AdapterHistory adapterHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        db = new DatabaseHelper(this);
        email = new ArrayList<>();
        quantity = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerHistory);
        adapterHistory = new AdapterHistory(this, email, quantity);
        recyclerView.setAdapter(adapterHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                email.add(cursor.getString(0));
                quantity.add(cursor.getString(1));
            }
        }
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