package com.example.internshipsignincontractapp.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbConnector {
    public FirebaseFirestore db ;
    public DatabaseReference students;
    public CollectionReference collectionReference;
    public List<Users> UserList = new ArrayList<>();
    public DbConnector() {

       db= FirebaseFirestore.getInstance();
       collectionReference=db.collection("Students");
       collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
           @Override
           public void onComplete(@NonNull Task<QuerySnapshot> task) {
               if (task.isSuccessful()) {
                   
                   for (QueryDocumentSnapshot document : task.getResult()) {
                       UserList.add(new Users(document.getString("name"),document.getString("password"),document.getString("email")));
                   }

               } else {
                   Log.d("TAG1", "Error getting documents: ");
               }
           }
       });;



    }
    public void addUser(Users user){
        DocumentReference newUser = db.collection("Students").document();
        HashMap <String,String>userMap = new HashMap();
        userMap.put("name",user.name);
        userMap.put("password",user.password);
        userMap.put("email",user.email);
        db.collection("Students").add(userMap);
    }
    public Boolean credentialsValidator(String username,String password){
        for( Users u :UserList) {
            if (username.equals(u.getName()) && password.equals(u.getPassword())) {
               return  true;
            }
        }
        return false;
    }

}
