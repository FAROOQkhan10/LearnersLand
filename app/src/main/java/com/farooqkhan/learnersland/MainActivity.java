package com.farooqkhan.learnersland;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.farooqkhan.learnersland.Adapter.categoryAdapter;
import com.farooqkhan.learnersland.Model.categoryModel;
import com.farooqkhan.learnersland.databinding.ActivityMainBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final ArrayList<categoryModel> categories = new ArrayList<>();
        final categoryAdapter adapter = new categoryAdapter(this, categories);


        database.collection("category")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        categories.clear();
                        for(DocumentSnapshot snapshot:value.getDocuments()){
                            categoryModel model = snapshot.toObject(categoryModel.class);
                            model.setCategoryId(snapshot.getId());
                            categories.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
        binding.categorylist.setLayoutManager(new GridLayoutManager(this,2));
        binding.categorylist.setAdapter(adapter);


    }
}