package com.farooqkhan.learnersland;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.farooqkhan.learnersland.Adapter.categoryAdapter;
import com.farooqkhan.learnersland.Adapter.categoryVideoAdapter;
import com.farooqkhan.learnersland.Model.categoryModel;
import com.farooqkhan.learnersland.Model.categoryVideoModel;
import com.farooqkhan.learnersland.databinding.ActivityVideoListBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class VideoList extends AppCompatActivity {
   ActivityVideoListBinding binding;
   FirebaseFirestore database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseFirestore.getInstance();
        getSupportActionBar().setTitle("VideoList");


        final ArrayList<categoryVideoModel> Categories = new ArrayList<>();
        final categoryVideoAdapter Adapter = new categoryVideoAdapter(Categories, this);

        final String catId = getIntent().getStringExtra("catId");

//        Log.e("catid", "catid :->"+catId);

        database.collection("category")
                .document(catId)
                .collection("videosList")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Categories.clear();
                for(DocumentSnapshot snapshot:queryDocumentSnapshots){
                    categoryVideoModel model = snapshot.toObject(categoryVideoModel.class);
                    model.setCategoryVideoId(snapshot.getId());
                    model.setCategoryVideoUrl(snapshot.getId());
                    Categories.add(model);
//                    Log.d("TAG", "sjsjjddddkfd");
                }
                Adapter.notifyDataSetChanged();
            }
        });
        binding.recycler.setAdapter(Adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));

    }

}