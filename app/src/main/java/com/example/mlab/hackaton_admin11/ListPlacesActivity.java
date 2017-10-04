package com.example.mlab.hackaton_admin11;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListPlacesActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseRef;
    private List<ImageUpload> imglist;
    private ListView lv;

    private ImageListAdapter adapter;

    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_places);


        imglist = new ArrayList<>();

        lv = (ListView) findViewById(R.id.ListViewImage);

        //setting up the dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading co working places");
        progressDialog.show();

        //ref. the DB
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(MainActivity.FB_DATABASE_PATH);

//monitors change in the D.B
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                //Fetching  and loop data from class ImageUpload
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    final ImageUpload imageUpload = snapshot.getValue(ImageUpload.class);
                    imglist.add(imageUpload);
                    
                }
                //Init adapter
                adapter =  new ImageListAdapter(ListPlacesActivity.this,R.layout.image_item,imglist);

                //displaying on the list
                lv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });
    }
}
