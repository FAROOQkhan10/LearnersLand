package com.farooqkhan.learnersland;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.farooqkhan.learnersland.Adapter.categoryVideoAdapter;
import com.farooqkhan.learnersland.Model.categoryVideoModel;
import com.farooqkhan.learnersland.databinding.ActivityVideoListBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DevActivity extends AppCompatActivity {
    ActivityVideoListBinding binding;
    FirebaseFirestore database;
    final ArrayList<categoryVideoModel> Categories = new ArrayList<>();
    final categoryVideoAdapter Adapter = new categoryVideoAdapter(Categories, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseFirestore.getInstance();



        binding.searchView.clearFocus();
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        if (isConnected()) {
//            Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(DevActivity.this);
            builder.setTitle("No Internet Connection")
                    .setMessage("Go to Setting...")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(DevActivity.this,"Go Back To HomePage!", Toast.LENGTH_SHORT).show();

                              startActivity(new Intent(DevActivity.this,MainActivity.class));


                        }
                    });
            //Creating dialog box
            AlertDialog dialog  = builder.create();
            dialog.show();
        }



        final String catId = getIntent().getStringExtra("catId");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Video List");

        database.collection("Development")
                .document(catId)
                .collection("devVideo")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Categories.clear();

                for(DocumentSnapshot snapshot:queryDocumentSnapshots){
                    categoryVideoModel model = snapshot.toObject(categoryVideoModel.class);
                    model.setCategoryVideoId(snapshot.getId());
                    Categories.add(model);
                }

                Adapter.notifyDataSetChanged();
                binding.shimmerViewContainer.stopShimmer();
                binding.shimmerLayout.setVisibility(View.GONE);

            }
        });
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(Adapter);



    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }



    private void filterList(String newText) {

        ArrayList<categoryVideoModel> filter_list = new ArrayList<>();

        for(categoryVideoModel item: Categories){
            if(item.getCategoryVideoName().toLowerCase().contains(newText.toLowerCase())){
                filter_list.add(item);
            }
        }

        if(filter_list.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }
        else{

            Adapter.setFilteredList(filter_list);


        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onPause() {
        binding.shimmerViewContainer.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onStart() {
        binding.shimmerViewContainer.startShimmer();
        super.onStart();
    }
}