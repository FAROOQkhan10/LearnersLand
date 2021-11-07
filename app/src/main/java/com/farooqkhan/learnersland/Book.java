package com.farooqkhan.learnersland;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.farooqkhan.learnersland.Adapter.BookAdapter;
import com.farooqkhan.learnersland.Model.BookModel;
import com.farooqkhan.learnersland.Model.categoryModel;
import com.farooqkhan.learnersland.databinding.ActivityBookBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Book extends AppCompatActivity {
    ActivityBookBinding binding;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Books");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<BookModel> list = new ArrayList<>();
        final BookAdapter adapter = new BookAdapter(this,list);


        database.collection("Books")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        list.clear();
                        for(DocumentSnapshot snapshot:value.getDocuments()){
                             BookModel model = snapshot.toObject(BookModel.class);
                             list.add(model);
                         }
                         adapter.notifyDataSetChanged();
                    }
                });

        binding.bookrecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        binding.bookrecyclerView.setAdapter(adapter);




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }



}

