package com.example.instagramclonejava.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.instagramclonejava.R;
import com.example.instagramclonejava.adapter.PostAdapter;
import com.example.instagramclonejava.databinding.ActivityFeedBinding;
import com.example.instagramclonejava.model.Post;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class FeedActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    ArrayList<Post> postArrayList;
    private ActivityFeedBinding binding;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setContentView(R.layout.activity_feed);
        postArrayList = new ArrayList<>();
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        datayiCek();
        binding.akisEkrani.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter(postArrayList);
        binding.akisEkrani.setAdapter(postAdapter);

    }

    private void datayiCek() {

        firebaseFirestore.collection("Gonderiler").orderBy("tarih", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(FeedActivity.this,error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                if (value != null) {
                    for (DocumentSnapshot anlikAkis: value.getDocuments()) {

                        Map<String, Object> data = anlikAkis.getData();
                        //Casting
                        String kullanicininmaili = (String) data.get("kullanicininmaili");
                        String kullaniciyorumu = (String) data.get("kullaniciyorumu");
                        String resimurlsi = (String) data.get("resimurlsi");
                        //System.out.println(kullaniciyorumu);

                        Post post = new Post(kullanicininmaili,kullaniciyorumu,resimurlsi);
                        postArrayList.add(post);



                    }

                    postAdapter.notifyDataSetChanged();
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.akis_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.gonderi_ekle){
            Intent intentToUpload = new Intent(FeedActivity.this,UploadActivity.class);
            startActivity(intentToUpload);
        } else if
            (item.getItemId() == R.id.cikis_yap){
            auth.signOut();
            Intent intentToMain = new Intent(FeedActivity.this,MainActivity.class);
            startActivity(intentToMain);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}